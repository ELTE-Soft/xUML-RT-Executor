package hu.eltesoft.modelexecution.m2m.logic;

/**
 * A task to update a single file in the textual representation of the model. An
 * update is either a modification or a deletion.
 * <p>
 * When created, this object already has all the required information to perform
 * the task. It has no references on the source model.
 * <p>
 * In case of modification, this task generates the new contents of the file.
 * <p>
 * This task does not perform any I/O actions, rather reports about the changes
 * to a {@link SourceCodeChangeListener}.
 * 
 * @see DeleteSourceCodeTask
 * @see UpdateSourceCodeTask
 */
public interface SourceCodeTask {

	/**
	 * Performs the update this task was created for.
	 */
	void perform(SourceCodeChangeListener listener);
}
