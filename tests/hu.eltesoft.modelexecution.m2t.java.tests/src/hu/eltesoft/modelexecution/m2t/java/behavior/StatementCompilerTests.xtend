package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import hu.eltesoft.modelexecution.runtime.base.SignalEvent
import hu.eltesoft.modelexecution.runtime.library.CollectionOperations
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class StatementCompilerTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new StatementCompiler()
	}

	@Test
	def testEmptyStatement() {
		assertCompilesTo(''';''', empty)
	}

	@Test
	def testEmptyBlock() {
		assertCompilesTo('''{}''', block)
	}

	@Test
	def testEmptyBlockSequence() {
		assertCompilesTo('''{}{}{}''', block, block, block)
	}

	@Test
	def testNestedEmptyBlocks() {
		assertCompilesTo('''{{{}}}''', block(block(block)))
	}

	@Test
	def testTwoLocalVarsInDifferentBlocks() {
		assertCompilesTo('''{Real x;}{Integer x = 10;}''',
			block(binOp("java.util.ArrayList<java.lang.Double> _local0", "=", realLiteral("0.0"))),
			block(binOp("java.util.ArrayList<java.math.BigInteger> _local1", "=", integerLiteral("10", 10))))
	}

	@Test
	def testReferencingVariableInBlock() {
		assertCompilesTo('''
			Real x;
			{
				x;
			}
		''', binOp("java.util.ArrayList<java.lang.Double> _local0", "=", realLiteral("0.0")),
			block(sequence("_local0")))
	}

	@Test
	def testReturnVoid() {
		assertCompilesTo('''return;''', sequence("return"))
	}

	@Test
	def testReturnFalse() {
		operation = ModelProperties.BOOL_OPERATION
		assertCompilesTo('''return false;''', "return " <> booleanLiteral("false"))
	}

	@Test
	def testIf() {
		assertCompilesTo('''if(false){}''', "if " <> paren(unwrap(booleanLiteral("false"))) <> " " <> block)
	}

	@Test
	def testIfElse() {
		assertCompilesTo('''if(false){}else{}''',
			"if " <> paren(unwrap(booleanLiteral("false"))) <> " " <> block <> "else " <> block)
	}

	@Test
	def testIfElseIfElseIfElse() {
		assertCompilesTo(
			'''if(false){}else if(true){}else if(false){}else{}''',
			"if " <> paren(unwrap(booleanLiteral("false"))) <> " " <> block <> "else if " <>
				paren(unwrap(booleanLiteral("true"))) <> " " <> block <> "else if " <>
				paren(unwrap(booleanLiteral("false"))) <> " " <> block <> "else " <> block
		)
	}

	@Test
	def testWhile() {
		assertCompilesTo('''while(false){}''', "while " <> paren(unwrap(booleanLiteral("false"))) <> " " <> block)
	}

	@Test
	def testDoWhile() {
		assertCompilesTo('''do{}while(false);''', "do " <> block <> "while " <> paren(unwrap(booleanLiteral("false"))))
	}

	@Test
	def testForWithEmptyUpdate() {
		assertCompilesTo('''for(Integer i = 0; false; ){}''',
			"for (" <> binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)) <>
				"; " <> unwrap(booleanLiteral("false")) <> "; ) " <> block)
	}

	@Test
	def testForWithNonEmptyUpdate() {
		assertCompilesTo('''for(Integer i = 0; false; false ){}''',
			"for (" <> binOp("java.util.ArrayList<java.math.BigInteger> _local0", "=", integerLiteral("0", 10)) <>
				"; " <> unwrap(booleanLiteral("false")) <> "; " <> booleanLiteral("false") <> ") " <> block)
	}

	@Test
	def testForWithCollectionLiteral() {
		val collection = fun(CollectionOperations.SEQUENCE_LITERAL, unwrap(integerLiteral("0", 10)),
			unwrap(integerLiteral("2", 10)), unwrap(integerLiteral("4", 10)))
		assertCompilesTo('''for(Integer number in Sequence<Integer>{ 0, 2, 4 }){ number; }''',
			"for " <> paren("java.math.BigInteger _local0 : " <> collection) <> " " <> block(
				"java.util.ArrayList<java.math.BigInteger> _local1 = " <> wrap("_local0"),
				"_local1"
			))
	}

	@Test
	def testBreak() {
		assertCompilesTo('''while(false){break;}''',
			"while " <> paren(unwrap(booleanLiteral("false"))) <> " " <> block("break"))
	}

	@Test
	def sendNewSignalToNewObject() {
		assertCompilesTo('''send new S() to new B();''',
			"_9SdsIEDoEeWCNoKXHvCpUQ" -> fun("create", "i -> i._LAXgUEHKEeWzwYgcaM4qwA()") ->
				fun("send", "new " <> SignalEvent.canonicalName <> paren("new " <> fun("_47IQsEGyEeWzwYgcaM4qwA"))))
	}

	@Test
	def sendNewSignalToThisObject() {
		assertCompilesTo('''send new S() to this;''', CompilerBase.CONTEXT_NAME ->
			fun("send", "new " <> SignalEvent.canonicalName <> paren("new " <> fun("_47IQsEGyEeWzwYgcaM4qwA"))))
	}

	@Test
	def sendExistingSignalToExistingObject() {
		assertCompilesTo('''
			S s = new S();
			B b = new B();
			send s to b;
		''',
			binOp("java.util.ArrayList<_47IQsEGyEeWzwYgcaM4qwA> _local0", "=",
				wrap("new " <> fun("_47IQsEGyEeWzwYgcaM4qwA"))),
			binOp("java.util.ArrayList<_9SdsIEDoEeWCNoKXHvCpUQ> _local1", "=",
				wrap("_9SdsIEDoEeWCNoKXHvCpUQ" -> fun("create", "i -> i._LAXgUEHKEeWzwYgcaM4qwA()"))),
			unwrap("_local1") -> fun("send", "new " <> fun(SignalEvent.canonicalName, unwrap("_local0"))))
	}

	@Test
	def testSwitchWithIntegerLiterals() {
		assertCompilesTo(
			'''
				switch (0) {
					case 1: 
					case 2: break;
					default: return;
				}
			''',
			"switch " <> paren(unwrap(integerLiteral("0", 10)) -> fun("longValue")) <> " " <> block(
				"case 1: " <> "case 2: " <> block("break"),
				"default: " <> block("return")
			)
		)
	}

	@Test
	def testSwitchWithStringLiterals() {
		assertCompilesTo(
			'''
				switch ("c") {
					case "a": 
					case "b": break;
					default: return;
				}
			''',
			"switch " <> paren(unwrap(stringLiteral("c"))) <> " " <> block(
				'case "a": ' <> 'case "b": ' <> block("break"),
				"default: " <> block("return")
			)
		)
	}
}
