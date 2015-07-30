package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.Messages;
import hu.eltesoft.modelexecution.cli.Utils;

public class CliRuntimeException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	private Exception e;

	public CliRuntimeException(Exception e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return Messages.RUNTIME_EXCEPTION.getMsg(Utils.stackTraceToString(e));
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
