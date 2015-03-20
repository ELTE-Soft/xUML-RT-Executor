package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BhBehavior;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.templates.BehaviorTemplate;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;

public class BehaviorGenerator extends AbstractGenerator<Behavior, BhBehavior> {

	public BehaviorGenerator(IncQueryEngine engine, TextChangesListener listener) throws IncQueryException {
		super(listener);
	}

	@Override
	public BhBehavior generateTranslationModel(Behavior source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateText(BhBehavior root) {
		BehaviorTemplate template = new BehaviorTemplate(root);

		SourceMappedText output = (SourceMappedText) template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		listener.contentChanged(root.getName(), output, symbols);
	}

	@Override
	public BhBehavior generateModelRoot(Behavior source) {
		// TODO Auto-generated method stub
		return null;
	}

}
