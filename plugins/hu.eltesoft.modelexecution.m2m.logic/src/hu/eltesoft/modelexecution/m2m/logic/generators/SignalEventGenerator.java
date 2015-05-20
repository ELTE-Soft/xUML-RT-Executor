package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
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
import org.eclipse.uml2.uml.Signal;
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
				root.setReference(new NamedReference(pEvent, pEventName));

				// signal
				check(signalEventMatcher.forOneArbitraryMatch(pEvent, null,
						null, getProcessorToSetNameOfRoot(root)));
			}

			private SignalEventProcessor getProcessorToSetNameOfRoot(
					EvSignalEvent root) {
				return new SignalEventProcessor() {

					@Override
					public void process(SignalEvent pEvent, Signal pSignal,
							String pSignalName) {
						root.setSignal(createSignal(pSignal, pSignalName));
					}

				};
			}

			private EvSignal createSignal(Signal pSignal, String name) {
				// new EvSignal
				EvSignal evSignal = FACTORY.createEvSignal();

				// name
				evSignal.setReference(new NamedReference(pSignal, name));

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

		textChangesListener.contentChanged(root.getReference()
				.getNewIdentifier(), output, symbols);
	}

	// add match update listeners

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<EventMatch> eventListener;
			private final IMatchUpdateListener<SignalEventMatch> signalEventListener;

			{ // set eventListener
				eventListener = new IMatchUpdateListener<EventMatch>() {

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

				};

				advancedEngine.addMatchUpdateListener(eventMatcher,
						eventListener, false);
			}

			{ // set signalEventListener
				signalEventListener = new IMatchUpdateListener<SignalEventMatch>() {

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

				};

				advancedEngine.addMatchUpdateListener(signalEventMatcher,
						signalEventListener, false);
			}

			@Override
			public boolean revert() {

				advancedEngine.removeMatchUpdateListener(eventMatcher,
						eventListener);
				advancedEngine.removeMatchUpdateListener(signalEventMatcher,
						signalEventListener);

				return true;
			}

		};

	}
}
