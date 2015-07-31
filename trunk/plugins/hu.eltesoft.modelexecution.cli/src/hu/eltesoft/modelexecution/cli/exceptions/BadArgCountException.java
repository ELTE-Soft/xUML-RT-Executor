package hu.eltesoft.modelexecution.cli.exceptions;

import org.apache.commons.cli.Options;

import hu.eltesoft.modelexecution.cli.Messages;

public class BadArgCountException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String presentOptName;
	int foundArgCount;
	int expectedArgCount;
	Options parserOpts;

	public BadArgCountException(String presentOptName, int foundArgCount, int expectedArgCount, Options parserOpts) {
		super();
		this.presentOptName = presentOptName;
		this.foundArgCount = foundArgCount;
		this.expectedArgCount = expectedArgCount;
		this.parserOpts = parserOpts;
	}

	@Override
	public String toString() {
		return Messages.BAD_ARG_COUNT.getMsg(presentOptName, expectedArgCount, foundArgCount);
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
