package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.api.impl.ParsingResults
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionList
import com.incquerylabs.uml.ralf.reducedAlfLanguage.InstanceCreationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.SendSignalStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Statements
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ThisExpression
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2t.smap.xtend.SmapStringConcatenation
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText
import hu.eltesoft.modelexecution.runtime.base.SignalEvent
import hu.eltesoft.modelexecution.m2t.java.Languages

/**
 * Generates an operation body written in rAlf to Java code by implementing an
 * AST visitor.
 */
class BehaviorBodyGenerator {

	public static val CONTEXT_NAME = "context"

	var SmapStringConcatenation builder

	/**
	 * Compile the specified operation body code to Java source code. The output
	 * code will be returned along with its source mapping information.
	 */
	def SourceMappedText generate(ParsingResults results) {
		builder = new SmapStringConcatenation(Languages.RALF)
		if (results.validationOK) {
			visit(results.model)
		}
		return builder.toSourceMappedText
	}

	private def dispatch void visit(Statements statements) {
		for (statement : statements.statement) {
			visit(statement)
			builder.append("\n")
		}
	}

	private def dispatch void visit(SendSignalStatement send) {
		visit(send.target)
		builder.append(".send(new ")
		builder.append(SignalEvent.canonicalName)
		builder.append("(")
		visit(send.signal)
		builder.append("));")
	}

	private def dispatch void visit(ThisExpression expr) {
		builder.append(CONTEXT_NAME)
	}

	private def dispatch void visit(InstanceCreationExpression expr) {
		builder.append("new ")
		builder.append(NamedReference.getIdentifier(expr.instance))
		visit(expr.tuple)
	}

	private def dispatch void visit(ExpressionList list) {
		builder.append("(")
		builder.append('''«FOR expr : list.expressions SEPARATOR ','»«visit(expr)»«ENDFOR»''')
		builder.append(")")
	}

/* 
 * 	/**
 * Handle feature invocation on an explicit this expression.
 * 
 * 	private def dispatch void visit(FeatureInvocationExpression invocation) {
 * 		builder.append(toJavaCode(invocation))
 * 	}
 * 
 * 	/**
 * Handle behavior invocation on an implicit this expression.
 * 
 * 	private def dispatch void visit(BehaviorInvocationExpression invocation) {
 * 		builder.append(toJavaCode(invocation))
 * 	}
 * 
 * 	private def dispatch CharSequence toJavaCode(NameBinding binding) {
 * 		'''«binding.name»'''
 * 	}
 * 
 * 	private def dispatch CharSequence toJavaCode(QualifiedName qname) {
 * 		'''«FOR binding : qname.nameBinding SEPARATOR '.'»«toJavaCode(binding)»«ENDFOR»'''
 * 	}
 * 
 * 	private def dispatch CharSequence toJavaCode(InvocationExpression invocation) {
 * 		toJavaCode(references.resolve(invocation))
 * 	}
 * 
 * 	private def dispatch CharSequence toJavaCode(ReceptionInvocation invocation) {
 * 		val namedReference = NamedReference.fromUnnamed(invocation.reference)
 * 		val methodName = namedReference.identifier
 * 		'''«CONTEXT_NAME».«methodName»()'''
 * 	}
 * 
 * 	private def dispatch CharSequence toJavaCode(ExternalEntityInvocation invocation) {
 * 		val proxyName = invocation.proxyName
 * 		'''
 * 		«CONTEXT_NAME».getRuntime().getExternalEntity(«invocation.entityName».class)
 * 			.«invocation.methodName»(«IF null != proxyName»new «proxyName»(«CONTEXT_NAME»)«ENDIF»)'''
 * 	}
 */
}
