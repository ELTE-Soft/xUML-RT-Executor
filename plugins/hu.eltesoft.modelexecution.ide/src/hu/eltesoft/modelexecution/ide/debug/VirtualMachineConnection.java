package hu.eltesoft.modelexecution.ide.debug;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaVariable;

import com.sun.jdi.Field;
import com.sun.jdi.IntegerValue;
import com.sun.jdi.Method;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.ui.XUmlRtStackFrame;
import hu.eltesoft.modelexecution.ide.debug.ui.XUmlRtValue;
import hu.eltesoft.modelexecution.ide.debug.ui.XUmlRtVariable;
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplate;
import hu.eltesoft.modelexecution.runtime.meta.LeftValueM;
import hu.eltesoft.modelexecution.runtime.meta.OwnerM;
import hu.eltesoft.modelexecution.runtime.meta.SignalM;
import hu.eltesoft.modelexecution.runtime.meta.StateM;

@SuppressWarnings("restriction")
public class VirtualMachineConnection {

	private VirtualMachine virtualMachine;

	public VirtualMachineConnection(VirtualMachine virtualMachine) {
		this.virtualMachine = virtualMachine;
	}

	public String getActualSMInstance() {
		JDTThread mainThread = getMainThread();
		try {
			ObjectReference thisObject = mainThread.getActualThis();
			Field ownerField = thisObject.referenceType().fieldByName(RegionTemplate.OWNER_FIELD_NAME);
			ObjectReference owner = (ObjectReference) thisObject.getValue(ownerField);
			List<Method> getInstanceID = owner.referenceType().methodsByName("getInstanceID");
			getInstanceID.removeIf(Method::isAbstract);
			Value result = mainThread.invokeMethod(owner, getInstanceID.get(0));
			return owner.referenceType().name() + "#" + ((IntegerValue) result).intValue();
		} catch (Exception e) {
			IdePlugin.logError("Could not ask the current SM instance", e);
			return null;
		}
	}

	public void loadSMVariables(XUmlRtStackFrame frame) {
		List<MokaVariable> ret = new LinkedList<>();
		JDTThread mainThread = getMainThread();

		ObjectReference smObj = mainThread.getActualThis();
		Value eventObj = mainThread.getLocalVariable("signal");
		Value stateObj = smObj.getValue(smObj.referenceType().fieldByName("currentState"));
		Field ownerField = smObj.referenceType().fieldByName(RegionTemplate.OWNER_FIELD_NAME);
		ObjectReference owner = (ObjectReference) smObj.getValue(ownerField);
		ret.add(createMokaVariable(frame, mainThread, owner, new OwnerM("this")));
		ret.add(createMokaVariable(frame, mainThread, eventObj, new SignalM("signal")));
		ret.add(createMokaVariable(frame, mainThread, stateObj, new StateM("currentState")));

		frame.setVariables(ret.toArray(new MokaVariable[ret.size()]));
	}

	protected MokaVariable createMokaVariable(XUmlRtStackFrame frame, JDTThread mainThread, Value value,
			LeftValueM leftVal) {
		MokaDebugTarget debugTarget = (MokaDebugTarget) frame.getDebugTarget();
		return new XUmlRtVariable(debugTarget, leftVal, new XUmlRtValue(debugTarget, mainThread, value));
	}

	public JDTThread getMainThread() {
		List<ThreadReference> threads = virtualMachine.allThreads();
		ThreadReference mainThread = null;
		for (ThreadReference thread : threads) {
			if (thread.name().equals("main")) {
				mainThread = thread;
			}
		}
		return new JDTThread(mainThread);
	}

}
