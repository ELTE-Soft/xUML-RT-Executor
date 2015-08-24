package hu.eltesoft.modelexecution.ide.debug.jvm;

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

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.launch.ModelExecutionLaunchConfig;
import hu.eltesoft.modelexecution.runtime.RuntimeControllerServer;

/**
 * This class receives event notifications and sends commands to a
 * {@linkplain RuntimeControllerServer}
 */
public class RuntimeControllerClient {

	private ServerSocket server;
	private Socket socket;
	private Writer writer;
	private BufferedReader reader;

	private CountDownLatch ready = new CountDownLatch(1);

	private List<ReactiveClassListener> reactiveClassListeners = new LinkedList<>();

	public RuntimeControllerClient(ILaunchConfiguration launchConfig) {
		try {
			int controlPort = launchConfig.getAttribute(ModelExecutionLaunchConfig.ATTR_CONTROL_PORT, -1);
			server = new ServerSocket(controlPort);

			if (controlPort != -1) {
				// this thread will only live until the runtime is started
				Thread thread = new Thread(() -> {
					try {
						socket = server.accept();
						writer = new OutputStreamWriter(socket.getOutputStream());
						reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						ready.countDown();
						String line;
						while ((line = reader.readLine()) != null) {
							processLine(line);
						}
					} catch (SocketException e) {
						// normal, runtime is terminated
					} catch (Exception e) {
						IdePlugin.logError("Error while trying to set up control stream", e);
					}
				});
				thread.setName("Control stream reader thread");
				thread.start();
			}
		} catch (CoreException | IOException e) {
			IdePlugin.logError("Error while trying to set up control stream", e);
		}
	}

	private void processLine(String line) {
		String[] command = line.split(" ");
		switch (command[0]) {
		case RuntimeControllerServer.EVENT_REACTIVE_CLASS_CREATED:
			for (ReactiveClassListener listener : reactiveClassListeners) {
				listener.instanceCreated(command[1], Integer.parseInt(command[2]), command[3]);
			}
			break;
		case RuntimeControllerServer.EVENT_REACTIVE_CLASS_TERMINATED:
			for (ReactiveClassListener listener : reactiveClassListeners) {
				listener.instanceDestroyed(command[1], Integer.parseInt(command[2]));
			}
			break;
		}
	}

	public boolean terminate() {
		return sendCommand(RuntimeControllerServer.COMMAND_TERMINATE);
	}

	protected boolean sendCommand(String command) {
		awaitControllerReady();
		try {
			writer.append(command + "\n");
			writer.flush();
			return true;
		} catch (IOException e) {
			IdePlugin.logError("Error while trying to send terminate request", e);
			return false;
		}
	}

	private void awaitControllerReady() {
		try {
			ready.await();
		} catch (InterruptedException e) {
			IdePlugin.logError("Error while waiting for socket connection", e);
		}
	}

	public void addReactiveClassListener(ReactiveClassListener listener) {
		reactiveClassListeners.add(listener);
	}

}
