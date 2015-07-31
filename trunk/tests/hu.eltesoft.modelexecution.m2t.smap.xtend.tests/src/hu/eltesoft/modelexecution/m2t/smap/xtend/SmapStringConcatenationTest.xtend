package hu.eltesoft.modelexecution.m2t.smap.xtend

import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.smap.xtend.Assert.assertStringEquals

class SmapStringConcatenationTest {

	@Test
	def testAppendingDataWithLocationText() {
		val smText = createBuilderFromDataWithLocation()

		assertStringEquals("a\nb\nc\ndata", smText)
	}

	@Test
	def testAppendingDataWithLocationSmap() {
		val smText = createBuilderFromDataWithLocation()

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
				17,2:4
				*E
			''', smText.smap.toString("test.java"))
	}

	private def createBuilderFromDataWithLocation() {
		val builder = new SmapStringConcatenation("sm")
		val location = new Location("test.sm", 17, 18)
		val data = new DataWithLocation<String>("data", location)
		builder.append("a\r\nb\nc\r")
		builder.append(data, "")
		builder.toSourceMappedText
	}

	@Test
	def testAppendingNestedTemplateText() {
		val smText = createBuilderFromNestedTemplate()

		assertStringEquals("0\n1\n2\na\nb\nc\ndata", smText)
	}

	@Test
	def testAppendingNestedTemplateSmap() {
		val smText = createBuilderFromNestedTemplate()

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
				17,2:7
				*E
			''', smText.smap.toString("test.java"))
	}

	def createBuilderFromNestedTemplate() {
		val builder = new SmapStringConcatenation("sm")
		val inner = createBuilderFromDataWithLocation()
		builder.append("0\r1\n2\r\n")
		builder.append(inner, "")
		builder.toSourceMappedText
	}
}
