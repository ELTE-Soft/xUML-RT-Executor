package hu.eltesoft.modelexecution.runtime.log;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Message;

/**
 * A logger can output textual information about the execution of the model. It
 * has different logging methods that are called from the generated code when a
 * given situation occurs.
 */
public interface Logger extends AutoCloseable {

	void messageQueued(ClassWithState target, Message message);

	void messageDispatched(ClassWithState target, Message event);

	void enterState(String state);

	void exitState(String state);

	void transition(String eventName, String messageName, String source,
			String target);

}
