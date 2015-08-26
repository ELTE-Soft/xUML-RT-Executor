package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import org.junit.Test

class StatementCompilerTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new StatementCompiler()
	}

	@Test
	def testEmptyStatement() {
		assertCompilesTo(";", ";")
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
			java.util.ArrayList<java.lang.Double> _local0 = realLiteral(0.0);
			}
			{
			java.util.ArrayList<java.math.BigInteger> _local1 = integerLiteral("10", 10);
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
			java.util.ArrayList<java.lang.Double> _local0 = realLiteral(0.0);
			{
			_local0;
			}
		''');
	}

	@Test
	def testReturnVoid() {
		assertCompilesTo("return;", "return;");
	}

	@Test
	def testReturnFalse() {
		operation = ModelProperties.BOOL_OPERATION;
		assertCompilesTo("return false;", "return booleanLiteral(false);");
	}

	@Test
	def testIf() {
		assertCompilesTo("if(false){}", '''
			if (unwrap(booleanLiteral(false))) {
			}
		''');
	}

	@Test
	def testIfElse() {
		assertCompilesTo("if(false){}else{}", '''
			if (unwrap(booleanLiteral(false))) {
			}
			else {
			}
		''');
	}

	@Test
	def testIfElseIfElseIfElse() {
		assertCompilesTo("if(false){}else if(true){}else if(false){}else{}", '''
			if (unwrap(booleanLiteral(false))) {
			}
			else if (unwrap(booleanLiteral(true))) {
			}
			else if (unwrap(booleanLiteral(false))) {
			}
			else {
			}
		''');
	}

	@Test
	def testWhile() {
		assertCompilesTo("while(false){}", '''
			while (unwrap(booleanLiteral(false))) {
			}
		''')
	}

	@Test
	def testDoWhile() {
		assertCompilesTo("do{}while(false);", '''
		do {
		} while (unwrap(booleanLiteral(false)));''')
	}

	@Test
	def testForWithEmptyUpdate() {
		assertCompilesTo("for(Integer i = 0; false; ){}", '''
			for (java.util.ArrayList<java.math.BigInteger> _local0 = integerLiteral("0", 10); booleanLiteral(false); ;) {
			}
		''')
	}

	@Test
	def testForWithNonEmptyUpdate() {
		assertCompilesTo("for(Integer i = 0; false; false ){}", '''
			for (java.util.ArrayList<java.math.BigInteger> _local0 = integerLiteral("0", 10); booleanLiteral(false); booleanLiteral(false);) {
			}
		''')
	}

	@Test
	def testBreak() {
		assertCompilesTo("while(false){break;}", '''
			while (unwrap(booleanLiteral(false))) {
			break;
			}
		''')
	}

	@Test
	def sendNewSignalToNewObject() {
		assertCompilesTo(
			"send new S() to new B();",
			'''unwrap(wrap(_9SdsIEDoEeWCNoKXHvCpUQ.create(context.getRuntime(), i -> i._LAXgUEHKEeWzwYgcaM4qwA()))).send(new hu.eltesoft.modelexecution.runtime.base.SignalEvent(unwrap(wrap(new _47IQsEGyEeWzwYgcaM4qwA()))));'''
		)
	}

	@Test
	def sendNewSignalToThisObject() {
		assertCompilesTo(
			"send new S() to this;",
			'''unwrap(wrap(context)).send(new hu.eltesoft.modelexecution.runtime.base.SignalEvent(unwrap(wrap(new _47IQsEGyEeWzwYgcaM4qwA()))));'''
		)
	}

	@Test
	def sendExistingSignalToExistingObject() {
		assertCompilesTo('''
			S s = new S();
			B b = new B();
			send s to b;
		''', '''
			java.util.ArrayList<_47IQsEGyEeWzwYgcaM4qwA> _local0 = wrap(new _47IQsEGyEeWzwYgcaM4qwA());
			java.util.ArrayList<_9SdsIEDoEeWCNoKXHvCpUQ> _local1 = wrap(_9SdsIEDoEeWCNoKXHvCpUQ.create(context.getRuntime(), i -> i._LAXgUEHKEeWzwYgcaM4qwA()));
			unwrap(_local1).send(new hu.eltesoft.modelexecution.runtime.base.SignalEvent(unwrap(_local0)));
		''')
	}
}
