package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent
import hu.eltesoft.modelexecution.m2m.metamodel.event.EventFactory
import hu.eltesoft.modelexecution.m2t.java.templates.SignalEventTemplate
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatch
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatcher
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.SignalEvent

class SignalEventTranslator extends RootElementTranslator<SignalEvent, EvSignalEvent, SignalEventMatch> {

	static val FACTORY = EventFactory.eINSTANCE

	new(IncQueryEngine engine) throws IncQueryException {
		super(engine)
	}

	override buildMapper(IncQueryEngine engine) {
		return fromRoot(SignalEventMatcher.on(engine)) [
			val root = FACTORY.createEvSignalEvent
			root.reference = new NamedReference(event)
			root.signal = new NamedReference(signal)
			return root
		]
	}

	override createTemplate(EvSignalEvent event) {
		return new SignalEventTemplate(event)
	}
}
