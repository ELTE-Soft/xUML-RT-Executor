package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.Messages;

public class MissingJavaCompilerException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return Messages.MISSING_JAVA_COMPILER.getMsg();
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
