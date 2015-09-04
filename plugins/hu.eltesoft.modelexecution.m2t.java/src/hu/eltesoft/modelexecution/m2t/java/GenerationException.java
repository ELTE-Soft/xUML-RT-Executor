package hu.eltesoft.modelexecution.m2t.java;

@SuppressWarnings("serial")
public class GenerationException extends RuntimeException {

	public GenerationException() {
	}

	public GenerationException(Exception cause) {
		super(cause);
	}

	public GenerationException(String msg) {
		super(msg);
	}

	@Override
	public String getMessage() {
		if (getCause() != null) {
			return getCause().getMessage();
		} else {
			return super.getMessage();
		}
	}
}
