package hu.eltesoft.modelexecution.cli;

import hu.eltesoft.modelexecution.cli.exceptions.BadFileException;
import hu.eltesoft.modelexecution.cli.exceptions.IncompatibleOptsException;
import hu.eltesoft.modelexecution.cli.exceptions.NothingToDoException;
import hu.eltesoft.modelexecution.cli.exceptions.BadDirectoryException;
import hu.eltesoft.modelexecution.cli.exceptions.UnknownArgForOptException;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.log.MinimalLogger;
import hu.eltesoft.modelexecution.runtime.log.NoLogger;
import hu.eltesoft.modelexecution.runtime.trace.NoTraceReader;
import hu.eltesoft.modelexecution.runtime.trace.NoTracer;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader;
import hu.eltesoft.modelexecution.runtime.trace.TraceReplayer;
import hu.eltesoft.modelexecution.runtime.trace.TraceWriter;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

/**
 * Console application that compiles and/or executes the model
 * based on the command line arguments.
 * 
 * @author kitlei
 */
public class ConsoleModelRunner {
	/** Names for the arguments of the options. */
	public enum ArgValueName {
		LOGGER_NONE("none"),
		LOGGER_MINIMAL("minimal")
		;

		String name;

		private ArgValueName(String name) {
			this.name = name;
		}
	}

	/** Messages that are printed at some point.
	 *  The names in the resource bundle must be the lower case equivalents
	 *  of the enum labels. */
	public enum Messages {
		EXECUTING_COMPILED_JAVA,
		DEFAULT_VALUE,
		POSSIBLE_VALUES,
		COMPILING_MODEL_TO_JAVA,
		UNKNOWN_OPT_PAR,
		NO_REQUIRED_OPTION_PRESENT_MANY,
		NO_REQUIRED_OPTION_PRESENT1,
		MISSING_ACTION_OPTIONS,
		OPTION,
		BAD_DIRECTORY,
		BAD_FILE
		;

		public String getMsg(ResourceBundle msgs, Object... args) {
			String descrBundleName = getDescriptionBundleName();
			String format = msgs.getString(descrBundleName);
			return MessageFormat.format(format, args);
		}
		
		public String getDescriptionBundleName() {
			return name().toLowerCase();
		}
	}

	/** Describes the syntax of the options that come from the command line. */
	public enum Opt {
		HELP("help", "h", Util.list(), Util.list()),
		VERBOSE("verbose", "v", Util.list(), Util.list()),

		SETUP("setup", "s", Util.list(), Util.list(), "model"),

		EXECUTE("execute", "e", Util.list(), Util.list(), "class", "feed"),
		WRITE_TRACE("write-trace", "wtr", Util.list(EXECUTE), Util.list(), "dir"),
		READ_TRACE("read-trace", "rtr", Util.list(EXECUTE), Util.list(), "dir"),
		LOGGER("logger", "l", Util.list(EXECUTE),
			   Util.list(ArgValueName.LOGGER_NONE, ArgValueName.LOGGER_MINIMAL), "logger"),

		ROOT("root", "r", Util.list(EXECUTE, SETUP), Util.list(), "dir")
		;

		private static final String OPT_BUNDLE_POSTFIX = "_opt";

		String longName;
		String shortName;
		List<String> argNames;
		/** If the current option is present, one of these must also be present. */
		public List<Opt> requiredOpts;
		/** If the option has a limited number of values, list them here.
		 *  An empty list means the values are not limited to a few items. */
		List<ArgValueName> argValueNames;

		Opt(String longName, String shortName, List<Opt> requiredOpts,
				List<ArgValueName> argValueNames, String... argNames) {
			this.longName = longName;
			this.shortName = shortName;
			this.requiredOpts = requiredOpts;
			this.argNames = Util.list(argNames);
			this.argValueNames = argValueNames;
		}

		Option mkOpt(ResourceBundle msgs) {
			OptionBuilder.withLongOpt(longName);
			OptionBuilder.hasArgs(argNames.size());
			OptionBuilder.withArgName(String.join(",", argNames));

			String descrBundleName = getDescriptionBundleName();
			String description = getDescription(msgs, descrBundleName);
			OptionBuilder.withDescription(description);
			
			return OptionBuilder.create(shortName);
		}

		public String getDescriptionBundleName() {
			return name().toLowerCase() + OPT_BUNDLE_POSTFIX;
		}

		private String getDescription(ResourceBundle msgs,
				String descrBundleName) {
			String descr = msgs.getString(descrBundleName);
			return hasArgValues() ? descr : mkDescriptionWithArgValues(descr, msgs);
		}

		/** Returns whether the option has (named) values for its argument. */
		private boolean hasArgValues() {
			return argValueNames.size() == 0;
		}

		private String mkDescriptionWithArgValues(String descr, ResourceBundle msgs) {
			String possibleValuesMsg = Messages.POSSIBLE_VALUES.getMsg(msgs);
			List<String> possibleValues = getPossibleLoggerValues(msgs);
			return String.format("%s%n%s: %s", descr,
					possibleValuesMsg, Util.join(possibleValues, ", "));
		}

		private List<String> getPossibleLoggerValues(ResourceBundle msgs) {
			List<String> argValuesTxt = new ArrayList<>();
			ArgValueName defaultValue = argValueNames.get(0);
			for (ArgValueName argValueName : new TreeSet<>(argValueNames)) {
				boolean isDefault = argValueName == defaultValue;
				String defaultTxt = " (" + Messages.DEFAULT_VALUE.getMsg(msgs) + ")";
				String appendWhenDefault = isDefault ? defaultTxt : "";
				String loggerOpt = argValueName.name + appendWhenDefault;
				
				argValuesTxt.add(loggerOpt);
			}
			return argValuesTxt; 
		}
		
		boolean isPresent(CommandLine cmd) {
			return cmd.hasOption(shortName) || cmd.hasOption(longName);
		}
		
		String getOption(CommandLine cmd, int idx) {
			String presentName = getPresentName(cmd);
			if (presentName == null)   return null;
			return (String) cmd.getOptionValues(presentName)[idx];
		}

		public boolean requires(Opt opt2) {
			return requiredOpts.contains(opt2);
		}

		public String getPresentName(CommandLine cmd) {
			if (cmd.hasOption(longName))    return longName;
			if (cmd.hasOption(shortName))    return shortName;
			return null;
		}
	};

	private static final int PARSER_EXCEPTION_EXIT_CODE = 1;

	private static final Map<String, Function<String, Logger>> LOGGERMAKER_BY_NAME = mkLoggerMaker();

	/** The main actions that the program can do.
	 *  At least one of them must be present. */
	public static final List<String> ACTION_OPTS = Util.list(
			Opt.SETUP.longName, Opt.EXECUTE.longName);

	public static void main(String[] args) {
		ResourceBundle msgs = getDefaultBundle();
		Options parserOpts = mkParserOpts(msgs);

		try {
			doCli(args, msgs, parserOpts);
		} catch (IllegalArgumentException | ParseException e) {
			exitWithErrorMsg(parserOpts, e.getLocalizedMessage(), msgs);
		}
	}

	public static void doCli(String[] args, ResourceBundle msgs,
			Options parserOpts) throws ParseException {
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = parser.parse(parserOpts, args);
		processCmdLine(cmd, parserOpts, msgs);
	}

	private static void exitWithErrorMsg(Options parserOpts, String errMsg,
			ResourceBundle msgs) {
		System.err.println(errMsg);
		printHelp(parserOpts, msgs);
		System.exit(PARSER_EXCEPTION_EXIT_CODE);
	}

	private static Map<String, Function<String, Logger>> mkLoggerMaker() {
		Map<String, Function<String, Logger>> loggerByName = new HashMap<>(); 
		loggerByName.put(ArgValueName.LOGGER_NONE.name, args -> new NoLogger());
		loggerByName.put(ArgValueName.LOGGER_MINIMAL.name, args -> new MinimalLogger());
		return loggerByName;
	}

	private static void processCmdLine(CommandLine cmd, Options parserOpts,
			ResourceBundle msgs) {
		if (cmd.hasOption(Opt.HELP.shortName)) {
			showOptionsAndExit(parserOpts, msgs);
		}

		checkOptsValidity(cmd, parserOpts, msgs);

		processValidCmdLine(parserOpts, cmd, msgs,
				Opt.VERBOSE.isPresent(cmd));
	}

	private static void checkOptsValidity(CommandLine cmd,
			Options parserOpts, ResourceBundle msgs) {
		checkIncompatibleOpts(cmd, parserOpts, msgs);
		
		checkUnknownLoggerType(cmd, parserOpts, msgs);

		checkNothingToDo(cmd, parserOpts, msgs);
		
		checkIsParameterDir(cmd, parserOpts, msgs, Opt.ROOT, 0);
		checkIsParameterDir(cmd, parserOpts, msgs, Opt.WRITE_TRACE, 0);
		checkIsParameterDir(cmd, parserOpts, msgs, Opt.READ_TRACE, 0);

		checkIsParameterFile(cmd, parserOpts, msgs, Opt.SETUP, 0);
	}

	private static void checkIsParameterFile(CommandLine cmd, Options parserOpts,
			ResourceBundle msgs, Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String model = opt.getOption(cmd, idx);

		if (!new File(model).canRead()) {
			throw new BadFileException(opt.getPresentName(cmd), model, msgs, parserOpts);
		}
	}

	private static void checkIsParameterDir(CommandLine cmd, Options parserOpts,
			ResourceBundle msgs, Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String root = opt.getOption(cmd, idx);

		if (!new File(root).isDirectory()) {
			throw new BadDirectoryException(opt.getPresentName(cmd), root, msgs, parserOpts);
		}
	}

	private static void checkIncompatibleOpts(CommandLine cmd,
			Options parserOpts, ResourceBundle msgs) {
		Set<Opt> presentOpts = getPresentOpts(cmd);
		for (Opt opt : presentOpts) {
			if (opt.requiredOpts.isEmpty()) {
				continue;
			}
			
			boolean hasRequiredOpt = opt.requiredOpts.stream().anyMatch(
					opt2 -> opt2.isPresent(cmd));
			if (!hasRequiredOpt) {
				throw new IncompatibleOptsException(opt, msgs, parserOpts);
			}
		}
	}

	private static Set<Opt> getPresentOpts(CommandLine cmd) {
		return Arrays.stream(Opt.values()).filter(opt -> opt.isPresent(cmd))
				.collect(Collectors.toSet());
	}

	private static Logger getLogger(CommandLine cmd) {
		// Note: placeholder to pass arguments to the logger if necessary
		String optsForLogger = "";
		
		String loggerName = Opt.LOGGER.getOption(cmd, 0);

		if (loggerName == null) {
			return new NoLogger();
		}
		
		return LOGGERMAKER_BY_NAME.get(loggerName).apply(optsForLogger);
	}

	private static Tracer getTracer(CommandLine cmd) {
		String folderName = Opt.WRITE_TRACE.getOption(cmd, 0); 

		if (folderName == null) {
			return new NoTracer();
		}

		return new TraceWriter(folderName);
	}
	
	private static TraceReader getTraceReader(
			CommandLine cmd,
			Options parserOpts, ResourceBundle msgs) {
		try {
			String folderName = Opt.READ_TRACE.getOption(cmd, 0); 

			if (folderName == null) {
				return new NoTraceReader();
			}

			return new TraceReplayer(folderName);
		} catch (FileNotFoundException e) {
			exitWithErrorMsg(parserOpts, e.getLocalizedMessage(), msgs);
		}
		return new NoTraceReader();
	}

	private static void checkNothingToDo(CommandLine cmd, Options parserOpts,
			ResourceBundle msgs) {
		boolean isAtLeastOneOptPresent = ACTION_OPTS.stream().anyMatch(
				opt -> cmd.hasOption(opt));
		if (!isAtLeastOneOptPresent) {
			throw new NothingToDoException(parserOpts, msgs);
		}
	}

	/** This check is only activated when the user enters a logger type.
	 *  Checks if the entered logger type is unknown.
	 */
	private static void checkUnknownLoggerType(CommandLine cmd,
			Options parserOpts, ResourceBundle msgs) {
		if (!Opt.LOGGER.isPresent(cmd))    return;

		String userLoggerType = Opt.LOGGER.getOption(cmd, 0);
		if (LOGGERMAKER_BY_NAME.containsKey(userLoggerType))    return;

		throw new UnknownArgForOptException(userLoggerType, Opt.LOGGER, parserOpts, msgs);
	}

	private static void processValidCmdLine(Options parserOpts, CommandLine cmd,
			ResourceBundle msgs, boolean isVerbose) {
		if (Opt.SETUP.isPresent(cmd)) {
			if (isVerbose)
				System.out.println(Messages.COMPILING_MODEL_TO_JAVA.getMsg(msgs));
			runCompilationStep();
		}

		if (Opt.EXECUTE.isPresent(cmd)) {
			Tracer tracer = getTracer(cmd);
			TraceReader traceReader = getTraceReader(cmd, parserOpts, msgs);
			Logger logger = getLogger(cmd);

			if (isVerbose)
				System.out.println(Messages.EXECUTING_COMPILED_JAVA.getMsg(msgs));
			runExecutionStep(tracer, traceReader, logger);
		}
	}

	private static void runCompilationStep() {
		// TODO put actual compilation step code here

	}

	private static void runExecutionStep(Tracer tracer, TraceReader traceReader, Logger logger) {
		new CliRuntime(tracer, traceReader, logger);
	}

	public static ResourceBundle getDefaultBundle() {
		final String BUNDLE_ID = ConsoleModelRunner.class.getSimpleName();
		return ResourceBundle.getBundle(BUNDLE_ID);
	}

	public static Options mkParserOpts(ResourceBundle msgs) {
		Options parserOpts = new Options();
		Arrays.stream(Opt.values()).map(opt -> opt.mkOpt(msgs)).forEach(parserOpts::addOption); 
		return parserOpts;
	}

	private static void showOptionsAndExit(Options parserOpts, ResourceBundle msgs) {
		printHelp(parserOpts, msgs);
		System.exit(0);
	}

	private static void printHelp(Options parserOpts, ResourceBundle msgs) {
		HelpFormatter formatter = new HelpFormatter();
		String headline = String.format("java %s%n\t\t [%s]...",
				ConsoleModelRunner.class.getCanonicalName(),
				Messages.OPTION.getMsg(msgs));
		formatter.printHelp(headline, parserOpts);
	}

}
