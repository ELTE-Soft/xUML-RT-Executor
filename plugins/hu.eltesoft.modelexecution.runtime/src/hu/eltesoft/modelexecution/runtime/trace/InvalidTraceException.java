package hu.eltesoft.modelexecution.runtime.trace;

/**
 * Indicates that recorded and observed events do not match, so there is an
 * inconsistency between the model and the replayed trace file. This is an
 * exception caused by the user and must be treated separately.
 */
public class InvalidTraceException extends RuntimeException {

	private TargetedMessage event;
	private TargetedMessage tracedEvent;

	private static final long serialVersionUID = 1L;

	public InvalidTraceException(TargetedMessage event, TargetedMessage tracedEvent) {
		this.event = event;
		this.tracedEvent = tracedEvent;
	}

	public TargetedMessage getEvent() {
		return event;
	}

	public TargetedMessage getTracedEvent() {
		return tracedEvent;
	}

}
