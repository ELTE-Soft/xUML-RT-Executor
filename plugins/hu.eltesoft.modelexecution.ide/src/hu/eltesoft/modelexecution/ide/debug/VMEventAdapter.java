package hu.eltesoft.modelexecution.ide.debug;

import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.VMDeathEvent;
import com.sun.jdi.event.VMDisconnectEvent;
import com.sun.jdi.event.VMStartEvent;

@SuppressWarnings("restriction")
public abstract class VMEventAdapter implements VMEventListener {

	@Override
	public void handleVMStart(VMStartEvent event) {
		// intentionally left blank
	}

	@Override
	public void handleVMDisconnect(VMDisconnectEvent event) {
		// intentionally left blank
	}

	@Override
	public void handleVMDeath(VMDeathEvent event) {
		// intentionally left blank
	}

	@Override
	public void handleClassPrepare(ClassPrepareEvent event) {
		// intentionally left blank
	}

	@Override
	public ThreadAction handleBreakpoint(BreakpointEvent event) {
		return ThreadAction.ShouldResume;
	}
}
