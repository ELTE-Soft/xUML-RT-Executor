package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
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
			fun(PrimitiveOperations.NEGATE_BOOLEAN, "_local0"))
	}

	@Test
	def testUnaryMinusIntegerExpression() {
		assertCompilesTo('''Integer x; -x;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", INTEGER_ZERO),
			fun(PrimitiveOperations.NEGATE_INTEGER, "_local0"))
	}

	@Test
	def testUnaryMinusRealExpression() {
		assertCompilesTo('''Real x; -x;''', binOp("java.util.ArrayList<java.lang.Double> _local0", "=", REAL_ZERO),
			fun(PrimitiveOperations.NEGATE_REAL, "_local0"))
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
		assertCompilesTo('''true && false;''', fun(PrimitiveOperations.BOOLEAN_AND, TRUE, FALSE))
	}

	@Test
	def testBooleanOr() {
		assertCompilesTo('''true || false;''', fun(PrimitiveOperations.BOOLEAN_OR, TRUE, FALSE))
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
			fun(PrimitiveOperations.NEGATE_BOOLEAN,
				fun(PrimitiveOperations.INTEGER_LESS_THAN_INTEGER, INTEGER_ZERO, INTEGER_ONE)))
	}

	@Test
	def testIntegerLessOrEqualInteger() {
		assertCompilesTo('''0 <= 1;''',
			fun(PrimitiveOperations.NEGATE_BOOLEAN,
				fun(PrimitiveOperations.INTEGER_LESS_THAN_INTEGER, INTEGER_ONE, INTEGER_ZERO)))
	}

	@Test
	def testPrimitiveTypeEquality() {
		assertCompilesTo('''0 == 1;''', fun(PrimitiveOperations.VALUE_EQUALITY, INTEGER_ZERO, INTEGER_ONE))
	}

	@Test
	def testPrimitiveTypeInequality() {
		assertCompilesTo('''0 != 1;''',
			fun(PrimitiveOperations.NEGATE_BOOLEAN, fun(PrimitiveOperations.VALUE_EQUALITY, INTEGER_ZERO, INTEGER_ONE)))
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
//	@Test
//	def testAddIntegers() {
//		assertCompilesTo('''2 + 4;''', empty)
//	}
//	
//	@Test
//	def testAddReals() {
//		assertCompilesTo('''2.0 + 4.0;''', empty)
//	}
//	
//	@Test
//	def testAddIntegerToReal() {
//		assertCompilesTo('''2 + 4.0;''', empty)
//	}
//	
//	@Test
//	def testAddRealToInteger() {
//		assertCompilesTo('''2.0 + 4;''', empty)
//	}
//
//	@Test
//	def testConcatenateStrings() {
//		assertCompilesTo('''"Hello " + "world!"''', empty)
//	}
}
