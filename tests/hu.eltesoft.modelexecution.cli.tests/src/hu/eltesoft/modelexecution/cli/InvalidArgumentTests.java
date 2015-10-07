package hu.eltesoft.modelexecution.cli;

import static org.junit.Assert.assertFalse;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
 * Tests invalid arguments. All of these will print an error message to the standard error stream.
 */
@RunWith(Parameterized.class)
public class InvalidArgumentTests {

	private final String arguments;

	public InvalidArgumentTests(String arguments) {
		this.arguments = arguments;
	}

	@Test
	public void tryToRun() throws Exception {
		SimpleEntry<String, String> output = TestUtils.withRedirectedIO(() -> {
			TestUtils.runCli(2, arguments);
		});
		// standard error should not be empty
		assertFalse(output.getValue().isEmpty());
	}

	@Parameters
	public static Collection<Object[]> getParameters() {
		return Arrays
				.asList("", "-s", "-s notExistingFile", "-wtr someArg", "-rtr someArg", "-rtr someArg -s someArg",
						"-r someArg", "-l someArg", "-l invalidArg -e someArg", "-e someArg",
						"dangling1 -e someArg someArg2 dangling2", "-r invalidDir -e someArg someArg2",
						"-rtr invalidDir -e someArg someArg2", "-rtr invalidDir -e someArg someArg2", "-s invalidFile",
						"-l invalidValue -e someArg someArg2", "-unknownArgument")
				.stream().map(args -> new Object[] { args }).collect(Collectors.toList());
	}
}
