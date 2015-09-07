package hu.eltesoft.modelexecution.m2t.java.behavior.codegen

import org.junit.Test

import static hu.eltesoft.modelexecution.test.utils.Assert.assertStringEqualsWithoutBreaks

class CodeGenNodeBlockTests {
	
	static extension CodeGenNode = CodeGenNode.EXTENSION

	@Test
	def testSingleBlock() {
		val node = topLevelBlock(block)
		assertStringifiedTo(node, "{}")
	}
	
	@Test
	def testTwoBlocks() {
		val node = topLevelBlock(block, block)
		assertStringifiedTo(node, "{}{}")
	}

	@Test
	def testSequenceNestedBlock() {
		val node = topLevelBlock("class A " <> block)
		assertStringifiedTo(node, "class A {}")
	}

	private def assertStringifiedTo(CodeGenNode node, String expected) {
		assertStringEqualsWithoutBreaks(expected, node.toString())
	}
}