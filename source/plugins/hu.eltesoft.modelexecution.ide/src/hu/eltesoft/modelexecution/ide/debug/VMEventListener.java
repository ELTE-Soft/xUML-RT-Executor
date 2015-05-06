package hu.eltesoft.modelexecution.ide.debug;

import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.VMDeathEvent;
import com.sun.jdi.event.VMDisconnectEvent;
import com.sun.jdi.event.VMStartEvent;

@SuppressWarnings("restriction")
public interface VMEventListener {

	void handleVMStart(VMStartEvent event);

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
			return shouldResume() && other.shouldResume() ? ShouldResume
					: RemainSuspended;
		}
	}
}
