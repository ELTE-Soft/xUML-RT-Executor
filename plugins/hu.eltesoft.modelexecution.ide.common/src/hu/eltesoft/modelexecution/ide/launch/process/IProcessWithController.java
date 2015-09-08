package hu.eltesoft.modelexecution.ide.launch.process;

import hu.eltesoft.modelexecution.ide.runtime.RuntimeControllerClient;

/**
 * A process that can have a runtime controller attached.
 */
public interface IProcessWithController {

	RuntimeControllerClient getController();

}
