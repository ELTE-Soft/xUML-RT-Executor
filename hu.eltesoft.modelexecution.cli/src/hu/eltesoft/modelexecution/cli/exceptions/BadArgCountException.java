package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Message;

import java.util.ResourceBundle;

import org.apache.commons.cli.Options;

public class BadArgCountException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String presentOptName;
	int foundArgCount;
	int expectedArgCount;
	ResourceBundle msgs;
	Options parserOpts;

	public BadArgCountException(String presentOptName, int foundArgCount,
			int expectedArgCount, ResourceBundle msgs, Options parserOpts) {
		super();
		this.presentOptName = presentOptName;
		this.foundArgCount = foundArgCount;
		this.expectedArgCount = expectedArgCount;
		this.msgs = msgs;
		this.parserOpts = parserOpts;
	}

	@Override
	public String toString() {
		return Message.BAD_ARG_COUNT.getMsg(msgs, presentOptName, expectedArgCount, foundArgCount);
	}
	
	@Override
	public String getLocalizedMessage() {
		return toString();
	}
	
	

}
