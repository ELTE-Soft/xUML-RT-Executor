package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test

class DeclarationTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testBooleanDefaultInitialization() {
		assertCompilesTo("Boolean x;", '''java.util.ArrayList<java.lang.Boolean> _local0 = booleanLiteral(false);''');
	}

	@Test
	def testRealDefaultInitialization() {
		assertCompilesTo("Real x;", '''java.util.ArrayList<java.lang.Double> _local0 = realLiteral(0.0);''');
	}

	@Test
	def testIntegerDefaultInitialization() {
		assertCompilesTo(
			"Integer x;", '''java.util.ArrayList<java.math.BigInteger> _local0 = integerLiteral("0", 10);''');
	}

	@Test
	def testStringDefaultInitialization() {
		assertCompilesTo("String x;", '''java.util.ArrayList<java.lang.String> _local0 = stringLiteral("");''');
	}

	@Test
	def testTwoLocalVarsInSameBlock() {
		assertCompilesTo('''
			Real x;
			Integer y;
		''', '''
			java.util.ArrayList<java.lang.Double> _local0 = realLiteral(0.0);
			java.util.ArrayList<java.math.BigInteger> _local1 = integerLiteral("0", 10);
		''');
	}

	@Test
	def testReferencingVariable() {
		assertCompilesTo('''
			Real x;
			x;
		''', '''
			java.util.ArrayList<java.lang.Double> _local0 = realLiteral(0.0);
			_local0;
		''');
	}

	@Test
	def testUsingUserDefinedClassAsLocalVariableType() {
		assertCompilesTo("B b;", "java.util.ArrayList<_9SdsIEDoEeWCNoKXHvCpUQ> _local0 = nullValue();");
	}

	@Test
	def testUsingUserDefinedClassAsLocalVariableTypeWithDefaultConstructor() {
		assertCompilesTo(
			"B b = new B();",
			"java.util.ArrayList<_9SdsIEDoEeWCNoKXHvCpUQ> _local0 = wrap(_9SdsIEDoEeWCNoKXHvCpUQ.create(context.getRuntime(), i -> i._LAXgUEHKEeWzwYgcaM4qwA()));"
		);
	}
}
