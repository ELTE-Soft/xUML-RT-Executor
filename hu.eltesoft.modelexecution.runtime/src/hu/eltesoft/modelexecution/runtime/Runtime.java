package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Event;

/**
 * The class responsible for running the modelled system, and an access point
 * for features used from the system, like event queues or logging.
 * 
 * @author nboldi
 */
public interface Runtime {

	public abstract void addEventToQueue(Class target, Event event);

	public abstract void logEventQueued(Class target, Event event);

	public abstract void logEventDispatched(Class target, Event event);

	public abstract void logEnterState(String state);

	public abstract void logExitState(String state);

	public abstract void logTransition(String eventName, String source,
			String target);

}