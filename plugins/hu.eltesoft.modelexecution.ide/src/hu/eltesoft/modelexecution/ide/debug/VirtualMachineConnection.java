package hu.eltesoft.modelexecution.ide.debug;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaVariable;

import com.sun.jdi.Field;
import com.sun.jdi.Method;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.StringReference;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.debug.ui.XUmlRtStackFrame;
import hu.eltesoft.modelexecution.ide.debug.ui.XUmlRtValue;
import hu.eltesoft.modelexecution.ide.debug.ui.XUmlRtVariable;
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplate;
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
		JDTThread mainThread = getMainThread();
		try {
			ObjectReference thisObject = mainThread.getActualThis();
			Field ownerField = thisObject.referenceType().fieldByName(RegionTemplate.OWNER_FIELD_NAME);
			ObjectReference owner = (ObjectReference) thisObject.getValue(ownerField);
			List<Method> getInstanceID = owner.referenceType().methodsByName(TO_STRING_METHOD);
			getInstanceID.removeIf(m -> m.isAbstract() || !m.argumentTypeNames().isEmpty());
			Value result = mainThread.invokeMethod(owner, getInstanceID.get(0));
			return ((StringReference) result).value();
		} catch (Exception e) {
			IdePlugin.logError("Could not ask the current SM instance", e); //$NON-NLS-1$
			return null;
		}
	}

	/**
	 * Fill the stack frame with standard data that can be shown in the
	 * variables view
	 */
	public void loadSMVariables(XUmlRtStackFrame frame) {
		List<MokaVariable> ret = new LinkedList<>();
		JDTThread mainThread = getMainThread();

		ObjectReference smObj = mainThread.getActualThis();
		Value eventObj = mainThread.getLocalVariable(RegionTemplate.SIGNAL_VARIABLE);
		Value stateObj = smObj.getValue(smObj.referenceType().fieldByName(RegionTemplate.CURRENT_STATE_ATTRIBUTE));
		Field ownerField = smObj.referenceType().fieldByName(RegionTemplate.OWNER_FIELD_NAME);
		ObjectReference owner = (ObjectReference) smObj.getValue(ownerField);
		ret.add(createMokaVariable(frame, mainThread, owner,
				new OwnerM(Messages.VirtualMachineConnection_variable_this_label)));
		ret.add(createMokaVariable(frame, mainThread, eventObj,
				new SignalM(Messages.VirtualMachineConnection_variable_signal_label)));
		ret.add(createMokaVariable(frame, mainThread, stateObj,
				new StateM(Messages.VirtualMachineConnection_variable_currentState_label)));

		frame.setVariables(ret.toArray(new MokaVariable[ret.size()]));
	}

	protected MokaVariable createMokaVariable(XUmlRtStackFrame frame, JDTThread mainThread, Value value,
			LeftValueM leftVal) {
		MokaDebugTarget debugTarget = (MokaDebugTarget) frame.getDebugTarget();
		return new XUmlRtVariable(debugTarget, leftVal, new XUmlRtValue(debugTarget, mainThread, value));
	}

	/**
	 * Gets the thread on which the runtime runs
	 */
	public JDTThread getMainThread() {
		List<ThreadReference> threads = virtualMachine.allThreads();
		ThreadReference mainThread = null;
		for (ThreadReference thread : threads) {
			if (thread.name().equals(MAIN_THREAD_NAME)) {
				mainThread = thread;
			}
		}
		return new JDTThread(mainThread);
	}

}
