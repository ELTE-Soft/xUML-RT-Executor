package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Messages;
import hu.eltesoft.modelexecution.cli.ConsoleModelRunner.Opt;
import hu.eltesoft.modelexecution.cli.Util;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.apache.commons.cli.Options;

public class IncompatibleOptsException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	Opt opt;
	ResourceBundle msgs;
	Options parserOpts;
	
	public IncompatibleOptsException(Opt opt, ResourceBundle msgs,
			Options parserOptions) {
		super();
		this.opt = opt;
		this.msgs = msgs;
		this.parserOpts = parserOptions;
	}

	public String toString() {
		List<String> optNames = opt.requiredOpts.stream().map(Opt::toString).collect(Collectors.toList());
		String commaSepOptNames = Util.join(optNames, ", ");
		if (optNames.size() > 1) {
			return Messages.NO_REQUIRED_OPTION_PRESENT_MANY.getMsg(msgs, opt,
					commaSepOptNames);
		} else {
			return Messages.NO_REQUIRED_OPTION_PRESENT1.getMsg(msgs, opt,
					commaSepOptNames);
		}
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
