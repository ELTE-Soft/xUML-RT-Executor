package hu.eltesoft.modelexecution.m2m.logic.changeregistry;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.ContainerNameProvider;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;
import hu.eltesoft.modelexecution.m2m.logic.impl.ChangeRegistryImpl;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.ecore.EObject;

/**
 * A change registry to record changes in the model and perform them later.
 */
public interface ChangeRegistry extends ContainerNameProvider {

	/**
	 * Creates a new registry.
	 */
	static ChangeRegistry create(TextChangesListener listener) {
		return new ChangeRegistryImpl(listener);
	}

	/**
	 * Registers a new modification. If another modification entry is already
	 * present with the same source object, that entry is overwritten.
	 */
	<S extends EObject, R extends ModelRoot> void newModification(S source,
			Generator<S, R> generator);

	/**
	 * Registers a new deletion. If another deletion entry is already present
	 * with the same <code>rootName</code>, that entry is overwritten.
	 */
	void newDeletion(String rootName);

	/**
	 * Performs the previously registered changes and clears this registry.
	 * 
	 * @return a queue of required file update tasks
	 */
	FileUpdateTaskQueue performAllChanges();
	
	
	/**
	 * Clears this registry.
	 */
	void clear();

	/**
	 * Sets the fully qualified root name which should be returned by the
	 * {@link ChangeRegistry#getFilename(EObject) getFilename} method for
	 * <code>modelElement</code>.
	 */
	void setContainerName(EObject modelElement, String rootName);

	@Override
	String getContainerName(EObject modelElement);
}
