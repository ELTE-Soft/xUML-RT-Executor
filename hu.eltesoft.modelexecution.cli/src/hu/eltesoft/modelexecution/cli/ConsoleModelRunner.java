package hu.eltesoft.modelexecution.cli;

import hu.eltesoft.modelexecution.cli.exceptions.BadArgCountException;
import hu.eltesoft.modelexecution.cli.exceptions.BadDirectoryException;
import hu.eltesoft.modelexecution.cli.exceptions.BadFileException;
import hu.eltesoft.modelexecution.cli.exceptions.DanglingArgumentsException;
import hu.eltesoft.modelexecution.cli.exceptions.IncompatibleOptsException;
import hu.eltesoft.modelexecution.cli.exceptions.NothingToDoException;
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
	public enum Message {
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
		BAD_FILE,
		BAD_ARG_COUNT,
		DANGLING_ARG
		;

		public String getMsg(Object... args) {
			String descrBundleName = getDescriptionBundleName();
			String format = getMsgs().getString(descrBundleName);
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

		private String longName;
		private String shortName;
		private List<String> argNames;
		/** If the current option is present, one of these must also be present. */
		public List<Opt> requiredOpts;
		/** If the option has a limited number of values, list them here.
		 *  An empty list means the values are not limited to a few items. */
		private List<ArgValueName> argValueNames;

		private Opt(String longName, String shortName, List<Opt> requiredOpts,
				List<ArgValueName> argValueNames, String... argNames) {
			this.longName = longName;
			this.shortName = shortName;
			this.requiredOpts = requiredOpts;
			this.argNames = Util.list(argNames);
			this.argValueNames = argValueNames;
		}

		private Option mkOpt() {
			OptionBuilder.withLongOpt(longName);
			OptionBuilder.hasArgs(argNames.size());
			OptionBuilder.withArgName(String.join(",", argNames));

			String descrBundleName = getDescriptionBundleName();
			String description = getDescription(descrBundleName);
			OptionBuilder.withDescription(description);
			
			return OptionBuilder.create(shortName);
		}

		public String getDescriptionBundleName() {
			return name().toLowerCase() + OPT_BUNDLE_POSTFIX;
		}

		private String getDescription(String descrBundleName) {
			String descr = getMsgs().getString(descrBundleName);
			return hasArgValues() ? descr : mkDescriptionWithArgValues(descr);
		}

		/** Returns whether the option has (named) values for its argument. */
		private boolean hasArgValues() {
			return argValueNames.size() == 0;
		}

		private String mkDescriptionWithArgValues(String descr) {
			String possibleValuesMsg = Message.POSSIBLE_VALUES.getMsg();
			List<String> possibleValues = getPossibleLoggerValues();
			return String.format("%s%n%s: %s", descr,
					possibleValuesMsg, Util.join(possibleValues, ", "));
		}

		private List<String> getPossibleLoggerValues() {
			List<String> argValuesTxt = new ArrayList<>();
			ArgValueName defaultValue = argValueNames.get(0);
			for (ArgValueName argValueName : new TreeSet<>(argValueNames)) {
				boolean isDefault = argValueName == defaultValue;
				String defaultTxt = " (" + Message.DEFAULT_VALUE.getMsg() + ")";
				String appendWhenDefault = isDefault ? defaultTxt : "";
				String loggerOpt = argValueName.name + appendWhenDefault;
				
				argValuesTxt.add(loggerOpt);
			}
			return argValuesTxt; 
		}
		
		private boolean isPresent(CommandLine cmd) {
			return cmd.hasOption(shortName) || cmd.hasOption(longName);
		}
		
		private String getOption(CommandLine cmd, int idx) {
			String[] options = getOptions(cmd);
			if (options == null)   return null;
			return options[idx];
		}

		private String[] getOptions(CommandLine cmd) {
			String presentName = getPresentName(cmd);
			if (presentName == null)   return null;
			return cmd.getOptionValues(presentName);
		}

		private String getPresentName(CommandLine cmd) {
			if (cmd.hasOption(longName))    return longName;
			if (cmd.hasOption(shortName))    return shortName;
			return null;
		}
	};

	private static ResourceBundle msgs = getDefaultBundle();

	private static final int PARSER_EXCEPTION_EXIT_CODE = 1;

	private static final Map<String, Function<String, Logger>> LOGGERMAKER_BY_NAME = mkLoggerMaker();

	/** The main actions that the program can do.
	 *  At least one of them must be present. */
	public static final List<String> ACTION_OPTS = Util.list(
			Opt.SETUP.longName, Opt.EXECUTE.longName);

	public static void main(String[] args) {
		Options parserOpts = mkParserOpts();

		try {
			doCli(args, parserOpts);
		} catch (IllegalArgumentException | ParseException e) {
			exitWithErrorMsg(parserOpts, e.getLocalizedMessage());
		}
	}

	public static void doCli(String[] args,
			Options parserOpts) throws ParseException {
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = parser.parse(parserOpts, args);
		processCmdLine(cmd, parserOpts);
	}

	private static void exitWithErrorMsg(Options parserOpts, String errMsg) {
		System.err.println(errMsg);
		printHelp(parserOpts);
		System.exit(PARSER_EXCEPTION_EXIT_CODE);
	}

	private static Map<String, Function<String, Logger>> mkLoggerMaker() {
		Map<String, Function<String, Logger>> loggerByName = new HashMap<>(); 
		loggerByName.put(ArgValueName.LOGGER_NONE.name, args -> new NoLogger());
		loggerByName.put(ArgValueName.LOGGER_MINIMAL.name, args -> new MinimalLogger());
		return loggerByName;
	}

	private static void processCmdLine(CommandLine cmd, Options parserOpts) {
		if (cmd.hasOption(Opt.HELP.shortName)) {
			showOptionsAndExit(parserOpts);
		}

		checkOptsValidity(cmd, parserOpts);

		processValidCmdLine(parserOpts, cmd,
				Opt.VERBOSE.isPresent(cmd));
	}

	private static void checkOptsValidity(CommandLine cmd,
			Options parserOpts) {
		checkMissingRequiredOpts(cmd, parserOpts);
		
		checkUnknownLoggerType(cmd, parserOpts);

		checkNothingToDo(cmd, parserOpts);
		
		checkIsParameterDir(cmd, parserOpts, Opt.ROOT, 0);
		checkIsParameterDir(cmd, parserOpts, Opt.WRITE_TRACE, 0);
		checkIsParameterDir(cmd, parserOpts, Opt.READ_TRACE, 0);

		checkIsParameterFile(cmd, parserOpts, Opt.SETUP, 0);

		checkArgCount(cmd, parserOpts, Opt.EXECUTE, 2);
		
		checkNoDanglingArg(cmd, parserOpts);
	}

	private static void checkNoDanglingArg(CommandLine cmd, Options parserOpts) {
		String[] danglingArgs = cmd.getArgs();
		if (danglingArgs.length > 0) {
			throw new DanglingArgumentsException(danglingArgs, parserOpts);
		}
		
	}

	private static void checkArgCount(CommandLine cmd, Options parserOpts,
			Opt opt, int expectedArgCount) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		int foundArgCount = opt.getOptions(cmd).length;
		if (foundArgCount != expectedArgCount) {
			throw new BadArgCountException(opt.getPresentName(cmd), foundArgCount, expectedArgCount, parserOpts);
		}
		
	}

	private static void checkIsParameterFile(CommandLine cmd, Options parserOpts,
			Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String model = opt.getOption(cmd, idx);

		if (!new File(model).canRead()) {
			throw new BadFileException(opt.getPresentName(cmd), model, parserOpts);
		}
	}

	private static void checkIsParameterDir(CommandLine cmd, Options parserOpts,
			Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String root = opt.getOption(cmd, idx);

		if (!new File(root).isDirectory()) {
			throw new BadDirectoryException(opt.getPresentName(cmd), root, parserOpts);
		}
	}

	private static void checkMissingRequiredOpts(CommandLine cmd,
			Options parserOpts) {
		Set<Opt> presentOpts = getPresentOpts(cmd);
		for (Opt opt : presentOpts) {
			if (opt.requiredOpts.isEmpty()) {
				continue;
			}
			
			boolean hasRequiredOpt = opt.requiredOpts.stream().anyMatch(
					opt2 -> opt2.isPresent(cmd));
			if (!hasRequiredOpt) {
				throw new IncompatibleOptsException(opt, parserOpts);
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
			Options parserOpts) {
		try {
			String folderName = Opt.READ_TRACE.getOption(cmd, 0); 

			if (folderName == null) {
				return new NoTraceReader();
			}

			return new TraceReplayer(folderName);
		} catch (FileNotFoundException e) {
			exitWithErrorMsg(parserOpts, e.getLocalizedMessage());
		}
		return new NoTraceReader();
	}

	private static void checkNothingToDo(CommandLine cmd, Options parserOpts) {
		boolean isAtLeastOneOptPresent = ACTION_OPTS.stream().anyMatch(
				opt -> cmd.hasOption(opt));
		if (!isAtLeastOneOptPresent) {
			throw new NothingToDoException(parserOpts);
		}
	}

	/** This check is only activated when the user enters a logger type.
	 *  Checks if the entered logger type is unknown.
	 */
	private static void checkUnknownLoggerType(CommandLine cmd,
			Options parserOpts) {
		if (!Opt.LOGGER.isPresent(cmd))    return;

		String userLoggerType = Opt.LOGGER.getOption(cmd, 0);
		if (LOGGERMAKER_BY_NAME.containsKey(userLoggerType))    return;

		throw new UnknownArgForOptException(userLoggerType, Opt.LOGGER, parserOpts);
	}

	private static void processValidCmdLine(Options parserOpts, CommandLine cmd,
			boolean isVerbose) {
		if (Opt.SETUP.isPresent(cmd)) {
			if (isVerbose)
				System.out.println(Message.COMPILING_MODEL_TO_JAVA.getMsg());
			runCompilationStep();
		}

		if (Opt.EXECUTE.isPresent(cmd)) {
			Tracer tracer = getTracer(cmd);
			TraceReader traceReader = getTraceReader(cmd, parserOpts);
			Logger logger = getLogger(cmd);

			if (isVerbose)
				System.out.println(Message.EXECUTING_COMPILED_JAVA.getMsg());
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
		String bundleId = ConsoleModelRunner.class.getSimpleName();
		return ResourceBundle.getBundle(bundleId);
	}

	public static Options mkParserOpts() {
		Options parserOpts = new Options();
		Arrays.stream(Opt.values()).map(opt -> opt.mkOpt()).forEach(parserOpts::addOption); 
		return parserOpts;
	}

	private static void showOptionsAndExit(Options parserOpts) {
		printHelp(parserOpts);
		System.exit(0);
	}

	private static void printHelp(Options parserOpts) {
		HelpFormatter formatter = new HelpFormatter();
		String headline = String.format("java %s%n\t\t [%s]...",
				ConsoleModelRunner.class.getCanonicalName(),
				Message.OPTION.getMsg());
		formatter.printHelp(headline, parserOpts);
	}

	public static ResourceBundle getMsgs() {
		return msgs;
	}

	public static void setMsgs(ResourceBundle newMsgs) {
		msgs = newMsgs;
	}

}
