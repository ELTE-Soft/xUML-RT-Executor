package hu.eltesoft.modelexecution.m2m.metamodel.base;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.NamedElement;

import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;

public class NamedReference extends Reference {

	private static final long serialVersionUID = 3423026481019864065L;

	/**
	 * Clone an existing reference with empty name.
	 */
	public static NamedReference fromUnnamed(Reference reference) {
		return new NamedReference(reference);
	}

	/**
	 * Calculate the identifier for an EMF object without creating a reference.
	 */
	public static String getIdentifier(EObject referencedElement) {
		if (null == referencedElement.eResource()) {
			// EObject identifier is unavailable after it is unlinked from its
			// containing resource.
			return null;
		}
		return uuidToIdentifier(toURIString(referencedElement));
	}

	/**
	 * Converts a UUID to a valid Java identifier.
	 */	
	private static String uuidToIdentifier(String uuid) {
		// The fragment is a generated UUID. As hyphens are not valid in Java
		// identifiers, they are replaced by dollar signs.
		return uuidToJavaId(URI.createURI(uuid).fragment());
	}
	
	/**
	 * Converts a UUID fragment to a valid Java identifier.
	 */	
	private static String uuidToJavaId(String uuid) {
		// The fragment is a generated UUID. As hyphens are not valid in Java
		// identifiers, they are replaced by dollar signs.
		return uuid.replace('-', '$');
	}
	
	/**
	 * Converts a valid Java identifier to the original UUID fragment.
	 */
	public static String javaIDToUUID(String identifier) {
		return identifier.replace('$', '-');
	}

	private final String originalName;
	private final String identifier;

	public NamedReference(EObject referencedElement, String originalName) {
		super(referencedElement);
		this.originalName = originalName;
		identifier = uuidToIdentifier(uriString);
	}

	public NamedReference(NamedElement referencedElement) {
		this(referencedElement, referencedElement.getName());
	}

	/**
	 * Used only by fromUnnamed. Hidden to prevent clashes with the other unary
	 * constructor.
	 */
	private NamedReference(Reference reference) {
		super(reference);
		originalName = "";
		identifier = uuidToIdentifier(uriString);
	}

	public String getOriginalName() {
		return originalName;
	}

	public String getIdentifier() {
		return identifier;
	}
}
