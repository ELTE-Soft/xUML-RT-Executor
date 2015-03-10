package hu.eltesoft.modelexecution.m2t.smap.emf;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.Before;

public class ModelBasedTests {

	private static final String UML_TEST_MODEL_PATH = "resources/model.uml";

	protected Model model;
	protected EObject aClass;

	@Before
	public void setUp() {
		model = loadModel(UML_TEST_MODEL_PATH);
		aClass = firstClassFoundIn(model);
	}

	public Model loadModel(String path) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI,
				UMLPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		URI uri = URI.createFileURI(path);
		Resource resource = resourceSet.getResource(uri, true);
		List<EObject> contents = resource.getContents();
		for (EObject eobj : contents) {
			if (eobj instanceof Model) {
				return (Model) eobj;
			}
		}
		return null;
	}

	public EObject firstClassFoundIn(Model model) {
		EList<PackageableElement> elems = model.getPackagedElements();
		for (PackageableElement elem : elems) {
			if (elem instanceof Class) {
				return elem;
			}
		}
		return null;
	}
}
