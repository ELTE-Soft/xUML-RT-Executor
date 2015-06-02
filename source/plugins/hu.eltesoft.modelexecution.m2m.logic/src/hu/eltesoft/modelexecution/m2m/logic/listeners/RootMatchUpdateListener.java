package hu.eltesoft.modelexecution.m2m.logic.listeners;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;

import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IPatternMatch;

/**
 * A match update listener which is intended to be used with root m2m model
 * elements. Every object disappearance will indicate a delete operation in the
 * change registry.
 */
public class RootMatchUpdateListener<M extends IPatternMatch, S extends EObject>
		extends MatchUpdateListener<M, S> {

	public RootMatchUpdateListener(Generator<S> generator,
			ChangeRegistry changeRegistry, Function<M, S> selector) {
		super(generator, changeRegistry, selector);
	}

	@Override
	public void notifyAppearance(M match) {
		S root = selector.apply(match);
		generator.saveRootName(root);
		changeRegistry.newModification(root, generator);
	}

	@Override
	public void notifyDisappearance(M match) {
		S root = selector.apply(match);
		generator.consumeRootName(root, changeRegistry::newDeletion);
	}
}
