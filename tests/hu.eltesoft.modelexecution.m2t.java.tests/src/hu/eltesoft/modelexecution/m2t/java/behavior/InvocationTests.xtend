package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test
import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode

class InvocationTests extends CompiledCodeCheckTestCase {

	static extension CodeGenNode = CodeGenNode.extension

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testNonStaticSelfCallNoParams() {
		assertCompilesTo('''this.OpVoid();''', CompilerBase.CONTEXT_NAME -> fun("_$1zHIEDoEeWCNoKXHvCpUQ"))
	}

	@Test
	def testNonStaticLocalCallNoParams() {
		assertCompilesTo(
			'''A a = new A(); a.Op();''',
			binOp("java.util.ArrayList<_aeMPwMc1EeSnK7LttAdTLw> _local0", "=",
				wrap("_aeMPwMc1EeSnK7LttAdTLw" -> fun("create", "null"))),
			unwrap("_local0") -> fun("_oMFm4EG6EeWzwYgcaM4qwA")
		)
	}

	@Test
	def testNonStaticSelfCallInParams() {
		assertCompilesTo('''this.OpIn(pInInt => 42, pInBool => true);''', CompilerBase.CONTEXT_NAME ->
			fun("_E59jwEG_EeWzwYgcaM4qwA", booleanLiteral("true"), integerLiteral("42", 10)))
		assertCompilesTo('''this.OpIn(pInBool => true, pInInt => 42);''', CompilerBase.CONTEXT_NAME ->
			fun("_E59jwEG_EeWzwYgcaM4qwA", booleanLiteral("true"), integerLiteral("42", 10)))
	}

	@Test
	def testStaticCallNoParams() {
		assertCompilesTo("A::OpStatic();", "_aeMPwMc1EeSnK7LttAdTLw_impl" -> fun("_M0$PUEG7EeWzwYgcaM4qwA"))
	}

	@Test
	def testStaticCallInParams() {
		assertCompilesTo('''B::OpStaticIn(pInString => "hello", pInReal => 3.1415);''',
			"_9SdsIEDoEeWCNoKXHvCpUQ_impl" ->
				fun("_VlbpQEHEEeWzwYgcaM4qwA", stringLiteral("hello"), realLiteral("3.1415")))
		assertCompilesTo('''B::OpStaticIn(pInReal => 3.1415, pInString => "hello");''',
			"_9SdsIEDoEeWCNoKXHvCpUQ_impl" ->
				fun("_VlbpQEHEEeWzwYgcaM4qwA", stringLiteral("hello"), realLiteral("3.1415")))
	}
}
