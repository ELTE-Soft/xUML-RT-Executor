package hu.eltesoft.modelexecution.m2m.logic.changeregistry;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTask;
import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileDeletionTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileUpdateTaskSet;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ModelGenerationTaskSet;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * A change registry to record changes in the model and perform them later.
 */
public class ChangeRegistry {

	private final ModelGenerationTaskSet modifications = new ModelGenerationTaskSet();
	private final FileUpdateTaskSet deletions = new FileUpdateTaskSet();

	/**
	 * Registers a new modification. If another modification entry is already
	 * present with the same source object, that entry is overwritten.
	 */
	public <S extends EObject> void newModification(S source,
			Generator<S> generator) {

		modifications.addNew(source, generator);
	}

	/**
	 * Registers a new deletion. If another deletion entry is already present
	 * with the same <code>rootName</code>, that entry is overwritten.
	 */
	public void newDeletion(String filename) {
		deletions.add(new FileDeletionTask(filename));
	}

	/**
	 * Performs the previously registered changes and clears this registry.
	 * 
	 * @return a queue of required file update tasks
	 */
	public List<FileUpdateTask> performAllChanges() {
		List<FileUpdateTask> taskQueue = deletions.asQueue();
		modifications.performAll(taskQueue);
		clear();
		return taskQueue;
	}

	/**
	 * Clears this registry.
	 */
	public void clear() {
		deletions.clear();
		modifications.clear();
	}
}
