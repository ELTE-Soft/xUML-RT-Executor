package hu.eltesoft.modelexecution.uml.alf

import hu.eltesoft.modelexecution.m2t.smap.emf.Reference
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.papyrus.uml.alf.InvocationExpression
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.Reception

/**
 * Holds a mapping between Alf AST nodes and model references.
 * Note that this is a workaround class until gets replaced by a new Alf
 * parser/semantic checker.
 */
class ModelReferences {

	protected val Map<EObject, Invocation> mapping = new HashMap()

	def dispatch connect(InvocationExpression invocation, Reception reception) {
		mapping.put(invocation, new ReceptionInvocation(reception))
	}

	def dispatch connect(InvocationExpression invocation, Operation operation) {
		mapping.put(invocation, new ExternalEntityInvocation(operation))
	}

	def resolve(InvocationExpression invocation) {
		mapping.get(invocation)
	}
}

interface Invocation {
}

class ReceptionInvocation implements Invocation {

	val Reference reference

	def getReference() {
		reference
	}

	new(Reception reception) {
		reference = new Reference(reception)
	}

	// mainly used for testing purposes
	override boolean equals(Object obj) {
		if (this === obj) {
			return true
		}
		if (obj == null || class != obj.class) {
			return false
		}
		val other = obj as ReceptionInvocation;
		return reference.equals(other.reference);
	}
}

class ExternalEntityInvocation implements Invocation {

	val String entityName
	val String methodName
	val String proxyName

	def getEntityName() {
		entityName
	}

	def getMethodName() {
		methodName
	}

	def getProxyName() {
		proxyName
	}

	new(Operation operation) {
		entityName = (operation.owner as NamedElement).name
		methodName = operation.name

		if (operation.ownedParameters.empty) {
			proxyName = null
		} else {

			// When the external call has a parameter, it must be a reference to a callable class.
			proxyName = operation.ownedParameters.get(0).type.name
		}
	}

	// mainly used for testing purposes
	override boolean equals(Object obj) {
		if (this === obj) {
			return true
		}
		if (obj == null || class != obj.class) {
			return false
		}
		val other = obj as ExternalEntityInvocation;
		return entityName.equals(other.entityName) && methodName.equals(other.methodName) &&
			((proxyName == null && other.proxyName == null) || proxyName.equals(other.proxyName));
	}
}
