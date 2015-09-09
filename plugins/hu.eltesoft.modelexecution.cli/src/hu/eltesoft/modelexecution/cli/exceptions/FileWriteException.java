package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.Messages;

public class FileWriteException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String filename;

	public FileWriteException(String filename) {
		super();
		this.filename = filename;
	}

	@Override
	public String toString() {
		return Messages.CANNOT_WRITE_FILE.getMsg(filename);
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
