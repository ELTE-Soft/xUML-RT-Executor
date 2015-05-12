package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Message;

/**
 * The class responsible for running the modeled system, and an access point
 * for features used from the system, like event queues or logging.
 */
public interface Runtime {

	void logMessageQueued(Class target, Message event);

	void logMessageDispatched(Class target, Message event);

	void logEnterState(String state);

	void logExitState(String state);

	void logTransition(String eventName, String messageName, String source,
			String target);

	void addEventToQueue(Class target, Message message);
	
	public abstract TerminationResult run(String className, String feedName)
			throws Exception;

}