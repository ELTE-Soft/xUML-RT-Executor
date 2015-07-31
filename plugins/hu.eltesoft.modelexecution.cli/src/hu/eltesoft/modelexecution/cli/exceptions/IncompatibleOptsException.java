package hu.eltesoft.modelexecution.cli.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.cli.Options;

import hu.eltesoft.modelexecution.cli.Messages;
import hu.eltesoft.modelexecution.cli.Opt;
import hu.eltesoft.modelexecution.cli.Utils;

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
		String commaSepOptNames = Utils.join(optNames, ", ");
		if (optNames.size() > 1) {
			return Messages.NO_REQUIRED_OPTION_PRESENT_MANY.getMsg(opt, commaSepOptNames);
		} else {
			return Messages.NO_REQUIRED_OPTION_PRESENT1.getMsg(opt, commaSepOptNames);
		}
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
