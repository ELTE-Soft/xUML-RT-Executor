package hu.eltesoft.modelexecution.ide.debug.util;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2t.java.StateQualifiers;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier.None;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * Contains utility functions that access the UML model. Should be kept as small
 * as possible.
 */
public class ModelUtils {

	public static Class<? extends LocationQualifier> defaultQualifierFor(
			EObject modelElement) {
		if (modelElement instanceof Pseudostate) {
			return StateQualifiers.Exit.class;
		} else if (modelElement instanceof State) {
			return StateQualifiers.Entry.class;
		}
		return None.class;
	}

	public static String getContainerName(EObject modelElement) {
		NamedElement container = (NamedElement) getContainer(modelElement);
		return new NamedReference(container, container.getName())
				.getIdentifier();
	}

	public static EObject getContainer(EObject modelElement) {
		while (!isContainer(modelElement)) {
			modelElement = ((Element) modelElement).getOwner();
		}

		return modelElement;
	}

	public static boolean isContainer(EObject modelElement) {
		return (modelElement instanceof Region)
				|| (modelElement instanceof org.eclipse.uml2.uml.Class);
	}

	/**
	 * Currently, states (including the initial state) and transitions are
	 * supported.
	 */
	public static boolean isSupportedNode(EObject modelElement) {
		return modelElement instanceof Vertex
				|| modelElement instanceof Transition;
	}

	/**
	 * @param eObjectToExecute
	 *            A {@code Region} model element.
	 * @return a stream of the contained nodes of the region that are supported.
	 */
	public static Stream<EObject> getSupportedContentNodes(
			EObject eObjectToExecute) {
		final Iterable<EObject> iterable = () -> eObjectToExecute
				.eAllContents();
		return StreamSupport.stream(iterable.spliterator(), false).filter(
				ModelUtils::isSupportedNode);
	}
}
