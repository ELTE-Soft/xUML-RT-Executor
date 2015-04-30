package hu.eltesoft.modelexecution.m2t.smap.emf;

import java.io.Serializable;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Reference to an EObject. Stores the URI of the referenced object. As EMF URI
 * instances are not serializable, it is stored as a single String.
 * 
 * For more information about reference resolution see the documentation of
 * org.eclipse.emf.ecore.resource.impl.ResourceSetImpl. This class takes
 * advantage of the following equation:
 * 
 * <code>
 * URI uri = EcoreUtil.getURI(eObject);
 * eObject == eObject.eResource().getResourceSet().getEObject(uri, false)
 * </code>
 */
public class Reference implements Serializable {

	private static final long serialVersionUID = 4842807564039793980L;

	protected final String uriString;

	public Reference(EObject referencedElement) {
		URI eURI = EcoreUtil.getURI(referencedElement);
		uriString = CommonPlugin.asLocalURI(eURI).toString();
	}

	protected Reference(Reference other) {
		uriString = other.uriString;
	}

	public URI getFileURI() {
		return URI.createURI(uriString).trimFragment();
	}

	public EObject resolve(ResourceSet resourceSet) {
		return resourceSet.getEObject(URI.createURI(uriString), false);
	}

	@Override
	public int hashCode() {
		return uriString.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Reference other = (Reference) obj;
		return uriString.equals(other.uriString);
	}

	@Override
	public String toString() {
		return uriString;
	}
}
