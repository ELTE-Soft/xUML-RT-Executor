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
                *S sm
                *F
                + 0 test.sm
                test.sm
                *L
                17:2
                42,3:3
            ''', smText.smap)
    }
}
