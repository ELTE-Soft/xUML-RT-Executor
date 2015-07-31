package hu.eltesoft.modelexecution.m2t.java;

import org.eclipse.uml2.uml.Class;
import org.junit.Assert;

import hu.eltesoft.modelexecution.test.utils.ModelBasedTestCase;
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzer;
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult;

public class CompiledCodeCheckTestCase extends ModelBasedTestCase {

	protected CompiledCodeCheckTestCase(String modelPath) {
		super(modelPath);
	}

	private final AlfAnalyzer analyzer = new AlfAnalyzer();
	private final BehaviorBodyGenerator generator = new BehaviorBodyGenerator();

	protected void assertCompilesTo(Class context, String alfCode, String javaCode) {
		AlfAnalyzerResult result = analyzer.analyze(alfCode, context);
		Assert.assertEquals(javaCode, generator.generate(result).toString());
	}
}
