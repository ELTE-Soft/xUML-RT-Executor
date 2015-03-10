package hu.eltesoft.modelexecution.m2t.smap.emf;

import org.eclipse.emf.ecore.EObject;

/**
 * An EMF object with its location qualifier. For unqualified locations, use
 * LocationQualifier.None.
 */
public class QualifiedEObject {

	private final EObject eObject;
	private final Class<? extends LocationQualifier> qualifier;

	public EObject getEObject() {
		return eObject;
	}

	public Class<? extends LocationQualifier> getQualifier() {
		return qualifier;
	}

	public QualifiedEObject(EObject eObject,
			Class<? extends LocationQualifier> qualifier) {
		this.eObject = eObject;
		this.qualifier = qualifier;
	}

	/**
	 * @return Whether this object has the specified qualifier. It compares the
	 *         canonical names of the classifier interfaces.
	 */
	public boolean isQualifieddAs(Class<? extends LocationQualifier> other) {
		return qualifier.getCanonicalName().equals(other.getCanonicalName());
	}

	public boolean isUnqualified() {
		return isQualifieddAs(LocationQualifier.None.class);
	}
}
