package hu.eltesoft.modelexecution.runtime.log;

import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Event;

/**
 * A logger can output textual information about the execution of the model. It
 * has different logging methods that are called from the generated code when a
 * given situation occurs.
 * 
 * @author nboldi
 */
public abstract class Logger implements AutoCloseable {

	public abstract void eventQueued(Class target, Event event);

	public abstract void eventDispatched(Class target, Event event);

	public abstract void enterState(String state);

	public abstract void exitState(String state);

	public abstract void transition(String eventName, String source,
			String target);

}
