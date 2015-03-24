package hu.eltesoft.modelexecution.m2m.logic.tasks;

import java.util.LinkedList;

/**
 * A queue of {@link FileUpdateTask} instances.
 * 
 * @author Gábor Ferenc Kovács
 *
 */
@SuppressWarnings("serial")
public class FileUpdateTaskQueue extends LinkedList<FileUpdateTask> implements
		FileUpdateTaskCollection {

}
