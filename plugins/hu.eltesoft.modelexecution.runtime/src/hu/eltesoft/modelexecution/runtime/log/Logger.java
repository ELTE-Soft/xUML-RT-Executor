package hu.eltesoft.modelexecution.runtime.log;

import hu.eltesoft.modelexecution.runtime.base.Event;
import hu.eltesoft.modelexecution.runtime.base.StatefulClass;

/**
 * A logger can output textual information about the execution of the model. It
 * has different logging methods that are called from the generated code when a
 * given situation occurs.
 */
public interface Logger extends AutoCloseable {

	void messageQueued(StatefulClass target, Event event);

	void messageDispatched(StatefulClass target, Event event);

	void enterState(String state);

	void exitState(String state);

	void transition(String eventName, String messageName, String source, String target);

}
