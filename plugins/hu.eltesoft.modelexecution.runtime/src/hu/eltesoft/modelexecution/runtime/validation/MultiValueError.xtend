package hu.eltesoft.modelexecution.runtime.validation

import hu.eltesoft.modelexecution.runtime.validation.ValidationError

class MultiValueError extends ValidationError {

	override getMessage() '''
		A value with multiplicity greater than 1 was found in an operation that requires having one single value.
	'''

}