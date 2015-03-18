package hu.eltesoft.modelexecution.uml.alf

import hu.eltesoft.modelexecution.m2t.smap.xtend.SmapStringConcatenation
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import org.eclipse.papyrus.uml.alf.BehaviorInvocationExpression
import org.eclipse.papyrus.uml.alf.Block
import org.eclipse.papyrus.uml.alf.ExpressionStatement
import org.eclipse.papyrus.uml.alf.FeatureInvocationExpression
import org.eclipse.papyrus.uml.alf.NameExpression
import org.eclipse.papyrus.uml.alf.QualifiedName
import org.eclipse.papyrus.uml.alf.SyntaxElement
import org.eclipse.papyrus.uml.alf.ThisExpression
import org.eclipse.papyrus.uml.alf.Tuple
import org.eclipse.xtext.parser.IParseResult

@Data
class CompilationResult {
	IParseResult parseResult
	SourceMappedText output;
}

class OperationBodyCompiler {

	public static val CONTEXT_NAME = "context"

	val parser = new OperationBodyParser
	var SmapStringConcatenation builder

	def IParseResult compile(String alfCode, SmapStringConcatenation builder) {
		val parseResult = parser.parse(alfCode)
		if (!parseResult.hasSyntaxErrors) {
			this.builder = builder
			visit(parseResult.rootASTElement as SyntaxElement)
		}
		return parseResult
	}

	private def dispatch void visit(Block block) {
		for (annotated : block.statement) {
			visit(annotated.statement)
		}
	}

	private def dispatch void visit(ExpressionStatement stmt) {
		visit(stmt.expression)
		builder.append(";")
	}

	private def dispatch void visit(FeatureInvocationExpression call) {
		val feature = call.target
		visit(feature.expression)
		builder.append(".")
		builder.append(feature.nameBinding.name)
		visit(call.tuple)
	}

	private def dispatch void visit(BehaviorInvocationExpression call) {
		builder.append(CONTEXT_NAME)
		builder.append(".")
		builder.append(toJavaName(call.target))
		visit(call.tuple)
	}

	private def dispatch void visit(ThisExpression expr) {
		builder.append(CONTEXT_NAME)
	}

	private def dispatch void visit(NameExpression expr) {
		builder.append(toJavaName(expr.name))
	}

	private def dispatch void visit(Tuple tuple) {
		builder.append("()")
	}

	private def toJavaName(QualifiedName qname) '''«FOR binding : qname.nameBinding SEPARATOR '.'»«binding.name»«ENDFOR»'''
}
