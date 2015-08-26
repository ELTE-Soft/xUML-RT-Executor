package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import org.junit.Test
import static hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations.*
import hu.eltesoft.modelexecution.runtime.base.SignalEvent

class StatementCompilerTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new StatementCompiler()
	}

	@Test
	def testEmptyStatement() {
		assertCompilesTo(''';''', ''';''')
	}

	@Test
	def testEmptyBlock() {
		assertCompilesTo('''{}''', '''
			{
			}
		''')
	}

	@Test
	def testEmptyBlockSequence() {
		assertCompilesTo('''{}{}{}''', '''
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
		assertCompilesTo('''{{{}}}''', '''
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
		assertCompilesTo('''{Real x;}{Integer x = 10;}''', '''
			{
			java.util.ArrayList<java.lang.Double> _local0 = «REAL_LITERAL»(0.0);
			}
			{
			java.util.ArrayList<java.math.BigInteger> _local1 = «INTEGER_LITERAL»("10", 10);
			}
		''')
	}

	@Test
	def testReferencingVariableInBlock() {
		assertCompilesTo('''
			Real x;
			{
				x;
			}
		''', '''
			java.util.ArrayList<java.lang.Double> _local0 = «REAL_LITERAL»(0.0);
			{
			_local0;
			}
		''')
	}

	@Test
	def testReturnVoid() {
		assertCompilesTo('''return;''', '''return;''')
	}

	@Test
	def testReturnFalse() {
		operation = ModelProperties.BOOL_OPERATION
		assertCompilesTo('''return false;''', '''return «BOOLEAN_LITERAL»(false);''')
	}

	@Test
	def testIf() {
		assertCompilesTo('''if(false){}''', '''
			if («UNWRAP»(«BOOLEAN_LITERAL»(false))) {
			}
		''')
	}

	@Test
	def testIfElse() {
		assertCompilesTo('''if(false){}else{}''', '''
			if («UNWRAP»(«BOOLEAN_LITERAL»(false))) {
			}
			else {
			}
		''')
	}

	@Test
	def testIfElseIfElseIfElse() {
		assertCompilesTo('''if(false){}else if(true){}else if(false){}else{}''', '''
			if («UNWRAP»(«BOOLEAN_LITERAL»(false))) {
			}
			else if («UNWRAP»(«BOOLEAN_LITERAL»(true))) {
			}
			else if («UNWRAP»(«BOOLEAN_LITERAL»(false))) {
			}
			else {
			}
		''')
	}

	@Test
	def testWhile() {
		assertCompilesTo('''while(false){}''', '''
			while («UNWRAP»(«BOOLEAN_LITERAL»(false))) {
			}
		''')
	}

	@Test
	def testDoWhile() {
		assertCompilesTo('''do{}while(false);''', '''
			do {
			} while («UNWRAP»(«BOOLEAN_LITERAL»(false)));''')
	}

	@Test
	def testForWithEmptyUpdate() {
		assertCompilesTo('''for(Integer i = 0; false; ){}''', '''
			for (java.util.ArrayList<java.math.BigInteger> _local0 = «INTEGER_LITERAL»("0", 10); «BOOLEAN_LITERAL»(false); ;) {
			}
		''')
	}

	@Test
	def testForWithNonEmptyUpdate() {
		assertCompilesTo('''for(Integer i = 0; false; false ){}''', '''
			for (java.util.ArrayList<java.math.BigInteger> _local0 = «INTEGER_LITERAL»("0", 10); «BOOLEAN_LITERAL»(false); «BOOLEAN_LITERAL»(false);) {
			}
		''')
	}

	@Test
	def testBreak() {
		assertCompilesTo('''while(false){break;}''', '''
			while («UNWRAP»(«BOOLEAN_LITERAL»(false))) {
			break;
			}
		''')
	}

	@Test
	def sendNewSignalToNewObject() {
		assertCompilesTo('''send new S() to new B();''', '''«UNWRAP»(«WRAP»(_9SdsIEDoEeWCNoKXHvCpUQ.create(«CompilerBase.CONTEXT_NAME».getRuntime(), i -> i._LAXgUEHKEeWzwYgcaM4qwA()))).send(new «SignalEvent.canonicalName»(«UNWRAP»(«WRAP»(new _47IQsEGyEeWzwYgcaM4qwA()))));''')
	}

	@Test
	def sendNewSignalToThisObject() {
		assertCompilesTo('''send new S() to this;''', '''«UNWRAP»(«WRAP»(«CompilerBase.CONTEXT_NAME»)).send(new «SignalEvent.canonicalName»(«UNWRAP»(«WRAP»(new _47IQsEGyEeWzwYgcaM4qwA()))));''')
	}

	@Test
	def sendExistingSignalToExistingObject() {
		assertCompilesTo('''
			S s = new S();
			B b = new B();
			send s to b;
		''', '''
			java.util.ArrayList<_47IQsEGyEeWzwYgcaM4qwA> _local0 = «WRAP»(new _47IQsEGyEeWzwYgcaM4qwA());
			java.util.ArrayList<_9SdsIEDoEeWCNoKXHvCpUQ> _local1 = «WRAP»(_9SdsIEDoEeWCNoKXHvCpUQ.create(«CompilerBase.CONTEXT_NAME».getRuntime(), i -> i._LAXgUEHKEeWzwYgcaM4qwA()));
			«UNWRAP»(_local1).send(new «SignalEvent.canonicalName»(«UNWRAP»(_local0)));
		''')
	}
}
