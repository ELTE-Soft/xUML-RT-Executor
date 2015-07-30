package hu.eltesoft.modelexecution.cli.exceptions;

import org.apache.commons.cli.Options;

import hu.eltesoft.modelexecution.cli.Messages;

public class BadFileException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String presentOptName;
	String model;
	Options parserOpts;

	public BadFileException(String presentOptName, String model, Options parserOpts) {
		super();
		this.presentOptName = presentOptName;
		this.model = model;
		this.parserOpts = parserOpts;
	}

	@Override
	public String toString() {
		return Messages.BAD_FILE.getMsg(presentOptName, model);
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
