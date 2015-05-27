package hu.eltesoft.modelexecution.m2m.logic.impl;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTask;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileDeletionTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileUpdateTaskSet;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ModelGenerationTaskSet;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EObject;

/**
 * Default implementation for the {@link ChangeRegistry} interface.
 */
public class ChangeRegistryImpl implements ChangeRegistry {

	private final ModelGenerationTaskSet modifications = new ModelGenerationTaskSet();
	private final FileUpdateTaskSet deletions = new FileUpdateTaskSet();
	private final Map<EObject, String> qualifiedNameMap = Collections
			.synchronizedMap(new WeakHashMap<>());

	@Override
	public <S extends EObject, R extends ModelRoot> void newModification(
			S source, Generator<S> generator) {

		modifications.addNew(source, generator);
	}

	@Override
	public void newDeletion(String filename) {
		deletions.add(new FileDeletionTask(filename));
	}

	@Override
	public List<FileUpdateTask> performAllChanges() {
		List<FileUpdateTask> taskQueue = deletions.asQueue();

		modifications.performAll(taskQueue);

		clear();

		return taskQueue;
	}

	@Override
	public void clear() {
		deletions.clear();
		modifications.clear();
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
