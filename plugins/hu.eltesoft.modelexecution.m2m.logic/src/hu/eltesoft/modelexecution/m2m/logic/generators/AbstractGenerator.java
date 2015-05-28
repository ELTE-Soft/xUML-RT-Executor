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

	protected void saveRootName(EObject object) {

		instanceToRootName.put(object, NamedReference.getIdentifier(object));
	}

	protected String takeRootName(EObject object) {
		return instanceToRootName.get(object);
	}

	/**
	 * Gets the root name of the given EObject instance, even after the
	 * connection with the Resource is lost. The entry is erased after the
	 * method call.
	 */
	protected void consumeRootName(EObject object, Consumer<String> task) {
		String rootName = instanceToRootName.get(object);
		if (null != rootName) {
			task.accept(rootName);
			instanceToRootName.remove(object);
		}
	}

	protected void check(boolean success) throws GenerationException {
		if (!success) {
			throw new GenerationException();
		}
	}
}
