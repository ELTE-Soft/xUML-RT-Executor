package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;

public abstract class AbstractGenerator<S extends EObject> implements
		Generator<S> {

	/**
	 * A mapping between EObject instances and their EObject id. It is a subset
	 * inverse of ResourceImpl#intrinsicIDToEObjectMap, with extended lifetime.
	 */
	private final Map<EObject, String> instanceToRootName = new HashMap<>();

	@Override
	public void saveRootName(S root) {

		instanceToRootName.put(root, NamedReference.getIdentifier(root));
	}

	@Override
	public void consumeRootName(S root, Consumer<String> task) {
		String rootName = instanceToRootName.get(root);
		if (null != rootName) {
			task.accept(rootName);
			instanceToRootName.remove(root);
		}
	}

	protected void check(boolean success) throws GenerationException {
		if (!success) {
			throw new GenerationException();
		}
	}
}
