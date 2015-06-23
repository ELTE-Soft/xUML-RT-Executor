package hu.eltesoft.modelexecution.uml.alf

import org.eclipse.emf.ecore.EObject
import org.eclipse.papyrus.uml.alf.BehaviorInvocationExpression
import org.eclipse.papyrus.uml.alf.Block
import org.eclipse.papyrus.uml.alf.BlockStatement
import org.eclipse.papyrus.uml.alf.ExpressionStatement
import org.eclipse.papyrus.uml.alf.FeatureInvocationExpression
import org.eclipse.papyrus.uml.alf.InvocationExpression
import org.eclipse.papyrus.uml.alf.NameBinding
import org.eclipse.papyrus.uml.alf.NameExpression
import org.eclipse.papyrus.uml.alf.QualifiedName
import org.eclipse.papyrus.uml.alf.SyntaxElement
import org.eclipse.papyrus.uml.alf.ThisExpression
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Operation
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
	def dispatch void visit(FeatureInvocationExpression invocation) {
		val feature = invocation.target
		visit(feature.expression)
		connectInvocation(invocation, toModelName(feature.nameBinding))
	}

	/**
	 * Handle behavior invocation on an implicit this expression or external entity call.
	 */
	def dispatch void visit(BehaviorInvocationExpression invocation) {
		connectInvocation(invocation, toModelName(invocation.target))
	}

	def connectInvocation(InvocationExpression invocation, String name) {
		val element = lookup(name)
		switch (element) {
			Reception:
				references.connect(invocation, element)
			Operation:
				references.connect(invocation, element)
			default:
				// this branch also handles null references
				throw new UnsupportedAlfFeatureException(
					"Invocation target `" + name +
						"` cannot be found. Only receptions and external entity calls are supported.")
		}
	}

	private def String toModelName(NameBinding binding) {
		binding.name
	}

	private def String toModelName(QualifiedName qname) '''«FOR binding : qname.nameBinding SEPARATOR '::'»«binding.name»«ENDFOR»'''

	def dispatch void visit(ThisExpression expr) {
		currentContext = context;
	}

	def dispatch void visit(NameExpression expr) {
		for (binding : expr.name.nameBinding) {

			// TODO: this lookup mechanism is likely to be incorrect
			currentContext = lookup(binding.name)
		}
	}

	def dispatch void visit(SyntaxElement other) {
		throw new UnsupportedAlfFeatureException(other.toString);
	}

	private def EObject lookup(String name) {
		if (isExternalCall(name)) {
			return lookupExternalCall(name);
		}
		return lookupInContext(currentContext, name);
	}

	private def isExternalCall(CharSequence name) {
		val identifierPattern = "[\\p{L}_$][\\p{L}\\p{N}_$]*";
		return name.toString.matches(identifierPattern + "::" + identifierPattern);
	}

	private def EObject lookupExternalCall(String name) {
		val parts = name.split("::")

		if (null == model) {
			return null
		}
		val entity = lookupInContext(model, parts.get(0))

		if (null == entity) {
			return null
		}
		val operation = lookupInContext(entity, parts.get(1))
		return operation
	}

	private def EObject getModel() {
		var parent = currentContext;
		while (null != parent.eContainer) {
			parent = parent.eContainer
		}
		return parent
	}

	private def EObject lookupInContext(EObject providedContext, String name) {
		for (child : providedContext.eContents) {
			if (child instanceof NamedElement && (child as NamedElement).name.equals(name)) {
				return child
			}
		}
		return null
	}
}
