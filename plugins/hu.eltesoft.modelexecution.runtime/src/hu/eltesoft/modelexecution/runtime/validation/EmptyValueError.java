package hu.eltesoft.modelexecution.runtime.validation;

public class EmptyValueError extends ValidationError {

	@Override
	public String getMessage() {
		return "Empty value was used in an operation that requires having one single value.";
	}
}
