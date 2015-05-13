package hu.eltesoft.modelexecution.m2t.java;

import hu.eltesoft.modelexecution.uml.alf.AlfAnalyzer;

import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.junit.Assert;

public class CompiledCodeCheckTestCase {

	private final AlfAnalyzer analyzer = new AlfAnalyzer();
	private final BehaviorBodyGenerator generator = new BehaviorBodyGenerator();

	protected void assertCompilesTo(String alfCode, String javaCode) {
		SyntaxElement alfASTRoot = analyzer.analyze(alfCode).getAstRoot();
		Assert.assertEquals(javaCode, generator.generate(alfASTRoot).toString());
	}
}
