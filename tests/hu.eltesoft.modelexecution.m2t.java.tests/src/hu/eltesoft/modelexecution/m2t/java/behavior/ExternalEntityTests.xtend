package hu.eltesoft.modelexecution.m2t.java.behavior

import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode
import org.junit.Before
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class ExternalEntityTests extends CompiledCodeCheckTestCase {

	static extension CodeGenNode = CodeGenNode.extension

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
}
