package hu.eltesoft.modelexecution.ide.common.process;

import hu.eltesoft.modelexecution.ide.common.runtime.RuntimeControllerClient;

/**
 * A process that can have a runtime controller attached.
 */
public interface IProcessWithController {

	RuntimeControllerClient getController();

}
