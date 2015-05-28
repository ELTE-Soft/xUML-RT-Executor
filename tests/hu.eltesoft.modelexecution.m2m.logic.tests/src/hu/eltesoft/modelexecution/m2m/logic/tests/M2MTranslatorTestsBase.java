package hu.eltesoft.modelexecution.m2m.logic.tests;

import static hu.eltesoft.modelexecution.m2m.logic.tests.Assert.assertAsSets;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

public abstract class M2MTranslatorTestsBase {

	protected static final String PATH_TO_PRINT_GENERATED_FILES = "src-gen";

	protected static final String UML_TEST_SIMPLE_MODEL_PATH = "resources/simple_model.uml";

	protected static final String UML_TEST_2015_Q1_MODEL_PATH = "resources/2015_q1_model.uml";
	protected static final String[] UML_TEST_2015_Q1_MODEL_EXPECTED_FILES = {
			"Class1", "Region1", "Method1", "Entry1", "Exit1", "Effect0",
			"Effect1", "Signal1", "SignalEvent1" };

	protected Model model;

	protected BasicTextChangesListener listener = new BasicTextChangesListener();

	public IncQueryEngine configureEngine(Model model) {
		this.model = model;
		try {
			return IncQueryEngine.on(model);
		} catch (IncQueryException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Resource loadResource(String path) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI,
				UMLPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		URI uri = URI.createFileURI(path);
		Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}

	public Model loadModel(String path) {
		Resource resource = loadResource(path);
		List<EObject> contents = resource.getContents();
		for (EObject eobj : contents) {
			if (eobj instanceof Model) {
				return (Model) eobj;
			}
		}
		return null;
	}

	protected void checkSimpleModelResult() {
		assertEquals(0, listener.deletions.size());
		assertEquals(2, listener.modifications.size());

		assertAsSets(new String[] { "A", "R1" }, listener.modifications.get(0),
				listener.modifications.get(1));
	}
}
