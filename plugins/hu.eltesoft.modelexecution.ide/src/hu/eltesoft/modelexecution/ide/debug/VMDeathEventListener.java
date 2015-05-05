package hu.eltesoft.modelexecution.ide.debug;

import com.sun.jdi.event.VMDeathEvent;

@SuppressWarnings("restriction")
public interface VMDeathEventListener {

	WrappedVirtualMachine.ThreadContinue vmDeath(VMDeathEvent event);

}
