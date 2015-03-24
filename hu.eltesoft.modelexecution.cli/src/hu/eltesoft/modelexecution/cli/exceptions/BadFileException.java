package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Messages;

import java.util.ResourceBundle;

import org.apache.commons.cli.Options;

public class BadFileException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String presentOptName;
	String model;
	ResourceBundle msgs;
	Options parserOpts;

	public BadFileException(String presentOptName, String model, ResourceBundle msgs,
			Options parserOpts) {
		super();
		this.presentOptName = presentOptName;
		this.model = model;
		this.msgs = msgs;
		this.parserOpts = parserOpts;
	}

	@Override
	public String toString() {
		return Messages.BAD_FILE.getMsg(msgs, presentOptName, model);
	}
	
	@Override
	public String getLocalizedMessage() {
		return toString();
	}
	
	

}
