package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @author Gábor Ferenc Kovács
 *
 */
public abstract class AbstractGenerator<S extends EObject, R extends ModelRoot>
		implements Generator<S, R> {

	protected final TextChangesListener listener;

	public AbstractGenerator(TextChangesListener listener) {
		this.listener = listener;
	}

	protected void check(boolean success) throws GenerationException {
		if (!success) {
			throw new GenerationException();
		}
	}

}
