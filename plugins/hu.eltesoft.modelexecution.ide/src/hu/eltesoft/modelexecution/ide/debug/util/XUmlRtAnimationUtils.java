package hu.eltesoft.modelexecution.ide.debug.util;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.registry.ModelElementsRegistry;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;

public class XUmlRtAnimationUtils {
	private static final String ERRMSG_MODEL_ELEMENT_IS_NULL = "Model element is null";
	private static final String ERRMSG_MISSING_DIAGRAM = "Diagrams are missing for element ";

	/** Indicates whether a suspended marker is applied to a model element. */
	private boolean hasSuspendedMarker = false;
	
	/**
	 * We always have at most one object with the marker. If {@code null}, no
	 * object currently has the marker.
	 */
	private EObject previousAnimatedEObject = null;
	private ModelElementsRegistry modelElementsRegistry;
	
	public XUmlRtAnimationUtils(EObject eObjectToExecute, ModelElementsRegistry modelElementsRegistry) {
		AnimationUtils.init(eObjectToExecute);
		this.modelElementsRegistry = modelElementsRegistry;
	}

	/**
	 * This method should only be called in init, otherwise it freezes up the
	 * GUI.
	 */
	public static void initForAnimation(EObject modelElement,
			Set<EObject> initialisedContainers) {
		if (modelElement == null) {
			IdePlugin.logError(ERRMSG_MODEL_ELEMENT_IS_NULL);
			return;
		}

		if (initialisedContainers.contains(modelElement)) {
			return;
		}

		// resolving EObject proxies here as animation depends on their eResource
		if (modelElement.eIsProxy()) {
			modelElement = AnimationUtils.resolve(modelElement);

			if (initialisedContainers.contains(modelElement)) {
				return;
			}
		}

		AnimationUtils.init(modelElement);
		initialisedContainers.add(modelElement);

		if (!AnimationUtils.getInstance().diagramsExistFor(modelElement)) {
			IdePlugin.logError(ERRMSG_MISSING_DIAGRAM + modelElement);
		}
	}

	/** Removes both animation and suspension markers from all model elements. */
	public void removeAllMarkers() {
		removeAllSuspendedMarkers();
		removeAllAnimationMarkers();
	}
	
	/**
	 * Removes all suspended markers.
	 */
	public void removeAllSuspendedMarkers() {
		if (hasSuspendedMarker) {
			AnimationUtils.getInstance().removeSuspendedMarker(null);
		}
		hasSuspendedMarker = false;
	}

	/** Removes animation markers from all model elements. */
	public void removeAllAnimationMarkers() {
		for (EObject modelElement : modelElementsRegistry.getAll()) {
			AnimationUtils.getInstance().removeAnimationMarker(modelElement);
		}
	}

	/**
	 * Removes both animation and suspension markers that were previously
	 * placed. Does not traverse all model elements.
	 */
	public void removeAllPreviousMarkers() {
		removeAllSuspendedMarkers();
		removePreviousAnimationMarker();
	}

	/**
	 * Unlits the previously lit model element. Does nothing if no previous
	 * element was lit.
	 */
	public void removePreviousAnimationMarker() {
		if (previousAnimatedEObject == null)
			return;
		
		AnimationUtils.getInstance()
				.removeAnimationMarker(previousAnimatedEObject);
		previousAnimatedEObject = null;
	}

	/**
	 * The {@code modelElement} is lit with the animation marker. Ensures that
	 * no other model element is lit with either the animation or the suspended
	 * marker.
	 */
	public void setAnimationMarker(EObject modelElement) {
		modelElement = ModelUtils.resolve(modelElement);

		if (previousAnimatedEObject == modelElement
				&& AnimationUtils.getInstance().isAnimationMarkerApplied(
						previousAnimatedEObject)) {
			return;
		}
	
		removeAllPreviousMarkers();
		AnimationUtils.getInstance().addAnimationMarker(modelElement);
		previousAnimatedEObject = modelElement;
	}

	
	/**
	 * The {@code modelElement} is lit with the suspended marker. Ensures that
	 * no other model element is lit with either the animation or the suspended
	 * marker.
	 */
	public void setSuspendedMarker(EObject modelElement) {
		modelElement = ModelUtils.resolve(modelElement);

		removeAllPreviousMarkers();
		AnimationUtils.getInstance().addSuspendedMarker(modelElement);
		hasSuspendedMarker = true;
	}


}
