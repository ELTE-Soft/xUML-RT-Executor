package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Messages;

import java.util.ResourceBundle;

import org.apache.commons.cli.Options;

public class BadDirectoryException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String presentOptName;
	String root;
	ResourceBundle msgs;
	Options parserOpts;

	public BadDirectoryException(String presentOptName, String root, ResourceBundle msgs,
			Options parserOpts) {
		super();
		this.presentOptName = presentOptName;
		this.root = root;
		this.msgs = msgs;
		this.parserOpts = parserOpts;
	}

	@Override
	public String toString() {
		return Messages.BAD_DIRECTORY.getMsg(msgs, presentOptName, root);
	}
	
	@Override
	public String getLocalizedMessage() {
		return toString();
	}
	
	
}
