package hu.eltesoft.modelexecution.cli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.AbstractMap.SimpleEntry;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import com.google.common.io.Files;

@RunWith(Parameterized.class)
public abstract class ModelBasedTests {

	@Rule
	public final TemporaryFolder baseFolder = new TemporaryFolder();

	@Parameter(0)
	public File umlFile;

	@Parameter(1)
	public String mainClass;

	@Parameter(2)
	public String mainFunction;

	@Parameter(3)
	public boolean isTerminating;

	protected File srcFolder;
	protected File buildFolder;

	@Before
	public void before() throws Throwable {
		srcFolder = baseFolder.newFolder("src");
		buildFolder = baseFolder.newFolder("build");

		srcFolder.mkdirs();
		buildFolder.mkdirs();
	}

	@After
	public void after() {
		srcFolder.delete();
		buildFolder.delete();
	}

	@Test
	public void compileAndRun() throws Exception {
		File targetFile = srcFolder.toPath().resolve(umlFile.getName()).toFile();
		Files.copy(umlFile, targetFile);
		String modelPath = targetFile.getPath();
		String modelDir = buildFolder.getPath();

		SimpleEntry<String, String> output = TestUtils.withRedirectedIO(() -> {
			TestUtils.runCli(10 * 60, "-s", modelPath, "-r", modelDir);
		});
		assertEquals("Standard output after compilation must be empty", "", output.getKey());
		assertEquals("Standard error after compilation must be empty", "", output.getValue());

		output = TestUtils.withRedirectedIO(() -> {
			boolean terminated = TestUtils.runCli(10, "-e", mainClass, mainFunction, "-r", modelDir);
			assertEquals("Termination property failed by timeout", isTerminating, terminated);
		});
		checkSuccessfulTermination(output);
		validateRunnerOutput(output);
	}

	private void checkSuccessfulTermination(SimpleEntry<String, String> output) {
		boolean containsTerminationLog = output.getValue().contains("INFO: Execution terminated successfully");
		if (isTerminating) {
			assertTrue("Log does not indicate successful termination", containsTerminationLog);
		} else {
			assertFalse("Log indicates termination for a non-terminating model", containsTerminationLog);
		}
	}

	protected void validateRunnerOutput(SimpleEntry<String, String> output) {
		assertNotEquals("Standard error after compilation must not be empty", "", output.getValue());
		assertEquals("Standard output after compilation must be empty", "", output.getKey());
	}
}
