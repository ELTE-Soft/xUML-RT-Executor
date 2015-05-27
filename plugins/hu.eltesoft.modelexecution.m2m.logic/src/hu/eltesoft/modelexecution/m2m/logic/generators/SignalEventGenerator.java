package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EventFactory;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalEventTemplate;
import hu.eltesoft.modelexecution.uml.incquery.EventMatch;
import hu.eltesoft.modelexecution.uml.incquery.EventMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.EventProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalEventProcessor;

import java.util.function.Consumer;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.xtext.xbase.lib.Pair;

public class SignalEventGenerator extends AbstractGenerator<SignalEvent> {

	private static final EventFactory FACTORY = EventFactory.eINSTANCE;

	private final EventMatcher eventMatcher;
	private final SignalEventMatcher signalEventMatcher;

	public SignalEventGenerator(IncQueryEngine engine) throws IncQueryException {
		eventMatcher = EventMatcher.on(engine);
		signalEventMatcher = SignalEventMatcher.on(engine);
	}

	// generate translation model

	@Override
	public Pair<String, Template> getTemplate(SignalEvent source)
			throws GenerationException {
		// new EvSignalEvent
		EvSignalEvent root = FACTORY.createEvSignalEvent();

		// name, signal
		check(eventMatcher.forOneArbitraryMatch(source, null,
				getProcessorToSetNameAndSignalOfRoot(root)));

		return new Pair<>(root.getName(), new SignalEventTemplate(root));
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

	// run query directly

	public void runOn(Consumer<SignalEvent> task) {
		signalEventMatcher.forEachMatch(null, null,
				match -> task.accept(match.getEvent()));
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
