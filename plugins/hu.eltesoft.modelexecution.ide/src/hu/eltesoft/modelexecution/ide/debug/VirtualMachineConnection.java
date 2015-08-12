package hu.eltesoft.modelexecution.ide.debug;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaVariable;

import com.sun.jdi.Field;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.IntegerValue;
import com.sun.jdi.Method;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.StackFrame;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.ui.XUmlRtStackFrame;
import hu.eltesoft.modelexecution.ide.debug.ui.XUmlRtValue;
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplate;

@SuppressWarnings("restriction")
public class VirtualMachineConnection {

	private VirtualMachine virtualMachine;

	public VirtualMachineConnection(VirtualMachine virtualMachine) {
		this.virtualMachine = virtualMachine;
	}
	
	public String getActualSMInstance() {
		ThreadReference mainThread = getMainThread();
		if (mainThread.isSuspended() && mainThread.isAtBreakpoint()) {
			try {
				StackFrame executionPoint = getExecutionPoint();
				Field ownerField = executionPoint.thisObject().referenceType()
						.fieldByName(RegionTemplate.OWNER_FIELD_NAME);
				ObjectReference owner = (ObjectReference) executionPoint.thisObject().getValue(ownerField);
				List<Method> getInstanceID = owner.referenceType().methodsByName("getInstanceID");
				getInstanceID.removeIf(Method::isAbstract);
				Value result = owner.invokeMethod(mainThread, getInstanceID.get(0), new LinkedList<Value>(), 0);
				return owner.referenceType().name() + "#" + ((IntegerValue) result).intValue();
			} catch (Exception e) {
				IdePlugin.logError("Could not ask the current SM instance", e);
			}
		}
		return null;
	}

	public void loadSMVariables(XUmlRtStackFrame frame) {
		List<MokaVariable> ret = new LinkedList<>();
		ThreadReference mainThread = getMainThread();
		if (mainThread.isSuspended() && mainThread.isAtBreakpoint()) {
			try {
				StackFrame executionPoint = getExecutionPoint();
				ObjectReference smObj = executionPoint.thisObject();
				Value eventObj = getExecutionPoint().getArgumentValues().get(0);
				Value stateObj = smObj.getValue(smObj.referenceType().fieldByName("currentState"));
				Field ownerField = smObj.referenceType().fieldByName(RegionTemplate.OWNER_FIELD_NAME);
				ObjectReference owner = (ObjectReference) smObj.getValue(ownerField);
				ret.add(createMokaVariable(frame, mainThread, owner, "this"));
				ret.add(createMokaVariable(frame, mainThread, eventObj, "event"));
				ret.add(createMokaVariable(frame, mainThread, stateObj, "currentState"));
			} catch (Exception e) {
				IdePlugin.logError("Could not ask for SM variables", e);
			}
		}
		frame.setVariables(ret.toArray(new MokaVariable[ret.size()]));

	}

	protected MokaVariable createMokaVariable(XUmlRtStackFrame frame, ThreadReference thread, Value value,
			String varName) throws DebugException {
		MokaDebugTarget debugTarget = (MokaDebugTarget) frame.getDebugTarget();
		MokaVariable variable = new MokaVariable(debugTarget);
		variable.setName(varName);
		variable.setValue(new XUmlRtValue(debugTarget, thread, value));
		return variable;
	}

	public StackFrame getExecutionPoint() {
		ThreadReference main = getMainThread();
		try {
			return main.frames().get(0);
		} catch (IncompatibleThreadStateException e) {
			IdePlugin.logError("Could not ask execution point", e);
			throw new RuntimeException(e);
		}
	}

	public ThreadReference getMainThread() {
		List<ThreadReference> threads = virtualMachine.allThreads();
		ThreadReference mainThread = null;
		for (ThreadReference thread : threads) {
			if (thread.name().equals("main")) {
				mainThread = thread;
			}
		}
		return mainThread;
	}

}
