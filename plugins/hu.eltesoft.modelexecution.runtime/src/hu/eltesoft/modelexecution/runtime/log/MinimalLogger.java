package hu.eltesoft.modelexecution.runtime.log;

import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Message;

/**
 * This logger outputs when state transitions happen.
 */
public class MinimalLogger implements Logger {

	@Override
	public void messageQueued(Class target, Message event) {
	}

	@Override
	public void enterState(String state) {
	}

	@Override
	public void exitState(String state) {
	}

	@Override
	public void transition(String eventName, String messageName, String source, String target) {
		System.out.println("Transition by " + messageName + "(" + eventName + ")" + ": " + source
				+ " -> " + target);
	}

	@Override
	public void messageDispatched(Class target, Message event) {
	}

	@Override
	public void close() throws Exception {
	}

}
