package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Event;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.trace.TargetedEvent;
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
 * 
 * @author nboldi
 */
public abstract class BaseRuntime implements Runtime {

	private Queue<TargetedEvent> queue = new LinkedList<>();

	private Tracer traceWriter;
	private TraceReader traceReader;
	private Logger logger;

	public BaseRuntime(Tracer tracer, TraceReader traceReader, Logger logger) {
		this.traceWriter = tracer;
		this.traceReader = traceReader;
		this.logger = logger;
	}

	@Override
	public void addEventToQueue(Class target, Event event) {
		TargetedEvent targetedEvent = new TargetedEvent(target, event);
		queue.add(targetedEvent);
		logger.eventQueued(target, event);
	}

	/**
	 * Runs the system. This can be an entry point of the runtime.
	 */
	public void run(String className, String feedName) throws Exception {
		prepare(className, feedName);
		while (!queue.isEmpty() || traceReader.hasEvent()) {
			if (!queue.isEmpty()) {
				TargetedEvent currQueueEvent = queue.peek();
				if (traceReader.dispatchEvent(currQueueEvent, logger) == EventSource.Queue) {
					queue.poll();
					traceWriter.traceEvent(currQueueEvent);
				}
			} else {
				// TODO: log events from outside
				traceReader.dispatchEvent(logger);
			}
		}
		traceWriter.close();
		traceReader.close();
		logger.close();
	}

	private void prepare(String className, String feedName)
			throws ClassNotFoundException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		java.lang.Class<?> classClass = java.lang.Class.forName(className);
		Constructor<?> constructor = classClass.getConstructor(Runtime.class);
		Class classInstance = (Class) constructor.newInstance(this);
		classInstance.init();
		Method method = classClass.getMethod(feedName);
		method.invoke(classInstance);
	}

	@Override
	public void logEventQueued(Class target, Event event) {
		logger.eventQueued(target, event);
	}

	@Override
	public void logEventDispatched(Class target, Event event) {
		logger.eventDispatched(target, event);
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
	public void logTransition(String eventName, String source, String target) {
		logger.transition(eventName, source, target);
	}

}
