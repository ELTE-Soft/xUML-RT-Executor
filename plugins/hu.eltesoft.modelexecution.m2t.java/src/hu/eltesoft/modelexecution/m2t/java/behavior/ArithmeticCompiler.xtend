package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LeftHandSide
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator
import com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.PrefixExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftOperator
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class ArithmeticCompiler extends ExpressionCompiler {

	static extension CodeGenNode = CodeGenNode.extension

//	def dispatch CodeGenNode compile(ArithmeticExpression expr) {
//		System.out.println(typeOf(expr.operand1).name)
//		System.out.println(typeOf(expr.operand2).name)
//		sequence("TODO: implement!")
//	}
	def dispatch CodeGenNode compile(LeftHandSide lhs) {
		compile(lhs.expression)
	}

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

	def dispatch CodeGenNode compile(PrefixExpression expr) {
		val opName = if (AffixOperator.DECREMENT == expr.operator)
				PrimitiveOperations.INTEGER_PREFIX_DECREMENT
			else
				PrimitiveOperations.INTEGER_PREFIX_INCREMENT
		fun(opName, compile(expr.operand))
	}

	def dispatch CodeGenNode compile(PostfixExpression expr) {
		val opName = if (AffixOperator.DECREMENT == expr.operator)
				PrimitiveOperations.INTEGER_POSTFIX_DECREMENT
			else
				PrimitiveOperations.INTEGER_POSTFIX_INCREMENT
		fun(opName, compile(expr.operand))
	}

	def dispatch CodeGenNode compile(ConditionalLogicalExpression expr) {
		val opName = if("&&" == expr.operator) PrimitiveOperations.BOOLEAN_AND else PrimitiveOperations.BOOLEAN_OR
		fun(opName, compile(expr.operand1), compile(expr.operand2))
	}

	def dispatch CodeGenNode compile(LogicalExpression expr) {
		val opName = switch expr.operator {
			case "&":
				if (expr.isBoolean)
					PrimitiveOperations.BOOLEAN_BITWISE_AND
				else
					PrimitiveOperations.INTEGER_BITWISE_AND
			case "|":
				if (expr.isBoolean)
					PrimitiveOperations.BOOLEAN_BITWISE_OR
				else
					PrimitiveOperations.INTEGER_BITWISE_OR
			case "^":
				if (expr.isBoolean)
					PrimitiveOperations.BOOLEAN_BITWISE_XOR
				else
					PrimitiveOperations.INTEGER_BITWISE_XOR
		}
		fun(opName, compile(expr.operand1), compile(expr.operand2))
	}

	def dispatch CodeGenNode compile(ShiftExpression expr) {
		val opName = switch expr.operator {
			case ShiftOperator.LEFT: PrimitiveOperations.INTEGER_SHIFT_LEFT
			case ShiftOperator.RIGHT: PrimitiveOperations.INTEGER_SHIFT_RIGHT
			case ShiftOperator.TRIPLE: PrimitiveOperations.INTEGER_SHIFT_RIGHT_UNSIGNED
		}
		fun(opName, compile(expr.operand1), compile(expr.operand2))
	}
}
