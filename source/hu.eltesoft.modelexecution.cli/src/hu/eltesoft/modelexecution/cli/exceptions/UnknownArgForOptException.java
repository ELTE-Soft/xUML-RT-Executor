package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Message;
import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Opt;

import org.apache.commons.cli.Options;

public class UnknownArgForOptException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String arg;
	Opt opt;
	Options parserOpts;

	public UnknownArgForOptException(String arg, Opt opt, Options parserOpts) {
		this.arg = arg;
		this.opt = opt;
		this.parserOpts = parserOpts;
	}

	public String toString() {
		return Message.UNKNOWN_OPT_PAR.getMsg(arg, opt.name());
	}
	
	public String getLocalizedMessage() {
		return toString();
	}
	
}
