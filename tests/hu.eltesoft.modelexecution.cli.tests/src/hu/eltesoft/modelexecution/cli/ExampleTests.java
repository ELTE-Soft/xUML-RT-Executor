package hu.eltesoft.modelexecution.cli;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.ImmutableList;

public class ExampleTests extends ModelBasedTests {

	private static final Path EXAMPLE_MODELS_DIR = Paths.get("..", "..", "plugins",
			"hu.eltesoft.modelexecution.examples", "resources");

	private static final List<Object[]> MODELS_AND_FUNCTIONS = ImmutableList.<Object[]> builder()
			.add(new Object[] { "HelloWorld", "run", true }).add(new Object[] { "Loop", "feed", false })
			.add(new Object[] { "Machine", "feed", true }).add(new Object[] { "Phone", "feed", false }).build();

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
