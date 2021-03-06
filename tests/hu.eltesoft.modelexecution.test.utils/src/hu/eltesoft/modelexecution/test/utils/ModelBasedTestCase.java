package hu.eltesoft.modelexecution.test.utils;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.Before;

public abstract class ModelBasedTestCase {

	protected final String modelPath;

	protected ModelSet modelSet;
	protected Model model;
	protected boolean usePluginUri = false;

	protected ModelBasedTestCase(String modelPath, boolean usePluginUri) {
		this(modelPath);
		this.usePluginUri = usePluginUri;
	}

	protected ModelBasedTestCase(String modelPath) {
		this.modelPath = modelPath;
	}

	@Before
	public void setUp() {
		modelSet = loadModelSet();
		model = loadModel(modelSet, modelPath);
	}

	public ModelSet loadModelSet() {
		ModelSet modelSet = new ModelSet();
		modelSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		modelSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		modelSet.getResource(createModelUri(modelPath), true);
		return modelSet;
	}

	public Model loadModel(ModelSet modelSet, String modelPath) {
		Resource resource = modelSet.getResource(createModelUri(modelPath), true);
		List<EObject> contents = resource.getContents();
		for (EObject eobj : contents) {
			if (eobj instanceof Model) {
				return (Model) eobj;
			}
		}
		return null;
	}

	private URI createModelUri(String modelPath) {
		return usePluginUri ? URI.createPlatformPluginURI(modelPath, true) : URI.createFileURI(modelPath);
	}

	@SuppressWarnings("unchecked")
	public <T extends NamedElement> T namedChild(EObject parent, java.lang.Class<T> type, String name) {
		for (EObject child : parent.eContents()) {
			if (type.isInstance(child) && ((NamedElement) child).getName().equals(name)) {
				return (T) child;
			}
		}
		return null;
	}
}
