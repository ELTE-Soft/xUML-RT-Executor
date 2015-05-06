package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Message;
import hu.eltesoft.modelexecution.cli.Util;

public class CliRuntimeException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	private Exception e;
	
	public CliRuntimeException(Exception e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return Message.RUNTIME_EXCEPTION.getMsg(Util.stackTraceToString(e));
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}

}
