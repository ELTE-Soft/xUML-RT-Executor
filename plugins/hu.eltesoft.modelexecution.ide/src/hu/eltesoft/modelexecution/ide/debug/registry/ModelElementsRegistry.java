package hu.eltesoft.modelexecution.ide.debug.registry;

import hu.eltesoft.modelexecution.ide.debug.util.MapUtils;
import hu.eltesoft.modelexecution.ide.debug.util.ModelUtils;
import hu.eltesoft.modelexecution.ide.debug.util.XUmlRtAnimationUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * Stores which model elements are contained in a top-level element, identified
 * by its class name.
 */
public class ModelElementsRegistry {
	private Map<String, Set<EObject>> elementsForClass = new HashMap<>();
	private Set<EObject> initializedForAnimation = new HashSet<>();

	public ModelElementsRegistry(EObject root) {
		storeModelElements(root);
	}

	private void storeModelElements(EObject root) {
		ModelUtils.getSupportedContentNodes(root).forEach(
				this::storeModelElement);
	}

	private void storeModelElement(EObject modelElement) {
		// FIXME: remove it from here entirely?
		XUmlRtAnimationUtils.initForAnimation(modelElement,
				initializedForAnimation);

		EObject container = ModelUtils.getContainer(modelElement);
		String containerName = ModelUtils.getContainerName(container);
		MapUtils.addElemIntoSet(elementsForClass, containerName, modelElement);
	}

	public void addModelElement(String classname, EObject modelElement) {
		MapUtils.addElemIntoSet(elementsForClass, classname, modelElement);
	}

	/** @return the model elements that belong to the classname */
	public Set<EObject> get(String classname) {
		return elementsForClass.get(classname);
	}

	/** @return all known model elements */
	public Set<EObject> getAll() {
		Set<EObject> retval = new HashSet<>();
		for (Set<EObject> modelElements : elementsForClass.values()) {
			retval.addAll(modelElements);
		}
		return retval;
	}
}
