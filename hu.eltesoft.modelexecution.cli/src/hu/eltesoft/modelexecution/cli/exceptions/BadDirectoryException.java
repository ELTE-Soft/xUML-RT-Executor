package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Message;

import org.apache.commons.cli.Options;

public class BadDirectoryException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String presentOptName;
	String root;
	Options parserOpts;

	public BadDirectoryException(String presentOptName, String root, Options parserOpts) {
		super();
		this.presentOptName = presentOptName;
		this.root = root;
		this.parserOpts = parserOpts;
	}

	@Override
	public String toString() {
		return Message.BAD_DIRECTORY.getMsg(presentOptName, root);
	}
	
	@Override
	public String getLocalizedMessage() {
		return toString();
	}
	
	
}
