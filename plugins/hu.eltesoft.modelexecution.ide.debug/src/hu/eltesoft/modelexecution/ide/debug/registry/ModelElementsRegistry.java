package hu.eltesoft.modelexecution.ide.debug.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import hu.eltesoft.modelexecution.ide.debug.util.MapUtils;
import hu.eltesoft.modelexecution.ide.debug.util.ModelUtils;

/**
 * Stores which model elements are contained in a top-level element, identified
 * by its class name.
 */
public class ModelElementsRegistry {
	private Map<String, Set<EObject>> elementsForClass = new HashMap<>();

	public ModelElementsRegistry(ResourceSet resourceSet) {
		storeModelElements(resourceSet);
	}

	private void storeModelElements(ResourceSet resourceSet) {
		ModelUtils.getSupportedContentNodes(resourceSet).forEach(n -> storeModelElement((EObject) n));
	}

	private void storeModelElement(EObject modelElement) {
		EObject container = ModelUtils.getContainer(modelElement);
		String containerName = ModelUtils.getContainerName(container);
		MapUtils.addElemIntoSet(elementsForClass, containerName, modelElement);
	}

	public void addModelElement(String classname, EObject modelElement) {
		MapUtils.addElemIntoSet(elementsForClass, classname, modelElement);
	}

	/**
	 * @return the model elements that belong to the class name
	 */
	public Set<EObject> get(String classname) {
		return elementsForClass.get(classname);
	}
}
