package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*

class AssociationTests extends CompiledCodeCheckTestCase {

	new() {
		compiler = new ExpressionCompiler()
	}

	@Test
	def testCreateLink() {
		assertCompilesTo(
			'''A a = new A(); AB::link(a => a, b => this);''',
			binOp("java.util.ArrayList<_aeMPwMc1EeSnK7LttAdTLw> _local0", "=",
				wrap("_aeMPwMc1EeSnK7LttAdTLw" -> fun("create", "null"))),
			"_nmXLsEzTEeWKTdNBA6WBAA" -> "link" <> paren(CompilerBase.CONTEXT_NAME, unwrap("_local0"))
		)
	}

	@Test
	def testDestroyLink() {
		assertCompilesTo(
			'''A a = new A(); AB::unlink(b => this, a => a);''',
			binOp("java.util.ArrayList<_aeMPwMc1EeSnK7LttAdTLw> _local0", "=",
				wrap("_aeMPwMc1EeSnK7LttAdTLw" -> fun("create", "null"))),
			"_nmXLsEzTEeWKTdNBA6WBAA" -> "unlink" <> paren(CompilerBase.CONTEXT_NAME, unwrap("_local0"))
		)
	}
}
