package hu.eltesoft.modelexecution.m2m.logic.tasks;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.generators.GenerationException;
import hu.eltesoft.modelexecution.m2m.logic.generators.Generator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * A collection of {@link ModelGenerationTask} instances.
 */
public interface ModelGenerationTaskCollection extends
		Collection<ModelGenerationTask<?, ?>> {

	default FileUpdateTaskQueue performAll() {
		return performAll(new FileUpdateTaskQueue());
	}

	default FileUpdateTaskQueue performAll(FileUpdateTaskQueue result) {
		forEach(task -> {
			try {
				result.add(task.perform());
			} catch (GenerationException ex) {
				// generation failed, current task is omitted
			}
		});
		return result;
	}

	default <S extends EObject, R extends ModelRoot> boolean addNew(S source,
			Generator<S, R> generator) {

		return add(new ModelGenerationTask<S, R>(source, generator));
	}

}
