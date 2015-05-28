package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EvSignalEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.event.EventFactory;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalEventTemplate;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatcher;

import java.util.function.Consumer;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.xtext.xbase.lib.Pair;

public class SignalEventGenerator extends AbstractGenerator<SignalEvent> {

	private static final EventFactory FACTORY = EventFactory.eINSTANCE;

	private final SignalEventMatcher signalEventMatcher;

	public SignalEventGenerator(IncQueryEngine engine) throws IncQueryException {
		signalEventMatcher = SignalEventMatcher.on(engine);
	}

	@Override
	public Pair<String, Template> getTemplate(SignalEvent source)
			throws GenerationException {
		EvSignalEvent root = FACTORY.createEvSignalEvent();

		check(signalEventMatcher.forOneArbitraryMatch(source, null, match -> {
			SignalEvent pEvent = match.getEvent();
			root.setReference(new NamedReference(pEvent));
			Signal pSignal = match.getSignal();
			root.setSignal(new NamedReference(pSignal));
		}));

		String rootName = NamedReference.getIdentifier(source);
		return new Pair<>(rootName, new SignalEventTemplate(root));
	}

	@Override
	public void runOn(Consumer<SignalEvent> task) {
		signalEventMatcher.forEachMatch(null, null,
				match -> task.accept(match.getEvent()));
	}

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<SignalEventMatch> signalEventListener;

			{
				signalEventMatcher.forEachMatch(null, null,
						match -> saveRootName(match.getEvent()));

				signalEventListener = new IMatchUpdateListener<SignalEventMatch>() {

					@Override
					public void notifyAppearance(SignalEventMatch match) {
						SignalEvent event = match.getEvent();
						saveRootName(event);
						changeRegistry.newModification(event,
								SignalEventGenerator.this);
					}

					@Override
					public void notifyDisappearance(SignalEventMatch match) {
						SignalEvent event = match.getEvent();
						consumeRootName(event, changeRegistry::newDeletion);
					}
				};

				advancedEngine.addMatchUpdateListener(signalEventMatcher,
						signalEventListener, false);
			}

			@Override
			public boolean revert() {
				advancedEngine.removeMatchUpdateListener(signalEventMatcher,
						signalEventListener);
				return true;
			}
		};
	}
}
