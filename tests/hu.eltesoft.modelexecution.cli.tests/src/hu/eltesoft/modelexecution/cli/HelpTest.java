package hu.eltesoft.modelexecution.cli;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.AbstractMap.SimpleEntry;

import org.junit.Test;

public class HelpTest {

	/*
	 * Checks whether the help message contains the necessary texts - The
	 * executable name is printed. - Every option name is printed, both short
	 * and long names.
	 */
	@Test
	public void help() throws Exception {
		SimpleEntry<String, String> output = TestUtils.withRedirectedIO(() -> {
			TestUtils.runCli(2, "-h");
		});

		String stdOut = output.getKey();

		// it will always be started from a jar, hence the runner name
		assertThat("Help message contains executable name", stdOut, containsString(TestUtils.runnerName));

		for (Opt opt : Opt.values()) {
			String optShortName = "-" + opt.shortName;
			assertThat("Has option " + optShortName, stdOut, containsString(optShortName));

			String optLongName = "--" + opt.longName;
			assertThat("Has option " + optLongName, stdOut, containsString(optLongName));
		}
	}
}
