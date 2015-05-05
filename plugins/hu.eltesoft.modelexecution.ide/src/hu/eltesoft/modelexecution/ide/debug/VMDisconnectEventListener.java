package hu.eltesoft.modelexecution.ide.debug;

import com.sun.jdi.event.VMDisconnectEvent;

@SuppressWarnings("restriction")
public interface VMDisconnectEventListener {
	
	WrappedVirtualMachine.ThreadContinue vmDisconnect(VMDisconnectEvent event);

}
