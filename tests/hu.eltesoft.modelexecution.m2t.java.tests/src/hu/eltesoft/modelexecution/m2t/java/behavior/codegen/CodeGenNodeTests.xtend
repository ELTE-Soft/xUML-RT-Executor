package hu.eltesoft.modelexecution.m2t.java.behavior.codegen

import org.junit.Test

import static org.junit.Assert.assertEquals

class CodeGenNodeTests {

	static extension CodeGenNode = CodeGenNode.EXTENSION

	@Test
	def testEmptyNodeWithBeforeAndAfter() {
		val node = new CodeGenNode("(", ")")
		assertStringifiedTo(node, "()")
	}

	@Test
	def testEmptyNodeWithAllSeparators() {
		val node = new CodeGenNode("(", ")", ",", ";")
		assertStringifiedTo(node, "()")
	}

	@Test
	def testSingleItemWithBeforeAndAfter() {
		val node = new CodeGenNode("(", ")")
		node.add("a")
		assertStringifiedTo(node, "(a)")
	}

	@Test
	def testSingleItemWithSeparator() {
		val node = new CodeGenNode("(", ")", ",")
		node.add("a")
		assertStringifiedTo(node, "(a)")
	}

	@Test
	def testSingleItemWithTerminator() {
		val node = new CodeGenNode("(", ")", "", ";")
		node.add("a")
		assertStringifiedTo(node, "(a;)")
	}

	@Test
	def testMultipleItemsWithSeparator() {
		val node = new CodeGenNode("(", ")", ",")
		node.add("a").add("b").add("c")
		assertStringifiedTo(node, "(a,b,c)")
	}

	@Test
	def testMultipleItemsWithTerminator() {
		val node = new CodeGenNode("(", ")", "", ";")
		node.add("a").add("b").add("c")
		assertStringifiedTo(node, "(a;b;c;)")
	}

	@Test
	def testMultipleItemsWithoutSeparator() {
		val node = new CodeGenNode("(", ")")
		node.add("a").add("b").add("c")
		assertStringifiedTo(node, "(abc)")
	}

	@Test
	def testMultipleItemsWithSeparatorAndTerminator() {
		val node = new CodeGenNode("(", ")", ",", ";")
		node.add("a", "b", "c")
		assertStringifiedTo(node, "(a;,b;,c;)")
	}

	@Test
	def testSequence() {
		val node = sequence("a", "b", "c", "d")
		assertStringifiedTo(node, "abcd")
	}

	@Test
	def testApos() {
		val node = str("a", "b", "c", "d")
		assertStringifiedTo(node, '''"abcd"''')
	}

	@Test
	def testParen() {
		val node = paren("a", "b", "c", "d")
		assertStringifiedTo(node, "(a, b, c, d)")
	}

	@Test
	def testBlock() {
		val node = block("a", "b")
		assertStringifiedTo(node, '''
			{
			a;
			b;
			}
		''')
	}

	@Test
	def testDot() {
		val node = dot("a", "b", "c", "d")
		assertStringifiedTo(node, "a.b.c.d")
	}

	@Test
	def testCreateSequenceWithObjects() {
		val node = "a" <> 42
		assertStringifiedTo(node, "a42")
	}

	@Test
	def testAppendParenToString() {
		val node = "a" <> paren("b")
		assertStringifiedTo(node, "a(b)")
	}

	@Test
	def testAppendParenToSequence() {
		val node = "a" <> paren("b", "c") <> 42
		assertStringifiedTo(node, "a(b, c)42")
	}

	@Test
	def testAppendedSequencesAreFlattened() {
		val node = "a" <> ("b" <> "c") <> "d"
		assertStringifiedTo(node, "abcd")
		assertEquals(4, node.size)
	}

	@Test
	def testCreateDotWithObjects() {
		val node = "a" -> 42
		assertStringifiedTo(node, "a.42")
	}

	@Test
	def testDottedSequencesAreFlattened() {
		val node = "a" -> ("b" -> "c") -> "d"
		assertStringifiedTo(node, "a.b.c.d")
		assertEquals(4, node.size)
	}

	private def assertStringifiedTo(CodeGenNode node, String expected) {
		assertEquals(expected, node.toString())
	}
}
