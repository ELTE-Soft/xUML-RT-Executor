package hu.eltesoft.modelexecution.uml.alf

import hu.eltesoft.modelexecution.m2t.smap.emf.Reference
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.papyrus.uml.alf.InvocationExpression
import org.eclipse.uml2.uml.Reception

/**
 * Holds a mapping between Alf AST nodes and model references.
 * Note that this is a workaround class until gets replaced by a new Alf
 * parser/semantic checker.
 */
class ModelReferences {

	val Map<EObject, Reference> mapping = new HashMap()

	def putInvokedReception(InvocationExpression invocation, Reception reception) {
		if (null == invocation || null == reception) {
			return
		}
		mapping.put(invocation, new Reference(reception))
	}

	def getInvokedReception(InvocationExpression invocation) {
		mapping.get(invocation)
	}

	/**
	 * This method is mainly for testing purposes, hence its visibility.
	 */
	package def mapsReception(Reception reception) {
		mapping.containsValue(new Reference(reception))
	}
}
