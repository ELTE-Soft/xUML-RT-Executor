package hu.eltesoft.modelexecution.uml.alf;

import hu.eltesoft.modelexecution.m2t.smap.xtend.SmapStringConcatenation;

import org.junit.Assert;

public class CompiledCodeCheckTestCase {

	private final OperationBodyCompiler compiler = new OperationBodyCompiler();

	protected void assertCompilesTo(String alfCode, String javaCode) {
		SmapStringConcatenation builder = new SmapStringConcatenation("Alf");
		compiler.compile(alfCode, builder);

		Assert.assertEquals(javaCode, builder.toString());
	}
}
