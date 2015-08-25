package hu.eltesoft.modelexecution.ide.debug.jvm;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.debug.MokaVariable;
import org.eclipse.uml2.uml.State;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.ClassType;
import com.sun.jdi.Field;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.StringReference;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.debug.model.SingleValue;
import hu.eltesoft.modelexecution.ide.debug.model.XUmlRtStateMachineInstance;
import hu.eltesoft.modelexecution.ide.debug.model.XUmlRtVariable;
import hu.eltesoft.modelexecution.ide.debug.util.JDIUtils;
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplate;
import hu.eltesoft.modelexecution.runtime.InstanceRegistry;
import hu.eltesoft.modelexecution.runtime.meta.LeftValueM;
import hu.eltesoft.modelexecution.runtime.meta.OwnerM;
import hu.eltesoft.modelexecution.runtime.meta.SignalM;

/**
 * A class to query the state of the runtime running in the given virtual
 * machine.
 */
@SuppressWarnings("restriction")
public class VirtualMachineConnection {

	private static final String NAME_METHOD = "name"; //$NON-NLS-1$
	private static final String GET_STATE_MACHINE_METHOD = "getStateMachine"; //$NON-NLS-1$
	private static final String GET_INSTANCE_METHOD = "getInstance"; //$NON-NLS-1$
	private static final String GET_INSTANCE_REGISTRY_METHOD = "getInstanceRegistry"; //$NON-NLS-1$
	private static final String MAIN_THREAD_NAME = "main"; //$NON-NLS-1$

	private VirtualMachine virtualMachine;
	private JDIThreadWrapper mainThread;

	public VirtualMachineConnection(VirtualMachine virtualMachine) {
		this.virtualMachine = virtualMachine;
	}

	/**
	 * @return the instance of a class that has a state machine which is
	 *         currently under execution
	 */
	public String getActualSMInstance() {
		JDIThreadWrapper mainThread = getMainThread();
		try {
			ObjectReference thisObject = mainThread.getActualThis();
			Field ownerField = thisObject.referenceType().fieldByName(RegionTemplate.OWNER_FIELD_NAME);
			ObjectReference owner = (ObjectReference) thisObject.getValue(ownerField);
			return new JDIUtils(mainThread).invokeToString(owner);
		} catch (Exception e) {
			IdePlugin.logError("Could not ask the current SM instance", e); //$NON-NLS-1$
			return null;
		}
	}

	/**
	 * Adds the event variable to the stack frame when stopped at state or
	 * transition breakpoint.
	 */
	public void addEventVariable(MokaStackFrame frame) {
		JDIThreadWrapper mainThread = getMainThread();
		Value eventObj = mainThread.getLocalVariable(RegionTemplate.SIGNAL_VARIABLE);
		if (eventObj != null) {
			addVariable(frame, createMokaVariable(frame, mainThread, eventObj,
					new SignalM(Messages.VirtualMachineConnection_variable_signal_label)));
		}
	}

	private static void addVariable(MokaStackFrame frame, MokaVariable variable) {
		List<MokaVariable> newVars = new LinkedList<>();
		try {
			for (IVariable var : frame.getVariables()) {
				if (var instanceof MokaVariable) {
					newVars.add((MokaVariable) var);
				}
			}
		} catch (DebugException e) {
			IdePlugin.logError("Error while accessing variables", e);
		}
		newVars.add(variable);
		frame.setVariables(newVars.toArray(new MokaVariable[newVars.size()]));
	}

	protected MokaVariable createMokaVariable(MokaStackFrame frame, JDIThreadWrapper mainThread, Value value,
			LeftValueM leftVal) {
		MokaDebugTarget debugTarget = (MokaDebugTarget) frame.getDebugTarget();
		return new XUmlRtVariable(debugTarget, leftVal, new SingleValue(debugTarget, mainThread, value));
	}

	/**
	 * Gets the thread on which the runtime runs. It is safe to use this method
	 * multiple times, because if a valid thread exists, it returns that and
	 * evade concurrent use of the same jvm thread.
	 */
	public JDIThreadWrapper getMainThread() {
		if (mainThread == null || !mainThread.isValid()) {
			List<ThreadReference> threads = virtualMachine.allThreads();
			for (ThreadReference thread : threads) {
				if (thread.name().equals(MAIN_THREAD_NAME)) {
					mainThread = new JDIThreadWrapper(thread);
				}
			}
		}
		return mainThread;
	}

	/**
	 * Loads the actual state machine instance into a stack frame. Fills the
	 * model element if it is empty.
	 */
	public void loadDataOfSMInstance(MokaStackFrame stackFrame, ResourceSet resourceSet) throws DebugException {
		XUmlRtStateMachineInstance stateMachineInstance = (XUmlRtStateMachineInstance) stackFrame.getThread();
		try {
			JDIThreadWrapper mainThread = getMainThread();
			ClassType instanceRegistryClass = (ClassType) virtualMachine
					.classesByName(InstanceRegistry.class.getCanonicalName()).get(0);
			ObjectReference instanceRegistry = (ObjectReference) mainThread.invokeStaticMethod(instanceRegistryClass,
					GET_INSTANCE_REGISTRY_METHOD);
			ReferenceType actualClass = virtualMachine.classesByName(stateMachineInstance.getClassId()).get(0);
			ObjectReference instance = (ObjectReference) mainThread.invokeMethod(instanceRegistry, GET_INSTANCE_METHOD,
					actualClass.classObject(), virtualMachine.mirrorOf(stateMachineInstance.getInstanceId()));
			ObjectReference stateMachine = (ObjectReference) mainThread.invokeMethod(instance,
					GET_STATE_MACHINE_METHOD);
			EObject modelElement = stackFrame.getModelElement();
			if (modelElement == null || modelElement instanceof State) {
				ObjectReference actualState = (ObjectReference) stateMachine
						.getValue(stateMachine.referenceType().fieldByName(RegionTemplate.CURRENT_STATE_ATTRIBUTE));
				addVariable(stackFrame, createCurrentStateVariable(stackFrame, mainThread, actualState));
				if (modelElement == null) {
					// we are not stopped on a breakpoint, or getModelElement()
					// wont be null, so the current model element can only be a
					// state
					StringReference stringVal = (StringReference) mainThread.invokeMethod(actualState, NAME_METHOD);
					stackFrame.setModelElement(findActualState(stringVal.value(), resourceSet));
				}
			}
			addVariable(stackFrame, createThisVariable(stackFrame, mainThread, instance));
		} catch (InvocationException | InvalidTypeException | ClassNotLoadedException | IncompatibleThreadStateException
				| NoSuchMethodException e) {
			IdePlugin.logError("Error while accessing state machine instance", e);
		}
	}

	private MokaVariable createThisVariable(MokaStackFrame stackFrame, JDIThreadWrapper mainThread, Value instance) {
		return createMokaVariable(stackFrame, mainThread, instance,
				new OwnerM(Messages.VirtualMachineConnection_variable_this_label));
	}

	private MokaVariable createCurrentStateVariable(MokaStackFrame stackFrame, JDIThreadWrapper mainThread,
			Value actualState) {
		return createMokaVariable(stackFrame, mainThread, actualState,
				new OwnerM(Messages.VirtualMachineConnection_variable_currentState_label));
	}

	private EObject findActualState(String id, ResourceSet resourceSet) {
		for (Resource resource : resourceSet.getResources()) {
			EObject eObject = resource.getEObject(id);
			if (eObject != null) {
				return eObject;
			}
		}
		return null;
	}

}
