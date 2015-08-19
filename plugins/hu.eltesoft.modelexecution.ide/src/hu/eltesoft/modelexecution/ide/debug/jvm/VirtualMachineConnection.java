package hu.eltesoft.modelexecution.ide.debug.jvm;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.debug.MokaVariable;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.ClassType;
import com.sun.jdi.Field;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;
import com.sun.jdi.Method;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.StringReference;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.debug.model.SingleValue;
import hu.eltesoft.modelexecution.ide.debug.model.XUmlRtSMStackFrame;
import hu.eltesoft.modelexecution.ide.debug.model.XUmlRtStEmptyStackFrame;
import hu.eltesoft.modelexecution.ide.debug.model.XUmlRtStateMachineInstance;
import hu.eltesoft.modelexecution.ide.debug.model.XUmlRtVariable;
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplate;
import hu.eltesoft.modelexecution.runtime.InstanceRegistry;
import hu.eltesoft.modelexecution.runtime.meta.LeftValueM;
import hu.eltesoft.modelexecution.runtime.meta.OwnerM;
import hu.eltesoft.modelexecution.runtime.meta.SignalM;
import hu.eltesoft.modelexecution.runtime.meta.StateM;

/**
 * A class to query the state of the runtime running in the given virtual
 * machine.
 */
@SuppressWarnings("restriction")
public class VirtualMachineConnection {

	private static final String MAIN_THREAD_NAME = "main"; //$NON-NLS-1$
	private static final String TO_STRING_METHOD = "toString"; //$NON-NLS-1$
	private VirtualMachine virtualMachine;

	public VirtualMachineConnection(VirtualMachine virtualMachine) {
		this.virtualMachine = virtualMachine;
	}

	/**
	 * @return the instance of a class that has a state machine which is
	 *         currently under execution
	 */
	public String getActualSMInstance() {
		JDTThreadWrapper mainThread = getMainThread();
		try {
			ObjectReference thisObject = mainThread.getActualThis();
			Field ownerField = thisObject.referenceType().fieldByName(RegionTemplate.OWNER_FIELD_NAME);
			ObjectReference owner = (ObjectReference) thisObject.getValue(ownerField);
			StringReference result = invokeToString(mainThread, owner);
			return result.value();
		} catch (Exception e) {
			IdePlugin.logError("Could not ask the current SM instance", e); //$NON-NLS-1$
			return null;
		}
	}

	private StringReference invokeToString(JDTThreadWrapper mainThread, ObjectReference owner) throws InvocationException,
			InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException {
		List<Method> getInstanceID = owner.referenceType().methodsByName(TO_STRING_METHOD);
		getInstanceID.removeIf(m -> m.isAbstract() || !m.argumentTypeNames().isEmpty());
		Value result = mainThread.invokeMethod(owner, getInstanceID.get(0));
		return (StringReference) result;
	}

	/**
	 * Fill the stack frame with standard data that can be shown in the
	 * variables view
	 */
	public void loadSMVariables(XUmlRtSMStackFrame frame) {
		List<MokaVariable> ret = new LinkedList<>();
		JDTThreadWrapper mainThread = getMainThread();

		ObjectReference smObj = mainThread.getActualThis();
		addOwnerAndStateVariables(frame, ret, mainThread, smObj);
		addEventVariable(frame, ret, mainThread);

		frame.setVariables(ret.toArray(new MokaVariable[ret.size()]));
	}

	private void addOwnerAndStateVariables(XUmlRtSMStackFrame frame, List<MokaVariable> ret,
			JDTThreadWrapper mainThread, ObjectReference smObj) {
		Value stateObj = smObj.getValue(smObj.referenceType().fieldByName(RegionTemplate.CURRENT_STATE_ATTRIBUTE));
		Field ownerField = smObj.referenceType().fieldByName(RegionTemplate.OWNER_FIELD_NAME);
		ObjectReference owner = (ObjectReference) smObj.getValue(ownerField);
		ret.add(createMokaVariable(frame, mainThread, owner,
				new OwnerM(Messages.VirtualMachineConnection_variable_this_label)));
		ret.add(createMokaVariable(frame, mainThread, stateObj,
				new StateM(Messages.VirtualMachineConnection_variable_currentState_label)));
	}

	private void addEventVariable(XUmlRtSMStackFrame frame, List<MokaVariable> ret, JDTThreadWrapper mainThread) {
		Value eventObj = mainThread.getLocalVariable(RegionTemplate.SIGNAL_VARIABLE);
		ret.add(createMokaVariable(frame, mainThread, eventObj,
				new SignalM(Messages.VirtualMachineConnection_variable_signal_label)));
	}

	protected MokaVariable createMokaVariable(MokaStackFrame frame, JDTThreadWrapper mainThread, Value value,
			LeftValueM leftVal) {
		MokaDebugTarget debugTarget = (MokaDebugTarget) frame.getDebugTarget();
		return new XUmlRtVariable(debugTarget, leftVal, new SingleValue(debugTarget, mainThread, value));
	}

	/**
	 * Gets the thread on which the runtime runs
	 */
	public JDTThreadWrapper getMainThread() {
		List<ThreadReference> threads = virtualMachine.allThreads();
		ThreadReference mainThread = null;
		for (ThreadReference thread : threads) {
			if (thread.name().equals(MAIN_THREAD_NAME)) {
				mainThread = thread;
			}
		}
		return new JDTThreadWrapper(mainThread);
	}

	public void loadDataOfSMInstance(XUmlRtStEmptyStackFrame stackFrame, ResourceSet resourceSet)
			throws DebugException {
		JDTThreadWrapper mainThread = getMainThread();
		ClassType instanceRegistryClass = (ClassType) virtualMachine
				.classesByName(InstanceRegistry.class.getCanonicalName()).get(0);
		ObjectReference instanceRegistry = (ObjectReference) instanceRegistryClass
				.getValue(instanceRegistryClass.fieldByName("INSTANCE"));
		List<Method> getInstance = instanceRegistryClass.methodsByName("getInstance");
		getInstance.removeIf(Method::isAbstract);
		try {
			XUmlRtStateMachineInstance stateMachineInstance = (XUmlRtStateMachineInstance) stackFrame.getThread();
			List<ReferenceType> actualClass = virtualMachine.classesByName(stateMachineInstance.getClassId());
			ObjectReference instance = (ObjectReference) mainThread.invokeMethod(instanceRegistry, getInstance.get(0),
					actualClass.get(0).classObject(), virtualMachine.mirrorOf(stateMachineInstance.getInstanceId()));
			List<Method> getSM = instance.referenceType().methodsByName("getStateMachine");
			getSM.removeIf(Method::isAbstract);
			ObjectReference stateMachine = (ObjectReference) mainThread.invokeMethod(instance, getSM.get(0));
			ObjectReference actualState = (ObjectReference) stateMachine
					.getValue(stateMachine.referenceType().fieldByName(RegionTemplate.CURRENT_STATE_ATTRIBUTE));
			stackFrame
					.setVariables(
							new MokaVariable[] {
									createMokaVariable(stackFrame, mainThread, instance, new OwnerM(
											Messages.VirtualMachineConnection_variable_this_label)),
							createMokaVariable(stackFrame, mainThread, actualState,
									new OwnerM(Messages.VirtualMachineConnection_variable_currentState_label)) });
			List<Method> nameMethod = actualState.referenceType().methodsByName("name");
			nameMethod.removeIf(Method::isAbstract);
			StringReference stringVal = (StringReference) mainThread.invokeMethod(actualState, nameMethod.get(0));
			stackFrame.setModelElement(findActualState(stringVal.value(), resourceSet));
		} catch (InvocationException | InvalidTypeException | ClassNotLoadedException
				| IncompatibleThreadStateException e) {
			IdePlugin.logError("Error while accessing state machine instance", e);
		}
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
