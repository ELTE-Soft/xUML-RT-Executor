package hu.eltesoft.modelexecution.runtime.log;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Message;

/**
 * This logger outputs when state transitions happen.
 */
public class MinimalLogger implements Logger {

	private java.util.logging.Logger stateLogger;
	private java.util.logging.Logger transitionLogger;
	private java.util.logging.Logger messageLogger;

	public MinimalLogger() {
		this.stateLogger = java.util.logging.Logger
				.getLogger(BaseRuntime.STATES_LOGGER_ID);
		this.transitionLogger = java.util.logging.Logger
				.getLogger(BaseRuntime.TRANSITIONS_LOGGER_ID);
		this.messageLogger = java.util.logging.Logger
				.getLogger(BaseRuntime.MESSAGES_LOGGER_ID);
	}


	@Override
	public void enterState(String state) {
		stateLogger.log(java.util.logging.Level.INFO, "Entered state " + state,
				new Object[] { state });
	}

	@Override
	public void exitState(String state) {
		stateLogger.log(java.util.logging.Level.INFO, "Exited state " + state,
				new Object[] { state });
	}

	@Override
	public void transition(String eventName, String messageName, String source,
			String target) {
		transitionLogger.log(java.util.logging.Level.INFO, "Transition by "
				+ messageName + "(" + eventName + ")" + ": " + source + " -> "
				+ target,
				new Object[] { eventName, messageName, source, target });
	}

	@Override
	public void messageDispatched(Class target, Message event) {
		messageLogger.log(java.util.logging.Level.INFO, "Message " + event
				+ " was dispatched to " + target,
				new Object[] { target, event });
	}

	@Override
	public void messageQueued(Class target, Message event) {
		messageLogger.log(java.util.logging.Level.INFO, "Message " + event
				+ " is queued for dispatching to " + target,
				new Object[] { target, event });
	}
	
	@Override
	public void close() throws Exception {
	}

}
