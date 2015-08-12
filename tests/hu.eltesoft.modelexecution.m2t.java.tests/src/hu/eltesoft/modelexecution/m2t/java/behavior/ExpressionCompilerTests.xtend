package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Ignore
import org.junit.Test

class ExpressionCompilerTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new LiteralCompiler()
	}

	@Test
	def testNull() {
		assertCompilesToSame("null;")
	}

	@Ignore("Unable to run test as context is broken: 'Cannot type this'")
	@Test
	def testThis() {
		assertCompilesTo("this;", '''«Compiler.CONTEXT_NAME»;''')
	}
}
