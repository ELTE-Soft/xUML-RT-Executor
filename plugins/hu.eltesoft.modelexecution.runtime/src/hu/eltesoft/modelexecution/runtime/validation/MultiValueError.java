package hu.eltesoft.modelexecution.runtime.validation;

public class MultiValueError extends ValidationError {

	@Override
	public String getMessage() {
		return "A value with multiplicity greater than 1 was found in an operation that requires having one single value.";
	}
}
