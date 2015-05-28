package hu.eltesoft.modelexecution.uml.alf

import org.eclipse.emf.ecore.EObject
import org.eclipse.papyrus.uml.alf.BehaviorInvocationExpression
import org.eclipse.papyrus.uml.alf.Block
import org.eclipse.papyrus.uml.alf.BlockStatement
import org.eclipse.papyrus.uml.alf.ExpressionStatement
import org.eclipse.papyrus.uml.alf.FeatureInvocationExpression
import org.eclipse.papyrus.uml.alf.NameBinding
import org.eclipse.papyrus.uml.alf.NameExpression
import org.eclipse.papyrus.uml.alf.QualifiedName
import org.eclipse.papyrus.uml.alf.ThisExpression
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Reception

/**
 * Builds a mapping between Alf AST nodes and model references.
 * Note that this is a workaround class until gets replaced by a new Alf
 * parser/semantic checker.
 */
class ModelReferenceDecorator {

	val ModelReferences references
	val Class context

	var EObject currentContext

	new(ModelReferences references, Class context) {
		this.references = references
		this.context = context

		currentContext = context
	}

	def getReferences() {
		references
	}

	def dispatch void visit(Block block) {
		for (annotated : block.statement) {
			visit(annotated.statement)
			currentContext = context;
		}
	}

	def dispatch void visit(BlockStatement blockStmt) {
		visit(blockStmt.block);
	}

	def dispatch void visit(ExpressionStatement stmt) {
		visit(stmt.expression)
	}

	/**
	 * Handle feature invocation on an explicit this expression.
	 */
	def dispatch void visit(FeatureInvocationExpression call) {
		val feature = call.target
		visit(feature.expression)
		val name = toModelName(feature.nameBinding)
		val referenced = lookupChild(name)

		// TODO: support referencing other element types
		references.putInvokedReception(call, referenced as Reception)
	}

	/**
	 * Handle behavior invocation on an implicit this expression.
	 */
	def dispatch void visit(BehaviorInvocationExpression call) {
		val name = toModelName(call.target)
		val referenced = lookupChild(name)

		// TODO: support referencing other element types
		references.putInvokedReception(call, referenced as Reception)
	}

	def dispatch void visit(ThisExpression expr) {
		currentContext = context;
	}

	def dispatch void visit(NameExpression expr) {
		for (binding : expr.name.nameBinding) {

			// TODO: this lookup mechanism is likely to be incorrect
			currentContext = lookupChild(binding.name)
		}
	}

	private def String toModelName(NameBinding binding) {
		binding.name
	}

	private def String toModelName(QualifiedName qname) '''«FOR binding : qname.nameBinding SEPARATOR '::'»«binding.name»«ENDFOR»'''

	private def EObject lookupChild(CharSequence name) {
		for (child : currentContext.eContents) {
			if (child instanceof NamedElement && (child as NamedElement).name.equals(name)) {
				return child
			}
		}
		return null
	}
}
