package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test
import org.junit.Before
import hu.eltesoft.modelexecution.m2t.java.ModelProperties

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
		assertCompilesTo('''E::Op1();''', '''«CompilerBase.RUNTIME_INSTANCE».getExternalEntity(E.class).Op1();''')
	}

	@Test
	def testExternalEntityInvocationProxyParameter() {
		assertCompilesTo('''E::Op2(this);''', '''«CompilerBase.RUNTIME_INSTANCE».getExternalEntity(E.class).Op2(new A(«CompilerBase.CONTEXT_NAME»));''')
	}
}
