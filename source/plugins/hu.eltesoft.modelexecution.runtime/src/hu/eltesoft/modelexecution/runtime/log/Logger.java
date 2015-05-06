package hu.eltesoft.modelexecution.runtime.log;

import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Event;

/**
 * A logger can output textual information about the execution of the model. It
 * has different logging methods that are called from the generated code when a
 * given situation occurs.
 */
public interface Logger extends AutoCloseable {

	void eventQueued(Class target, Event event);

	void eventDispatched(Class target, Event event);

	void enterState(String state);

	void exitState(String state);

	void transition(String eventName, String source, String target);

}
