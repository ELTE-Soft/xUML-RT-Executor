package hu.eltesoft.modelexecution.m2t.java.behavior

import com.incquerylabs.uml.ralf.reducedAlfLanguage.AffixOperator
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ArithmeticExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.AssignmentOperator
import com.incquerylabs.uml.ralf.reducedAlfLanguage.BooleanUnaryExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ConditionalLogicalExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.EqualityExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.Expression
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
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftExpression
import com.incquerylabs.uml.ralf.reducedAlfLanguage.ShiftOperator
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2t.java.CompilationFailedException
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class OperatorCompiler extends ExpressionCompiler {

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
				fun(PrimitiveOperations.BOOLEAN_NEGATE, compile(expr.operand))
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
						return fun(PrimitiveOperations.INTEGER_NEGATE, compile(expr.operand))
					} else if (value.isReal) {
						return fun(PrimitiveOperations.REAL_NEGATE, compile(expr.operand))
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

	def dispatch CodeGenNode compile(ArithmeticExpression expr) {
		val opName = getArithmeticFunction(expr.operator, expr.operand1, expr.operand2)
		fun(opName, compile(expr.operand1), compile(expr.operand2))
	}

	def getArithmeticFunction(String operator, Expression op1, Expression op2) {
		val intLhs = op1.isInteger
		val intRhs = op2.isInteger
		switch operator {
			case "+":
				if (op1.isString && op2.isString) {
					PrimitiveOperations.STRING_CONCATENATION
				} else if (intLhs && intRhs) {
					PrimitiveOperations.INTEGER_ADD_INTEGER
				} else if (intLhs) {
					PrimitiveOperations.INTEGER_ADD_REAL
				} else if (intRhs) {
					PrimitiveOperations.REAL_ADD_INTEGER
				} else {
					PrimitiveOperations.REAL_ADD_REAL
				}
			case "-":
				if (intLhs && intRhs) {
					PrimitiveOperations.INTEGER_SUBTRACT_INTEGER
				} else if (intLhs) {
					PrimitiveOperations.INTEGER_SUBTRACT_REAL
				} else if (intRhs) {
					PrimitiveOperations.REAL_SUBTRACT_INTEGER
				} else {
					PrimitiveOperations.REAL_SUBTRACT_REAL
				}
			case "*":
				if (intLhs && intRhs) {
					PrimitiveOperations.INTEGER_MULTIPLY_INTEGER
				} else if (intLhs) {
					PrimitiveOperations.INTEGER_MULTIPLY_REAL
				} else if (intRhs) {
					PrimitiveOperations.REAL_MULTIPLY_INTEGER
				} else {
					PrimitiveOperations.REAL_MULTIPLY_REAL
				}
			case "/":
				if (intLhs && intRhs) {
					PrimitiveOperations.INTEGER_DIVIDE_INTEGER
				} else if (intLhs) {
					PrimitiveOperations.INTEGER_DIVIDE_REAL
				} else if (intRhs) {
					PrimitiveOperations.REAL_DIVIDE_INTEGER
				} else {
					PrimitiveOperations.REAL_DIVIDE_REAL
				}
			case "%":
				PrimitiveOperations.INTEGER_MODULO_INTEGER
		}
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

	def dispatch CodeGenNode compile(RelationalExpression expr) {
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
			case LESSER_THAN: lesser
			case GREATER_OR_EQUALS: fun(PrimitiveOperations.BOOLEAN_NEGATE, lesser)
			case GREATER_THAN: greater
			case LESSER_OR_EQUALS: fun(PrimitiveOperations.BOOLEAN_NEGATE, greater)
		}
	}

	def dispatch CodeGenNode compile(EqualityExpression expr) {
		val opName = if (expr.operand1.hasValueType) {
				PrimitiveOperations.VALUE_EQUALITY
			} else {
				PrimitiveOperations.REFERENCE_EQUALITY
			};
		val eq = fun(opName, compile(expr.operand1), compile(expr.operand2))
		switch expr.operator {
			case EQUALS: eq
			case NOT_EQUALS: fun(PrimitiveOperations.BOOLEAN_NEGATE, eq)
		}
	}

	def dispatch CodeGenNode compile(AssignmentExpression assignment) {
		val lhs = assignment.leftHandSide
		val rhs = if (AssignmentOperator.ASSIGN == assignment.operator) {
				compile(assignment.rightHandSide)
			} else {
				// compound assignment, transform right hand side
				fun(getAssignmentOperatorFunction(assignment.operator, lhs, assignment.rightHandSide), compile(lhs),
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

	def getAssignmentOperatorFunction(AssignmentOperator operator, Expression op1, Expression op2) {
		val forBoolean = op1.isBoolean
		switch operator {
			case INCREMENT_ASSIGN: getArithmeticFunction("+", op1, op2)
			case DECREMENT_ASSIGN: getArithmeticFunction("-", op1, op2)
			case MULTIPLY_ASSIGN: getArithmeticFunction("*", op1, op2)
			case DIVISION_ASSIGN: getArithmeticFunction("/", op1, op2)
			case MODULO_ASSIGN: getArithmeticFunction("%", op1, op2)
			case AND_ASSIGN: getBitwiseFunction("&", forBoolean)
			case OR_ASSIGN: getBitwiseFunction("|", forBoolean)
			case XOR_ASSIGN: getBitwiseFunction("^", forBoolean)
			case LEFT_SHIFT_ASSIGN: getShiftFunction(ShiftOperator.LEFT)
			case RIGHT_SHIFT_ASSIGN: getShiftFunction(ShiftOperator.RIGHT)
			case TRIPLE_SHIFT_ASSIGN: getShiftFunction(ShiftOperator.TRIPLE)
			default: throw new CompilationFailedException("Unsupported compound assignment operator")
		}
	}
}
