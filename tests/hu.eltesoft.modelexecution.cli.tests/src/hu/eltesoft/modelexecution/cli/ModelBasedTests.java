package hu.eltesoft.modelexecution.cli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
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

	private File srcFolder;
	private File buildFolder;

	@Before
	public void before() throws IOException {
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
		// standard error and output are both empty
		assertTrue("Standard output after compilation must be empty", output.getKey().isEmpty());
		assertTrue("Standard error after compilation must be empty", output.getValue().isEmpty());

		output = TestUtils.withRedirectedIO(() -> {
			boolean terminated = TestUtils.runCli(10, "-e", mainClass, mainFunction, "-r", modelDir);
			assertEquals("Termination property failed by timeout", isTerminating, terminated);
		});
		// standard error must not be empty
		assertFalse("Standard error after compilation must not be empty", output.getValue().isEmpty());
		boolean containsTerminationLog = output.getValue().contains("INFO: Execution terminated successfully");
		assertEquals("Termination property failed by logging", isTerminating, containsTerminationLog);
		// standard output must be empty
		assertTrue("Standard output after compilation must be empty", output.getKey().isEmpty());
	}
}
