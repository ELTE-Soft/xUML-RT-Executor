package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test

class DeclarationTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testBooleanDefaultInitialization() {
		assertCompilesTo("Boolean x;", '''java.lang.Boolean _local0 = false;''');
	}

	@Test
	def testRealDefaultInitialization() {
		assertCompilesTo("Real x;", '''java.lang.Double _local0 = 0.0;''');
	}

	@Test
	def testIntegerDefaultInitialization() {
		assertCompilesTo("Integer x;", '''java.math.BigInteger _local0 = java.math.BigInteger.valueOf(0);''');
	}

	@Test
	def testStringDefaultInitialization() {
		assertCompilesTo("String x;", '''java.lang.String _local0 = "";''');
	}

	@Test
	def testTwoLocalVarsInSameBlock() {
		assertCompilesTo('''
			Real x;
			Integer y;
		''', '''
			java.lang.Double _local0 = 0.0;
			java.math.BigInteger _local1 = java.math.BigInteger.valueOf(0);
		''');
	}

	@Test
	def testReferencingVariable() {
		assertCompilesTo('''
			Real x;
			x;
		''', '''
			java.lang.Double _local0 = 0.0;
			_local0;
		''');
	}

	@Test
	def testUsingUserDefinedClassAsLocalVariableType() {
		assertCompilesTo("B b;", "_9SdsIEDoEeWCNoKXHvCpUQ _local0;");
	}

	@Test
	def testUsingUserDefinedClassAsLocalVariableTypeWithDefaultConstructor() {
		assertCompilesTo("B b = new B();",
			"_9SdsIEDoEeWCNoKXHvCpUQ _local0 = _9SdsIEDoEeWCNoKXHvCpUQ.create(context.getRuntime());");
	}
}
