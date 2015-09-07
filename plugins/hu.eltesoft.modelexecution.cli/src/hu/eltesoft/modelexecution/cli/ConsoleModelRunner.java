package hu.eltesoft.modelexecution.cli;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import hu.eltesoft.modelexecution.cli.exceptions.BadArgCountException;
import hu.eltesoft.modelexecution.cli.exceptions.BadDirectoryException;
import hu.eltesoft.modelexecution.cli.exceptions.BadFileException;
import hu.eltesoft.modelexecution.cli.exceptions.DanglingArgumentsException;
import hu.eltesoft.modelexecution.cli.exceptions.IncompatibleOptsException;
import hu.eltesoft.modelexecution.cli.exceptions.NothingToDoException;
import hu.eltesoft.modelexecution.cli.exceptions.UnknownArgForOptException;
import hu.eltesoft.modelexecution.filemanager.FileManager;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.log.MinimalLogger;
import hu.eltesoft.modelexecution.runtime.log.NoLogger;

/**
 * Console application that compiles and/or executes the model based on the
 * command line arguments.
 */
public class ConsoleModelRunner {

	private static final int ERROR_EXIT_CODE = 1;

	private static final Map<String, Supplier<Logger>> LOGGER_FACTORY = new HashMap<>();

	static {
		LOGGER_FACTORY.put(LoggerType.LOGGER_NONE.name, () -> new NoLogger());
		LOGGER_FACTORY.put(LoggerType.LOGGER_MINIMAL.name, () -> new MinimalLogger());
	}

	/**
	 * The main actions that the program can do. At least one of these must be
	 * present.
	 */
	public static final List<String> ACTION_OPTS = Utils.list(Opt.SETUP.longName, Opt.EXECUTE.longName);

	private final Options options = createParserOptions();

	private CommandLine cmd;

	private ConsoleLogger logger = new IdleLogger();

	public static void main(String[] args) {
		ConsoleModelRunner runner = new ConsoleModelRunner();
		try {
			runner.run(args);
		} catch (IllegalArgumentException | ParseException e) {
			runner.exitWithErrorMsg(e.getLocalizedMessage());
		}
	}

	private void exitWithErrorMsg(String errorMessage) {
		System.err.println(errorMessage);
		printHelp();
		System.exit(ERROR_EXIT_CODE);
	}

	public void run(String[] args) throws ParseException {
		CommandLineParser parser = new PosixParser();
		cmd = parser.parse(options, args);
		processCommands();
	}

	public Options createParserOptions() {
		Options options = new Options();
		Arrays.stream(Opt.values()).map(opt -> opt.createOption()).forEach(options::addOption);
		return options;
	}

	private void processCommands() {
		if (cmd.hasOption(Opt.HELP.shortName)) {
			showOptionsAndExit();
		}
		checkOptionsValidity();
		processValidCommands();
	}

	private void showOptionsAndExit() {
		printHelp();
		System.exit(0);
	}

	private void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
		String headline = String.format("java %s%n\t\t [%s]...", ConsoleModelRunner.class.getCanonicalName(),
				Messages.OPTION.getMsg());
		formatter.printHelp(headline, options);
	}

	private void checkOptionsValidity() {
		checkMissingRequiredOptions();

		checkUnknownLoggerType();

		checkNothingToDo();

		boolean rootDirIsNeeded = Opt.EXECUTE.isPresent(cmd);
		boolean rootDirIsAutocreated = Opt.SETUP.isPresent(cmd);
		if (rootDirIsNeeded && !rootDirIsAutocreated) {
			checkIsParameterDir(Opt.ROOT, 0);
		}

		checkIsParameterDir(Opt.WRITE_TRACE, 0);
		checkIsParameterDir(Opt.READ_TRACE, 0);

		checkIsParameterFile(Opt.SETUP, 0);

		checkArgCount(Opt.EXECUTE, 2);

		checkNoDanglingArg();
	}

	private void checkNoDanglingArg() {
		String[] danglingArgs = cmd.getArgs();
		if (danglingArgs.length > 0) {
			throw new DanglingArgumentsException(danglingArgs, options);
		}
	}

	private void checkArgCount(Opt opt, int expectedArgCount) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		int foundArgCount = opt.getOptions(cmd).get().length;
		if (foundArgCount != expectedArgCount) {
			throw new BadArgCountException(opt.getPresentName(cmd).get(), foundArgCount, expectedArgCount, options);
		}
	}

	private void checkIsParameterFile(Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String model = opt.getOption(cmd, idx).get();
		if (!new File(model).canRead()) {
			throw new BadFileException(opt.getPresentName(cmd).get(), model, options);
		}
	}

	private void checkIsParameterDir(Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String root = opt.getOption(cmd, idx).get();
		if (!new File(root).isDirectory()) {
			throw new BadDirectoryException(opt.getPresentName(cmd).get(), root, options);
		}
	}

	private void checkMissingRequiredOptions() {
		Set<Opt> presentOpts = getPresentOpts();
		for (Opt opt : presentOpts) {
			if (opt.requiredOpts.isEmpty()) {
				continue;
			}

			boolean hasRequiredOpt = opt.requiredOpts.stream().anyMatch(opt2 -> opt2.isPresent(cmd));
			if (!hasRequiredOpt) {
				throw new IncompatibleOptsException(opt, options);
			}
		}
	}

	private Set<Opt> getPresentOpts() {
		return Arrays.stream(Opt.values()).filter(opt -> opt.isPresent(cmd)).collect(Collectors.toSet());
	}

	private void checkNothingToDo() {
		boolean isAtLeastOneOptPresent = ACTION_OPTS.stream().anyMatch(opt -> cmd.hasOption(opt));
		if (!isAtLeastOneOptPresent) {
			throw new NothingToDoException();
		}
	}

	/**
	 * This check is only activated when the user enters a logger type. Checks
	 * if the entered logger type is unknown.
	 */
	private void checkUnknownLoggerType() {
		if (!Opt.LOGGER.isPresent(cmd)) {
			return;
		}

		String userLoggerType = Opt.LOGGER.getOption(cmd, 0).get();
		if (LOGGER_FACTORY.containsKey(userLoggerType)) {
			return;
		}

		throw new UnknownArgForOptException(userLoggerType, Opt.LOGGER, options);
	}

	private void processValidCommands() {
		String rootDir = getRootDir(cmd);
		if (Opt.VERBOSE.isPresent(cmd)) {
			logger = new VerboseConsoleLogger();
		}
		if (Opt.SETUP.isPresent(cmd)) {
			StandaloneModelCompiler compiler = new StandaloneModelCompiler(logger);
			String modelPath = Opt.SETUP.getOption(cmd, 0).get();
			compiler.compileModel(modelPath, rootDir);
		}

		if (Opt.EXECUTE.isPresent(cmd)) {
			StandaloneModelExecutor executor = new StandaloneModelExecutor(logger, cmd);
			executor.executeModel(rootDir);
		}

		logger.verboseTimeMsg(Messages.FINISHED_RUNNING);
	}
	
	/**
	 * @return Gets the absolute path of the {@link Opt.ROOT} option, except
	 *         when it is not present; then it is null, as {@link FileManager}
	 *         expects it so.
	 */
	private String getRootDir(CommandLine cmd) {
		if (!Opt.ROOT.isPresent(cmd))
			return null;
		return Paths.get(Opt.ROOT.getOption(cmd, 0).get()).toAbsolutePath().toString();
	}


}
