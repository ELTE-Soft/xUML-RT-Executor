package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2m.logic.tasks.FileDeletionTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileModificationTask;

/**
 * A task to update a single file in the textual representation of the model. An
 * update is either a modification or a deletion.
 * <p>
 * When created, this object already has all the required information to perform
 * the task. It has no references on the source model.
 * <p>
 * In case of modification, this task generates the new contents of the file.
 * <p>
 * This task does not perform any i/o actions, rather reports about the changes
 * to a {@link TextChangesListener}.
 * 
 * @see FileDeletionTask
 * @see FileModificationTask
 */
public interface FileUpdateTask {

	/**
	 * Performs the update this task was created for.
	 */
	void perform(TextChangesListener listener);

	@Override
	int hashCode();

	@Override
	boolean equals(Object obj);

}
