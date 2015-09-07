package hu.eltesoft.modelexecution.m2t.java.behavior.codegen

import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations
import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.java.behavior.codegen.CodeGenNodeExtensons.*
import static org.junit.Assert.assertEquals

class CodeGenNodeExtensonsTests {

	static extension CodeGenNode = CodeGenNode.EXTENSION

	@Test
	def testFunWithoutParameters() {
		val node = fun("f")
		assertStringifiedTo(node, '''f()''')
	}

	def testFunWithParameters() {
		val node = fun("f", "a", "b")
		assertStringifiedTo(node, '''f(a, b)''')
	}

	@Test
	def testBinOp() {
		val node = binOp("a", "+", "b")
		assertStringifiedTo(node, '''a + b''')
	}

	@Test
	def testWrapObject() {
		val node = wrap("a")
		assertStringifiedTo(node, '''«PrimitiveOperations.WRAP»(a)''')
	}

	@Test
	def testWrapSequence() {
		val node = wrap("a" <> "b")
		assertStringifiedTo(node, '''«PrimitiveOperations.WRAP»(ab)''')
	}

	@Test
	def testUnwrapObject() {
		val node = unwrap("a")
		assertStringifiedTo(node, '''«PrimitiveOperations.UNWRAP»(a)''')
	}

	@Test
	def testUnwrapSequence() {
		val node = unwrap("a" <> "b")
		assertStringifiedTo(node, '''«PrimitiveOperations.UNWRAP»(ab)''')
	}

	@Test
	def testWrapUnwrapFlattenedObject() {
		val node = wrap(unwrap("a"))
		assertStringifiedTo(node, '''a''')
	}

	@Test
	def testWrapUnwrapFlattenedSequence() {
		val node = wrap(unwrap("a" <> "b"))
		assertStringifiedTo(node, '''ab''')
	}

	@Test
	def testUnwrapWrapFlattenedObject() {
		val node = unwrap(wrap("a"))
		assertStringifiedTo(node, '''a''')
	}

	@Test
	def testUnwrapWrapFlattenedSequence() {
		val node = unwrap(wrap("a" <> "b"))
		assertStringifiedTo(node, '''ab''')
	}

	@Test
	def testFlatteningLongEvenWrapUnwrapSequence() {
		val node = unwrap(wrap(unwrap(wrap(unwrap(wrap("a" <> "b"))))))
		assertStringifiedTo(node, '''ab''')
	}

	@Test
	def testFlatteningLongOddWrapUnwrapSequence() {
		val node = wrap(unwrap(wrap(unwrap(wrap("a" + "b")))))
		assertStringifiedTo(node, '''«PrimitiveOperations.WRAP»(ab)''')
	}

	@Test
	def testFlatteningMixedWrapUnwrapSequence() {
		val node = wrap(wrap(unwrap(unwrap("a" <> "b"))))
		assertStringifiedTo(node, '''ab''')
	}

	private def assertStringifiedTo(CodeGenNode node, String expected) {
		assertEquals(expected, node.toString())
	}
}
