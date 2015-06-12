package hu.eltesoft.modelexecution.m2m.logic.registry;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;

/**
 * Stores identifiers for EObjects. When an EObject destroyed, it gets unlinked
 * from the underlying Resource object. As a side effect the object looses its
 * identifier before the notification of removal has been dispatched. This class
 * helps to store the identifier, then use it in the object remove event handler
 * code.
 */
public class RootNameStorage {

	/**
	 * A mapping between EObject instances and their EObject id. It is a subset
	 * inverse of ResourceImpl#intrinsicIDToEObjectMap, with extended lifetime.
	 */
	private final Map<EObject, String> instanceToRootName = new ConcurrentHashMap<>();

	/**
	 * Saves the EObject identifier of the specified root UML element. This is
	 * needed to be able to reconstruct the identifier after an object is
	 * destroyed and removed from its resource. When the object is already
	 * destroyed, the identifier will not be saved.
	 */
	public void saveRootName(EObject root) {
		if (null == root.eResource()) {
			return;
		}
		instanceToRootName.put(root, NamedReference.getIdentifier(root));
	}

	/**
	 * Gets the root name of the given EObject instance, even after the
	 * connection with its Resource is lost. The entry is erased after the
	 * method call. It is recommended to call this method at least once for
	 * every saved object as the mapping will hold a reference to the EObject.
	 */
	public void consumeRootName(EObject root, Consumer<String> task) {
		String rootName = instanceToRootName.remove(root);
		if (null != rootName) {
			task.accept(rootName);
		}
	}

	public void clear() {
		instanceToRootName.clear();
	}
}
