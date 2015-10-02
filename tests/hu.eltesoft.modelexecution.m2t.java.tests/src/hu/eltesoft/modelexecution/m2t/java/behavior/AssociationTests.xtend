package hu.eltesoft.modelexecution.m2t.java.behavior

import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*
import hu.eltesoft.modelexecution.m2t.java.ModelProperties
import java.util.function.Function
import java.util.Collection
import java.util.HashSet

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

	@Test
	def testNavigationFromThisToOne() {
		operation = ModelProperties.A_OPERATION
		val resultType = HashSet.canonicalName <> "<_9SdsIEDoEeWCNoKXHvCpUQ>"
		val type = paren(
			Function.canonicalName <> "<" <> Collection.canonicalName <> "<? extends _aeMPwMc1EeSnK7LttAdTLw>, " <>
				resultType <> ">")
		assertCompilesTo('''this->b;''',
			paren(type <>
				paren(paren("_local0") <> " -> " <>
					block(
						binOp(sequence(resultType) <> " _local1", "=", "new " <> HashSet.canonicalName <> "<>()"),
						"for " <> paren("_aeMPwMc1EeSnK7LttAdTLw _local2 : _local0") <> " " <>
							block(
								"for " <>
									paren("_nmXLsEzTEeWKTdNBA6WBAA _local3 : _local2.get__nmqGo0zTEeWKTdNBA6WBAA()") <>
									" " <> block(
										"_local1" -> fun("add", "_local3._nmqGokzTEeWKTdNBA6WBAA")
									)
							),
						"return _local1"
					))) -> fun("apply", wrap(CompilerBase.CONTEXT_NAME)))
	}

	@Test
	def testNavigationFromThisToMany() {
		operation = ModelProperties.B_OPERATION
		val resultType = HashSet.canonicalName <> "<_aeMPwMc1EeSnK7LttAdTLw>"
		val type = paren(
			Function.canonicalName <> "<" <> Collection.canonicalName <> "<? extends _9SdsIEDoEeWCNoKXHvCpUQ>, " <>
				resultType <> ">")
		assertCompilesTo('''this->a;''',
			paren(type <>
				paren(paren("_local0") <> " -> " <>
					block(
						binOp(sequence(resultType) <> " _local1", "=", "new " <> HashSet.canonicalName <> "<>()"),
						"for " <> paren("_9SdsIEDoEeWCNoKXHvCpUQ _local2 : _local0") <> " " <>
							block(
								"for " <>
									paren("_nmXLsEzTEeWKTdNBA6WBAA _local3 : _local2.get__nmqGokzTEeWKTdNBA6WBAA()") <>
									" " <> block(
										"_local1" -> fun("add", "_local3._nmqGo0zTEeWKTdNBA6WBAA")
									)
							),
						"return _local1"
					))) -> fun("apply", wrap(CompilerBase.CONTEXT_NAME)))
	}
}
