package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.StringLiteralExpression
import org.apache.commons.lang.StringEscapeUtils

class LiteralCompiler extends ExpressionCompiler {

	def dispatch void compile(LiteralExpression lit) {
		append(lit.value)
	}

	def dispatch void compile(StringLiteralExpression lit) {
		append('''"«StringEscapeUtils.escapeJava(lit.value)»"''')
	}
}
