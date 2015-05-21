package hu.eltesoft.modelexecution.runtime.log;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Message;

/**
 * This logger outputs when state transitions happen.
 */
public class MinimalLogger implements Logger {

	private final java.util.logging.Logger stateLogger;
	private final java.util.logging.Logger transitionLogger;
	private final java.util.logging.Logger messageLogger;

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
		stateLogger.log(java.util.logging.Level.INFO, "Entered state {0}",
				state);
	}

	@Override
	public void exitState(String state) {
		stateLogger
				.log(java.util.logging.Level.INFO, "Exited state {0}", state);
	}

	@Override
	public void transition(String eventName, String messageName, String source,
			String target) {
		transitionLogger.log(java.util.logging.Level.INFO,
				"Transition by {1}( {0} ): {2} -> {3}", new Object[] {
						eventName, messageName, source, target });
	}

	@Override
	public void messageDispatched(ClassWithState target, Message event) {
		messageLogger.log(java.util.logging.Level.INFO,
				"Message {1} was dispatched to {0}", new Object[] { target,
						event });
	}

	@Override
	public void messageQueued(ClassWithState target, Message event) {
		messageLogger.log(java.util.logging.Level.INFO,
				"Message {1} is queued for dispatching to {0}", new Object[] {
						target, event });
	}

	@Override
	public void close() throws Exception {
	}

}
