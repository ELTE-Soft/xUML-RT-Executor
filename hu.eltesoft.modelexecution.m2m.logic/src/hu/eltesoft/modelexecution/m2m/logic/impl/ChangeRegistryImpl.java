package hu.eltesoft.modelexecution.m2m.logic.impl;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileDeletionTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileUpdateTaskSet;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ModelGenerationTaskSet;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import org.eclipse.emf.ecore.EObject;

/**
 * Default implementation for the {@link ChangeRegistry} interface.
 * 
 * @author Gábor Ferenc Kovács
 *
 */
public class ChangeRegistryImpl implements ChangeRegistry {

	private final TextChangesListener listener;
	private final ModelGenerationTaskSet modifications;
	private final FileUpdateTaskSet deletions;

	public ChangeRegistryImpl(TextChangesListener listener) {
		this.listener = listener;
		this.modifications = new ModelGenerationTaskSet();
		this.deletions = new FileUpdateTaskSet();
	}

	@Override
	public <S extends EObject, R extends ModelRoot> void newModification(
			S source, Generator<S, R> generator) {

		modifications.addNew(source, generator);
	}

	@Override
	public void newDeletion(String filename) {
		deletions.add(new FileDeletionTask(filename, listener));
	}

	@Override
	public FileUpdateTaskQueue performAllChanges() {
		FileUpdateTaskQueue taskQueue = deletions.asQueue();
		deletions.clear();

		modifications.performAll(taskQueue);
		modifications.clear();

		return taskQueue;
	}

}
