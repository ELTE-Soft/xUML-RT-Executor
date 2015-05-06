package hu.eltesoft.modelexecution.m2t.smap.xtend

import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.smap.xtend.Assert.assertStringEquals

class SourceMappedTextTest {

	@Test
	def testEmptySmap() {
		val smText = new SourceMappedText("sm", newArrayList(), "")

		assertStringEquals(
			'''
				SMAP
				test.java
				sm
				*E
			''', smText.smap.toString("test.java"))
	}

	@Test
	def testOneLineMapping() {
		val location = new Location("test.sm", 42, 42)
		val line = new LineMapping(location, 17, 1)
		val mapping = newArrayList(line)
		val smText = new SourceMappedText("sm", mapping, "")

		assertStringEquals(
			'''
				SMAP
				test.java
				sm
				*S sm
				*F
				+ 0 test.sm
				test.sm
				*L
				42:17
				*E
			''', smText.smap.toString("test.java"))
	}

	@Test
	def testMultiLineInputMapping() {
		val location = new Location("test.sm", 42, 45)
		val line = new LineMapping(location, 17, 1)
		val mapping = newArrayList(line)
		val smText = new SourceMappedText("sm", mapping, "")

		assertStringEquals(
			'''
				SMAP
				test.java
				sm
				*S sm
				*F
				+ 0 test.sm
				test.sm
				*L
				42,4:17
				*E
			''', smText.smap.toString("test.java"))
	}

	@Test
	def testMultiLineOutputMapping() {
		val location = new Location("test.sm", 42, 42)
		val line = new LineMapping(location, 17, 3)
		val mapping = newArrayList(line)
		val smText = new SourceMappedText("sm", mapping, "")

		assertStringEquals(
			'''
				SMAP
				test.java
				sm
				*S sm
				*F
				+ 0 test.sm
				test.sm
				*L
				42:17,3
				*E
			''', smText.smap.toString("test.java"))
	}

	@Test
	def testMultiLineMapping() {
		val location = new Location("test.sm", 42, 45)
		val line = new LineMapping(location, 17, 3)
		val mapping = newArrayList(line)
		val smText = new SourceMappedText("sm", mapping, "")

		assertStringEquals(
			'''
				SMAP
				test.java
				sm
				*S sm
				*F
				+ 0 test.sm
				test.sm
				*L
				42,4:17,3
				*E
			''', smText.smap.toString("test.java"))
	}

	@Test
	def testMultiFileMapping() {
		val locationA = new Location("a.sm", 42, 42)
		val lineA = new LineMapping(locationA, 17, 1)
		val locationB = new Location("b.sm", 29, 29)
		val lineB = new LineMapping(locationB, 32, 1)
		val mapping = newArrayList(lineA, lineB)
		val smText = new SourceMappedText("sm", mapping, "")

		assertStringEquals(
			'''
				SMAP
				test.java
				sm
				*S sm
				*F
				+ 0 a.sm
				a.sm
				+ 1 b.sm
				b.sm
				*L
				42:17
				29#1:32
				*E
			''', smText.smap.toString("test.java"))
	}

	@Test
	def testFileNameIsExtractedFromPath() {
		val location = new Location("xtend/smap/test.sm", 42, 42)
		val line = new LineMapping(location, 17, 1)
		val mapping = newArrayList(line)
		val smText = new SourceMappedText("sm", mapping, "")

		assertStringEquals(
			'''
				SMAP
				test.java
				sm
				*S sm
				*F
				+ 0 test.sm
				xtend/smap/test.sm
				*L
				42:17
				*E
			''', smText.smap.toString("test.java"))
	}
}
