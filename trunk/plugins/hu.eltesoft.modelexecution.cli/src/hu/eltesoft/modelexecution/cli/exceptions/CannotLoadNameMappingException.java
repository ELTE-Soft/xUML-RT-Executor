package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.Messages;

public class CannotLoadNameMappingException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String mappingFilename;

	public CannotLoadNameMappingException(String mappingFilename) {
		this.mappingFilename = mappingFilename;
	}

	@Override
	public String toString() {
		return Messages.MODEL_LOAD_FAILED.getMsg(mappingFilename);
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
