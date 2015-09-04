package hu.eltesoft.modelexecution.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.SocketException;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;

/**
 * This class accepts textual control messages through an input stream and
 * performs them while the runtime is running. It also sends notifications about
 * created and destroyed state machine instances.
 */
public class RuntimeControllerServer implements InstanceListener {

	private BaseRuntime baseRuntime;
	private BufferedReader controlReader;
	private Writer controlWriter;

	private volatile boolean running = true;

	/**
	 * A command that asks the runtime to terminate in a gentle way.
	 */
	public static final String COMMAND_TERMINATE = "COMMAND_TERMINATE";
	public static final String COMMAND_START = "COMMAND_START";
	public static final String EVENT_REACTIVE_CLASS_CREATED = "EVENT_REACTIVE_CLASS_CREATED";
	public static final String EVENT_REACTIVE_CLASS_TERMINATED = "EVENT_REACTIVE_CLASS_TERMINATED";

	public RuntimeControllerServer(InputStream control, OutputStream eventStream, BaseRuntime baseRuntime) {
		this.controlReader = new BufferedReader(new InputStreamReader(control));
		this.controlWriter = new OutputStreamWriter(eventStream);
		this.baseRuntime = baseRuntime;
	}

	public void startListening() {
		new Thread(() -> readControlStream()).start();
		InstanceRegistry.getInstanceRegistry().addInstanceListener(this);
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
				case COMMAND_START:
					baseRuntime.start();
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

	@Override
	public void instanceCreated(ClassWithState instance) {
		String eventLine = EVENT_REACTIVE_CLASS_CREATED + " " + instance.getClass().getCanonicalName() + " "
				+ instance.getInstanceID() + " " + instance.getOriginalClassName();
		trySendEvent(eventLine);
	}

	@Override
	public void instanceDeleted(ClassWithState instance) {
		String eventLine = EVENT_REACTIVE_CLASS_TERMINATED + " " + instance.getClass().getCanonicalName() + " "
				+ instance.getInstanceID();
		trySendEvent(eventLine);
	}

	private void trySendEvent(String eventLine) {
		try {
			controlWriter.write(eventLine + "\n");
			controlWriter.flush();
		} catch (IOException e) {
			BaseRuntime.logError("Error sending event on control stream: " + eventLine);
		}
	}
}
