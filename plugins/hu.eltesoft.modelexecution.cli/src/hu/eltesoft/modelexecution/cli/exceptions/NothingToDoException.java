package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner;
import hu.eltesoft.modelexecution.cli.Messages;
import hu.eltesoft.modelexecution.cli.Utils;

public class NothingToDoException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return Messages.MISSING_ACTION_OPTIONS.getMsg() + Utils.join(ConsoleModelRunner.ACTION_OPTS, "\n\t");
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
