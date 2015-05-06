package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Message;

public class RootDirCreationFailed extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	private String rootDirName;

	public RootDirCreationFailed(String rootDirName) {
		this.rootDirName = rootDirName;
	}

	@Override
	public String toString() {
		return Message.ROOT_DIR_CREATION_FAILED.getMsg(rootDirName);
	}
	
	@Override
	public String getLocalizedMessage() {
		return toString();
	}

}
