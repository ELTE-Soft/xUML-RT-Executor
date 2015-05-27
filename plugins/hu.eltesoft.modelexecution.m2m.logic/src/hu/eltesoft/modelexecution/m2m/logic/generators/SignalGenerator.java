package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplate;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalProcessor;

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

	// generate translation model

	@Override
	public Pair<String, Template> getTemplate(Signal source)
			throws GenerationException {

		// new SgSignal
		SgSignal root = FACTORY.createSgSignal();

		// name
		check(signalMatcher.forOneArbitraryMatch(source, null,
				getPorcessorToSetNameOfRoot(root)));

		return new Pair<>(root.getName(), new SignalTemplate(root));
	}

	private SignalProcessor getPorcessorToSetNameOfRoot(SgSignal root) {
		return new SignalProcessor() {

			@Override
			public void process(Signal pSignal, String pSignalName) {
				// name
				root.setName(pSignalName);
			}

		};
	}

	// run query directly

	public void runOn(Consumer<Signal> task) {
		signalMatcher.forEachMatch(null, null,
				match -> task.accept(match.getSignal()));
	}

	// add match update listeners

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<SignalMatch> signalListener;

			{ // set signalListener
				signalListener = new IMatchUpdateListener<SignalMatch>() {

					@Override
					public void notifyAppearance(SignalMatch match) {
						changeRegistry.newModification(match.getSignal(),
								SignalGenerator.this);
					}

					@Override
					public void notifyDisappearance(SignalMatch match) {
						// disappearance of root: delete file
						changeRegistry.newDeletion(match.getSignalName());
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
