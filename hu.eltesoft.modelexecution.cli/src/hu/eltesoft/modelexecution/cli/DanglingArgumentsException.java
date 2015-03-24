package hu.eltesoft.modelexecution.cli;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Message;

import java.util.ResourceBundle;

import org.apache.commons.cli.Options;

public class DanglingArgumentsException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String[] danglingArgs;
	ResourceBundle msgs;
	Options parserOpts;
	
	public DanglingArgumentsException(String[] danglingArgs,
			ResourceBundle msgs, Options parserOpts) {
		super();
		this.danglingArgs = danglingArgs;
		this.msgs = msgs;
		this.parserOpts = parserOpts;
	}


	@Override
	public String toString() {
		return Message.DANGLING_ARG.getMsg(msgs, String.join(" ", danglingArgs));
	}
	
	@Override
	public String getLocalizedMessage() {
		return toString();
	}

}
