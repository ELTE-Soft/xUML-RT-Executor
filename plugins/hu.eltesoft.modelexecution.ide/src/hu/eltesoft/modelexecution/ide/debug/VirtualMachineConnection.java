package hu.eltesoft.modelexecution.ide.debug;

import java.util.List;

import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.StackFrame;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.VirtualMachine;

import hu.eltesoft.modelexecution.ide.IdePlugin;

@SuppressWarnings("restriction")
public class VirtualMachineConnection {

	private VirtualMachine virtualMachine;

	public VirtualMachineConnection(VirtualMachine virtualMachine) {
		this.virtualMachine = virtualMachine;
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
