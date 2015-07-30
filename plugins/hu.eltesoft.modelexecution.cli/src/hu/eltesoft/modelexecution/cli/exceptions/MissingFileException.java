package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.Messages;

public class MissingFileException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String filename;

	public MissingFileException(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return Messages.MISSING_FILE.getMsg(filename);
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
