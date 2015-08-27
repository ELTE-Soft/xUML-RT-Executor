package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class LifecycleTests extends CompiledCodeCheckTestCase {

	static extension CodeGenNode = CodeGenNode.extension

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testDefaultConstructor() {
		assertCompilesTo('''new A();''', wrap("_aeMPwMc1EeSnK7LttAdTLw" -> fun("create", "null")))
	}

	@Test
	def testCustomConstructorNoParams() {
		assertCompilesTo('''new B();''',
			wrap("_9SdsIEDoEeWCNoKXHvCpUQ" -> fun("create", "i -> i._LAXgUEHKEeWzwYgcaM4qwA()")))
	}

	@Test
	def testCustomConstructorInParams() {
		assertCompilesTo('''new C(pInString => "world", pInBool => false);''', wrap("_5FoZEEHJEeWzwYgcaM4qwA" ->
			fun("create",
				fun("i -> i._7BAgoEHJEeWzwYgcaM4qwA", fun(PrimitiveOperations.BOOLEAN_LITERAL, "false"),
					fun(PrimitiveOperations.STRING_LITERAL, str("world"))))))
		assertCompilesTo('''new C(pInBool => false, pInString => "world");''', wrap("_5FoZEEHJEeWzwYgcaM4qwA" ->
			fun("create",
				fun("i -> i._7BAgoEHJEeWzwYgcaM4qwA", fun(PrimitiveOperations.BOOLEAN_LITERAL, "false"),
					fun(PrimitiveOperations.STRING_LITERAL, str("world"))))))
	}

	@Test
	def testSignalConstructorNoParams() {
		assertCompilesTo('''new S();''', wrap("new " <> fun("_47IQsEGyEeWzwYgcaM4qwA")))
	}

	@Test
	def testSignalConstructorPropertyParams() {
		assertCompilesTo('''new SParams(aBool => true, aString => "hello");''',
			wrap("new " <>
				fun("_MR4rMEHNEeWzwYgcaM4qwA", fun(PrimitiveOperations.BOOLEAN_LITERAL, "true"),
					fun(PrimitiveOperations.STRING_LITERAL, str("hello")))))
		assertCompilesTo('''new SParams(aString => "hello", aBool => true);''',
			wrap("new " <>
				fun("_MR4rMEHNEeWzwYgcaM4qwA", fun(PrimitiveOperations.BOOLEAN_LITERAL, "true"),
					fun(PrimitiveOperations.STRING_LITERAL, str("hello")))))
	}

	@Test
	def testDeleteExpression() {
		assertCompilesTo(
			'''A a = new A(); delete a;''',
			binOp("java.util.ArrayList<_aeMPwMc1EeSnK7LttAdTLw> _local0", "=",
				wrap("_aeMPwMc1EeSnK7LttAdTLw" -> fun("create", "null"))),
			unwrap("_local0") -> fun("dispose")
		)
	}
}
