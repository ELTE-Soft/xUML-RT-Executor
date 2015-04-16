package hu.eltesoft.modelexecution.m2m.logic.impl;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileDeletionTask;
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
	private final ModelGenerationTaskSet modifications = new ModelGenerationTaskSet();
	private final FileUpdateTaskSet deletions = new FileUpdateTaskSet();
	private final Map<EObject, String> qualifiedNameMap = Collections
			.synchronizedMap(new WeakHashMap<>());

	public ChangeRegistryImpl(TextChangesListener listener) {
		this.listener = listener;
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

	@Override
	public void setContainerName(EObject modelElement, String rootName) {
		qualifiedNameMap.put(modelElement, rootName);
	}

	@Override
	public String getContainerName(EObject modelElement) {
		return qualifiedNameMap.get(modelElement);
	}

}
