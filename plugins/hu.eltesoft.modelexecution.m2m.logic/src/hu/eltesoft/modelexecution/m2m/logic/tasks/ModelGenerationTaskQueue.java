package hu.eltesoft.modelexecution.m2m.logic.tasks;

import java.util.LinkedList;

/**
 * A queue of {@link ModelGenerationTask} instances.
 */
@SuppressWarnings("serial")
public class ModelGenerationTaskQueue extends
		LinkedList<ModelGenerationTask<?, ?>> implements
		ModelGenerationTaskCollection {

}
