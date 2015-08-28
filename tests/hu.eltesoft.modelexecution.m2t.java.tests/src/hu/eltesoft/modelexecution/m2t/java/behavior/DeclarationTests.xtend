package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class DeclarationTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testBooleanDefaultInitialization() {
		assertCompilesTo('''Boolean x;''',
			binOp("java.util.ArrayList<java.lang.Boolean> _local0", "=", booleanLiteral("false")))
	}

	@Test
	def testRealDefaultInitialization() {
		assertCompilesTo('''Real x;''', binOp("java.util.ArrayList<java.lang.Double> _local0", "=", realLiteral("0.0")))
	}

	@Test
	def testIntegerDefaultInitialization() {
		assertCompilesTo('''Integer x;''',
			binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)))
	}

	@Test
	def testStringDefaultInitialization() {
		assertCompilesTo('''String x;''',
			binOp("java.util.ArrayList<java.lang.String> _local0", "=", stringLiteral("")))
	}

	@Test
	def testTwoLocalVarsInSameBlock() {
		assertCompilesTo(
			'''
				Real x;
				Integer y;
			''',
			binOp("java.util.ArrayList<java.lang.Double> _local0", "=", realLiteral("0.0")),
			binOp("java.util.ArrayList<java.math.BigInteger> _local1", "=", integerLiteral("0", 10))
		)
	}

	@Test
	def testReferencingVariable() {
		assertCompilesTo(
			'''
				Real x;
				x;
			''',
			binOp("java.util.ArrayList<java.lang.Double> _local0", "=", realLiteral("0.0")),
			sequence("_local0")
		)
	}

	@Test
	def testUsingUserDefinedClassAsLocalVariableType() {
		assertCompilesTo('''B b;''',
			binOp("java.util.ArrayList<_9SdsIEDoEeWCNoKXHvCpUQ> _local0", "=", fun(PrimitiveOperations.NULL_VALUE)))
	}

	@Test
	def testUsingUserDefinedClassAsLocalVariableTypeWithDefaultConstructor() {
		assertCompilesTo('''B b = new B();''',
			binOp("java.util.ArrayList<_9SdsIEDoEeWCNoKXHvCpUQ> _local0", "=",
				wrap("_9SdsIEDoEeWCNoKXHvCpUQ" -> fun("create", "i -> i._LAXgUEHKEeWzwYgcaM4qwA()"))))
	}
}
