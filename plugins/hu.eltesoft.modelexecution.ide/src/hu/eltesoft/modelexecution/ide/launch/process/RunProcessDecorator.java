package hu.eltesoft.modelexecution.ide.launch.process;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;

import hu.eltesoft.modelexecution.ide.debug.jvm.RuntimeControllerClient;
import hu.eltesoft.modelexecution.ide.util.ProcessDecorator;

/**
 * This decorator changes the process to try to terminate in a gentle way.
 * Signals the runtime, that it should be terminated by writing the expected
 * command on its standard input stream.
 */
public class RunProcessDecorator extends ProcessDecorator {

	private RuntimeControllerClient runtimeController;

	public RunProcessDecorator(IProcess process, ILaunchConfiguration launchConfig) {
		super(process);
		this.runtimeController = new RuntimeControllerClient(launchConfig);
	}

	@Override
	public void terminate() throws DebugException {

		boolean terminateSuccess = runtimeController.terminate();
		if (!terminateSuccess) {
			// if graceful termination does not succeed, terminate it directly
			process.terminate();
		}
	}

	@Override
	public RuntimeControllerClient getController() {
		return runtimeController;
	}

}