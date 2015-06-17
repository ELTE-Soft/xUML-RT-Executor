package hu.eltesoft.modelexecution.m2t.java

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2t.smap.xtend.SmapStringConcatenation
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult
import hu.eltesoft.modelexecution.uml.alf.ModelReferences
import org.eclipse.papyrus.uml.alf.BehaviorInvocationExpression
import org.eclipse.papyrus.uml.alf.Block
import org.eclipse.papyrus.uml.alf.BlockStatement
import org.eclipse.papyrus.uml.alf.ExpressionStatement
import org.eclipse.papyrus.uml.alf.FeatureInvocationExpression
import org.eclipse.papyrus.uml.alf.InvocationExpression
import org.eclipse.papyrus.uml.alf.NameBinding
import org.eclipse.papyrus.uml.alf.NameExpression
import org.eclipse.papyrus.uml.alf.QualifiedName
import org.eclipse.papyrus.uml.alf.ThisExpression
import org.eclipse.papyrus.uml.alf.Tuple
import org.eclipse.papyrus.uml.alf.ReturnStatement
import org.eclipse.papyrus.uml.alf.NaturalLiteralExpression
import hu.eltesoft.modelexecution.runtime.values.MutableInt

/**
 * Generates an operation body written in Alf to Java code by implementing an
 * AST visitor.
 */
class BehaviorBodyGenerator {

	public static val CONTEXT_NAME = "context"

	var SmapStringConcatenation builder
	var ModelReferences references

	/**
	 * Compile the specified operation body code to Java source code. The output
	 * code will be returned along with its source mapping information.
	 */
	def SourceMappedText generate(AlfAnalyzerResult result) {
		references = result.references
		builder = new SmapStringConcatenation(Languages.ALF)
		visit(result.astRoot)
		return builder.toSourceMappedText
	}

	private def dispatch void visit(Block block) {
		for (annotated : block.statement) {
			visit(annotated.statement)
			builder.append("\n")
		}
	}

	private def dispatch void visit(BlockStatement blockStmt) {
		visit(blockStmt.block);
	}

	private def dispatch void visit(ExpressionStatement stmt) {
		visit(stmt.expression)
		builder.append(";")
	}
	
	private def dispatch void visit(ReturnStatement stmt) {
		builder.append("return ");
		visit(stmt.expression)
		builder.append(";")
	}

	/**
	 * Handle feature invocation on an explicit this expression.
	 */
	private def dispatch void visit(FeatureInvocationExpression call) {
		val feature = call.target
		visit(feature.expression)
		builder.append(".")
		builder.append(toJavaName(call))
		visit(call.tuple)
	}

	/**
	 * Handle behavior invocation on an implicit this expression.
	 */
	private def dispatch void visit(BehaviorInvocationExpression call) {
		builder.append(CONTEXT_NAME)
		builder.append(".")
		builder.append(toJavaName(call))
		visit(call.tuple)
	}

	private def dispatch void visit(ThisExpression expr) {
		builder.append(CONTEXT_NAME)
	}

	private def dispatch void visit(NameExpression expr) {
		builder.append(toJavaName(expr.name))
	}
	
	private def dispatch void visit(NaturalLiteralExpression expr) {
		builder.append("new ")
		builder.append(MutableInt.canonicalName)
		builder.append("(")
		builder.append(expr.image)
		builder.append(")")
	}

	private def dispatch void visit(Tuple tuple) {
		builder.append("()")
	}

	private def toJavaName(NameBinding binding) '''«binding.name»'''

	private def toJavaName(QualifiedName qname) '''«FOR binding : qname.nameBinding SEPARATOR '.'»«toJavaName(binding)»«ENDFOR»'''

	private def toJavaName(InvocationExpression call) {
		var reception = references.getInvokedReception(call)
		return NamedReference.fromUnnamed(reception).identifier
	}
}
