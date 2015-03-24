package hu.eltesoft.modelexecution.cli;

import java.util.ResourceBundle;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

/**
 * @author kitlei
 */
public class ConsoleModelRunner {
	private static final int PARSER_EXCEPTION_EXIT_CODE = 1;

	public static void main(String[] args) {
		ResourceBundle msgs = getDefaultBundle();
		Options parserOpts = mkParserOpts(msgs);

		try {
			CommandLineParser parser = new PosixParser();
			CommandLine cmd = parser.parse(parserOpts, args);
			processCmdLine(cmd, parserOpts, msgs);
		} catch (ParseException e) {
			printHelp(parserOpts);
			System.exit(PARSER_EXCEPTION_EXIT_CODE);
		}
	}

	private static void processCmdLine(CommandLine cmd, Options parserOpts,
			ResourceBundle msgs) {
		exitOnCmdLineError(cmd, parserOpts);

		boolean isVerbose = cmd.hasOption("verbose");
		processValidCmdLine(cmd, msgs, isVerbose);
	}

	private static void processValidCmdLine(CommandLine cmd,
			ResourceBundle msgs, boolean isVerbose) {
		if (cmd.hasOption("s")) {
			if (isVerbose)
				System.out.println(msgs.getString("compilingModelToJava"));
			runCompilationStep();
		}

		if (cmd.hasOption("execute")) {
			if (isVerbose)
				System.out.println(msgs.getString("executingCompiledJava"));
			runExecutionStep();
		}
	}

	private static void runCompilationStep() {
		// TODO put actual compilation step code here

	}

	private static void runExecutionStep() {
		// TODO put actual execution step code here

	}

	private static ResourceBundle getDefaultBundle() {
		final String BUNDLE_ID = ConsoleModelRunner.class.getSimpleName();
		return ResourceBundle.getBundle(BUNDLE_ID);
	}

	private static Options mkParserOpts(ResourceBundle msgs) {
		Options parserOpts = new Options();

		Option[] opts = { mkHelpOpt(msgs), mkSetupOpt(msgs),
				mkExecuteOpt(msgs), mkVerboseOpt(msgs) };
		for (Option opt : opts) {
			parserOpts.addOption(opt);
		}

		return parserOpts;
	}

	private static void exitOnCmdLineError(CommandLine cmd, Options parserOpts) {
		boolean noArgs = cmd.getArgList().isEmpty();
		if (cmd.hasOption("h") || noArgs) {
			printHelp(parserOpts);
			System.exit(0);
		}
	}

	private static void printHelp(Options parserOpts) {
		HelpFormatter formatter = new HelpFormatter();
		String headline = String.format("java %s [OPTION]...",
				ConsoleModelRunner.class.getCanonicalName());
		formatter.printHelp(headline, parserOpts);
	}

	private static Option mkHelpOpt(ResourceBundle msgs) {
		OptionBuilder.withLongOpt("help");
		OptionBuilder.withDescription(msgs.getString("helpOptMsg"));
		return OptionBuilder.create("h");
	}

	private static Option mkSetupOpt(ResourceBundle msgs) {
		OptionBuilder.withLongOpt("setup");
		OptionBuilder.withDescription(msgs.getString("setupOptMsg"));
		return OptionBuilder.create("s");
	}

	private static Option mkExecuteOpt(ResourceBundle msgs) {
		OptionBuilder.withLongOpt("execute");
		OptionBuilder.withDescription(msgs.getString("executeOptMsg"));
		return OptionBuilder.create("e");
	}

	private static Option mkVerboseOpt(ResourceBundle msgs) {
		OptionBuilder.withLongOpt("verbose");
		OptionBuilder.withDescription(msgs.getString("verboseOptMsg"));
		return OptionBuilder.create("v");
	}
}
