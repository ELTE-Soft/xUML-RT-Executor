package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SgSignal;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.templates.SignalTemplate;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalProcessor;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;

public class SignalGenerator extends AbstractGenerator<Signal, SgSignal> {

	private static final SignalFactory FACTORY = SignalFactory.eINSTANCE;

	private final SignalMatcher signalMatcher;

	public SignalGenerator(IncQueryEngine engine, TextChangesListener listener) throws IncQueryException {
		super(listener);
		signalMatcher = SignalMatcher.on(engine);
	}

	@Override
	public SgSignal generateTranslationModel(Signal source) {
		// new SgSignal
		SgSignal root = FACTORY.createSgSignal();

		// name
		signalMatcher.forOneArbitraryMatch(source, null, getPorcessorToSetNameOfRoot(root));

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

	@Override
	public void generateText(SgSignal root) {
		SignalTemplate template = new SignalTemplate(root);

		SourceMappedText output = (SourceMappedText) template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		listener.contentChanged(root.getName(), output, symbols);
	}

	@Override
	public SgSignal generateModelRoot(Signal source) {
		// TODO Auto-generated method stub
		return null;
	}
}
