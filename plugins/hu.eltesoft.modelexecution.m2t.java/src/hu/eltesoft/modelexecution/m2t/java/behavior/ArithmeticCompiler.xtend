package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression

class ArithmeticCompiler extends ExpressionCompiler {

	static extension CodeGenNode = CodeGenNode.extension

//	def dispatch CodeGenNode compile(ArithmeticExpression expr) {
//		System.out.println(typeOf(expr.operand1).name)
//		System.out.println(typeOf(expr.operand2).name)
//		sequence("TODO: implement!")
//	}
	def dispatch CodeGenNode compile(BooleanUnaryExpression expr) {
		val value = expr.operand
		switch value {
			LiteralExpression: {
				value.value = if("true" == value.value) "false" else "true"
				compile(expr.operand)
			}
			default: fun(PrimitiveOperations.NEGATE_BOOLEAN, compile(expr.operand))
		}
	}

	def dispatch CodeGenNode compile(NumericUnaryExpression expr) {
		if (NumericUnaryOperator.MINUS == expr.operator) {
			val value = expr.operand
			switch value {
				LiteralExpression:
					value.value = "-" + value.value
				default:
					if (value.isInteger) {
						return fun(PrimitiveOperations.NEGATE_INTEGER, compile(expr.operand))
					} else if (value.isReal) {
						return fun(PrimitiveOperations.NEGATE_REAL, compile(expr.operand))
					}
			}
		}
		compile(expr.operand)
	}
}
