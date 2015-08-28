package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test
import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*
import hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNode

class AssociationTests extends CompiledCodeCheckTestCase {

	static extension CodeGenNode = CodeGenNode.extension

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testNonStaticSelfCallNoParams() {
		assertCompilesTo('''A a = new A(); AB::link(a => a, b => this);''', empty)
	}
}
