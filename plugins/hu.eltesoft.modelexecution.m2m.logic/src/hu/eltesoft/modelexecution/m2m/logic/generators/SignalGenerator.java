package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplate;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;

public class SignalGenerator extends
		AbstractGenerator<Signal, SgSignal, SignalTemplate> {

	private static final SignalFactory FACTORY = SignalFactory.eINSTANCE;

	private final SignalMatcher signalMatcher;

	public SignalGenerator(IncQueryEngine engine, TextChangesListener listener)
			throws IncQueryException {
		super(listener);
		signalMatcher = SignalMatcher.on(engine);
	}

	@Override
	public SgSignal generateTranslationModel(Signal source)
			throws GenerationException {
		SgSignal root = FACTORY.createSgSignal();

		check(signalMatcher.forOneArbitraryMatch(source, match -> {
			Signal pSignal = match.getSignal();
			root.setReference(new NamedReference(pSignal));
		}));

		return root;
	}

	@Override
	protected SignalTemplate createTemplate(SgSignal root) {
		return new SignalTemplate(root);
	}

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<SignalMatch> signalListener;

			{
				signalListener = new IMatchUpdateListener<SignalMatch>() {

					@Override
					public void notifyAppearance(SignalMatch match) {
						changeRegistry.newModification(match.getSignal(),
								SignalGenerator.this);
					}

					@Override
					public void notifyDisappearance(SignalMatch match) {
						// disappearance of root: delete file
						Signal signal = match.getSignal();
						String fileName = NamedReference.getIdentifier(signal);
						changeRegistry.newDeletion(fileName);
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
