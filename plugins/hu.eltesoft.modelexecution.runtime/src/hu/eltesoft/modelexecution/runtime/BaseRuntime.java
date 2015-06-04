package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Message;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.log.NoLogger;
import hu.eltesoft.modelexecution.runtime.trace.InvalidTraceException;
import hu.eltesoft.modelexecution.runtime.trace.NoTraceReader;
import hu.eltesoft.modelexecution.runtime.trace.NoTracer;
import hu.eltesoft.modelexecution.runtime.trace.TargetedMessage;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader.EventSource;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Handler;

/**
 * Executes the model using logging and tracing. Receives the name of the class
 * and the name of a static function to execute.
 */
public class BaseRuntime implements Runtime, AutoCloseable {

	private static final String LOGGER_ID = "hu.eltesoft.modelexecution.runtime.baseRuntime.";
	public static final String RUNTIME_LOGGER_ID = LOGGER_ID + "Runtime";
	public static final String STATES_LOGGER_ID = LOGGER_ID
			+ "StateMachine.States";
	public static final String TRANSITIONS_LOGGER_ID = LOGGER_ID
			+ "StateMachine.Transitions";
	public static final String MESSAGES_LOGGER_ID = LOGGER_ID
			+ "Events.Messages";

	private Queue<TargetedMessage> queue = new LinkedList<>();
	private Tracer traceWriter = new NoTracer();
	private TraceReader traceReader = new NoTraceReader();
	private Logger logger = new NoLogger();
	private ClassLoader classLoader;
	private static java.util.logging.Logger errorLogger = java.util.logging.Logger
			.getLogger(LOGGER_ID); //$NON-NLS-1$
	private boolean terminate = false;

	public BaseRuntime(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	/**
	 * Switches the runtime to a controlled mode. In controlled mode, the
	 * runtime can be managed with control messages throught the control stream.
	 * This method may be called multiple times, in this case, the runtime
	 * responds to messages on all control streams.
	 */
	public void addControlStream(InputStream controlStream) {
		RuntimeController controller = new RuntimeController(controlStream,
				this);
		controller.startListening();
	}

	/**
	 * Stops the execution of the runtime after the current event is dispatched.
	 */
	public void terminate() {
		terminate = true;
	}

	@Override
	public void addEventToQueue(ClassWithState target, Message message) {
		TargetedMessage targetedEvent = new TargetedMessage(target, message);
		queue.add(targetedEvent);
		logger.messageQueued(target, message);
	}

	public void setTraceWriter(Tracer traceWriter) {
		this.traceWriter = traceWriter;
	}

	public void setTraceReader(TraceReader traceReader) {
		this.traceReader = traceReader;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * Runs the system. This can be an entry point of the runtime.
	 */
	@Override
	public TerminationResult run(String className, String feedName)
			throws Exception {
		try {
			logInfo("Preparing system for execution");
			prepare(className, feedName);
			logInfo("Starting execution");
			while (!terminate && (!queue.isEmpty() || traceReader.hasEvent())) {
				if (!queue.isEmpty()) {
					TargetedMessage currQueueEvent = queue.peek();
					if (traceReader.dispatchEvent(currQueueEvent, logger) == EventSource.Queue) {
						queue.poll();
					}
					traceWriter.traceEvent(currQueueEvent);
				} else {
					traceReader.dispatchEvent(logger);
				}
			}
			logInfo("Execution terminated successfully");
			return TerminationResult.SUCCESSFUL_TERMINATION;
		} catch (InvalidTraceException e) {
			logError(
					"The trace file is not consistent with the current model.",
					e);
			return TerminationResult.INVALID_TRACEFILE;
		} catch (Exception e) {
			logError("An internal error happened", e);
			return TerminationResult.INTERNAL_ERROR;
		}
	}

	/**
	 * Creates an instance of the selected class and executes it.
	 */
	private void prepare(String className, String feedName)
			throws ClassNotFoundException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		java.lang.Class<?> classClass = classLoader.loadClass(className);
		Constructor<?> constructor = classClass.getConstructor(Runtime.class);
		ClassWithState classInstance = (ClassWithState) constructor
				.newInstance(this);
		classInstance.init();
		Method method = classClass.getMethod(feedName);
		method.invoke(classInstance);
	}

	@Override
	public void logEnterState(String state) {
		logger.enterState(state);
	}

	@Override
	public void logExitState(String state) {
		logger.exitState(state);
	}

	@Override
	public void logTransition(String eventName, String messageName,
			String source, String target) {
		logger.transition(eventName, messageName, source, target);
	}

	public static void logInfo(String message) {
		errorLogger.log(java.util.logging.Level.INFO, message);
	}

	public static void logError(String message) {
		errorLogger.log(java.util.logging.Level.SEVERE, message);
	}

	public static void logError(String message, Throwable cause) {
		errorLogger.log(java.util.logging.Level.SEVERE, message);
		errorLogger.log(java.util.logging.Level.INFO, "", cause);
	}

	public static void logError(Throwable cause) {
		errorLogger.log(java.util.logging.Level.SEVERE, "Unexpected exception", //$NON-NLS-1$
				cause);
	}

	@Override
	public void close() throws Exception {
		logger.close();
		traceWriter.close();
		traceReader.close();
		for (Handler handler : errorLogger.getHandlers()) {
			handler.flush();
		}
	}

}
