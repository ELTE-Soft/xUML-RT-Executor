package hu.eltesoft.modelexecution.m2t.smap.xtend

import org.junit.Test

import static hu.eltesoft.modelexecution.m2t.smap.xtend.Assert.assertStringEquals

class SourceMappedTemplateTest {

	@Test
	def testComplexTemplateTextIsCorrect() {
		val template = new TestTemplate()
		val smText = template.generate("test")

		assertStringEquals(
			'''
				test
				    a
				b1
				
				b2
				
				{ item:
				    Integer: 1, 
				item:
				    String: 2, 
				item:
				    Double: 3.14
				 }
			''', smText)
	}

	@Test
	def testComplexTemplateSmapIsCorrect() {
		val template = new TestTemplate()
		val smText = template.generate("test")

		assertStringEquals(
			'''
				SMAP
				test.java
				sm
				*S sm
				*F
				+ 0 test.sm
				test.sm
				+ 1 test2.sm
				test2.sm
				*L
				17:2
				42,3:3
				1#1:8
				2:10
				5:12
				*E
			''', smText.smap.toString("test.java"))
	}
}
