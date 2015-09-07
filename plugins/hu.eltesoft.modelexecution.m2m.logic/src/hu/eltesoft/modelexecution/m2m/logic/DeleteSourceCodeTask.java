package hu.eltesoft.modelexecution.m2m.logic;

/**
 * An implementation of {@link SourceCodeTask} which performs the deletion of a
 * single file.
 */
public class DeleteSourceCodeTask implements SourceCodeTask {

	private final String rootName;

	public DeleteSourceCodeTask(String rootName) {
		this.rootName = rootName;
	}

	@Override
	public void perform(SourceCodeChangeListener listener) {
		listener.sourceCodeDeleted(rootName);
	}

	@Override
	public String toString() {
		return super.toString() + "( rootName: " + rootName + ")";
	}
}
