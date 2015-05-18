package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplate;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalProcessor;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;

public class SignalGenerator extends AbstractGenerator<Signal, SgSignal> {

	private static final SignalFactory FACTORY = SignalFactory.eINSTANCE;

	private final SignalMatcher signalMatcher;

	public SignalGenerator(IncQueryEngine engine, TextChangesListener listener)
			throws IncQueryException {
		super(listener);
		signalMatcher = SignalMatcher.on(engine);
	}

	// generate translation model

	@Override
	public SgSignal generateTranslationModel(Signal source)
			throws GenerationException {

		// new SgSignal
		SgSignal root = FACTORY.createSgSignal();

		// name
		check(signalMatcher.forOneArbitraryMatch(source, null,
				getPorcessorToSetNameOfRoot(root)));

		return root;
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

	// generate text

	@Override
	public void generateText(SgSignal root) {
		SignalTemplate template = new SignalTemplate(root);

		SourceMappedText output = template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		textChangesListener.contentChanged(root.getName(), output, symbols);
	}

	// add match update listeners

	@Override
	public ReversionTask addMatchUpdateListeners(AdvancedIncQueryEngine advancedEngine,
			ChangeRegistry changeRegistry) {

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

					advancedEngine.addMatchUpdateListener(signalMatcher, signalListener, false);
			}

			@Override
			public boolean revert() {
				
				advancedEngine.removeMatchUpdateListener(signalMatcher, signalListener);
				
				return true;
			}

		};
		
	}

}
