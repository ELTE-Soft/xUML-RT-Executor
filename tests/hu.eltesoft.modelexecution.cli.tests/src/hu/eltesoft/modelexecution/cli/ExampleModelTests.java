package hu.eltesoft.modelexecution.cli;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.ImmutableList;

public class ExampleModelTests extends ModelBasedTests {

	private static final Path EXAMPLE_MODELS_DIR = Paths.get("..", "..", "plugins",
			"hu.eltesoft.modelexecution.examples", "resources");

	// fields of a single item:
	// - main class name (same as file name without extension)
	// - main function name
	// - whether it is a terminating model
	private static final List<Object[]> MODELS_AND_FUNCTIONS = ImmutableList.<Object[]> builder()
			.add(new Object[] { "HelloWorld", "run", true }).add(new Object[] { "Machine", "feed", true }).build();

	// WARNING: do not run non-terminating models, as unfortunately it is not
	// guaranteed now that the process gets killed by invoking destroyForcibly
	// .add(new Object[] { "Loop", "feed", false })
	// .add(new Object[] { "Phone", "feed", false })

	@Parameters(name = "{1}")
	public static Collection<Object[]> getParameters() {
		return MODELS_AND_FUNCTIONS.stream().map(item -> {
			Object[] params = new Object[4];
			params[0] = EXAMPLE_MODELS_DIR.resolve(item[0] + ".uml").toFile();
			params[1] = item[0];
			params[2] = item[1];
			params[3] = item[2];
			return params;
		}).collect(Collectors.toList());
	}
}
