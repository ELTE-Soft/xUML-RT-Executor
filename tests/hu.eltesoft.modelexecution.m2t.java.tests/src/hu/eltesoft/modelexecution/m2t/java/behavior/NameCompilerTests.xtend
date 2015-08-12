package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Ignore
import org.junit.Test

class NameCompilerTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new NameCompiler()
	}

	@Test
	def testSingleLocalVar() {
		assertCompilesTo("Real x;", '''java.lang.Double _local0;''');
	}

	@Test
	def testTwoLocalVarsInSameBlock() {
		assertCompilesTo('''
			Real x;
			Integer y;
		''', '''
			java.lang.Double _local0;
			java.math.BigInteger _local1;
		''');
	}

	@Ignore("Move this test down on the compiler inheritance hierarchy")
	@Test
	def testTwoLocalVarsInDifferentBlocks() {
		assertCompilesTo("{Real x;}{Integer x;}", '''
			{
			java.lang.Double _local0;
			}
			{
			java.math.BigInteger _local1;
			}
		''');
	}

	@Test
	def testReferencingVariable() {
		assertCompilesTo('''
			Real x;
			x;
		''', '''
			java.lang.Double _local0;
			_local0;
		''');
	}

	@Ignore("Move this test down on the compiler inheritance hierarchy")
	@Test
	def testReferencingVariableInBlock() {
		assertCompilesTo('''
			Real x;
			{
				x;
			}
		''', '''
			java.lang.Double _local0;
			{
			_local0;
			}
		''');
	}

	@Test
	def testUsingUserDefinedClassAsLocalVariableType() {
		assertCompilesTo("B b;", "_9SdsIEDoEeWCNoKXHvCpUQ _local0;");
	}
}
