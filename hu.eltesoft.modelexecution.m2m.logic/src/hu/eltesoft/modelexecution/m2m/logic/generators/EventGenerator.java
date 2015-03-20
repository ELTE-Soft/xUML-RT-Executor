package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EventFactory;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalEventTemplate;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;
import hu.eltesoft.modelexecution.uml.incquery.EventMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.EventProcessor;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Event;

public class EventGenerator extends AbstractGenerator<Event, EvEvent> {

	private static final EventFactory FACTORY = EventFactory.eINSTANCE;

	private final EventMatcher eventMatcher;

	public EventGenerator(IncQueryEngine engine, TextChangesListener listener) throws IncQueryException {
		super(listener);
		eventMatcher = EventMatcher.on(engine);
	}

	@Override
	public EvEvent generateTranslationModel(Event event) {
		// new EvSignalEvent
		EvSignalEvent root = FACTORY.createEvSignalEvent();

		// name, signal
		eventMatcher.forOneArbitraryMatch(event, null, null, getProcessorToSetNameAndSignalOfRoot(root));

		return root;
	}

	private EventProcessor getProcessorToSetNameAndSignalOfRoot(EvSignalEvent root) {
		return new EventProcessor() {

			@Override
			public void process(Event pEvent, String pEventName, String pSignalName) {
				// name
				root.setName(pEventName);

				// signal
				root.setSignal(createSignal(pSignalName));
			}

			private EvSignal createSignal(String name) {
				// new EvSignal
				EvSignal evSignal = FACTORY.createEvSignal();

				// name
				evSignal.setName(name);

				return evSignal;
			}

		};
	}

	@Override
	public void generateText(EvEvent root) {
		SignalEventTemplate template = new SignalEventTemplate((EvSignalEvent) root); // TODO
																						// different
																						// events

		SourceMappedText output = (SourceMappedText) template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		listener.contentChanged(root.getName(), output, symbols);
	}

	@Override
	public EvEvent generateModelRoot(Event source) {
		// TODO Auto-generated method stub
		return null;
	}

}
