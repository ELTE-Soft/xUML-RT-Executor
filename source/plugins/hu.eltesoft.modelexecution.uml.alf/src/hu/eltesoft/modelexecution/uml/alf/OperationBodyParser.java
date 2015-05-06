package hu.eltesoft.modelexecution.uml.alf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.AlfStandaloneSetup;
import org.eclipse.papyrus.uml.alf.parser.antlr.AlfParser;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseResult;

import com.google.inject.Injector;

/**
 * Alf parser with a custom start rule. It tries to parse an operation body
 * parsing a non empty statement sequence. The {@link #parse(String) parse}
 * method is implemented to return an empty block when there are no statements
 * in the input text at all, or it is null.
 */
class OperationBodyParser extends AlfParser {

	public OperationBodyParser() {
		AlfStandaloneSetup setup = new AlfStandaloneSetup();
		Injector injector = setup.createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}

	@Override
	protected String getDefaultRuleName() {
		return "NonEmptyStatementSequence";
	}

	public IParseResult parse(String alfCode) {
		if (null == alfCode || alfCode.trim().isEmpty()) {
			ICompositeNode blockNode = new EmptyBlockNode();
			EObject block = blockNode.getSemanticElement();
			return new ParseResult(block, blockNode, false);
		}
		return doParse(alfCode);
	}
}
