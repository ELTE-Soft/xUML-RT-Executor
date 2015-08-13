package hu.eltesoft.modelexecution.ide.launch.process;

import hu.eltesoft.modelexecution.ide.debug.jvm.RuntimeControllerClient;

public interface IProcessWithController {

	RuntimeControllerClient getController();
	
}
