package hu.eltesoft.modelexecution.m2t.java

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2t.smap.xtend.SmapStringConcatenation
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult
import hu.eltesoft.modelexecution.uml.alf.ExternalEntityInvocation
import hu.eltesoft.modelexecution.uml.alf.ModelReferences
import hu.eltesoft.modelexecution.uml.alf.ReceptionInvocation
import org.eclipse.papyrus.uml.alf.BehaviorInvocationExpression
import org.eclipse.papyrus.uml.alf.Block
import org.eclipse.papyrus.uml.alf.BlockStatement
import org.eclipse.papyrus.uml.alf.ExpressionStatement
import org.eclipse.papyrus.uml.alf.FeatureInvocationExpression
import org.eclipse.papyrus.uml.alf.InvocationExpression
import org.eclipse.papyrus.uml.alf.NameBinding
import org.eclipse.papyrus.uml.alf.QualifiedName
import org.eclipse.papyrus.uml.alf.ThisExpression

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

	/**
	 * Handle feature invocation on an explicit this expression.
	 */
	private def dispatch void visit(FeatureInvocationExpression invocation) {
		builder.append(toJavaCode(invocation))
	}

	/**
	 * Handle behavior invocation on an implicit this expression.
	 */
	private def dispatch void visit(BehaviorInvocationExpression invocation) {
		builder.append(toJavaCode(invocation))
	}

	private def dispatch void visit(ThisExpression expr) {
		builder.append(CONTEXT_NAME)
	}

	private def dispatch CharSequence toJavaCode(NameBinding binding) {
		'''«binding.name»'''
	}

	private def dispatch CharSequence toJavaCode(QualifiedName qname) {
		'''«FOR binding : qname.nameBinding SEPARATOR '.'»«toJavaCode(binding)»«ENDFOR»'''
	}

	private def dispatch CharSequence toJavaCode(InvocationExpression invocation) {
		toJavaCode(references.resolve(invocation))
	}

	private def dispatch CharSequence toJavaCode(ReceptionInvocation invocation) {
		val namedReference = NamedReference.fromUnnamed(invocation.reference)
		val methodName = namedReference.identifier
		'''«CONTEXT_NAME».«methodName»()'''
	}

	private def dispatch CharSequence toJavaCode(ExternalEntityInvocation invocation) {
		val proxyName = invocation.proxyName
		'''
			«CONTEXT_NAME».getRuntime().getExternalEntity(«invocation.entityName».class)
				.«invocation.methodName»(«IF null != proxyName»new «proxyName»(«CONTEXT_NAME»)«ENDIF»)'''
	}
}
