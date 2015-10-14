package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import java.math.BigInteger
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class OperatorTests extends CompiledCodeCheckTestCase {

	static val FALSE = booleanLiteral("false")
	static val TRUE = booleanLiteral("true")

	static val INTEGER_ZERO = integerLiteral("0", 10)
	static val INTEGER_ONE = integerLiteral("1", 10)

	static val REAL_ZERO = realLiteral("0.0")
	static val REAL_ONE = realLiteral("1.0")

	new() {
		compiler = new OperatorCompiler()
	}

	@Test
	def testNegateBooleanLiteral() {
		assertCompilesTo('''!false;''', TRUE)
	}

	@Test
	def testUnaryMinusIntegerLiteral() {
		assertCompilesTo('''-10;''', integerLiteral("-10", 10))
	}

	@Test
	def testUnaryMinusRealLiteral() {
		assertCompilesTo('''-3.14;''', realLiteral("-3.14"))
	}

	@Test
	def testNegateBooleanExpression() {
		assertCompilesTo('''Boolean x; !x;''', binOp("java.util.ArrayList<java.lang.Boolean> _local0", "=", FALSE),
			fun(PrimitiveOperations.BOOLEAN_NEGATE, "_local0"))
	}

	@Test
	def testUnaryMinusIntegerExpression() {
		assertCompilesTo('''Integer x; -x;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", INTEGER_ZERO),
			fun(PrimitiveOperations.INTEGER_NEGATE, "_local0"))
	}

	@Test
	def testUnaryMinusRealExpression() {
		assertCompilesTo('''Real x; -x;''', binOp("java.util.ArrayList<java.lang.Double> _local0", "=", REAL_ZERO),
			fun(PrimitiveOperations.REAL_NEGATE, "_local0"))
	}

	@Test
	def testPrefixDecrement() {
		assertCompilesTo('''Integer x; --x;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", INTEGER_ZERO),
			fun(PrimitiveOperations.INTEGER_PREFIX_DECREMENT, "_local0"))
	}

	@Test
	def testPrefixIncrement() {
		assertCompilesTo('''Integer x; ++x;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", INTEGER_ZERO),
			fun(PrimitiveOperations.INTEGER_PREFIX_INCREMENT, "_local0"))
	}

	@Test
	def testPostfixDecrement() {
		assertCompilesTo('''Integer x; x--;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", INTEGER_ZERO),
			fun(PrimitiveOperations.INTEGER_POSTFIX_DECREMENT, "_local0"))
	}

	@Test
	def testPostfixIncrement() {
		assertCompilesTo('''Integer x; x++;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", INTEGER_ZERO),
			fun(PrimitiveOperations.INTEGER_POSTFIX_INCREMENT, "_local0"))
	}

	@Test
	def testBooleanAnd() {
		assertCompilesTo('''true && false;''', wrap(binOp(unwrap(TRUE), "&&", unwrap(FALSE))))
	}

	@Test
	def testBooleanOr() {
		assertCompilesTo('''true || false;''', wrap(binOp(unwrap(TRUE), "||", unwrap(FALSE))))
	}

	@Test
	def testBooleanBitwiseAnd() {
		assertCompilesTo('''true & false;''', fun(PrimitiveOperations.BOOLEAN_BITWISE_AND, TRUE, FALSE))
	}

	@Test
	def testBooleanBitwiseOr() {
		assertCompilesTo('''true | false;''', fun(PrimitiveOperations.BOOLEAN_BITWISE_OR, TRUE, FALSE))
	}

	@Test
	def testBooleanBitwiseXor() {
		assertCompilesTo('''true ^ false;''', fun(PrimitiveOperations.BOOLEAN_BITWISE_XOR, TRUE, FALSE))
	}

	@Test
	def testIntegerBitwiseAnd() {
		assertCompilesTo('''0 & 1;''', fun(PrimitiveOperations.INTEGER_BITWISE_AND, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testIntegerBitwiseOr() {
		assertCompilesTo('''0 | 1;''', fun(PrimitiveOperations.INTEGER_BITWISE_OR, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testIntegerBitwiseXor() {
		assertCompilesTo('''0 ^ 1;''', fun(PrimitiveOperations.INTEGER_BITWISE_XOR, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testIntegerShiftLeft() {
		assertCompilesTo('''0 << 1;''', fun(PrimitiveOperations.INTEGER_SHIFT_LEFT, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testIntegerShiftRight() {
		assertCompilesTo('''0 >> 1;''', fun(PrimitiveOperations.INTEGER_SHIFT_RIGHT, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testIntegerShiftRightUnsigned() {
		assertCompilesTo('''0 >>> 1;''',
			fun(PrimitiveOperations.INTEGER_SHIFT_RIGHT_UNSIGNED, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testIntegerLessThanInteger() {
		assertCompilesTo('''0 < 1;''', fun(PrimitiveOperations.INTEGER_LESS_THAN_INTEGER, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testIntegerLessThanReal() {
		assertCompilesTo('''0 < 1.0;''', fun(PrimitiveOperations.INTEGER_LESS_THAN_REAL, INTEGER_ZERO, REAL_ONE))
	}

	@Test
	def testRealLessThanInteger() {
		assertCompilesTo('''0.0 < 1;''', fun(PrimitiveOperations.REAL_LESS_THAN_INTEGER, REAL_ZERO, INTEGER_ONE))
	}

	@Test
	def testRealLessThanReal() {
		assertCompilesTo('''0.0 < 1.0;''', fun(PrimitiveOperations.REAL_LESS_THAN_REAL, REAL_ZERO, REAL_ONE))
	}

	@Test
	def testIntegerGreaterThanInteger() {
		assertCompilesTo('''0 > 1;''', fun(PrimitiveOperations.INTEGER_LESS_THAN_INTEGER, INTEGER_ONE, INTEGER_ZERO))
	}

	@Test
	def testIntegerGreaterOrEqualInteger() {
		assertCompilesTo('''0 >= 1;''',
			fun(PrimitiveOperations.BOOLEAN_NEGATE,
				fun(PrimitiveOperations.INTEGER_LESS_THAN_INTEGER, INTEGER_ZERO, INTEGER_ONE)))
	}

	@Test
	def testIntegerLessOrEqualInteger() {
		assertCompilesTo('''0 <= 1;''',
			fun(PrimitiveOperations.BOOLEAN_NEGATE,
				fun(PrimitiveOperations.INTEGER_LESS_THAN_INTEGER, INTEGER_ONE, INTEGER_ZERO)))
	}

	@Test
	def testPrimitiveTypeEquality() {
		assertCompilesTo('''0 == 1;''', fun(PrimitiveOperations.VALUE_EQUALITY, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testPrimitiveTypeInequality() {
		assertCompilesTo('''0 != 1;''',
			fun(PrimitiveOperations.BOOLEAN_NEGATE, fun(PrimitiveOperations.VALUE_EQUALITY, INTEGER_ZERO, INTEGER_ONE)))
	}

	@Test
	def testClassReferenceEquality() {
		assertCompilesTo(
			'''B b1; B b2; b1 == b2;''',
			binOp("java.util.ArrayList<_9SdsIEDoEeWCNoKXHvCpUQ> _local0", "=", fun(PrimitiveOperations.NULL_VALUE)),
			binOp("java.util.ArrayList<_9SdsIEDoEeWCNoKXHvCpUQ> _local1", "=", fun(PrimitiveOperations.NULL_VALUE)),
			fun(PrimitiveOperations.REFERENCE_EQUALITY, "_local0", "_local1")
		)
	}

	@Test
	def testStringConcatenation() {
		assertCompilesTo('''"a" + "b";''',
			fun(PrimitiveOperations.STRING_CONCATENATION, stringLiteral("a"), stringLiteral("b")))
	}

	@Test
	def testIntegerAddInteger() {
		assertCompilesTo('''0 + 1;''', fun(PrimitiveOperations.INTEGER_ADD_INTEGER, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testIntegerAddReal() {
		assertCompilesTo('''0 + 1.0;''', fun(PrimitiveOperations.INTEGER_ADD_REAL, INTEGER_ZERO, REAL_ONE))
	}

	@Test
	def testRealAddInteger() {
		assertCompilesTo('''0.0 + 1;''', fun(PrimitiveOperations.REAL_ADD_INTEGER, REAL_ZERO, INTEGER_ONE))
	}

	@Test
	def testRealAddReal() {
		assertCompilesTo('''0.0 + 1.0;''', fun(PrimitiveOperations.REAL_ADD_REAL, REAL_ZERO, REAL_ONE))
	}

	@Test
	def testIntegerSubtractInteger() {
		assertCompilesTo('''0 - 1;''', fun(PrimitiveOperations.INTEGER_SUBTRACT_INTEGER, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testIntegerSubtractReal() {
		assertCompilesTo('''0 - 1.0;''', fun(PrimitiveOperations.INTEGER_SUBTRACT_REAL, INTEGER_ZERO, REAL_ONE))
	}

	@Test
	def testRealSubtractInteger() {
		assertCompilesTo('''0.0 - 1;''', fun(PrimitiveOperations.REAL_SUBTRACT_INTEGER, REAL_ZERO, INTEGER_ONE))
	}

	@Test
	def testRealSubtractReal() {
		assertCompilesTo('''0.0 - 1.0;''', fun(PrimitiveOperations.REAL_SUBTRACT_REAL, REAL_ZERO, REAL_ONE))
	}

	@Test
	def testIntegerMultiplyInteger() {
		assertCompilesTo('''0 * 1;''', fun(PrimitiveOperations.INTEGER_MULTIPLY_INTEGER, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testIntegerMultiplyReal() {
		assertCompilesTo('''0 * 1.0;''', fun(PrimitiveOperations.INTEGER_MULTIPLY_REAL, INTEGER_ZERO, REAL_ONE))
	}

	@Test
	def testRealMultiplyInteger() {
		assertCompilesTo('''0.0 * 1;''', fun(PrimitiveOperations.REAL_MULTIPLY_INTEGER, REAL_ZERO, INTEGER_ONE))
	}

	@Test
	def testRealMultiplyReal() {
		assertCompilesTo('''0.0 * 1.0;''', fun(PrimitiveOperations.REAL_MULTIPLY_REAL, REAL_ZERO, REAL_ONE))
	}

	@Test
	def testIntegerDivideInteger() {
		assertCompilesTo('''0 / 1;''', fun(PrimitiveOperations.INTEGER_DIVIDE_INTEGER, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testIntegerDivideReal() {
		assertCompilesTo('''0 / 1.0;''', fun(PrimitiveOperations.INTEGER_DIVIDE_REAL, INTEGER_ZERO, REAL_ONE))
	}

	@Test
	def testRealDivideInteger() {
		assertCompilesTo('''0.0 / 1;''', fun(PrimitiveOperations.REAL_DIVIDE_INTEGER, REAL_ZERO, INTEGER_ONE))
	}

	@Test
	def testRealDivideReal() {
		assertCompilesTo('''0.0 / 1.0;''', fun(PrimitiveOperations.REAL_DIVIDE_REAL, REAL_ZERO, REAL_ONE))
	}

	@Test
	def testIntegerModuloInteger() {
		assertCompilesTo('''0 % 1;''', fun(PrimitiveOperations.INTEGER_MODULO_INTEGER, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testCastingToBoolean() {
		assertCompilesTo('''(Boolean) false;''', fun(PrimitiveOperations.CAST, Boolean.canonicalName -> "class", FALSE))
	}

	@Test
	def testCastingToInteger() {
		assertCompilesTo('''(Integer) 0.0;''',
			fun(PrimitiveOperations.CAST, BigInteger.canonicalName -> "class", REAL_ZERO))
	}

	@Test
	def testCastingToReal() {
		assertCompilesTo('''(Real) 0;''', fun(PrimitiveOperations.CAST, Double.canonicalName -> "class", INTEGER_ZERO))
	}

	@Test
	def testCastingToString() {
		assertCompilesTo('''(String) "hello";''',
			fun(PrimitiveOperations.CAST, String.canonicalName -> "class", stringLiteral("hello")))
	}

	@Test
	def testCastingToReferenceType() {
		assertCompilesTo('''(A) this;''',
			fun(PrimitiveOperations.CAST, "_aeMPwMc1EeSnK7LttAdTLw" -> "class", wrap(CompilerBase.CONTEXT_NAME)))
	}
}
