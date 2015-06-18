package hu.eltesoft.modelexecution.ide.launch.process;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.launch.ModelExecutionLaunchConfig;
import hu.eltesoft.modelexecution.ide.util.ProcessDecorator;
import hu.eltesoft.modelexecution.runtime.RuntimeController;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;

/**
 * This decorator changes the process to try to terminate in a gentle way.
 * Signals the runtime, that it should be terminated by writing the expected
 * command on its standard input stream. If terminate is called for the second
 * time, it forces termination as before.
 */
public class GracefulTerminationProcessDecorator extends ProcessDecorator {

	ServerSocket server;
	Socket socket;
	Writer writer;

	@Override
	public void terminate() throws DebugException {

		if (socket != null) {
			try {
				writer.append(RuntimeController.COMMAND_TERMINATE + "\n");
				writer.flush();
			} catch (IOException e) {
				IdePlugin.logError(
						"Error while trying to send terminate request", e);
				// if there is a problem with sending the terminate message on
				// the control thread, it should be terminated directly
				process.terminate();
			}
		} else {
			// if there is a problem with establishing the control thread, it
			// should be terminated directly
			process.terminate();
		}
	}

	public GracefulTerminationProcessDecorator(IProcess process,
			ILaunchConfiguration launchConfig) {
		super(process);
		int controlPort;
		try {
			controlPort = launchConfig.getAttribute(
					ModelExecutionLaunchConfig.ATTR_CONTROL_PORT, -1);
			server = new ServerSocket(controlPort);

			if (controlPort != -1) {
				// this thread will only live until the runtime is started
				new Thread(() -> {
					try {
						socket = server.accept();
						writer = new OutputStreamWriter(
								socket.getOutputStream());
					} catch (Exception e) {
						IdePlugin.logError(
								"Error while trying to set up control stream",
								e);
						// nothing to do, termination will be forced
					}
				}).start();
			}
		} catch (CoreException | IOException e) {
			IdePlugin
					.logError("Error while trying to set up control stream", e);
		}
	}
}