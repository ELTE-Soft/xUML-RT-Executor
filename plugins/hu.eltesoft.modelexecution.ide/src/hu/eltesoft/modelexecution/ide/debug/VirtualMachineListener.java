package hu.eltesoft.modelexecution.ide.debug;

import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.VMDeathEvent;
import com.sun.jdi.event.VMDisconnectEvent;
import com.sun.jdi.event.VMStartEvent;

@SuppressWarnings("restriction")
public interface VirtualMachineListener {

	void handleVMStart(VMStartEvent event);

	/**
	 * @param event
	 *            Can be null as the machine is unable to produce a proper event
	 *            when the disconnect exception comes before the event. This
	 *            situation is caused by a bug in JDI.
	 */
	void handleVMDisconnect(VMDisconnectEvent event);

	void handleVMDeath(VMDeathEvent event);

	void handleClassPrepare(ClassPrepareEvent event);

	ThreadAction handleBreakpoint(BreakpointEvent event);

	public enum ThreadAction {
		ShouldResume, RemainSuspended;

		public boolean shouldResume() {
			return this == ShouldResume;
		}

		public ThreadAction merge(ThreadAction other) {
			return shouldResume() && other.shouldResume() ? ShouldResume : RemainSuspended;
		}
	}
}
