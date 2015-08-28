package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class ArithmeticTests extends CompiledCodeCheckTestCase {

	static extension CodeGenNode = CodeGenNode.extension

	new() {
		compiler = new ArithmeticCompiler()
	}

	@Test
	def testNegateBooleanLiteral() {
		assertCompilesTo('''!false;''', booleanLiteral("true"))
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
		assertCompilesTo(
			'''Boolean x; !x;''',
			binOp("java.util.ArrayList<java.lang.Boolean> _local0", "=", booleanLiteral("false")),
			fun(PrimitiveOperations.NEGATE_BOOLEAN, "_local0")
		)
	}

	@Test
	def testUnaryMinusIntegerExpression() {
		assertCompilesTo(
			'''Integer x; -x;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.NEGATE_INTEGER, "_local0")
		)
	}

	@Test
	def testUnaryMinusRealExpression() {
		assertCompilesTo(
			'''Real x; -x;''',
			binOp("java.util.ArrayList<java.lang.Double> _local0", "=", realLiteral("0.0")),
			fun(PrimitiveOperations.NEGATE_REAL, "_local0")
		)
	}

	@Test
	def testPrefixDecrement() {
		assertCompilesTo(
			'''Integer x; --x;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.INTEGER_PREFIX_DECREMENT, "_local0")
		)
	}

	@Test
	def testPrefixIncrement() {
		assertCompilesTo(
			'''Integer x; ++x;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.INTEGER_PREFIX_INCREMENT, "_local0")
		)
	}

	@Test
	def testPostfixDecrement() {
		assertCompilesTo(
			'''Integer x; x--;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.INTEGER_POSTFIX_DECREMENT, "_local0")
		)
	}

	@Test
	def testPostfixIncrement() {
		assertCompilesTo(
			'''Integer x; x++;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.INTEGER_POSTFIX_INCREMENT, "_local0")
		)
	}

	@Test
	def testBooleanAnd() {
		assertCompilesTo(
			'''true && false;''',
			fun(PrimitiveOperations.BOOLEAN_AND, booleanLiteral("true"), booleanLiteral("false"))
		)
	}

	@Test
	def testBooleanOr() {
		assertCompilesTo(
			'''true || false;''',
			fun(PrimitiveOperations.BOOLEAN_OR, booleanLiteral("true"), booleanLiteral("false"))
		)
	}

	@Test
	def testBooleanBitwiseAnd() {
		assertCompilesTo(
			'''true & false;''',
			fun(PrimitiveOperations.BOOLEAN_BITWISE_AND, booleanLiteral("true"), booleanLiteral("false"))
		)
	}

	@Test
	def testBooleanBitwiseOr() {
		assertCompilesTo(
			'''true | false;''',
			fun(PrimitiveOperations.BOOLEAN_BITWISE_OR, booleanLiteral("true"), booleanLiteral("false"))
		)
	}

	@Test
	def testBooleanBitwiseXor() {
		assertCompilesTo(
			'''true ^ false;''',
			fun(PrimitiveOperations.BOOLEAN_BITWISE_XOR, booleanLiteral("true"), booleanLiteral("false"))
		)
	}

	@Test
	def testIntegerBitwiseAnd() {
		assertCompilesTo(
			'''10 & 20;''',
			fun(PrimitiveOperations.INTEGER_BITWISE_AND, integerLiteral("10", 10), integerLiteral("20", 10))
		)
	}

	@Test
	def testIntegerBitwiseOr() {
		assertCompilesTo(
			'''10 | 20;''',
			fun(PrimitiveOperations.INTEGER_BITWISE_OR, integerLiteral("10", 10), integerLiteral("20", 10))
		)
	}

	@Test
	def testIntegerBitwiseXor() {
		assertCompilesTo(
			'''10 ^ 20;''',
			fun(PrimitiveOperations.INTEGER_BITWISE_XOR, integerLiteral("10", 10), integerLiteral("20", 10))
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
