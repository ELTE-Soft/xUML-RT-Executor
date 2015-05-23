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

	/**
	 * Thrown when the event produced by the model and the event recorded in the
	 * trace does not check.
	 */
	public InvalidTraceException(TargetedMessage event,
			TargetedMessage tracedEvent) {
		this.event = event;
		this.tracedEvent = tracedEvent;
	}

	/**
	 * Thrown when there is an event that is in the trace but produced by the
	 * model.
	 */
	public InvalidTraceException(TargetedMessage tracedEvent) {
		this.tracedEvent = tracedEvent;
	}

	/**
	 * Used when the trace does not conform to the runtime (different classes
	 * are used)
	 */
	public InvalidTraceException(ClassNotFoundException e) {
		super(e);
	}

	public TargetedMessage getEvent() {
		return event;
	}

	public TargetedMessage getTracedEvent() {
		return tracedEvent;
	}

}
