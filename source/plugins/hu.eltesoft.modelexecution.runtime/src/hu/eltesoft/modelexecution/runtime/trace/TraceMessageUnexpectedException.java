package hu.eltesoft.modelexecution.runtime.trace;

public class TraceMessageUnexpectedException extends InvalidTraceException {

	private static final long serialVersionUID = 1L;

	private TargetedMessage unexpectedMessage;

	public TraceMessageUnexpectedException(TargetedMessage unexpectedMessage) {
		super("Did not expect any messages, but " + unexpectedMessage
				+ " was read");
		this.unexpectedMessage = unexpectedMessage;
	}

	public TargetedMessage getUnexpectedMessage() {
		return unexpectedMessage;
	}

}
