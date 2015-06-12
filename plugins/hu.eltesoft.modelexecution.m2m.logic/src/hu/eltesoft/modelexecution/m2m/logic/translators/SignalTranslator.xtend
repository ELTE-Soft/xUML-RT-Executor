package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplate
import hu.eltesoft.modelexecution.uml.incquery.SignalMatch
import org.eclipse.uml2.uml.Signal
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalPackage
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatcher

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
		rootNode.onEObject(PACKAGE.sgSignal_Attributes, SignalAttributeMatcher.on(engine)) [
			val elem = FACTORY.createSgAttribute
			elem.reference = new NamedReference(attribute)
			elem.type = attribute.type.convert
			return elem
		]
		
		return rootNode
	}
	
	
	override createTemplate(SgSignal signal) {
		return new SignalTemplate(signal)
	}
	
}
