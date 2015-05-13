package hu.eltesoft.modelexecution.uml.alf

import org.eclipse.papyrus.uml.alf.AlfFactory
import org.eclipse.papyrus.uml.alf.Block
import org.eclipse.papyrus.uml.alf.SyntaxElement
import org.eclipse.uml2.uml.Class
import org.eclipse.xtext.parser.IParseResult

/**
 * Represents the result of analyzing an Alf operation body. It contains the
 * potential parsing errors, the root of the AST and its mapping to the model
 * elements.
 */
@Data
class AlfAnalyzerResult {

	val IParseResult parseResult
	val SyntaxElement astRoot
	val ModelReferences references
}

/**
 * Analyzes an Alf operation body in two steps. First it parses the provided
 * code, then tries to decorate its AST with model element references.
 */
class AlfAnalyzer {

	def AlfAnalyzerResult analyze(String alfCode) {
		analyze(alfCode, null)
	}

	def AlfAnalyzerResult analyze(String alfCode, Class context) {
		val parser = new OperationBodyParser
		val parseResult = parser.parse(alfCode)
		val references = new ModelReferences

		if (!parseResult.hasSyntaxErrors) {

			// OperationBodyParser always returns a block
			val root = parseResult.rootASTElement as Block

			if (null != context) {
				new ModelReferenceDecorator(references, context).visit(root);
			}

			return new AlfAnalyzerResult(parseResult, root, references)
		}

		val root = AlfFactory.eINSTANCE.createBlock();
		return new AlfAnalyzerResult(parseResult, root, references)
	}
}
