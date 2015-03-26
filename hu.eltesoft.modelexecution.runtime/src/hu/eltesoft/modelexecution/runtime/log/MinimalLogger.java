package hu.eltesoft.modelexecution.runtime.log;

import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Event;

/**
 * This logger outputs when state transitions happen.
 */
public class MinimalLogger extends Logger {

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
		System.out.println("Transition by " + eventName + ": " + source
				+ " -> " + target);
	}

	@Override
	public void eventDispatched(Class target, Event event) {
	}

	@Override
	public void close() throws Exception {
	}

}
