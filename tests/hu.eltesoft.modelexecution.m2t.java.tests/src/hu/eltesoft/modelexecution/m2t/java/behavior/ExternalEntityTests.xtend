package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test

class ExternalEntityTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler();
	}

	@Test
	def testExternalEntityInvocationNoParameters() {
		assertCompilesTo('''E::Op1();''', '''«CompilerBase.CONTEXT_NAME».getRuntime().getExternalEntity(E.class).Op1();''')
	}

	@Test
	def testExternalEntityInvocationProxyParameter() {
		assertCompilesTo('''E::Op2(this);''', '''«CompilerBase.CONTEXT_NAME».getRuntime().getExternalEntity(E.class).Op2(«CompilerBase.CONTEXT_NAME»);''')
	}
}
