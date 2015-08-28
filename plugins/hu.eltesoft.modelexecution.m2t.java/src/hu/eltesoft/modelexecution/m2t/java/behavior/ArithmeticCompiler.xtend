package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes

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
			default:
				fun(PrimitiveOperations.NEGATE_BOOLEAN, compile(expr.operand))
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

	def dispatch CodeGenNode compile(ConditionalLogicalExpression expr) {
		val opName = if("&&" == expr.operator) PrimitiveOperations.BOOLEAN_AND else PrimitiveOperations.BOOLEAN_OR
		fun(opName, compile(expr.operand1), compile(expr.operand2))
	}

	def dispatch CodeGenNode compile(LogicalExpression expr) {
		val opName = switch expr.operator {
			case "&": if(expr.isBoolean) PrimitiveOperations.BOOLEAN_BITWISE_AND else PrimitiveOperations.
				INTEGER_BITWISE_AND
			case "|": if(expr.isBoolean) PrimitiveOperations.BOOLEAN_BITWISE_OR else PrimitiveOperations.
				INTEGER_BITWISE_OR
			case "^": if(expr.isBoolean) PrimitiveOperations.BOOLEAN_BITWISE_XOR else PrimitiveOperations.
				INTEGER_BITWISE_XOR
		}
		fun(opName, compile(expr.operand1), compile(expr.operand2))
	}
}
