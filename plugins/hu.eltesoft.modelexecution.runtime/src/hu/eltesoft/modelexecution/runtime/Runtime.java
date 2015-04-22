package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Event;

/**
 * The class responsible for running the modelled system, and an access point
 * for features used from the system, like event queues or logging.
 */
public interface Runtime {

	void addEventToQueue(Class target, Event event);

	void logEventQueued(Class target, Event event);

	void logEventDispatched(Class target, Event event);

	void logEnterState(String state);

	void logExitState(String state);

	void logTransition(String eventName, String source, String target);

	public abstract void run(String className, String feedName)
			throws Exception;

}