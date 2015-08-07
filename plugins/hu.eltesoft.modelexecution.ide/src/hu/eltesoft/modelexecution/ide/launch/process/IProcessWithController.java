package hu.eltesoft.modelexecution.ide.launch.process;

import hu.eltesoft.modelexecution.ide.debug.RuntimeControllerClient;

public interface IProcessWithController {

	RuntimeControllerClient getController();
	
}
