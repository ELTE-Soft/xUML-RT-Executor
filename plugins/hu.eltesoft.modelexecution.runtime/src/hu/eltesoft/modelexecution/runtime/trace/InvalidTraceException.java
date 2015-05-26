package hu.eltesoft.modelexecution.runtime.trace;

/**
 * An exception raised when the trace file cannot be replayed. This is an
 * exception caused by the user and must be treated separately. Can be used when
 * the trace does not conform to the runtime (different classes are used, or a
 * class has changed), or the read event is not the one that is expected.
 */
public class InvalidTraceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidTraceException(Exception cause) {
		super(cause);
	}

	public InvalidTraceException(String msg) {
		super(msg);
	}

	public InvalidTraceException(String msg, Exception cause) {
		super(msg, cause);
	}

}
