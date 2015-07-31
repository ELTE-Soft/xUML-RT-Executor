package hu.eltesoft.modelexecution.m2t.java;

public class CompilationFailedException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public CompilationFailedException(Exception cause) {
		super(cause);
	}
	
	@Override
	public String getMessage() {
		return getCause().getMessage();
	}

}
