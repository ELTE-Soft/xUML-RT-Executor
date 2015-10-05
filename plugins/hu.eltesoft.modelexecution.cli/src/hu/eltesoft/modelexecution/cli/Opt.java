package hu.eltesoft.modelexecution.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.TreeSet;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;

import hu.eltesoft.modelexecution.cli.logger.Loggers;

/**
 * Describes the syntax of the command line options.
 */
public enum Opt {
	HELP("help", "h", Utils.list(), Utils.list()),

	VERBOSE("verbose", "v", Utils.list(), Utils.list()),

	SETUP("setup", "s", Utils.list(), Utils.list(), "model"),

	EXECUTE("execute", "e", Utils.list(), Utils.list(), "class", "feed"),

	WRITE_TRACE("write-trace", "wtr", Utils.list(EXECUTE), Utils.list(), "dir"),

	READ_TRACE("read-trace", "rtr", Utils.list(EXECUTE), Utils.list(), "dir"),

	LOGGER("logger", "l", Utils.list(EXECUTE), Utils.list(Loggers.LOGGER_NONE, Loggers.LOGGER_MINIMAL), "logger"),

	ROOT("root", "r", Utils.list(EXECUTE, SETUP), Utils.list(), "dir");

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
	private List<Loggers> argValueNames;

	private Opt(String longName, String shortName, List<Opt> requiredOpts, List<Loggers> argValueNames,
			String... argNames) {
		this.longName = longName;
		this.shortName = shortName;
		this.requiredOpts = requiredOpts;
		this.argNames = Utils.list(argNames);
		this.argValueNames = argValueNames;
	}

	Option createOption() {
		OptionBuilder.withLongOpt(longName);
		OptionBuilder.hasArgs(argNames.size());
		OptionBuilder.withArgName(String.join(",", argNames));
		OptionBuilder.withDescription(getDescription());
		return OptionBuilder.create(shortName);
	}

	private static final String BUNDLE_NAME = Opt.class.getSimpleName().toLowerCase();
	public static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private String getDescription() {
		String key = Utils.toResourceKey(this);
		String description = BUNDLE.getString(key);
		return hasArgValues() ? description : getDescriptionWithArgValues(description);
	}

	/** Returns whether the option has (named) values for its argument. */
	private boolean hasArgValues() {
		return argValueNames.size() == 0;
	}

	private String getDescriptionWithArgValues(String descr) {
		String possibleValuesMsg = Messages.POSSIBLE_VALUES.getMsg();
		List<String> possibleValues = getPossibleValues();
		return String.format("%s%n%s: %s", descr, possibleValuesMsg, Utils.join(possibleValues, ", "));
	}

	private List<String> getPossibleValues() {
		List<String> argValuesText = new ArrayList<>();
		Loggers defaultValue = argValueNames.get(0);
		for (Loggers argValueName : new TreeSet<>(argValueNames)) {
			String optText = argValueName.name;
			if (argValueName == defaultValue) {
				optText += " (" + Messages.DEFAULT_VALUE.getMsg() + ")";
			}
			argValuesText.add(optText);
		}
		return argValuesText;
	}

	public boolean isPresent(CommandLine cmd) {
		return cmd.hasOption(shortName) || cmd.hasOption(longName);
	}

	public Optional<String> getOption(CommandLine cmd, int index) {
		Optional<String[]> options = getOptions(cmd);
		if (!options.isPresent()) {
			return Optional.empty();
		}
		return Optional.of(options.get()[index]);
	}

	public Optional<String[]> getOptions(CommandLine cmd) {
		Optional<String> presentName = getPresentName(cmd);
		if (!presentName.isPresent()) {
			return Optional.empty();
		}
		return Optional.of(cmd.getOptionValues(presentName.get()));
	}

	public Optional<String> getPresentName(CommandLine cmd) {
		if (cmd.hasOption(longName)) {
			return Optional.of(longName);
		}
		if (cmd.hasOption(shortName)) {
			return Optional.of(shortName);
		}
		return Optional.empty();
	}
}
