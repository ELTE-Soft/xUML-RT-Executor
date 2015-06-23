package hu.eltesoft.modelexecution.runtime.external;

public class ExternalEntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExternalEntityException(String message) {
		super(message);
	}

	public ExternalEntityException(String message, Throwable cause) {
		super(message, cause);
	}
}
