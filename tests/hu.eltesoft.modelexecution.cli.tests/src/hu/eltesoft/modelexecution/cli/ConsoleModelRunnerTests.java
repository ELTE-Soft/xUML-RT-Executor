package hu.eltesoft.modelexecution.cli;

import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.Before;
import org.junit.Test;

import hu.eltesoft.modelexecution.cli.exceptions.BadArgCountException;
import hu.eltesoft.modelexecution.cli.exceptions.BadDirectoryException;
import hu.eltesoft.modelexecution.cli.exceptions.BadFileException;
import hu.eltesoft.modelexecution.cli.exceptions.DanglingArgumentsException;
import hu.eltesoft.modelexecution.cli.exceptions.IncompatibleOptsException;
import hu.eltesoft.modelexecution.cli.exceptions.NothingToDoException;
import hu.eltesoft.modelexecution.cli.exceptions.UnknownArgForOptException;

public class ConsoleModelRunnerTests {

	Options parserOpts;

	@Before
	public void before() {
		parserOpts = ConsoleModelRunner.mkParserOpts();
	}

	private void runCli(String argsTxt) throws ParseException {
		String[] args = argsTxt.split(" ");
		ConsoleModelRunner.doCli(args, parserOpts);
	}

	@Test(expected = NothingToDoException.class)
	public void nothingToDo() throws ParseException {
		runCli("");
	}

	@Test(expected = ParseException.class)
	public void setupArgIsMissing() throws ParseException {
		runCli("-s");
	}

	@Test(expected = BadFileException.class)
	public void setupBadArg() throws ParseException {
		runCli("-s notExistingFile");
	}

	@Test(expected = IncompatibleOptsException.class)
	public void wtrRequiresExecute() throws ParseException {
		runCli("-wtr someArg");
	}

	@Test(expected = IncompatibleOptsException.class)
	public void rtrRequiresExecute() throws ParseException {
		runCli("-rtr someArg");
	}

	@Test(expected = IncompatibleOptsException.class)
	public void rtrRequiresExecute2() throws ParseException {
		runCli("-rtr someArg -s someArg");
	}

	@Test(expected = IncompatibleOptsException.class)
	public void rootRequiresSetupOrExecute() throws ParseException {
		runCli("-r someArg");
	}

	@Test(expected = IncompatibleOptsException.class)
	public void loggerRequiresExecute() throws ParseException {
		runCli("-l someArg");
	}

	@Test(expected = UnknownArgForOptException.class)
	public void loggerInvalidArg() throws ParseException {
		runCli("-l invalidArg -e someArg");
	}

	@Test(expected = BadArgCountException.class)
	public void executeBadArgCount1() throws ParseException {
		runCli("-e someArg");
	}

	@Test(expected = DanglingArgumentsException.class)
	public void danglingArgs() throws ParseException {
		runCli("dangling1 -e someArg someArg2 dangling2");
	}

	@Test(expected = BadDirectoryException.class)
	public void invalidDirRoot() throws ParseException {
		runCli("-r invalidDir -e someArg someArg2");
	}

	@Test(expected = BadDirectoryException.class)
	public void invalidDirWtr() throws ParseException {
		runCli("-rtr invalidDir -e someArg someArg2");
	}

	@Test(expected = BadDirectoryException.class)
	public void invalidDirRtr() throws ParseException {
		runCli("-rtr invalidDir -e someArg someArg2");
	}

	@Test(expected = BadFileException.class)
	public void invalidFileSetup() throws ParseException {
		runCli("-s invalidFile");
	}

	@Test(expected = UnknownArgForOptException.class)
	public void invalidLoggerValue() throws ParseException {
		runCli("-l invalidValue -e someArg someArg2");
	}
}
