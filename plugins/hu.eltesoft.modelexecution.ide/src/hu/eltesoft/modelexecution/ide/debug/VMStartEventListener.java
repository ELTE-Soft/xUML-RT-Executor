package hu.eltesoft.modelexecution.ide.debug;

import com.sun.jdi.event.VMStartEvent;

@SuppressWarnings("restriction")
public interface VMStartEventListener {

	WrappedVirtualMachine.ThreadContinue vmStart(VMStartEvent event);

}
