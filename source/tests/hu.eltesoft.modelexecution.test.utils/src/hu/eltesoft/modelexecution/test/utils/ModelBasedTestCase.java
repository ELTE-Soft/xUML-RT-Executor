package hu.eltesoft.modelexecution.test.utils;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.Before;

public abstract class ModelBasedTestCase {

	protected final String modelPath;

	protected Resource resource;
	protected Model model;

	protected ModelBasedTestCase(String modelPath) {
		this.modelPath = modelPath;
	}

	@Before
	public void setUp() {
		resource = loadResource(modelPath);
		model = loadModel(resource);
	}

	public Resource loadResource(String path) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI,
				UMLPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		URI uri = URI.createFileURI(path);
		return resourceSet.getResource(uri, true);
	}

	public Model loadModel(Resource resource) {
		List<EObject> contents = resource.getContents();
		for (EObject eobj : contents) {
			if (eobj instanceof Model) {
				return (Model) eobj;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T extends NamedElement> T namedChild(EObject parent,
			java.lang.Class<T> type, String name) {
		for (EObject child : parent.eContents()) {
			if (type.isInstance(child)
					&& ((NamedElement) child).getName().equals(name)) {
				return (T) child;
			}
		}
		return null;
	}
}
