package hu.eltesoft.modelexecution.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;

/**
 * This class accepts textual control messages through an input stream and
 * performs them while the runtime is running.
 */
public class RuntimeController {

	private BaseRuntime baseRuntime;
	private BufferedReader controlReader;

	private volatile boolean running = true;

	/**
	 * A command that asks the runtime to terminate in a gentle way.
	 */
	public static final String COMMAND_TERMINATE = "TERMINATE";

	public RuntimeController(InputStream control, BaseRuntime baseRuntime) {
		this.controlReader = new BufferedReader(new InputStreamReader(control));
		this.baseRuntime = baseRuntime;
	}

	public void startListening() {
		new Thread(() -> readControlStream()).start();
	}

	public void stopListening() {
		running = false;
	}

	private void readControlStream() {
		String controlLine;
		try {
			while (running && (controlLine = controlReader.readLine()) != null) {
				switch (controlLine) {
				case COMMAND_TERMINATE:
					baseRuntime.terminate();
					return;
				default:
					BaseRuntime.logError("Illegal command on control stream: " + controlLine);
				}
			}
		} catch (SocketException e) {
			if (running) {
				reportError(e);
			}
		} catch (IOException e) {
			reportError(e);
		}
	}

	private void reportError(Exception e) {
		BaseRuntime.logError("Error while processing control stream", e);
		baseRuntime.terminate();
	}
}
