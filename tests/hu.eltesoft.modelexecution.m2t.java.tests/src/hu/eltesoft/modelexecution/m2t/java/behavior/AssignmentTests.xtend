package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class AssignmentTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new OperatorCompiler()
	}

	@Test
	def testAssignToBoolVariable() {
		assertCompilesTo(
			'''Boolean b; b = true;''',
			binOp("java.util.ArrayList<java.lang.Boolean> _local0", "=", booleanLiteral("false")),
			fun(PrimitiveOperations.SET_VALUE, "_local0", booleanLiteral("true"))
		)
	}

	@Test
	def testStringConcatAssign() {
		assertCompilesTo(
			'''String x; x += "a";''',
			binOp("java.util.ArrayList<java.lang.String> _local0", "=", stringLiteral("")),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.STRING_CONCATENATION, "_local0", stringLiteral("a")))
		)
	}

	@Test
	def testRealAddIntegerAssign() {
		assertCompilesTo(
			'''Real x; x += 1;''',
			binOp("java.util.ArrayList<java.lang.Double> _local0", "=", realLiteral("0.0")),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.REAL_ADD_INTEGER, "_local0", integerLiteral("1", 10)))
		)
	}

	@Test
	def testRealSubtractIntegerAssign() {
		assertCompilesTo(
			'''Real x; x -= 1;''',
			binOp("java.util.ArrayList<java.lang.Double> _local0", "=", realLiteral("0.0")),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.REAL_SUBTRACT_INTEGER, "_local0", integerLiteral("1", 10)))
		)
	}

	@Test
	def testRealMultiplyIntegerAssign() {
		assertCompilesTo(
			'''Real x; x *= 1;''',
			binOp("java.util.ArrayList<java.lang.Double> _local0", "=", realLiteral("0.0")),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.REAL_MULTIPLY_INTEGER, "_local0", integerLiteral("1", 10)))
		)
	}

	@Test
	def testRealDivideIntegerAssign() {
		assertCompilesTo(
			'''Real x; x /= 1;''',
			binOp("java.util.ArrayList<java.lang.Double> _local0", "=", realLiteral("0.0")),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.REAL_DIVIDE_INTEGER, "_local0", integerLiteral("1", 10)))
		)
	}

	@Test
	def testIntegerModuloIntegerAssign() {
		assertCompilesTo(
			'''Integer x; x %= 1;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.INTEGER_MODULO_INTEGER, "_local0", integerLiteral("1", 10)))
		)
	}

	@Test
	def testBooleanBitwiseAndAssign() {
		assertCompilesTo(
			'''Boolean b; b &= true;''',
			binOp("java.util.ArrayList<java.lang.Boolean> _local0", "=", booleanLiteral("false")),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.BOOLEAN_BITWISE_AND, "_local0", booleanLiteral("true")))
		)
	}

	@Test
	def testBooleanBitwiseOrAssign() {
		assertCompilesTo(
			'''Boolean b; b |= true;''',
			binOp("java.util.ArrayList<java.lang.Boolean> _local0", "=", booleanLiteral("false")),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.BOOLEAN_BITWISE_OR, "_local0", booleanLiteral("true")))
		)
	}

	@Test
	def testBooleanBitwiseXorAssign() {
		assertCompilesTo(
			'''Boolean b; b ^= true;''',
			binOp("java.util.ArrayList<java.lang.Boolean> _local0", "=", booleanLiteral("false")),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.BOOLEAN_BITWISE_XOR, "_local0", booleanLiteral("true")))
		)
	}

	@Test
	def testIntegerBitwiseAndAssign() {
		assertCompilesTo(
			'''Integer x; x &= 2;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.INTEGER_BITWISE_AND, "_local0", integerLiteral("2", 10)))
		)
	}

	@Test
	def testIntegerBitwiseOrAssign() {
		assertCompilesTo(
			'''Integer x; x |= 2;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.INTEGER_BITWISE_OR, "_local0", integerLiteral("2", 10)))
		)
	}

	@Test
	def testIntegerBitwiseXorAssign() {
		assertCompilesTo(
			'''Integer x; x ^= 2;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.INTEGER_BITWISE_XOR, "_local0", integerLiteral("2", 10)))
		)
	}

	@Test
	def testIntegerLeftShiftAssign() {
		assertCompilesTo(
			'''Integer x; x <<= 2;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.INTEGER_SHIFT_LEFT, "_local0", integerLiteral("2", 10)))
		)
	}

	@Test
	def testIntegerRightShiftAssign() {
		assertCompilesTo(
			'''Integer x; x >>= 2;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.INTEGER_SHIFT_RIGHT, "_local0", integerLiteral("2", 10)))
		)
	}

	@Test
	def testIntegerRightUnsignedShiftAssign() {
		assertCompilesTo(
			'''Integer x; x >>>= 2;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)),
			fun(PrimitiveOperations.SET_VALUE, "_local0",
				fun(PrimitiveOperations.INTEGER_SHIFT_RIGHT_UNSIGNED, "_local0", integerLiteral("2", 10)))
		)
	}
}
