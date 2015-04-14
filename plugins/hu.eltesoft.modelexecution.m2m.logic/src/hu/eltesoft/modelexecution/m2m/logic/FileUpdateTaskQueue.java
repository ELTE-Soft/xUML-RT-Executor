package hu.eltesoft.modelexecution.m2m.logic;

import java.util.LinkedList;

/**
 * A queue of {@link FileUpdateTask} instances.
 */
@SuppressWarnings("serial")
public class FileUpdateTaskQueue extends LinkedList<FileUpdateTask> {

	/**
	 * Iterates through the {@link FileUpdateTask} instances contained in this
	 * collection and calls the <code>perform</code> method on all of them.
	 */
	public void performAll() {
		forEach(task -> task.perform());
	}
	
}
