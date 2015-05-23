package hu.eltesoft.modelexecution.runtime.trace;

/**
 * Indicates that recorded and observed events do not match, so there is an
 * inconsistency between the model and the replayed trace file.
 */
public class TraceMessageMismatchException extends InvalidTraceException {

	private static final long serialVersionUID = 1L;

	private TargetedMessage expectedMessage;
	private TargetedMessage actualMessage;

	public TraceMessageMismatchException(TargetedMessage expectedMessage,
			TargetedMessage actualMessage) {
		super("Expected event: " + expectedMessage + ", actual event: "
				+ actualMessage);
		this.expectedMessage = expectedMessage;
		this.actualMessage = actualMessage;
	}

	public TargetedMessage getExpectedMessage() {
		return expectedMessage;
	}

	public TargetedMessage getTracedMessage() {
		return actualMessage;
	}

}
