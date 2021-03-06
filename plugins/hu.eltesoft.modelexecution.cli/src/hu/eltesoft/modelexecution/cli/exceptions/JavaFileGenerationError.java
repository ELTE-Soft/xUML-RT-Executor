package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.Messages;

public class JavaFileGenerationError extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return Messages.FAILURE_WHILE_GENERATING_JAVA_FILES.getMsg();
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
