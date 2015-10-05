package hu.eltesoft.modelexecution.cli;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import hu.eltesoft.modelexecution.cli.logger.ConsoleLogger;
import hu.eltesoft.modelexecution.cli.logger.IdleLogger;
import hu.eltesoft.modelexecution.cli.logger.VerboseConsoleLogger;
import hu.eltesoft.modelexecution.filemanager.FileManager;

/**
 * Console application that compiles and/or executes the model based on the
 * command line arguments.
 */
public class ConsoleModelRunner {
	static ConsoleModelRunner runner = new ConsoleModelRunner();
	
	public static ConsoleModelRunner getRunner() {
		return runner;
	}

	public static Options getOptions() {
		return getRunner().options;
	}
	
	public static List<String> getActionOpts() {
		return ACTION_OPTS;
	}

	private static final int ERROR_EXIT_CODE = 1;

	/**
	 * The main actions that the program can do. At least one of these must be
	 * present.
	 */
	private static final List<String> ACTION_OPTS = Utils.list(Opt.SETUP.longName, Opt.EXECUTE.longName);

	private final Options options = createParserOptions();

	private ConsoleLogger logger = new IdleLogger();

	public static void main(String[] args) {
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
		CommandLine cmd = parser.parse(options, args);
		if (cmd.hasOption(Opt.HELP.shortName)) {
			printHelp();
			return;
		}
		Checks.checkOptionsValidity(cmd);
		processValidCommands(cmd);
	}

	public Options createParserOptions() {
		Options options = new Options();
		Arrays.stream(Opt.values()).map(opt -> opt.createOption()).forEach(options::addOption);
		return options;
	}

	private void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
		String prgName = Utils.getProgramName();
		String headline = String.format("java %s%n\t\t [%s]...", prgName, Messages.OPTION.getMsg());
		formatter.printHelp(headline, options);
	}

	private void processValidCommands(CommandLine cmd) {
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
		if (!Opt.ROOT.isPresent(cmd)) {
			return null;
		}
		return Paths.get(Opt.ROOT.getOption(cmd, 0).get()).toAbsolutePath().toString();
	}


}
