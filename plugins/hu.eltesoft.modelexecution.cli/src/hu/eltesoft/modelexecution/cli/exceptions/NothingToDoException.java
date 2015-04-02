package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner;
import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Message;
import hu.eltesoft.modelexecution.cli.Util;

import org.apache.commons.cli.Options;

public class NothingToDoException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	Options parserOpt;

	public NothingToDoException(Options parserOpts) {
		this.parserOpt = parserOpts;
	}

	@Override
	public String toString() {
		return Message.MISSING_ACTION_OPTIONS.getMsg()
				+ Util.join(ConsoleModelRunner.ACTION_OPTS, "\n\t");
	}
	
	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
