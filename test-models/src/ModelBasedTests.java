
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiConsumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

import junit.framework.TestSuite;

@RunWith(AllTests.class)
public class ModelBasedTests {

	public static TestSuite suite() throws Exception {
		TestSuite suite = new TestSuite("Model-Based Tests");

		Path dir = Paths.get("");
		DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{uml}");
		for (Path entry : stream) {
			ResourceSetImpl models = new ResourceSetImpl();
			models.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
			models.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
					UMLResource.Factory.INSTANCE);
			models.getResource(URI.createFileURI(entry.toAbsolutePath().toString()), true);
			withEachTest(models, (cls, op) -> suite.addTest(new ModelBasedTestCase(entry.toString(), cls, op)));
		}

		return suite;
	}

	private static void withEachTest(ResourceSetImpl models, BiConsumer<Class, Operation> action) {
		models.getAllContents().forEachRemaining(n -> {
			if (n instanceof Operation) {
				Operation op = (Operation) n;
				Class cls = op.getClass_();
				if ("run".equals(op.getName()) && "Test".equals(cls.getName())) {
					action.accept(cls, op);
				}
			}
		});
	}

}