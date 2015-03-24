package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner;
import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Messages;
import hu.eltesoft.modelexecution.cli.Util;

import java.util.ResourceBundle;

import org.apache.commons.cli.Options;

public class NothingToDoException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	Options parserOpt;
	ResourceBundle msgs;

	public NothingToDoException(Options parserOpts, ResourceBundle msgs) {
		this.parserOpt = parserOpts;
		this.msgs = msgs;
	}

	@Override
	public String toString() {
		return Messages.MISSING_ACTION_OPTIONS.getMsg(msgs)
				+ Util.join(ConsoleModelRunner.ACTION_OPTS, "\n\t");
	}
	
	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
