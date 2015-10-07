package hu.eltesoft.modelexecution.cli;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.runners.Parameterized.Parameters;

//FIXME: enable test
@Ignore
public class SystemTests extends ModelBasedTests {

	private static final Path TRUNK_SYSTEM_MODELS_DIR = Paths.get("..", "..", "..", "testing", "TestModels");
	private static final Path BRANCH_SYSTEM_MODELS_DIR = Paths.get("..", "..", "..", "..", "testing", "TestModels");

	@Parameters
	public static Collection<Object[]> getParameters() {
		File trunkFile = TRUNK_SYSTEM_MODELS_DIR.toFile();
		File branchFile = BRANCH_SYSTEM_MODELS_DIR.toFile();

		File systemModelsDir = trunkFile.exists() ? trunkFile : branchFile;

		Collection<Object[]> umlFiles = dirToParams(systemModelsDir);
		// do not explicitly compile or run Tester.uml
		umlFiles.removeIf(f -> ((File) f[0]).getName().endsWith("Tester.uml"));
		return umlFiles;
	}

	protected static Collection<Object[]> dirToParams(File modelsDir) {
		Predicate<? super File> isUmlFile = file -> file.toString().endsWith(".uml");
		Function<? super File, ? extends Object[]> makeParams = file -> new Object[] { file };
		return Arrays.stream(modelsDir.listFiles()).filter(isUmlFile).map(makeParams).collect(Collectors.toList());
	}
}
