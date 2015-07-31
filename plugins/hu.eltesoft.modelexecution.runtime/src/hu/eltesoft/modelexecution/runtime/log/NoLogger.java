package hu.eltesoft.modelexecution.runtime.log;

import hu.eltesoft.modelexecution.runtime.base.Event;
import hu.eltesoft.modelexecution.runtime.base.StatefulClass;

/**
 * A logger that does not log. Used to turn off logging support.
 */
public class NoLogger implements Logger {

	@Override
	public void enterState(String state) {
	}

	@Override
	public void exitState(String state) {
	}

	@Override
	public void transition(String eventName, String messageName, String source, String target) {
	}

	@Override
	public void close() throws Exception {
	}

	@Override
	public void messageQueued(StatefulClass target, Event event) {
	}

	@Override
	public void messageDispatched(StatefulClass target, Event event) {
	}

}
