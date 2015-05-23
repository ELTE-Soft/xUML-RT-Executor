package hu.eltesoft.modelexecution.runtime.trace;

public class DeserializationException extends IllegalStateException {

	private static final long serialVersionUID = 1L;

	/**
	 * Thrown when the trace is not valid.
	 */
	public DeserializationException(Exception e) {
		super(e);
	}

}
