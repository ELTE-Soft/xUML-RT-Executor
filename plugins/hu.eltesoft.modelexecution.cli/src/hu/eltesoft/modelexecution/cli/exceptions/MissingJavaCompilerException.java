package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Message;

public class MissingJavaCompilerException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return Message.MISSING_JAVA_COMPILER.getMsg();
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}

}
