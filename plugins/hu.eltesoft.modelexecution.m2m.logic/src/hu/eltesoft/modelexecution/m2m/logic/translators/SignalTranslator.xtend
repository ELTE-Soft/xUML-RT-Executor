package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplate
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatcher
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.SignalMatch
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Signal

class SignalTranslator extends RootElementTranslator<Signal, SgSignal, SignalMatch> {

	static val SignalFactory FACTORY = SignalFactory.eINSTANCE;
	static val SignalPackage PACKAGE = SignalPackage.eINSTANCE;

	new(IncQueryEngine engine) throws IncQueryException {
		super(engine)
	}
	
	override protected buildMapper(IncQueryEngine engine) throws IncQueryException {
		val rootNode = fromRoot(SignalMatcher.on(engine)) [ 
			val root = FACTORY.createSgSignal
			root.reference = new NamedReference(signal)
			return root
		]
		val attributeNode = rootNode.onEObject(PACKAGE.sgSignal_Attributes, SignalAttributeMatcher.on(engine)) [
			val elem = FACTORY.createSgAttribute
			elem.reference = new NamedReference(attribute)
			return elem
		]
		val typeNode = attributeNode.on(PACKAGE.sgAttribute_Type, SignalAttributeTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createFullType
			elem.baseType = type.convert
			elem.isOrdered = ordered
			elem.isUnique = unique
			return elem
		]
		typeNode.on(BASE_PACKAGE.fullType_LowerBound, SignalAttributeLowerBoundMatcher.on(engine)) [
			lowerBound.toInt
		]
		typeNode.on(BASE_PACKAGE.fullType_UpperBound, SignalAttributeUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]
		
		return rootNode
	}
	
	
	override createTemplate(SgSignal signal) {
		return new SignalTemplate(signal)
	}
	
}
