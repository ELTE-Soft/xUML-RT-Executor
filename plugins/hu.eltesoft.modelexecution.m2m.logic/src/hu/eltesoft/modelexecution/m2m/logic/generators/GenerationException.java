package hu.eltesoft.modelexecution.m2m.logic.generators;

@SuppressWarnings("serial")
public class GenerationException extends RuntimeException {

	public GenerationException() {
	}
	
	public GenerationException(Exception cause) {
		super(cause);
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
