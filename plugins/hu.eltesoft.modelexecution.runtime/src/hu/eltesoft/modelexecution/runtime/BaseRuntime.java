package hu.eltesoft.modelexecution.runtime;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Event;
import hu.eltesoft.modelexecution.runtime.external.ExternalEntityException;
import hu.eltesoft.modelexecution.runtime.external.ExternalEntityRegistry;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.log.NoLogger;
import hu.eltesoft.modelexecution.runtime.trace.InvalidTraceException;
import hu.eltesoft.modelexecution.runtime.trace.NoTraceReader;
import hu.eltesoft.modelexecution.runtime.trace.NoTracer;
import hu.eltesoft.modelexecution.runtime.trace.TargetedEvent;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader.EventSource;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;
import hu.eltesoft.modelexecution.runtime.validation.ValidationError;

/**
 * Executes the model using logging and tracing. Receives the name of the class
 * and the name of a static function to execute.
 */
public final class BaseRuntime implements AutoCloseable {

	private static final String LOGGER_ID = "hu.eltesoft.modelexecution.runtime.baseRuntime";
	public static final String RUNTIME_LOGGER_ID = LOGGER_ID + ".Runtime";
	public static final String STATES_LOGGER_ID = LOGGER_ID + ".StateMachine.States";
	public static final String TRANSITIONS_LOGGER_ID = LOGGER_ID + ".StateMachine.Transitions";
	public static final String MESSAGES_LOGGER_ID = LOGGER_ID + ".Events.Messages";

	private PriorityBlockingQueue<TargetedEvent> queue = new PriorityBlockingQueue<>();
	private Tracer traceWriter = new NoTracer();
	private TraceReader traceReader = new NoTraceReader();
	private Logger logger = new NoLogger();
	private RuntimeControllerServer controller;
	private static java.util.logging.Logger errorLogger = java.util.logging.Logger.getLogger(RUNTIME_LOGGER_ID); // $NON-NLS-1$

	private final ExternalEntityRegistry externalEntities;

	private ClassLoader classLoader = BaseRuntime.class.getClassLoader();

	private final CountDownLatch executionReady = new CountDownLatch(1);
	private boolean controlledStart = false;

	/**
	 * If has to set the class loader it must be done before the runtime is
	 * used.
	 */
	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	private static BaseRuntime INSTANCE = null;

	public static BaseRuntime getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BaseRuntime();
		}
		return INSTANCE;
	}

	private BaseRuntime() {
		externalEntities = new ExternalEntityRegistry(classLoader);
	}

	/**
	 * Switches the runtime to a controlled mode. In controlled mode, the
	 * runtime can be managed with control messages throught the control stream.
	 * This method may be called multiple times, in this case, the runtime
	 * responds to messages on all control streams.
	 */
	public void addControlStreams(InputStream controlStream, OutputStream eventStream) {
		controller = new RuntimeControllerServer(controlStream, eventStream, this);
		controller.startListening();
	}

	public void start() {
		executionReady.countDown();
	}

	/**
	 * Stops the execution of the runtime after the logs have been written out.
	 */
	public void terminate() {
		try {
			// explicitly call close
			close();
		} catch (Exception e) {
			logError("Cannot close the runtime", e);
		}
		System.exit(1);
	}

	public void addEventToQueue(ClassWithState target, Event event) {
		TargetedEvent targetedEvent = new TargetedEvent(target, event);
		queue.add(targetedEvent);
		logger.messageQueued(target, event);
	}

	public void addExternalEventToQueue(ClassWithState target, Event event) {
		TargetedEvent targetedEvent = TargetedEvent.createOutsideEvent(target, event);
		queue.add(targetedEvent);
		logger.messageQueued(target, event);
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
	public TerminationResult run(String className, String mainName) throws Exception {
		try {
			logInfo("Preparing system for execution");
			prepare(className, mainName);
			if (InstanceRegistry.getInstanceRegistry().hasReactiveInstances()) {
				if (controlledStart) {
					executionReady.await();
				}
				logInfo("Starting execution");
				do {
					// events read from trace will not be written to trace
					if (queue.isEmpty() && traceReader.hasEvent()) {
						traceReader.dispatchEvent(logger);
					} else {
						// if queue is empty, take blocks
						TargetedEvent currQueueEvent = queue.take();
						if (traceReader.dispatchEvent(currQueueEvent, logger) == EventSource.Trace) {
							// put back the event to the original position
							queue.add(currQueueEvent);
						} else {
							traceWriter.traceEvent(currQueueEvent);
						}
					}
				} while (InstanceRegistry.getInstanceRegistry().hasReactiveInstances());
			}
			logInfo("Execution terminated successfully");
			return TerminationResult.SUCCESSFUL_TERMINATION;
		} catch (InvalidTraceException e) {
			logError("The trace file is not consistent with the current model.", e);
			return TerminationResult.INVALID_TRACEFILE;
		} catch (ExternalEntityException e) {
			logError("Invalid external entity.", e);
			return TerminationResult.INVALID_EXTERNAL_ENTITY;
		} catch (Exception e) {
			logError("An internal error happened", e);
			return TerminationResult.INTERNAL_ERROR;
		} finally {
			if (controller != null) {
				controller.stopListening();
			}
		}
	}

	/**
	 * Runs the selected static main method.
	 */
	private void prepare(String className, String mainName)
			throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		java.lang.Class<?> classClass = classLoader.loadClass(className);
		Method main = classClass.getMethod(mainName);
		main.invoke(null);
	}

	public void logEnterState(String state) {
		logger.enterState(state);
	}

	public void logExitState(String state) {
		logger.exitState(state);
	}

	public void logTransition(String eventName, String messageName, String source, String target) {
		logger.transition(eventName, messageName, source, target);
	}

	public static void logInfo(String message) {
		errorLogger.log(java.util.logging.Level.INFO, message);
	}

	public static void validationError(ValidationError validationError) {
		errorLogger.log(java.util.logging.Level.SEVERE, validationError.getMessage());
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
		INSTANCE = null;
	}

	public <Impl> Impl getExternalEntity(Class<? super Impl> entityClass) {
		return externalEntities.getInstance(entityClass);
	}

	public void setControlledStart(boolean controlledStart) {
		this.controlledStart = controlledStart;

	}
}
