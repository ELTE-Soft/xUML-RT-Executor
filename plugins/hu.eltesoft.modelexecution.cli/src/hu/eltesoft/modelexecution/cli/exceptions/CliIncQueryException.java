package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.Messages;
import hu.eltesoft.modelexecution.cli.Util;

import org.eclipse.incquery.runtime.exception.IncQueryException;

public class CliIncQueryException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	private IncQueryException e;

	public CliIncQueryException(IncQueryException e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return Messages.INCQUERY_EXCEPTION_OCCURRED.getMsg(Util.stackTraceToString(e));
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
