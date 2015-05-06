package hu.eltesoft.modelexecution.m2m.logic.tasks;

import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTask;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;

/**
 * An implementation of {@link FileUpdateTask} which performs the deletion of a
 * single file.
 */
public class FileDeletionTask implements FileUpdateTask {

	private final String filename;
	private final TextChangesListener listener;

	public FileDeletionTask(String filename, TextChangesListener listener) {
		this.filename = filename;
		this.listener = listener;
	}

	@Override
	public void perform() {
		listener.contentDeleted(filename);
	}

	@Override
	public int hashCode() {
		return (filename == null) ? 0 : filename.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileDeletionTask other = (FileDeletionTask) obj;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		return true;
	}

}
