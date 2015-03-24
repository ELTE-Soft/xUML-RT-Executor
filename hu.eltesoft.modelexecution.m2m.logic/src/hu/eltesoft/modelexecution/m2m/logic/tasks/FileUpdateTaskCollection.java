package hu.eltesoft.modelexecution.m2m.logic.tasks;

import java.util.Collection;

/**
 * A collection of {@link FileUpdateTask} instances.
 * 
 * @author Gábor Ferenc Kovács
 *
 */
public interface FileUpdateTaskCollection extends Collection<FileUpdateTask> {

	/**
	 * Iterates through the {@link FileUpdateTask} instances contained in this
	 * collection and calls the <code>perform</code> method on all of them.
	 */
	default void performAll() {
		forEach(task -> task.perform());
	}

}
