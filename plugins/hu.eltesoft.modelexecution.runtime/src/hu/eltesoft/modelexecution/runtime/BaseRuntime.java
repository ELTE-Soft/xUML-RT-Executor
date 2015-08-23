package hu.eltesoft.modelexecution.runtime;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingDeque;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Event;
import hu.eltesoft.modelexecution.runtime.base.StatefulClass;
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

/**
 * Executes the model using logging and tracing. Receives the name of the class
 * and the name of a static function to execute.
 */
public class BaseRuntime implements Runtime, AutoCloseable {

	private static final String LOGGER_ID = "hu.eltesoft.modelexecution.runtime.baseRuntime.";
	public static final String RUNTIME_LOGGER_ID = LOGGER_ID + "Runtime";
	public static final String STATES_LOGGER_ID = LOGGER_ID + "StateMachine.States";
	public static final String TRANSITIONS_LOGGER_ID = LOGGER_ID + "StateMachine.Transitions";
	public static final String MESSAGES_LOGGER_ID = LOGGER_ID + "Events.Messages";

	private LinkedBlockingDeque<TargetedEvent> queue = new LinkedBlockingDeque<>();
	private Tracer traceWriter = new NoTracer();
	private TraceReader traceReader = new NoTraceReader();
	private Logger logger = new NoLogger();
	private ClassLoader classLoader;
	private RuntimeControllerServer controller;
	private static java.util.logging.Logger errorLogger = java.util.logging.Logger.getLogger(LOGGER_ID); // $NON-NLS-1$

	private final ExternalEntityRegistry externalEntities;

	public BaseRuntime(ClassLoader classLoader) {
		this.classLoader = classLoader;
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

	@Override
	public void addEventToQueue(StatefulClass target, Event event) {
		TargetedEvent targetedEvent = new TargetedEvent(target, event);
		queue.addLast(targetedEvent);
		logger.messageQueued(target, event);
	}

	@Override
	public void addExternalEventToQueue(StatefulClass target, Event event) {
		TargetedEvent targetedEvent = TargetedEvent.createOutsideEvent(target, event);
		queue.addLast(targetedEvent);
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
	@Override
	public TerminationResult run(String className, String feedName) throws Exception {
		try {
			logInfo("Preparing system for execution");
			prepare(className, feedName);
			logInfo("Starting execution");
			while (!InstanceRegistry.getInstanceRegistry().isEmpty()) {
				// events read from trace will not be written to trace
				if (queue.isEmpty() && traceReader.hasEvent()) {
					traceReader.dispatchEvent(logger);
				} else {
					// if queue is empty, take blocks
					TargetedEvent currQueueEvent = queue.take();
					if (traceReader.dispatchEvent(currQueueEvent, logger) == EventSource.Trace) {
						// put back the event to the original position
						queue.addFirst(currQueueEvent);
					} else {
						traceWriter.traceEvent(currQueueEvent);
					}
				}
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
	 * Registers the runtime in the {@link InstanceRegistry}. Creates an
	 * instance of the selected class and executes it.
	 */
	private void prepare(String className, String feedName) throws ClassNotFoundException, NoSuchMethodException,
			InstantiationException, IllegalAccessException, InvocationTargetException {
		java.lang.Class<?> classClass = classLoader.loadClass(className);

		Method creator = classClass.getMethod("create", Runtime.class);
		ClassWithState classInstance = (ClassWithState) creator.invoke(null, this);
		ClassWithState classInstance2 = (ClassWithState) creator.invoke(null, this);
		classInstance.init();
		classInstance2.init();
		Method method = classClass.getMethod(feedName);
		method.invoke(classInstance);
		method.invoke(classInstance2);
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
	}

	@Override
	public <Impl> Impl getExternalEntity(Class<? super Impl> entityClass) {
		return externalEntities.getInstance(entityClass);
	}
}
