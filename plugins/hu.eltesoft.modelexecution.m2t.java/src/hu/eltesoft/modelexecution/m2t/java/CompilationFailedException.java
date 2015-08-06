package hu.eltesoft.modelexecution.m2t.java;

public class CompilationFailedException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public CompilationFailedException(String message) {
		super(message);
	}

	public CompilationFailedException(Exception cause) {
		super(cause);
	}

	@Override
	public String getMessage() {
		if (null != getCause()) {
			return getCause().getMessage();
		}
		return super.getMessage();
	}
}
