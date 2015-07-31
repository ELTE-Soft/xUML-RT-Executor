package hu.eltesoft.modelexecution.uml.alf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.uml.alf.Block;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.Test;

public class StartRuleTests {

	private OperationBodyParser parser = new OperationBodyParser();

	@Test
	public void testParsingSignatureLeadsToSyntaxError() {
		assertTrue(parser.parse("x() {}").hasSyntaxErrors());
	}

	@Test
	public void testParsingNullBodyResultsInAnEmptyBlock() {
		assertIsEmptyBlock(parser.parse((String) null));
	}

	@Test
	public void testParsingEmptyBodyResultsInAnEmptyBlock() {
		assertIsEmptyBlock(parser.parse(""));
	}

	private void assertIsEmptyBlock(IParseResult result) {
		assertIsBlock(result);
		assertTrue(((Block) result.getRootASTElement()).getStatement().isEmpty());
	}

	private void assertIsBlock(IParseResult result) {
		assertFalse(result.hasSyntaxErrors());
		assertTrue(result.getRootASTElement() instanceof Block);
	}

	@Test
	public void testParsingSingleFeatureCallResultsInABlock() {
		assertIsBlock(parser.parse("this.x();"));
	}

	@Test
	public void testParsingMultipleFeatureCallsResultsInABlock() {
		assertIsBlock(parser.parse("this.x(); y();"));
	}
}
