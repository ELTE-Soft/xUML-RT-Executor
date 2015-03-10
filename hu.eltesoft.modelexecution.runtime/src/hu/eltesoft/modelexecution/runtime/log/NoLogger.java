package hu.eltesoft.modelexecution.runtime.log;

import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Event;

/**
 * A logger that does not log. Used to turn off logging support.
 * 
 * @author nboldi
 */
public class NoLogger extends Logger {

	@Override
	public void eventQueued(Class target, Event event) {
	}

	@Override
	public void enterState(String state) {
	}

	@Override
	public void exitState(String state) {
	}

	@Override
	public void transition(String eventName, String source, String target) {
	}

	@Override
	public void eventDispatched(Class target, Event event) {
	}

	@Override
	public void close() throws Exception {
	}

}
