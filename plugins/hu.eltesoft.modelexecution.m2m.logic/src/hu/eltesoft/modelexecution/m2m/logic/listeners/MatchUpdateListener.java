package hu.eltesoft.modelexecution.m2m.logic.listeners;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;

import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IPatternMatch;

/**
 * Update listener applied by generators to keep the change registry in sync
 * using query notification listeners. As it indicates a modification even in
 * case of object removals, this class is intended to use with non-m2m-root
 * model elements.
 */
public class MatchUpdateListener<M extends IPatternMatch, S extends EObject>
		implements IMatchUpdateListener<M> {

	protected final Generator<S> generator;
	protected final ChangeRegistry changeRegistry;
	protected final Function<M, S> selector;

	public MatchUpdateListener(Generator<S> generator,
			ChangeRegistry changeRegistry, Function<M, S> selector) {
		this.generator = generator;
		this.changeRegistry = changeRegistry;
		this.selector = selector;
	}

	@Override
	public void notifyAppearance(M match) {
		changeRegistry.newModification(selector.apply(match), generator);
	}

	@Override
	public void notifyDisappearance(M match) {
		changeRegistry.newModification(selector.apply(match), generator);
	}
}
