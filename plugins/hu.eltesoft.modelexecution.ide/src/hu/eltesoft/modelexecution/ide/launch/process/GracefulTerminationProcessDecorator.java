package hu.eltesoft.modelexecution.ide.launch.process;

import hu.eltesoft.modelexecution.ide.util.ProcessDecorator;
import hu.eltesoft.modelexecution.runtime.RuntimeController;

import java.io.IOException;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.swt.widgets.Display;

/**
 * This decorator changes the process to try to terminate in a gentle way.
 * Signals the runtime, that it should be terminated by writing the expected
 * command on its standard input stream. If terminate is called for the second
 * time, it forces termination as before.
 */
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
					streamsProxy.write(RuntimeController.COMMAND_TERMINATE
							+ "\n");
				} catch (IOException e) {
					process.terminate();
				}
			}
			this.sigkill = true;
		} else {
			process.terminate();
		}

		// let the console update the termination status
		// see ticket #187
		Display.getDefault().asyncExec(() -> {
			DebugEvent event = new DebugEvent(this, DebugEvent.TERMINATE);
			DebugEvent[] eventSet = new DebugEvent[] { event };
			DebugPlugin.getDefault().fireDebugEventSet(eventSet);
		});

	}

	public GracefulTerminationProcessDecorator(IProcess process) {
		super(process);
	}
}