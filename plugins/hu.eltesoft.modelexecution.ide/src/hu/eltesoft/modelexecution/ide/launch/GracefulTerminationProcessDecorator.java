package hu.eltesoft.modelexecution.ide.launch;

import hu.eltesoft.modelexecution.ide.util.ProcessDecorator;
import hu.eltesoft.modelexecution.runtime.BaseRuntime;

import java.io.IOException;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

public class GracefulTerminationProcessDecorator extends ProcessDecorator {

	private boolean sigkill = false;

	@Override
	public void terminate() throws DebugException {
		if (!sigkill) {
			IStreamsProxy streamsProxy = process.getStreamsProxy();
			if (streamsProxy == null) {
				process.terminate();
			} else {
				try {
					streamsProxy.write(BaseRuntime.COMMAND_TERMINATE + "\n");
				} catch (IOException e) {
					process.terminate();
				}
			}
			this.sigkill = true;
		} else {
			process.terminate();
		}
	}

	public GracefulTerminationProcessDecorator(IProcess process) {
		super(process);
	}
}