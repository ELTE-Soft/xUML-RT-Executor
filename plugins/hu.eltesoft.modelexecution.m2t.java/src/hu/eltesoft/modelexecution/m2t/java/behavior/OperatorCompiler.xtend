package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator
import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentOperator
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.FeatureInvocationExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LeftHandSide
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LiteralExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.LogicalExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NameExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.NumericUnaryOperator
import com.incquerylabs.uml.ralf.reducedAlfLanguage.PostfixExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.PrefixExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.RelationalOperator
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftOperator
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2t.java.CompilationFailedException
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class OperatorCompiler extends ExpressionCompiler {

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
				value.value = if ("true" == value.value) {
					"false"
				} else {
					"true"
				}
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
		val opName = if (AffixOperator.DECREMENT == expr.operator) {
				PrimitiveOperations.INTEGER_PREFIX_DECREMENT
			} else {
				PrimitiveOperations.INTEGER_PREFIX_INCREMENT
			}
		fun(opName, compile(expr.operand))
	}

	def dispatch CodeGenNode compile(PostfixExpression expr) {
		val opName = if (AffixOperator.DECREMENT == expr.operator) {
				PrimitiveOperations.INTEGER_POSTFIX_DECREMENT
			} else {
				PrimitiveOperations.INTEGER_POSTFIX_INCREMENT
			}
		fun(opName, compile(expr.operand))
	}

	def dispatch CodeGenNode compile(ConditionalLogicalExpression expr) {
		val opName = if ("&&" == expr.operator) {
				PrimitiveOperations.BOOLEAN_AND
			} else {
				PrimitiveOperations.BOOLEAN_OR
			}
		fun(opName, compile(expr.operand1), compile(expr.operand2))
	}

	def dispatch CodeGenNode compile(LogicalExpression expr) {
		val opName = getBitwiseFunction(expr.operator, expr.isBoolean)
		fun(opName, compile(expr.operand1), compile(expr.operand2))
	}

	def getBitwiseFunction(String operator, boolean forBoolean) {
		switch operator {
			case "&":
				if (forBoolean)
					PrimitiveOperations.BOOLEAN_BITWISE_AND
				else
					PrimitiveOperations.INTEGER_BITWISE_AND
			case "|":
				if (forBoolean)
					PrimitiveOperations.BOOLEAN_BITWISE_OR
				else
					PrimitiveOperations.INTEGER_BITWISE_OR
			case "^":
				if (forBoolean)
					PrimitiveOperations.BOOLEAN_BITWISE_XOR
				else
					PrimitiveOperations.INTEGER_BITWISE_XOR
		}
	}

	def dispatch CodeGenNode compile(ShiftExpression expr) {
		val opName = getShiftFunction(expr.operator)
		fun(opName, compile(expr.operand1), compile(expr.operand2))
	}

	def getShiftFunction(ShiftOperator operator) {
		switch operator {
			case ShiftOperator.LEFT: PrimitiveOperations.INTEGER_SHIFT_LEFT
			case ShiftOperator.RIGHT: PrimitiveOperations.INTEGER_SHIFT_RIGHT
			case ShiftOperator.TRIPLE: PrimitiveOperations.INTEGER_SHIFT_RIGHT_UNSIGNED
		}
	}

	def dispatch compile(RelationalExpression expr) {
		val intLhs = expr.operand1.isInteger
		val intRhs = expr.operand2.isInteger
		val opName = if (intLhs && intRhs) {
				PrimitiveOperations.INTEGER_LESS_THAN_INTEGER
			} else if (intLhs) {
				PrimitiveOperations.INTEGER_LESS_THAN_REAL
			} else if (intRhs) {
				PrimitiveOperations.REAL_LESS_THAN_INTEGER
			} else {
				PrimitiveOperations.REAL_LESS_THAN_REAL
			}
		val lesser = fun(opName, compile(expr.operand1), compile(expr.operand2))
		val greater = fun(opName, compile(expr.operand2), compile(expr.operand1))
		switch expr.operator {
			case RelationalOperator.LESSER_THAN: lesser
			case RelationalOperator.GREATER_OR_EQUALS: fun(PrimitiveOperations.NEGATE_BOOLEAN, lesser)
			case RelationalOperator.GREATER_THAN: greater
			case RelationalOperator.LESSER_OR_EQUALS: fun(PrimitiveOperations.NEGATE_BOOLEAN, greater)
		}
	}

	def dispatch compile(AssignmentExpression assignment) {
		val lhs = assignment.leftHandSide
		val rhs = if (AssignmentOperator.ASSIGN == assignment.operator) {
				compile(assignment.rightHandSide)
			} else {
				// compound assignment, transform right hand side
				fun(getAssignmentOperatorFunction(assignment.operator, lhs.isBoolean), compile(lhs),
					compile(assignment.rightHandSide))
			}
		switch lhs {
			// attribute assignment
			FeatureInvocationExpression: {
				unwrap(compile(lhs.context)) ->
					fun(Template.SETTER_PREFIX <> NamedReference.getIdentifier(lhs.feature), rhs)
			}
			// local variable assignment
			NameExpression: {
				fun(PrimitiveOperations.SET_VALUE, compile(lhs), rhs)
			}
		}
	}

	def getAssignmentOperatorFunction(AssignmentOperator operator, boolean forBoolean) {
		switch operator {
			case AssignmentOperator.INCREMENT_ASSIGN: ""
			case AssignmentOperator.DECREMENT_ASSIGN: ""
			case AssignmentOperator.MULTIPLY_ASSIGN: ""
			case AssignmentOperator.DIVISION_ASSIGN: ""
			case AssignmentOperator.MODULO_ASSIGN: ""
			case AssignmentOperator.AND_ASSIGN: getBitwiseFunction("&", forBoolean)
			case AssignmentOperator.OR_ASSIGN: getBitwiseFunction("|", forBoolean)
			case AssignmentOperator.XOR_ASSIGN: getBitwiseFunction("^", forBoolean)
			case AssignmentOperator.LEFT_SHIFT_ASSIGN: getShiftFunction(ShiftOperator.LEFT)
			case AssignmentOperator.RIGHT_SHIFT_ASSIGN: getShiftFunction(ShiftOperator.RIGHT)
			case AssignmentOperator.TRIPLE_SHIFT_ASSIGN: getShiftFunction(ShiftOperator.TRIPLE)
			default: throw new CompilationFailedException("Unsupported compound assignment operator")
		}
	}
}
