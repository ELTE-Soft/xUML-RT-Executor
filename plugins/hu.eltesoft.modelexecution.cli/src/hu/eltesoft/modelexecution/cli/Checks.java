package hu.eltesoft.modelexecution.cli;

import java.io.File;
import java.util.Set;

import org.apache.commons.cli.CommandLine;

import hu.eltesoft.modelexecution.cli.exceptions.BadArgCountException;
import hu.eltesoft.modelexecution.cli.exceptions.BadDirectoryException;
import hu.eltesoft.modelexecution.cli.exceptions.BadFileException;
import hu.eltesoft.modelexecution.cli.exceptions.DanglingArgumentsException;
import hu.eltesoft.modelexecution.cli.exceptions.IncompatibleOptsException;
import hu.eltesoft.modelexecution.cli.exceptions.NothingToDoException;
import hu.eltesoft.modelexecution.cli.exceptions.UnknownArgForOptException;
import hu.eltesoft.modelexecution.cli.logger.Loggers;

public class Checks {
	public static void checkOptionsValidity(CommandLine cmd) {
		checkMissingRequiredOptions(cmd);

		checkUnknownLoggerType(cmd);

		checkNothingToDo(cmd);

		boolean rootDirIsNeeded = Opt.EXECUTE.isPresent(cmd);
		boolean rootDirIsAutocreated = Opt.SETUP.isPresent(cmd);
		if (rootDirIsNeeded && !rootDirIsAutocreated) {
			checkIsParameterDir(cmd, Opt.ROOT, 0);
		}

		checkIsParameterDir(cmd, Opt.WRITE_TRACE, 0);
		checkIsParameterDir(cmd, Opt.READ_TRACE, 0);

		checkIsParameterFile(cmd, Opt.SETUP, 0);

		checkArgCount(cmd, Opt.EXECUTE, 2);

		checkNoDanglingArg(cmd);
	}

	private static void checkNoDanglingArg(CommandLine cmd) {
		String[] danglingArgs = cmd.getArgs();
		if (danglingArgs.length > 0) {
			throw new DanglingArgumentsException(danglingArgs, ConsoleModelRunner.getOptions());
		}
	}

	private static void checkArgCount(CommandLine cmd, Opt opt, int expectedArgCount) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		int foundArgCount = opt.getOptions(cmd).get().length;
		if (foundArgCount != expectedArgCount) {
			throw new BadArgCountException(opt.getPresentName(cmd).get(), foundArgCount, expectedArgCount, ConsoleModelRunner.getOptions());
		}
	}

	private static void checkIsParameterFile(CommandLine cmd, Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String model = opt.getOption(cmd, idx).get();
		if (!new File(model).canRead()) {
			throw new BadFileException(opt.getPresentName(cmd).get(), model, ConsoleModelRunner.getOptions());
		}
	}

	private static void checkIsParameterDir(CommandLine cmd, Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String root = opt.getOption(cmd, idx).get();
		if (!new File(root).isDirectory()) {
			throw new BadDirectoryException(opt.getPresentName(cmd).get(), root, ConsoleModelRunner.getOptions());
		}
	}

	private static void checkMissingRequiredOptions(CommandLine cmd) {
		Set<Opt> presentOpts = Utils.getPresentOpts(cmd);
		for (Opt opt : presentOpts) {
			if (opt.requiredOpts.isEmpty()) {
				continue;
			}

			boolean hasRequiredOpt = opt.requiredOpts.stream().anyMatch(opt2 -> opt2.isPresent(cmd));
			if (!hasRequiredOpt) {
				throw new IncompatibleOptsException(opt, ConsoleModelRunner.getOptions());
			}
		}
	}

	private static void checkNothingToDo(CommandLine cmd) {
		boolean isAtLeastOneOptPresent = ConsoleModelRunner.getActionOpts().stream().anyMatch(opt -> cmd.hasOption(opt));
		if (!isAtLeastOneOptPresent) {
			throw new NothingToDoException();
		}
	}

	/**
	 * This check is only activated when the user enters a logger type. Checks
	 * if the entered logger type is unknown.
	 * @param cmd 
	 */
	private static void checkUnknownLoggerType(CommandLine cmd) {
		if (!Opt.LOGGER.isPresent(cmd)) {
			return;
		}

		String userLoggerType = Opt.LOGGER.getOption(cmd, 0).get();
		if (Loggers.hasLoggerName(userLoggerType)) {
			return;
		}

		throw new UnknownArgForOptException(userLoggerType, Opt.LOGGER, ConsoleModelRunner.getOptions());
	}
}
