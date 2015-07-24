package hu.eltesoft.modelexecution.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.TreeSet;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;

/** Describes the syntax of the options that come from the command line. */
public enum Opt {
	HELP("help", "h", Util.list(), Util.list()), VERBOSE("verbose", "v", Util.list(), Util.list()),

	SETUP("setup", "s", Util.list(), Util.list(), "model"),

	EXECUTE("execute", "e", Util.list(), Util.list(), "class", "feed"), WRITE_TRACE("write-trace", "wtr",
			Util.list(EXECUTE), Util.list(),
			"dir"), READ_TRACE("read-trace", "rtr", Util.list(EXECUTE), Util.list(), "dir"), LOGGER("logger", "l",
					Util.list(EXECUTE), Util.list(LoggerType.LOGGER_NONE, LoggerType.LOGGER_MINIMAL), "logger"),

	ROOT("root", "r", Util.list(EXECUTE, SETUP), Util.list(), "dir");

	String longName;
	String shortName;
	private List<String> argNames;
	/**
	 * If the current option is present, one of these must also be present.
	 */
	public List<Opt> requiredOpts;
	/**
	 * If the option has a limited number of values, list them here. An empty
	 * list means the values are not limited to a few items.
	 */
	private List<LoggerType> argValueNames;

	private Opt(String longName, String shortName, List<Opt> requiredOpts, List<LoggerType> argValueNames,
			String... argNames) {
		this.longName = longName;
		this.shortName = shortName;
		this.requiredOpts = requiredOpts;
		this.argNames = Util.list(argNames);
		this.argValueNames = argValueNames;
	}

	Option mkOpt() {
		OptionBuilder.withLongOpt(longName);
		OptionBuilder.hasArgs(argNames.size());
		OptionBuilder.withArgName(String.join(",", argNames));

		String key = name().toLowerCase();
		String description = getDescription(key);
		OptionBuilder.withDescription(description);

		return OptionBuilder.create(shortName);
	}

	private static final String BUNDLE_NAME = "opt";
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private String getDescription(String key) {
		String description = BUNDLE.getString(key);
		return hasArgValues() ? description : mkDescriptionWithArgValues(description);
	}

	/** Returns whether the option has (named) values for its argument. */
	private boolean hasArgValues() {
		return argValueNames.size() == 0;
	}

	private String mkDescriptionWithArgValues(String descr) {
		String possibleValuesMsg = Messages.POSSIBLE_VALUES.getMsg();
		List<String> possibleValues = getPossibleLoggerValues();
		return String.format("%s%n%s: %s", descr, possibleValuesMsg, Util.join(possibleValues, ", "));
	}

	private List<String> getPossibleLoggerValues() {
		List<String> argValuesTxt = new ArrayList<>();
		LoggerType defaultValue = argValueNames.get(0);
		for (LoggerType argValueName : new TreeSet<>(argValueNames)) {
			boolean isDefault = argValueName == defaultValue;
			String defaultTxt = " (" + Messages.DEFAULT_VALUE.getMsg() + ")";
			String appendWhenDefault = isDefault ? defaultTxt : "";
			String loggerOpt = argValueName.name + appendWhenDefault;

			argValuesTxt.add(loggerOpt);
		}
		return argValuesTxt;
	}

	boolean isPresent(CommandLine cmd) {
		return cmd.hasOption(shortName) || cmd.hasOption(longName);
	}

	Optional<String> getOption(CommandLine cmd, int idx) {
		Optional<String[]> options = getOptions(cmd);
		if (!options.isPresent())
			return Optional.empty();
		return Optional.of(options.get()[idx]);
	}

	Optional<String[]> getOptions(CommandLine cmd) {
		Optional<String> presentName = getPresentName(cmd);
		if (!presentName.isPresent())
			return Optional.empty();
		return Optional.of(cmd.getOptionValues(presentName.get()));
	}

	Optional<String> getPresentName(CommandLine cmd) {
		if (cmd.hasOption(longName))
			return Optional.of(longName);
		if (cmd.hasOption(shortName))
			return Optional.of(shortName);
		return Optional.empty();
	}
}
