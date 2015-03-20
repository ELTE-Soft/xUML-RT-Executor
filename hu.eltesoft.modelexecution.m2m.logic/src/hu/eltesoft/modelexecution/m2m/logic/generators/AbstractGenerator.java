package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.ecore.EObject;

public abstract class AbstractGenerator<S extends EObject, R extends ModelRoot> implements IGenerator<S, R> {

	protected final TextChangesListener listener;

	public AbstractGenerator(TextChangesListener listener) {
		this.listener = listener;
	}

	@Override
	public abstract R generateTranslationModel(S source);

	@Override
	public abstract void generateText(R root);

	@Override
	public void deleteText(R root) {
		listener.contentDeleted(root.getName());
	}

}
