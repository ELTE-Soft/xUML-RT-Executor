package hu.eltesoft.modelexecution.ide.common.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.common.launch.LaunchConfig;
import hu.eltesoft.modelexecution.runtime.RuntimeControllerServer;

/**
 * This class receives event notifications and sends commands to a
 * {@linkplain RuntimeControllerServer}
 */
public class RuntimeControllerClient {

	private ServerSocket server;

	private volatile Socket socket;
	private volatile Writer writer;

	private final CountDownLatch ready = new CountDownLatch(1);

	private final List<StateMachnineInstanceListener> reactiveClassListeners = new LinkedList<>();

	public RuntimeControllerClient(ILaunchConfiguration launchConfig) {
		try {
			int controlPort = launchConfig.getAttribute(LaunchConfig.ATTR_CONTROL_PORT, -1);
			connectToRuntime(controlPort);
		} catch (CoreException | IOException e) {
			PluginLogger.logError("Error while trying to set up control stream", e); //$NON-NLS-1$
		}
	}

	private void connectToRuntime(int controlPort) throws IOException {
		if (controlPort != -1) {
			server = new ServerSocket(controlPort);

			Thread thread = new Thread(() -> {
				try {
					socket = server.accept();
					writer = new OutputStreamWriter(socket.getOutputStream());
					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					ready.countDown();
					String line;
					while ((line = reader.readLine()) != null) {
						processLine(line);
					}
				} catch (SocketException e) {
					// normal, runtime is terminated
				} catch (Exception e) {
					PluginLogger.logError("Error while trying to set up control stream", e); //$NON-NLS-1$
				}
			});
			thread.setName("Control stream reader thread"); //$NON-NLS-1$
			thread.start();
		}
	}

	/**
	 * Processes one event coming from the runtime and informs the registered
	 * listeners.
	 */
	private void processLine(String line) {
		// limit array length to 4 as original name (the last argument) could
		// contain spaces
		String[] command = line.split(" ", 4); //$NON-NLS-1$
		switch (command[0]) {
		case RuntimeControllerServer.EVENT_REACTIVE_CLASS_CREATED:
			for (StateMachnineInstanceListener listener : reactiveClassListeners) {
				listener.instanceCreated(command[1], Integer.parseInt(command[2]), command[3]);
			}
			break;
		case RuntimeControllerServer.EVENT_REACTIVE_CLASS_TERMINATED:
			for (StateMachnineInstanceListener listener : reactiveClassListeners) {
				listener.instanceDestroyed(command[1], Integer.parseInt(command[2]));
			}
			break;
		}
	}

	/**
	 * Instructs the runtime to terminate in a graceful way. This call blocks
	 * until the runtime starts and connects to the IDE.
	 */
	public boolean terminate() {
		return sendCommand(RuntimeControllerServer.COMMAND_TERMINATE);
	}

	/**
	 * Instructs the runtime to start the engine.
	 */
	public boolean start() {
		return sendCommand(RuntimeControllerServer.COMMAND_START);
	}

	protected boolean sendCommand(String command) {
		awaitControllerReady();
		if (socket.isClosed()) {
			return false;
		}
		try {
			writer.append(command + "\n"); //$NON-NLS-1$
			writer.flush();
			return true;
		} catch (IOException e) {
			PluginLogger.logError("Error while trying to send terminate request", e); //$NON-NLS-1$
			return false;
		}
	}

	/**
	 * Blocks until the runtime starts and connects to the IDE.
	 */
	private void awaitControllerReady() {
		try {
			ready.await();
		} catch (InterruptedException e) {
			PluginLogger.logError("Error while waiting for socket connection", e); //$NON-NLS-1$
		}
	}

	/**
	 * Adds a new listener to be notified when a new state machine instance is
	 * created in the runtime or one is destroyed.
	 */
	public void addStateMachineInstanceListener(StateMachnineInstanceListener listener) {
		reactiveClassListeners.add(listener);
	}

}
