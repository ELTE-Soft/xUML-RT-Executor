package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.Messages;

public class CliJavaCompilerException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return Messages.JAVA_COMPILER_FAILURE.getMsg();
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
