package hu.eltesoft.modelexecution.m2m.logic.tasks;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTask;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;

import java.util.LinkedHashSet;

/**
 * A set of {@link FileUpdateTask} instances, which keeps the original iteration
 * order of its elements but never lets the addition of two objects which are
 * equal.
 */
@SuppressWarnings("serial")
public class FileUpdateTaskSet extends LinkedHashSet<FileUpdateTask> {

	public FileUpdateTaskQueue asQueue() {
		FileUpdateTaskQueue taskQueue = new FileUpdateTaskQueue();
		taskQueue.addAll(this);
		return taskQueue;
	}

}
