package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.ReducedAlfSystem
import com.incquerylabs.uml.ralf.scoping.IUMLContextProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.DataType
import org.eclipse.uml2.uml.Signal
import org.eclipse.uml2.uml.Type

class TypeSystemExtensions {

	val ReducedAlfSystem typeSystem

	new(ReducedAlfSystem typeSystem) {
		this.typeSystem = typeSystem
	}

	def Type typeOf(EObject expression) {
		typeSystem.type(expression).value.umlType
	}

	def Type valueTypeOf(EObject expression) {
		typeSystem.type(expression).value.umlValueType
	}

	def isBoolean(EObject expression) {
		IUMLContextProvider.BOOLEAN_TYPE == typeOf(expression).name
	}

	def isInteger(EObject expression) {
		IUMLContextProvider.INTEGER_TYPE == typeOf(expression).name
	}

	def isReal(EObject expression) {
		IUMLContextProvider.REAL_TYPE == typeOf(expression).name
	}

	def isString(EObject expression) {
		IUMLContextProvider.STRING_TYPE == typeOf(expression).name
	}

	def isPrimitive(EObject expression) {
		IUMLContextProvider.PRIMITIVE_TYPES.contains(typeOf(expression).name)
	}

	def hasValueType(EObject expression) {
		val type = typeSystem.type(expression).value.umlType
		expression.isPrimitive || type instanceof Signal || type instanceof DataType
	}

	def hasReferenceType(EObject expression) {
		!expression.hasValueType
	}
}
