package hu.eltesoft.modelexecution.m2m.metamodel.base;

import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public class NamedReference extends Reference {

	private static final long serialVersionUID = 3423026481019864065L;

	private final String originalName;
	private final String newIdentifier;

	public NamedReference(EObject referencedElement, String originalName) {
		super(referencedElement);
		this.originalName = originalName;
		newIdentifier = convertIdentifier();
	}

	public NamedReference(Reference reference) {
		super(reference);
		originalName = "";
		newIdentifier = convertIdentifier();
	}

	private String convertIdentifier() {
		// The fragment is a generated UUID. As hyphens are not valid in Java
		// identifiers, they are replaced by dollar signs.
		return URI.createURI(uriString).fragment().replace('-', '$');
	}

	public String getOriginalName() {
		return originalName;
	}

	public String getNewIdentifier() {
		return newIdentifier;
	}
}
