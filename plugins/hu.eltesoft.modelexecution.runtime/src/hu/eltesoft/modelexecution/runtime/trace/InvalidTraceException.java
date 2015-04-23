package hu.eltesoft.modelexecution.runtime.trace;

/**
 * Indicates that recorded and observed events do not match, so there is an
 * inconsistency between the model and the replayed trace file. This is an
 * exception caused by the user and must be treated separately.
 */
public class InvalidTraceException extends RuntimeException {

	private TargetedEvent event;
	private TargetedEvent tracedEvent;

	private static final long serialVersionUID = 1L;

	public InvalidTraceException(TargetedEvent event, TargetedEvent tracedEvent) {
		this.event = event;
		this.tracedEvent = tracedEvent;
	}

	public TargetedEvent getEvent() {
		return event;
	}

	public TargetedEvent getTracedEvent() {
		return tracedEvent;
	}

}
