package hu.eltesoft.modelexecution.m2m.logic.generators;

import org.eclipse.emf.ecore.EObject;

public abstract class AbstractGenerator<S extends EObject> implements
		Generator<S> {

	protected void check(boolean success) throws GenerationException {
		if (!success) {
			throw new GenerationException();
		}
	}
}
