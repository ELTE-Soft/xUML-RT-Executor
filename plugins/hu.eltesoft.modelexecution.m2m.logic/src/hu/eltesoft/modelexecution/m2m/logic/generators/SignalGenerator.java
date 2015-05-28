package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplate;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher;

import java.util.function.Consumer;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.xtext.xbase.lib.Pair;

public class SignalGenerator extends AbstractGenerator<Signal> {

	private static final SignalFactory FACTORY = SignalFactory.eINSTANCE;

	private final SignalMatcher signalMatcher;

	public SignalGenerator(IncQueryEngine engine) throws IncQueryException {
		signalMatcher = SignalMatcher.on(engine);
	}

	@Override
	public Pair<String, Template> getTemplate(Signal source)
			throws GenerationException {
		SgSignal root = FACTORY.createSgSignal();

		check(signalMatcher.forOneArbitraryMatch(source, match -> {
			Signal pSignal = match.getSignal();
			root.setReference(new NamedReference(pSignal));
		}));

		String rootName = NamedReference.getIdentifier(source);
		return new Pair<>(rootName, new SignalTemplate(root));
	}

	@Override
	public void runOn(Consumer<Signal> task) {
		signalMatcher.forEachMatch((Signal) null,
				match -> task.accept(match.getSignal()));
	}

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<SignalMatch> signalListener;

			{
				signalMatcher.forEachMatch((Signal) null,
						match -> saveRootName(match.getSignal()));

				signalListener = new IMatchUpdateListener<SignalMatch>() {
					@Override
					public void notifyAppearance(SignalMatch match) {
						Signal signal = match.getSignal();
						saveRootName(signal);
						changeRegistry.newModification(signal,
								SignalGenerator.this);
					}

					@Override
					public void notifyDisappearance(SignalMatch match) {
						Signal signal = match.getSignal();
						consumeRootName(signal, changeRegistry::newDeletion);
					}
				};
				advancedEngine.addMatchUpdateListener(signalMatcher,
						signalListener, false);
			}

			@Override
			public boolean revert() {
				advancedEngine.removeMatchUpdateListener(signalMatcher,
						signalListener);
				return true;
			}
		};
	}
}
