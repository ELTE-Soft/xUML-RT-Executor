package hu.eltesoft.modelexecution.ide.debug;

import com.sun.jdi.event.BreakpointEvent;

@SuppressWarnings("restriction")
public interface BreakpointEventListener {

	WrappedVirtualMachine.ThreadContinue breakpointHit(BreakpointEvent event);

}
