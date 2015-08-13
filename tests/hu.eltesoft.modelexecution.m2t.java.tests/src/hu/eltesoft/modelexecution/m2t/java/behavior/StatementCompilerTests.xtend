package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import org.junit.Test

class StatementCompilerTests extends CompiledCodeCheckTestCase {

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
	def testTwoLocalVarsInDifferentBlocks() {
		assertCompilesTo("{Real x;}{Integer x = 10;}", '''
			{
			java.lang.Double _local0 = 0.0;
			}
			{
			java.math.BigInteger _local1 = java.math.BigInteger.valueOf(10);
			}
		''');
	}

	@Test
	def testReferencingVariableInBlock() {
		assertCompilesTo('''
			Real x;
			{
				x;
			}
		''', '''
			java.lang.Double _local0 = 0.0;
			{
			_local0;
			}
		''');
	}

	@Test
	def testReturnVoid() {
		assertCompilesToSame("return;");
	}

	@Test
	def testReturnFalse() {
		operation = ModelProperties.BOOL_OPERATION;
		assertCompilesToSame("return false;");
	}

	@Test
	def testIf() {
		assertCompilesTo("if(false){}", '''
			if (false) {
			}
		''');
	}

	@Test
	def testIfElse() {
		assertCompilesTo("if(false){}else{}", '''
			if (false) {
			}
			else {
			}
		''');
	}

	@Test
	def testIfElseIfElseIfElse() {
		assertCompilesTo("if(false){}else if(true){}else if(false){}else{}", '''
			if (false) {
			}
			else if (true) {
			}
			else if (false) {
			}
			else {
			}
		''');
	}

	@Test
	def testWhile() {
		assertCompilesTo("while(false){}", '''
			while (false) {
			}
		''')
	}

	@Test
	def testDoWhile() {
		assertCompilesTo("do{}while(false);", '''
		do {
		} while (false);''')
	}

	@Test
	def testForWithEmptyUpdate() {
		assertCompilesTo("for(Integer i = 0; false; ){}", '''
			for (java.math.BigInteger _local0 = java.math.BigInteger.valueOf(0); false; ;) {
			}
		''')
	}

	@Test
	def testForWithNonEmptyUpdate() {
		assertCompilesTo("for(Integer i = 0; false; false ){}", '''
			for (java.math.BigInteger _local0 = java.math.BigInteger.valueOf(0); false; false;) {
			}
		''')
	}

	@Test
	def testBreak() {
		assertCompilesTo("while(false){break;}", '''
			while (false) {
			break;
			}
		''')
	}

	@Test
	def sendNewSignalToNewObject() {
		assertCompilesTo(
			"send new S() to new B();",
			'''
			_9SdsIEDoEeWCNoKXHvCpUQ.create(context.getRuntime()).send(new hu.eltesoft.modelexecution.runtime.base.SignalEvent(new _47IQsEGyEeWzwYgcaM4qwA()));'''
		)
	}

	@Test
	def sendExistingSignalToExistingObject() {
		assertCompilesTo('''
			S s = new S();
			B b = new B();
			send s to b;
		''', '''
			_47IQsEGyEeWzwYgcaM4qwA _local0 = new _47IQsEGyEeWzwYgcaM4qwA();
			_9SdsIEDoEeWCNoKXHvCpUQ _local1 = _9SdsIEDoEeWCNoKXHvCpUQ.create(context.getRuntime());
			_local1.send(new hu.eltesoft.modelexecution.runtime.base.SignalEvent(_local0));
		''')
	}
}
