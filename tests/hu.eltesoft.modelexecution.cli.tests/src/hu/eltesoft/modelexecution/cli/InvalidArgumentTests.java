package hu.eltesoft.modelexecution.cli;

import java.io.IOException;

import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.junit.Test;

import hu.eltesoft.modelexecution.cli.exceptions.BadArgCountException;
import hu.eltesoft.modelexecution.cli.exceptions.BadDirectoryException;
import hu.eltesoft.modelexecution.cli.exceptions.BadFileException;
import hu.eltesoft.modelexecution.cli.exceptions.DanglingArgumentsException;
import hu.eltesoft.modelexecution.cli.exceptions.IncompatibleOptsException;
import hu.eltesoft.modelexecution.cli.exceptions.NothingToDoException;
import hu.eltesoft.modelexecution.cli.exceptions.UnknownArgForOptException;

/*
 * Tests invalid arguments. All of these will throw a subclass of {@link IllegalArgumentException}.
 */
public class InvalidArgumentTests {
	@Test(expected = NothingToDoException.class)
	public void nothingToDo() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("");
	}

	@Test(expected = ParseException.class)
	public void setupArgIsMissing() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-s");
	}

	@Test(expected = BadFileException.class)
	public void setupBadArg() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-s notExistingFile");
	}

	@Test(expected = IncompatibleOptsException.class)
	public void wtrRequiresExecute() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-wtr someArg");
	}

	@Test(expected = IncompatibleOptsException.class)
	public void rtrRequiresExecute() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-rtr someArg");
	}

	@Test(expected = IncompatibleOptsException.class)
	public void rtrRequiresExecute2() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-rtr someArg -s someArg");
	}

	@Test(expected = IncompatibleOptsException.class)
	public void rootRequiresSetupOrExecute() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-r someArg");
	}

	@Test(expected = IncompatibleOptsException.class)
	public void loggerRequiresExecute() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-l someArg");
	}

	@Test(expected = UnknownArgForOptException.class)
	public void loggerInvalidArg() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-l invalidArg -e someArg");
	}

	@Test(expected = BadArgCountException.class)
	public void executeBadArgCount1() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-e someArg");
	}

	@Test(expected = DanglingArgumentsException.class)
	public void danglingArgs() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("dangling1 -e someArg someArg2 dangling2");
	}

	@Test(expected = BadDirectoryException.class)
	public void invalidDirRoot() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-r invalidDir -e someArg someArg2");
	}

	@Test(expected = BadDirectoryException.class)
	public void invalidDirWtr() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-rtr invalidDir -e someArg someArg2");
	}

	@Test(expected = BadDirectoryException.class)
	public void invalidDirRtr() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-rtr invalidDir -e someArg someArg2");
	}

	@Test(expected = BadFileException.class)
	public void invalidFileSetup() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-s invalidFile");
	}

	@Test(expected = UnknownArgForOptException.class)
	public void invalidLoggerValue() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-l invalidValue -e someArg someArg2");
	}

	@Test(expected = UnrecognizedOptionException.class)
	public void invalidArgument() throws ParseException, IOException, InterruptedException {
		TestUtils.runCli("-unknownArgument");
	}
}
