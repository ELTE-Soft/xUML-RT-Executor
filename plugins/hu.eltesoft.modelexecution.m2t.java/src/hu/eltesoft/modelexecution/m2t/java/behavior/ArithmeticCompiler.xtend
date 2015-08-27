package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode

class ArithmeticCompiler extends ExpressionCompiler {

	static extension CodeGenNode = CodeGenNode.extension

	def dispatch CodeGenNode compile(ArithmeticExpression expr) {
		System.out.println(typeOf(expr.operand1).name)
		System.out.println(typeOf(expr.operand2).name)
		sequence("TODO: implement!")
	}
}
