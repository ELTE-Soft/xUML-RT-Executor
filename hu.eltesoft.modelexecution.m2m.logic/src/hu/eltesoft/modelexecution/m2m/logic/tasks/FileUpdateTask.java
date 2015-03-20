package hu.eltesoft.modelexecution.m2m.logic.tasks;

/**
 * A task to update a single file in the textual representation of the model. An
 * update is either a modification or a deletion.
 * <p>
 * When created, this object already has all the required information to perform
 * the task. It has no references on the original EMF-UML2 model.
 * <p>
 * In case of modification, this task generates the new contents of the file.
 * <p>
 * This task does not perform any i/o actions, rather reports about the changes
 * to a {@link TextChangesListener}.
 * 
 * @author Kovács Gábor Ferenc
 *
 */
public interface FileUpdateTask {

	/**
	 * Performs the update this task was created for.
	 */
	void perform();

}
