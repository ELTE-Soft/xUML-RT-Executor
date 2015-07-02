package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Event;

/**
 * The class responsible for running the modeled system, and an access point for
 * features used from the system, like event queues or logging.
 */
public interface Runtime {

	void logEnterState(String state);

	void logExitState(String state);

	void logTransition(String eventName, String messageName, String source,
			String target);

	/**
	 * Adds an internal event to the event queue. The order in which events are
	 * dispatched is not specified.
	 */
	void addEventToQueue(ClassWithState target, Event event);

	/**
	 * Adds an external event to the event queue. The order in which events are
	 * dispatched is not specified.
	 */
	void addExternalEventToQueue(ClassWithState target, Event event);

	/**
	 * Runs the model execution started by the execution of the given operation
	 * in the given class.
	 */
	TerminationResult run(String className, String feedName) throws Exception;

	/**
	 * Fetches an external entity instance by its interface class.
	 */
	<Impl> Impl getExternalEntity(Class<? super Impl> entityClass);
}
