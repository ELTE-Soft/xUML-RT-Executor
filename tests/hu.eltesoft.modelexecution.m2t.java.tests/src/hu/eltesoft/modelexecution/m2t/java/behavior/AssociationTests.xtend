package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test

class AssociationTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testNonStaticSelfCallNoParams() {
		assertCompilesTo('''A a = new A(); AB::link(a => a, b => this);''', empty)
	}
}
