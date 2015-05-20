package hu.eltesoft.modelexecution.m2t.java;

import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzer;
import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzerResult;
import hu.eltesoft.modelexecution.uml.alf.ModelReferences;

import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.junit.Assert;

public class CompiledCodeCheckTestCase {

	private final AlfAnalyzer analyzer = new AlfAnalyzer();
	private final BehaviorBodyGenerator generator = new BehaviorBodyGenerator();

	protected void assertCompilesTo(String alfCode, String javaCode) {
		SyntaxElement alfASTRoot = analyzer.analyze(alfCode).getAstRoot();
		AlfAnalyzerResult result = new AlfAnalyzerResult(null, alfASTRoot,
				new ModelReferences());
		Assert.assertEquals(javaCode, generator.generate(result).toString());
	}
}
