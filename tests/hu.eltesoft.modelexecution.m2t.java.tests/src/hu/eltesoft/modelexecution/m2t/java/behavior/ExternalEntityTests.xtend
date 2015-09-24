package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import org.junit.Before
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class ExternalEntityTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler();
	}

	@Before
	override setup() {
		operation = ModelProperties.CALLABLE_OPERATION
	}

	@Test
	def testExternalEntityInvocationNoParameters() {
		assertCompilesTo('''E::Op1();''',
			CompilerBase.RUNTIME_INSTANCE -> fun("getExternalEntity", "E.class") -> fun("Op1"))
	}

	@Test
	def testExternalEntityInvocationProxyParameter() {
		assertCompilesTo('''E::Op2(this);''', CompilerBase.RUNTIME_INSTANCE -> fun("getExternalEntity", "E.class") ->
			fun("Op2", "new " <> fun("A", CompilerBase.CONTEXT_NAME)))
	}

	@Test
	def testExternalEntityInvocationProxyParameterByName() {
		assertCompilesTo('''E::Op2(proxy => this);''',
			CompilerBase.RUNTIME_INSTANCE -> fun("getExternalEntity", "E.class") ->
				fun("Op2", "new " <> fun("A", CompilerBase.CONTEXT_NAME)))
	}

	@Test
	def testExternalEntityPrimitiveParameters() {
		assertCompilesTo('''E::Op3(false, 42, 3.1415, "hello");''', wrap(CompilerBase.RUNTIME_INSTANCE -> fun("getExternalEntity", "E.class") ->
			fun("Op3", unwrap(booleanLiteral("false")), unwrap(integerLiteral("42", 10)), unwrap(realLiteral("3.1415")), unwrap(stringLiteral("hello")))))
	}

	@Test
	def testExternalEntityPrimitiveParametersByName() {
		assertCompilesTo('''E::Op3(d => "hello", a => false, b => 42, c => 3.1415);''', wrap(CompilerBase.RUNTIME_INSTANCE -> fun("getExternalEntity", "E.class") ->
			fun("Op3", unwrap(booleanLiteral("false")), unwrap(integerLiteral("42", 10)), unwrap(realLiteral("3.1415")), unwrap(stringLiteral("hello")))))
	}
}
