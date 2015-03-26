package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Message;

import org.apache.commons.cli.Options;

public class DanglingArgumentsException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String[] danglingArgs;
	Options parserOpts;
	
	public DanglingArgumentsException(String[] danglingArgs,
			Options parserOpts) {
		super();
		this.danglingArgs = danglingArgs;
		this.parserOpts = parserOpts;
	}


	@Override
	public String toString() {
		return Message.DANGLING_ARG.getMsg(String.join(" ", danglingArgs));
	}
	
	@Override
	public String getLocalizedMessage() {
		return toString();
	}

}
