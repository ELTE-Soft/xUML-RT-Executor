package hu.eltesoft.modelexecution.runtime.validation

import hu.eltesoft.modelexecution.runtime.validation.ValidationError

class EmptyValueError extends ValidationError {
		
	override getMessage() '''
		Empty value was used in an operation that requires having one single value.
	'''
	
}