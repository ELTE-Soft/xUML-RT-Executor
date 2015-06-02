package hu.eltesoft.modelexecution.m2m.logic.tasks;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTask;
import hu.eltesoft.modelexecution.m2m.logic.generators.GenerationException;
import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * A collection of {@link ModelGenerationTask} instances.
 */
public interface ModelGenerationTaskCollection extends
		Collection<ModelGenerationTask<?>> {

	default List<FileUpdateTask> performAll() {
		return new LinkedList<FileUpdateTask>();
	}

	default List<FileUpdateTask> performAll(List<FileUpdateTask> result) {
		forEach(task -> {
			try {
				result.add(task.perform());
			} catch (GenerationException ex) {
				// generation failed, current task is omitted
			}
		});
		return result;
	}

	default <S extends EObject> boolean addNew(S source, Generator<S> generator) {
		return add(new ModelGenerationTask<S>(source, generator));
	}
}
