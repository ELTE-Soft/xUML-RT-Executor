package hu.eltesoft.modelexecution.ide.debug;

import com.sun.jdi.event.ClassPrepareEvent;

@SuppressWarnings("restriction")
public interface ClassPrepareEventListener {

	WrappedVirtualMachine.ThreadContinue classPrepare(ClassPrepareEvent event);

}
