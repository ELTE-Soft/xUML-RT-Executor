package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.ReducedAlfSystem
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.Type

class TypeSystemExtensions {

	val ReducedAlfSystem typeSystem

	new(ReducedAlfSystem typeSystem) {
		this.typeSystem = typeSystem
	}

	protected def Type typeOf(EObject expression) {
		typeSystem.type(expression).value.umlType
	}

	protected def Type primitiveType(Object name) {
		typeSystem.typeFactory.primitiveTypeReference(name.toString).umlType
	}

	protected def isBoolean(EObject expression) {
		primitiveType(typeSystem.BOOLEAN) == typeOf(expression)
	}

	protected def isInteger(EObject expression) {
		primitiveType(typeSystem.INTEGER) == typeOf(expression)
	}

	protected def isReal(EObject expression) {
		primitiveType(typeSystem.REAL) == typeOf(expression)
	}

	protected def isString(EObject expression) {
		primitiveType(typeSystem.STRING) == typeOf(expression)
	}

	protected def isPrimitive(EObject expression) {
		expression.isBoolean || expression.isInteger || expression.isReal || expression.isString
	}

	protected def hasValueType(EObject expression) {
		expression.isPrimitive
	// TODO: add data types later
	}

	protected def hasReferenceType(EObject expression) {
		!expression.hasValueType
	}
}
