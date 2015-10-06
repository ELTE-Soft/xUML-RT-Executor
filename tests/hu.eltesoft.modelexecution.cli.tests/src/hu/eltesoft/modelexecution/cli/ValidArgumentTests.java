package hu.eltesoft.modelexecution.cli;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// FIXME: correct the tests and re-enable test case
@Ignore

@RunWith(Parameterized.class)
public class ValidArgumentTests {
	@Rule
	public TemporaryFolder baseFolder = new TemporaryFolder();

	File umlFile;
	File srcFolder;
	File buildFolder;

	public ValidArgumentTests(File umlFile) {
		this.umlFile = umlFile;
	}

	@Before
	public void before() throws IOException {
		srcFolder = baseFolder.newFolder("src");
		buildFolder = baseFolder.newFolder("build");

		srcFolder.mkdirs();
		buildFolder.mkdirs();
	}

	@Test
	public void compile() throws Exception {
		SimpleEntry<String, String> output = TestUtils.withRedirectedIO(() -> {
			String modelPath = umlFile.getPath();
			String modelDir = umlFile.getParent();
			TestUtils.runCli("-s", modelPath, "-r", modelDir);
		});
		// standard error and output are both empty
		assertTrue(output.getKey().isEmpty());
		assertTrue(output.getValue().isEmpty());
	}

	@Parameters
	public static Collection<Object[]> getParameters() {
		File testModelsDir = Paths.get("..", "..", "..", "..", "testing", "TestModels").toFile();
		File exampleModelsDir = Paths.get("..", "..", "plugins", "hu.eltesoft.modelexecution.examples", "resources")
				.toFile();

		Collection<Object[]> retval = dirToParams(testModelsDir);
		retval.addAll(dirToParams(exampleModelsDir));
		return retval;
	}

	private static Collection<Object[]> dirToParams(File modelsDir) {
		Predicate<? super File> isUmlFile = file -> file.toString().endsWith(".uml");
		Function<? super File, ? extends Object[]> makeParams = file -> new Object[] { file };
		return Arrays.stream(modelsDir.listFiles()).filter(isUmlFile).map(makeParams).collect(Collectors.toList());
	}
}
