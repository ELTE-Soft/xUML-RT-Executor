package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Message;

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
	 * Adds an event to the event queue. The order in which evest are dispached
	 * is not specified.
	 */
	void addEventToQueue(ClassWithState target, Message message);

	/**
	 * Runs the model execution started by the execution of the given operation
	 * in the given class.
	 */
	public abstract TerminationResult run(String className, String feedName)
			throws Exception;

}