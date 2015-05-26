package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EventFactory;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalEventTemplate;
import hu.eltesoft.modelexecution.uml.incquery.EventMatch;
import hu.eltesoft.modelexecution.uml.incquery.EventMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatcher;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;

public class SignalEventGenerator extends
		AbstractGenerator<SignalEvent, EvSignalEvent, SignalEventTemplate> {

	private static final EventFactory FACTORY = EventFactory.eINSTANCE;

	private final EventMatcher eventMatcher;
	private final SignalEventMatcher signalEventMatcher;

	public SignalEventGenerator(IncQueryEngine engine,
			TextChangesListener listener) throws IncQueryException {
		super(listener);
		eventMatcher = EventMatcher.on(engine);
		signalEventMatcher = SignalEventMatcher.on(engine);
	}

	@Override
	public EvSignalEvent generateTranslationModel(SignalEvent source)
			throws GenerationException {
		EvSignalEvent root = FACTORY.createEvSignalEvent();

		check(eventMatcher.forOneArbitraryMatch(source, eventMatch -> {
			SignalEvent pEvent = eventMatch.getEvent();
			root.setReference(new NamedReference(pEvent));

			check(signalEventMatcher.forOneArbitraryMatch(pEvent, null,
					signalMatch -> {
						Signal pSignal = signalMatch.getSignal();
						root.setSignal(new NamedReference(pSignal));
					}));
		}));

		return root;
	}

	@Override
	protected SignalEventTemplate createTemplate(EvSignalEvent root) {
		return new SignalEventTemplate(root);
	};

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<EventMatch> eventListener;
			private final IMatchUpdateListener<SignalEventMatch> signalEventListener;

			{
				eventListener = new IMatchUpdateListener<EventMatch>() {

					@Override
					public void notifyAppearance(EventMatch match) {
						changeRegistry.newModification(match.getEvent(),
								SignalEventGenerator.this);
					}

					@Override
					public void notifyDisappearance(EventMatch match) {
						// disappearance of root: delete file
						SignalEvent event = match.getEvent();
						String fileName = NamedReference.getIdentifier(event);
						changeRegistry.newDeletion(fileName);
					}
				};

				advancedEngine.addMatchUpdateListener(eventMatcher,
						eventListener, false);
			}

			{
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
