package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test
import org.junit.Ignore

class ControlCompilerTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new StatementCompiler()
	}

	@Test
	def testEmptyStatement() {
		assertCompilesToSame(";")
	}

	@Test
	def testEmptyBlock() {
		assertCompilesTo("{}", '''
			{
			}
		''')
	}

	@Test
	def testEmptyBlockSequence() {
		assertCompilesTo("{}{}{}", '''
			{
			}
			{
			}
			{
			}
		''')
	}

	@Test
	def testNestedEmptyBlocks() {
		assertCompilesTo("{{{}}}", '''
			{
			{
			{
			}
			}
			}
		''')
	}

	@Test
	def testReturnVoid() {
		assertCompilesToSame("return;");
	}

	@Ignore("Diagnostic throws NullPointerException. However, the operation signature is indeed incorrect in context.")
	@Test
	def testReturnFalse() {
		assertCompilesToSame("return false;");
	}

	@Test
	def testWhile() {
		assertCompilesTo("while(false){}", '''
			while (false)
			{
			}
		''')
	}

	@Test
	def testDoWhile() {
		assertCompilesTo("do{}while(false);", '''
		do
		{
		} while (false);''')
	}

	@Test
	def testForWithEmptyUpdate() {
		assertCompilesTo("for(Integer i; false; ){}", '''
			for (java.math.BigInteger _local0; false; ;)
			{
			}
		''')
	}

	@Test
	def testForWithNonEmptyUpdate() {
		assertCompilesTo("for(Integer i; false; false ){}", '''
			for (java.math.BigInteger _local0; false; false;)
			{
			}
		''')
	}

	@Test
	def testBreak() {
		assertCompilesTo("while(false){break;}", '''
			while (false)
			{
			break;
			}
		''')
	}
}
