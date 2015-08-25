package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplateSmap
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatcher
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.SignalMatch
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Signal

class SignalTranslator extends RootElementTranslator<Signal, SgSignal, SignalMatch> {

	static val SignalFactory FACTORY = SignalFactory.eINSTANCE;
	static val SignalPackage PACKAGE = SignalPackage.eINSTANCE;

	new(AdvancedIncQueryEngine engine) throws IncQueryException {
		super(engine)
	}

	override protected createMapper(AdvancedIncQueryEngine engine) {
		val rootNode = fromRoot(SignalMatcher.on(engine)) [
			val root = FACTORY.createSgSignal
			root.reference = new NamedReference(signal)
			return root
		]
		return rootNode
	}

	override protected initMapper(RootNode<?, ?, ?> rootNode, AdvancedIncQueryEngine engine) {
		val attributeNode = rootNode.onEObject(PACKAGE.sgSignal_Attributes, SignalAttributeMatcher.on(engine)) [
			val elem = FACTORY.createSgAttribute
			elem.reference = new NamedReference(attribute)
			elem.type = type.convert as PrimitiveType
			elem.isOrdered = ordered
			elem.isUnique = unique
			return elem
		]
		attributeNode.on(BASE_PACKAGE.multiplicity_LowerBound, SignalAttributeLowerBoundMatcher.on(engine)) [
			lowerBound
		]
		attributeNode.on(BASE_PACKAGE.multiplicity_UpperBound, SignalAttributeUpperBoundMatcher.on(engine)) [
			upperBound
		]
	}

	override createTemplate(SgSignal signal) {
		return new SignalTemplateSmap(signal)
	}

}
