package hu.eltesoft.modelexecution.cli;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;

public class SystemTests extends ModelBasedTests {

	// TODO: maintain this list according to system tests
	private static final Set<String> EXCLUDED_TESTS = ImmutableSet.<String> builder().add("AssociationClass").build();

	private static final String TESTER_UML_FILE_NAME = "Tester.uml";

	private static final Path TRUNK_SYSTEM_MODELS_DIR = Paths.get("..", "..", "..", "testing", "TestModels");
	private static final Path BRANCH_SYSTEM_MODELS_DIR = Paths.get("..", "..", "..", "..", "testing", "TestModels");

	private static File systemModelsDir;

	@Before
	@Override
	public void before() throws Throwable {
		super.before();

		// copy Tester.uml to source folder
		File targetFile = srcFolder.toPath().resolve(TESTER_UML_FILE_NAME).toFile();
		File testerFile = systemModelsDir.toPath().resolve(TESTER_UML_FILE_NAME).toFile();
		Files.copy(testerFile, targetFile);

		// copy external entity implementation to build folder
		try (InputStream eeStream = getClass().getClassLoader().getResourceAsStream("TesterImpl.class")) {
			byte[] eeBytes = ByteStreams.toByteArray(eeStream);
			targetFile = buildFolder.toPath().resolve("TesterImpl.class").toFile();
			Files.write(eeBytes, targetFile);
		}
	}

	@Override
	protected void validateRunnerOutput(SimpleEntry<String, String> output) {
		assertNotEquals("Standard error after compilation must not be empty", "", output.getValue());
		assertFalse("Explicit model test failure", output.getKey().startsWith("failure"));
		assertTrue("Implicit model test failure", output.getKey().startsWith("success"));
	}

	@Parameters(name = "{0}")
	public static Collection<Object[]> getParameters() {
		File trunkDir = TRUNK_SYSTEM_MODELS_DIR.toFile();
		File branchDir = BRANCH_SYSTEM_MODELS_DIR.toFile();
		systemModelsDir = trunkDir.exists() ? trunkDir : branchDir;

		Stream<File> umlFiles = Arrays.stream(systemModelsDir.listFiles()).filter(file -> {
			String name = file.getName();
			if (TESTER_UML_FILE_NAME.equals(name)) {
				return false;
			}
			if (name.endsWith(".uml")) {
				// drop extension
				String testName = name.substring(0, name.length() - 4);
				if (!EXCLUDED_TESTS.contains(testName)) {
					return true;
				}
			}
			return false;

		});
		return umlFiles.map(file -> {
			Object[] params = new Object[4];
			params[0] = file;
			params[1] = "Test";
			params[2] = "run";
			params[3] = true;
			return params;
		}).collect(Collectors.toList());
	}
}
