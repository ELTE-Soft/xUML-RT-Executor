package hu.eltesoft.modelexecution.cli;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.AbstractMap.SimpleEntry;

import org.junit.Ignore;
import org.junit.Test;

// FIXME: re-enable when the expectation for executable name is correct
@Ignore
public class HelpTest {

	/*
	 * Checks whether the help message contains the necessary texts
	 * - The executable name is printed.
	 * - Every option name is printed, both short and long names.
	 */
	@Test
	public void help() throws Exception {
		SimpleEntry<String, String> output = TestUtils.withRedirectedIO(() -> {
			TestUtils.runCli(2, "-h");
		});

		String stdOut = output.getKey();

		assertThat("Help message contains executable name", stdOut, containsString(Utils.getProgramName()));

		for (Opt opt : Opt.values()) {
			String optShortName = "-" + opt.shortName;
			assertThat("Has option " + optShortName, stdOut, containsString(optShortName));

			String optLongName = "--" + opt.longName;
			assertThat("Has option " + optLongName, stdOut, containsString(optLongName));
		}
	}
}
