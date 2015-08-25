package hu.eltesoft.modelexecution.m2m.logic.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;

/**
 * Stores root names for EObjects. When an EObject destroyed, it gets unlinked
 * from the underlying Resource object. As a side effect the object looses its
 * identifier before the notification of removal has been dispatched. This class
 * helps to store the root name, then use it in the object remove event handler
 * code.
 * 
 * The root name of an EObject is not necessarily its EObject identifier, but
 * rather an arbitrary text which is assigned by a translator and could be a
 * part of a file name on all supported platforms.
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
	public void saveRootName(EObject root, String rootName) {
		if (null == rootName) {
			return;
		}
		instanceToRootName.put(root, rootName);
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

}
