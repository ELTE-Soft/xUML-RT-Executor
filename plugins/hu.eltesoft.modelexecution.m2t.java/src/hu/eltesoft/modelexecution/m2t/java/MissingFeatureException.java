package hu.eltesoft.modelexecution.m2t.java;

import java.text.MessageFormat;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

import hu.eltesoft.modelexecution.m2m.metamodel.behavior.BehaviorPackage;

/**
 * An exception indicating that a feature cannot be found.
 */
public class MissingFeatureException extends GenerationException {

	private static final long serialVersionUID = 1L;
	private EStructuralFeature feature;
	private EObject containingObject;

	public MissingFeatureException(EStructuralFeature feature, EObject containingObject) {
		this.feature = feature;
		this.containingObject = containingObject;
	}

	@Override
	public String getMessage() {
		if (feature.equals(BehaviorPackage.eINSTANCE.getBhBehavior_ParsingResults())) {
			return getMessageForMissingParsingResults();
		}
		return getMessageNormal();
	}

	private String getMessageNormal() {
		String featureContainerName = feature.getEContainingClass().getName();
		String containerName = ((NamedElement) containingObject).getQualifiedName();
		return MessageFormat.format("Required feature not found: {0} in {1} on `{2}`", feature.getName(),
				featureContainerName, containerName);
	}

	private String getMessageForMissingParsingResults() {
		NamedElement namedObject = getFirstNamedObject((Element) containingObject);
		return MessageFormat.format("Correct rALF code not found for `{0}`", namedObject.getQualifiedName());
	}

	private NamedElement getFirstNamedObject(Element element) {
		while (element != null
				&& (!(element instanceof NamedElement) || ((NamedElement) element).getQualifiedName() == null)) {
			element = element.getOwner();
		}
		return (NamedElement) element;
	}

}