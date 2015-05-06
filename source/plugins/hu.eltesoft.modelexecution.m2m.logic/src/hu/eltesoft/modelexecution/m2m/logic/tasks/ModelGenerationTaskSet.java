package hu.eltesoft.modelexecution.m2m.logic.tasks;

import java.util.LinkedHashSet;

/**
 * A set of {@link ModelGenerationTask} instances, which keeps the original
 * iteration order of its elements but never lets the addition of two objects
 * which are equal.
 */
@SuppressWarnings("serial")
public class ModelGenerationTaskSet extends
		LinkedHashSet<ModelGenerationTask<?, ?>> implements
		ModelGenerationTaskCollection {

	public ModelGenerationTaskQueue asQueue() {
		ModelGenerationTaskQueue taskQueue = new ModelGenerationTaskQueue();
		taskQueue.addAll(this);
		return taskQueue;
	}

}
