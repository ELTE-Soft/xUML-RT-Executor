package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Message;
import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Opt;
import hu.eltesoft.modelexecution.cli.Util;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.cli.Options;

public class IncompatibleOptsException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	Opt opt;
	Options parserOpts;
	
	public IncompatibleOptsException(Opt opt, Options parserOptions) {
		super();
		this.opt = opt;
		this.parserOpts = parserOptions;
	}

	public String toString() {
		List<String> optNames = opt.requiredOpts.stream().map(Opt::toString).collect(Collectors.toList());
		String commaSepOptNames = Util.join(optNames, ", ");
		if (optNames.size() > 1) {
			return Message.NO_REQUIRED_OPTION_PRESENT_MANY.getMsg(opt,
					commaSepOptNames);
		} else {
			return Message.NO_REQUIRED_OPTION_PRESENT1.getMsg(opt,
					commaSepOptNames);
		}
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
