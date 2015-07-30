package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.Messages;

public class NoMappedNameFoundException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String internalClassName;

	public NoMappedNameFoundException(String internalClassName) {
		this.internalClassName = internalClassName;
	}

	@Override
	public String toString() {
		return Messages.NO_MAPPED_NAME_FOUND.getMsg(internalClassName);
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
