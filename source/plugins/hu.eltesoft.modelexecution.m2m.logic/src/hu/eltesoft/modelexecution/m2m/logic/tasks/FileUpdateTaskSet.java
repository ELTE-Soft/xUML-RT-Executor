package hu.eltesoft.modelexecution.m2m.logic.tasks;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTask;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * A set of {@link FileUpdateTask} instances, which keeps the original iteration
 * order of its elements but never lets the addition of two objects which are
 * equal.
 */
@SuppressWarnings("serial")
public class FileUpdateTaskSet extends LinkedHashSet<FileUpdateTask> {

	public List<FileUpdateTask> asQueue() {
		List<FileUpdateTask> taskQueue = new LinkedList<FileUpdateTask>();
		taskQueue.addAll(this);
		return taskQueue;
	}

}
