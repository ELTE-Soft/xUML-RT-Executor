package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.ExpressionStatement
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NullExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ThisExpression

class ExpressionCompiler extends Compiler {

	def dispatch void compile(ExpressionStatement statement) {
		compile(statement.expression)
		append(";")
	}

	def dispatch void compile(NullExpression expr) {
		append("null")
	}

	def dispatch void compile(ThisExpression expr) {
		append(Compiler.CONTEXT_NAME)
	}
}
