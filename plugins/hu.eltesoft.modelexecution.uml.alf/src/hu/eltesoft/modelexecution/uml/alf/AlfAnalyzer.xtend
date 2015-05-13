package hu.eltesoft.modelexecution.uml.alf

import org.eclipse.papyrus.uml.alf.AlfFactory
import org.eclipse.papyrus.uml.alf.SyntaxElement
import org.eclipse.xtext.parser.IParseResult

/**
 * Represents the result of analyzing an Alf operation body.
 */
@Data
class AlfAnalyzerResult {

	val IParseResult parseResult
	val SyntaxElement astRoot
}

/**
 * Analyzes an Alf operation body in two steps. First it parses the provided
 * code, then tries to decorate its AST with model element references.
 */
class AlfAnalyzer {

	def AlfAnalyzerResult analyze(String alfCode) {
		val parser = new OperationBodyParser
		val parseResult = parser.parse(alfCode)

		if (!parseResult.hasSyntaxErrors) {
			val root = parseResult.rootASTElement as SyntaxElement

			// TODO: visit and decorate the AST with model references!
			return new AlfAnalyzerResult(parseResult, root)
		}

		val root = AlfFactory.eINSTANCE.createBlock();
		return new AlfAnalyzerResult(parseResult, root)
	}
}
