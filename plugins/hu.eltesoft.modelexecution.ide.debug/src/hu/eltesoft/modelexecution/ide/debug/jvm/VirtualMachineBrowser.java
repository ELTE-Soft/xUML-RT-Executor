package hu.eltesoft.modelexecution.ide.debug.jvm;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.xtext.xbase.lib.Pair;

import com.sun.jdi.ClassType;
import com.sun.jdi.Field;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.LongValue;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.StringReference;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.debug.Messages;
import hu.eltesoft.modelexecution.ide.debug.model.ModelVariable;
import hu.eltesoft.modelexecution.ide.debug.model.SingleValue;
import hu.eltesoft.modelexecution.ide.debug.model.StackFrame;
import hu.eltesoft.modelexecution.ide.debug.model.StateMachineInstance;
import hu.eltesoft.modelexecution.ide.debug.model.StateMachineStackFrame;
import hu.eltesoft.modelexecution.ide.debug.model.XUMLRTDebugTarget;
import hu.eltesoft.modelexecution.ide.debug.util.ModelUtils;
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplate;
import hu.eltesoft.modelexecution.runtime.InstanceRegistry;
import hu.eltesoft.modelexecution.runtime.meta.OwnerMeta;
import hu.eltesoft.modelexecution.runtime.meta.SignalMeta;
import hu.eltesoft.modelexecution.runtime.meta.VariableMeta;

/**
 * A class to query the state of the runtime running in the given virtual
 * machine. Only one {@link VirtualMachineBrowser} should be used for each
 * {@link VirtualMachine}.
 */
@SuppressWarnings("restriction")
public class VirtualMachineBrowser {

	private static final String NAME_METHOD = "name"; //$NON-NLS-1$
	private static final String GET_STATE_MACHINE_METHOD = "getStateMachine"; //$NON-NLS-1$
	private static final String GET_INSTANCE_METHOD = "getInstance"; //$NON-NLS-1$
	private static final String GET_INSTANCE_REGISTRY_METHOD = "getInstanceRegistry"; //$NON-NLS-1$
	private static final String MAIN_THREAD_NAME = "main"; //$NON-NLS-1$

	private final VirtualMachineManager vmManager;
	private final VirtualMachine virtualMachine;

	private JDIThreadWrapper mainThread;
	private Pair<String, Long> currentSMInstance;

	public VirtualMachineBrowser(VirtualMachineManager vmManager) {
		this.vmManager = vmManager;
		virtualMachine = vmManager.getVirtualMachine();
	}

	public synchronized void cleanupAfterBrakpoint() {
		currentSMInstance = null;
		mainThread = null;
	}

	public synchronized void initializeAtBreakpoint() {
		mainThread = createMainThreadWrapper();
		currentSMInstance = fetchSMInstance();
	}

	private JDIThreadWrapper createMainThreadWrapper() {
		List<ThreadReference> threads = virtualMachine.allThreads();
		for (ThreadReference thread : threads) {
			if (thread.name().equals(MAIN_THREAD_NAME)) {
				return new JDIThreadWrapper(vmManager, thread);
			}
		}
		throw new IllegalStateException("Unable to initialze JDI thread wrapper"); //$NON-NLS-1$
	}

	private Pair<String, Long> fetchSMInstance() {
		try {
			ObjectReference thisObject = mainThread.getActualThis();
			Field ownerField = thisObject.referenceType().fieldByName(RegionTemplate.OWNER_FIELD_NAME);
			ObjectReference owner = (ObjectReference) thisObject.getValue(ownerField);
			Field objectIdField = owner.referenceType().fieldByName("instanceID");
			String instanceTypeName = owner.referenceType().name();
			long instanceID = ((LongValue) owner.getValue(objectIdField)).longValue();
			return new Pair<>(instanceTypeName, instanceID);
		} catch (Exception e) {
			throw new IllegalStateException("Could not ask the current SM instance", e); //$NON-NLS-1$
		}
	}

	/**
	 * @return the instance of a class that has a state machine which is
	 *         currently under execution
	 */
	public synchronized Pair<String, Long> getActualSMInstance() {
		return currentSMInstance;
	}

	protected ModelVariable createVariable(StackFrame frame, JDIThreadWrapper mainThread, Value value,
			VariableMeta leftVal) {
		XUMLRTDebugTarget debugTarget = frame.getXUmlRtDebugTarget();
		return new ModelVariable(debugTarget, leftVal, mainThread, value);
	}

	public synchronized List<ModelVariable> getAttributes(StateMachineInstance instance) throws DebugException {
		try {
			List<ModelVariable> ret = new LinkedList<>();
			ObjectReference smInstance = getInstanceFromRegistry(instance, mainThread);
			SingleValue value = new SingleValue(instance.getXUmlRtDebugTarget(), mainThread, smInstance);
			for (IVariable variable : value.getVariables()) {
				if (variable instanceof ModelVariable) {
					ret.add((ModelVariable) variable);
				}
			}
			return ret;
		} catch (IncompatibleThreadStateException e) {
			// thread not suspended: fall through
			return null;
		}
	}

	private ObjectReference getInstanceFromRegistry(StateMachineInstance stateMachineInstance,
			JDIThreadWrapper mainThread) throws IncompatibleThreadStateException {
		try {
			ClassType instanceRegistryClass = (ClassType) virtualMachine
					.classesByName(InstanceRegistry.class.getCanonicalName()).get(0);
			ObjectReference instanceRegistry = (ObjectReference) mainThread.invokeStaticMethod(instanceRegistryClass,
					GET_INSTANCE_REGISTRY_METHOD);
			ReferenceType actualClass = virtualMachine.classesByName(stateMachineInstance.getClassId()).get(0);
			ObjectReference instance = (ObjectReference) mainThread.invokeMethod(instanceRegistry, GET_INSTANCE_METHOD,
					actualClass.classObject(), virtualMachine.mirrorOf(stateMachineInstance.getInstanceId()));
			return instance;
		} catch (IncompatibleThreadStateException e) {
			throw e;
		} catch (Exception e) {
			PluginLogger.logError("Error while accessing state machine instance", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Loads the actual state machine instance into a stack frame. Fills the
	 * model element if it is empty.
	 */
	public synchronized List<ModelVariable> getVariables(StateMachineStackFrame stackFrame) throws DebugException {
		List<ModelVariable> ret = new LinkedList<>();
		StateMachineInstance stateMachineInstance = (StateMachineInstance) stackFrame.getThread();
		try {
			ObjectReference instance = getInstanceFromRegistry(stateMachineInstance, mainThread);
			ObjectReference stateMachine = (ObjectReference) mainThread.invokeMethod(instance,
					GET_STATE_MACHINE_METHOD);
			EObject modelElement = stackFrame.getModelElement();
			if (modelElement == null || modelElement instanceof Vertex) {
				// because null means we are not stopped on a breakpoint, so the
				// current model element can only be a vertex
				// see: StateMachineStackFrame
				ObjectReference actualState = (ObjectReference) stateMachine
						.getValue(stateMachine.referenceType().fieldByName(RegionTemplate.CURRENT_STATE_ATTRIBUTE));
				ret.add(createCurrentStateVariable(stackFrame, mainThread, actualState));
			} else {
				// the model element is a transition
				addEventVariable(stackFrame, ret, mainThread);
			}
			ret.add(createThisVariable(stackFrame, mainThread, instance));
		} catch (IncompatibleThreadStateException e) {
			// thread not suspended: fall through
			return null;
		} catch (Exception e) {
			PluginLogger.logError("Error while accessing stack frame variables", e);
		}
		return ret;
	}

	private void addEventVariable(StateMachineStackFrame stackFrame, List<ModelVariable> ret,
			JDIThreadWrapper mainThread) {
		try {
			Value eventObj = mainThread.getLocalVariable(RegionTemplate.SIGNAL_VARIABLE);
			if (eventObj != null) {
				ret.add(createVariable(stackFrame, mainThread, eventObj,
						new SignalMeta(Messages.VirtualMachineConnection_variable_signal_label)));
			}
		} catch (IllegalStateException e) {
			// thread not suspended: fall through
		}
	}

	public synchronized NamedElement loadModelElement(StateMachineStackFrame stackFrame, ResourceSet resourceSet) {
		try {
			ObjectReference instance = getInstanceFromRegistry(stackFrame.getStateMachineInstance(), mainThread);
			ObjectReference stateMachine = (ObjectReference) mainThread.invokeMethod(instance,
					GET_STATE_MACHINE_METHOD);
			ObjectReference actualState = (ObjectReference) stateMachine
					.getValue(stateMachine.referenceType().fieldByName(RegionTemplate.CURRENT_STATE_ATTRIBUTE));
			StringReference stringVal = (StringReference) mainThread.invokeMethod(actualState, NAME_METHOD);
			return (NamedElement) ModelUtils.javaNameToEObject(stringVal.value(), resourceSet);
		} catch (IncompatibleThreadStateException e) {
			// thread not suspended: fall through
			return null;
		} catch (Exception e) {
			PluginLogger.logError("Error while accessing stack frame model element", e);
			return null;
		}
	}

	private ModelVariable createThisVariable(StackFrame stackFrame, JDIThreadWrapper mainThread, Value instance) {
		return createVariable(stackFrame, mainThread, instance,
				new OwnerMeta(Messages.VirtualMachineConnection_variable_this_label));
	}

	private ModelVariable createCurrentStateVariable(StackFrame stackFrame, JDIThreadWrapper mainThread,
			Value actualState) {
		return createVariable(stackFrame, mainThread, actualState,
				new OwnerMeta(Messages.VirtualMachineConnection_variable_currentState_label));
	}
}
