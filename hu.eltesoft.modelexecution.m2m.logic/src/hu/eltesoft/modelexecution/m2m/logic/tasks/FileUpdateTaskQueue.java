package hu.eltesoft.modelexecution.m2m.logic.tasks;

/**
 * A queue of {@link FileUpdateTask} instances.
 * 
 * @author Kovács Gábor Ferenc
 *
 */
public interface FileUpdateTaskQueue {

	/**
	 * Iterates through the {@link FileUpdateTask} instances contained in this
	 * queue and calls the <code>update</code> method on all of them.
	 */
	void updateAll();

}
