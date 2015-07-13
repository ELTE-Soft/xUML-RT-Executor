package hu.eltesoft.modelexecution.m2t.smap.xtend;

import static hu.eltesoft.modelexecution.m2t.smap.xtend.Assert.assertStringEquals;

import org.junit.Test;

public class SourceMappedTemplateTest {

	@Test
	public void testComplexTemplateTextIsCorrect() {
		TestTemplateSmap template = new TestTemplateSmap();
		SourceMappedText result = template.generate("test");

		String expected = "test\n" + "    a\n" + "b1\n" + "\n" + "b2\n" + "\n"
				+ "{ item:\n" + "    Integer: 0, \n" + "item:\n"
				+ "    String: 2, \n" + "item:\n" + "    Double: 3.14\n"
				+ " }\n";
		assertStringEquals(expected, result);
	}

	@Test
	public void testComplexTemplateSmapIsCorrect() {
		TestTemplateSmap template = new TestTemplateSmap();
		SourceMappedText result = template.generate("test");

		String expected = "SMAP\n" + "\n" + "sm\n" + "*S sm\n" + "*F\n" + "+ 0 test.sm\n" + "test.sm\n"
				+ "+ 1 test2.sm\n" + "test2.sm\n" + "*L\n" + "17:2\n"
				+ "42,3:3\n" + "1#1:8\n" + "2:10\n" + "5:12\n" + "*E\n";
		assertStringEquals(expected, result.getSmap());
	}
}
