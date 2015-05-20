package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Message;

/**
 * The class responsible for running the modeled system, and an access point
 * for features used from the system, like event queues or logging.
 */
public interface Runtime {

	void logMessageQueued(ClassWithState target, Message event);

	void logMessageDispatched(ClassWithState target, Message event);

	void logEnterState(String state);

	void logExitState(String state);

	void logTransition(String eventName, String messageName, String source,
			String target);

	void addEventToQueue(ClassWithState target, Message message);
	
	public abstract TerminationResult run(String className, String feedName)
			throws Exception;

}