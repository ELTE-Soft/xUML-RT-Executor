package hu.eltesoft.modelexecution.uml.alf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.AlfStandaloneSetup;
import org.eclipse.papyrus.uml.alf.parser.antlr.AlfParser;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseResult;

import com.google.inject.Injector;

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
		if (null == alfCode) {
			alfCode = "";
		}
		if (alfCode.trim().isEmpty()) {
			ICompositeNode blockNode = new EmptyBlockNode();
			EObject block = blockNode.getSemanticElement();
			return new ParseResult(block, blockNode, false);
		}
		return doParse(alfCode);
	}
}
