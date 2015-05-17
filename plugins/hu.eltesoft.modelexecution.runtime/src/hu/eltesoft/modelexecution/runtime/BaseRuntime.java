package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Message;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.trace.InvalidTraceException;
import hu.eltesoft.modelexecution.runtime.trace.TargetedMessage;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader.EventSource;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Executes the model using logging and tracing. Receives the name of the class
 * and the name of a static function to execute.
 */
public abstract class BaseRuntime implements Runtime {

	private static final String LOGGER_ID = "hu.eltesoft.modelexecution.runtime.baseRuntime.";
	public static final String RUNTIME_LOGGER_ID = LOGGER_ID + "Runtime";
	public static final String STATES_LOGGER_ID = LOGGER_ID + "StateMachine.States";
	public static final String TRANSITIONS_LOGGER_ID = LOGGER_ID + "StateMachine.Transitions";
	public static final String MESSAGES_LOGGER_ID = LOGGER_ID + "Events.Messages";
	

	private Queue<TargetedMessage> queue = new LinkedList<>();

	private Tracer traceWriter;
	private TraceReader traceReader;
	private Logger logger;
	private ClassLoader classLoader;
	private static java.util.logging.Logger errorLogger = java.util.logging.Logger
			.getLogger(LOGGER_ID); //$NON-NLS-1$

	public BaseRuntime(Tracer tracer, TraceReader traceReader, Logger logger) {
		this(BaseRuntime.class.getClassLoader(), tracer, traceReader, logger);
	}

	public BaseRuntime(ClassLoader classLoader, Tracer tracer,
			TraceReader traceReader, Logger logger) {
		this.classLoader = classLoader;
		this.traceWriter = tracer;
		this.traceReader = traceReader;
		this.logger = logger;
	}

	@Override
	public void addEventToQueue(Class target, Message message) {
		TargetedMessage targetedEvent = new TargetedMessage(target, message);
		queue.add(targetedEvent);
		logger.messageQueued(target, message);
	}

	/**
	 * Runs the system. This can be an entry point of the runtime.
	 */
	@Override
	public TerminationResult run(String className, String feedName) throws Exception {
		try {
			prepare(className, feedName);
			while (!queue.isEmpty() || traceReader.hasEvent()) {
				if (!queue.isEmpty()) {
					TargetedMessage currQueueEvent = queue.peek();
					if (traceReader.dispatchEvent(currQueueEvent, logger) == EventSource.Queue) {
						queue.poll();
						traceWriter.traceEvent(currQueueEvent);
					}
				} else {
					traceReader.dispatchEvent(logger);
				}
			}
			return TerminationResult.SUCCESSFUL_TERMINATION;
		} catch (InvalidTraceException e) {
			return TerminationResult.INVALID_TRACEFILE;
		} catch (Exception e) {
			logError(e);
			return TerminationResult.INTERNAL_ERROR;
		} finally {
			traceWriter.close();
			traceReader.close();
			logger.close();
		}
	}

	private void prepare(String className, String feedName)
			throws ClassNotFoundException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		java.lang.Class<?> classClass = classLoader.loadClass(className);
		Constructor<?> constructor = classClass.getConstructor(Runtime.class);
		Class classInstance = (Class) constructor.newInstance(this);
		classInstance.init();
		Method method = classClass.getMethod(feedName);
		method.invoke(classInstance);
	}

	@Override
	public void logMessageQueued(Class target, Message event) {
		logger.messageQueued(target, event);
	}

	@Override
	public void logMessageDispatched(Class target, Message event) {
		logger.messageDispatched(target, event);
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
	public void logTransition(String eventName, String messageName, String source, String target) {
		logger.transition(eventName, messageName, source, target);
	}

	public static void logError(String message) {
		errorLogger.log(java.util.logging.Level.SEVERE, message);
	}

	public static void logError(String message, Throwable cause) {
		errorLogger.log(java.util.logging.Level.SEVERE, message, cause);
	}

	public static void logError(Throwable cause) {
		errorLogger.log(java.util.logging.Level.SEVERE, "Unexpected exception", //$NON-NLS-1$
				cause);
	}

}
