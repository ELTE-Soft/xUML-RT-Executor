package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EventFactory;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalEventTemplate;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;
import hu.eltesoft.modelexecution.uml.incquery.EventMatch;
import hu.eltesoft.modelexecution.uml.incquery.EventMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.EventProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalEventProcessor;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.SignalEvent;

public class SignalEventGenerator extends
		AbstractGenerator<SignalEvent, EvSignalEvent> {

	private static final EventFactory FACTORY = EventFactory.eINSTANCE;

	private final EventMatcher eventMatcher;
	private final SignalEventMatcher signalEventMatcher;

	public SignalEventGenerator(IncQueryEngine engine,
			TextChangesListener listener) throws IncQueryException {
		super(listener);
		eventMatcher = EventMatcher.on(engine);
		signalEventMatcher = SignalEventMatcher.on(engine);
	}

	// generate translation model

	@Override
	public EvSignalEvent generateTranslationModel(SignalEvent event)
			throws GenerationException {
		// new EvSignalEvent
		EvSignalEvent root = FACTORY.createEvSignalEvent();

		// name, signal
		check(eventMatcher.forOneArbitraryMatch(event, null,
				getProcessorToSetNameAndSignalOfRoot(root)));

		return root;
	}

	private EventProcessor getProcessorToSetNameAndSignalOfRoot(
			EvSignalEvent root) {
		return new EventProcessor() {

			@Override
			public void process(SignalEvent pEvent, String pEventName) {
				// name
				root.setName(pEventName);

				// signal
				check(signalEventMatcher.forOneArbitraryMatch(pEvent, null,
						getProcessorToSetNameOfRoot(root)));
			}

			private SignalEventProcessor getProcessorToSetNameOfRoot(
					EvSignalEvent root) {
				return new SignalEventProcessor() {

					@Override
					public void process(SignalEvent pEvent, String pSignalName) {
						root.setSignal(createSignal(pSignalName));
					}

				};
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

	// generate text

	@Override
	public void generateText(EvSignalEvent root) {
		SignalEventTemplate template = new SignalEventTemplate(root);

		SourceMappedText output = template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		listener.contentChanged(root.getName(), output, symbols);
	}

	// add match update listeners

	@Override
	public void addMatchUpdateListeners(AdvancedIncQueryEngine advancedEngine,
			ChangeRegistry changeRegistry) {

		advancedEngine.addMatchUpdateListener(eventMatcher,
				new IMatchUpdateListener<EventMatch>() {

					@Override
					public void notifyAppearance(EventMatch match) {
						changeRegistry.newModification(match.getEvent(),
								SignalEventGenerator.this);
					}

					@Override
					public void notifyDisappearance(EventMatch match) {
						// disappearance of root: delete file
						changeRegistry.newDeletion(match.getEventName());
					}

				}, false);

		advancedEngine.addMatchUpdateListener(signalEventMatcher,
				new IMatchUpdateListener<SignalEventMatch>() {

					@Override
					public void notifyAppearance(SignalEventMatch match) {
						changeRegistry.newModification(match.getEvent(),
								SignalEventGenerator.this);
					}

					@Override
					public void notifyDisappearance(SignalEventMatch match) {
						changeRegistry.newModification(match.getEvent(),
								SignalEventGenerator.this);
					}

				}, false);

	}
}
