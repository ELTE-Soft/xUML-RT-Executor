package hu.eltesoft.modelexecution.runtime.trace;

public class TraceMessageUnexpectedException extends InvalidTraceException {

	private static final long serialVersionUID = 1L;

	private TargetedEvent unexpectedMessage;

	public TraceMessageUnexpectedException(TargetedEvent unexpectedMessage) {
		super("Did not expect any messages, but " + unexpectedMessage + " was read");
		this.unexpectedMessage = unexpectedMessage;
	}

	public TargetedEvent getUnexpectedMessage() {
		return unexpectedMessage;
	}

}
