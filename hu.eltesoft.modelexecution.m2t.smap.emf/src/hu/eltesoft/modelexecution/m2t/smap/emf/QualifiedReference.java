package hu.eltesoft.modelexecution.m2t.smap.emf;

import org.eclipse.emf.ecore.EObject;

/**
 * An EMF object reference with its location qualifier. For unqualified
 * locations, use LocationQualifier.None.
 */
public class QualifiedReference extends Reference {

	private static final long serialVersionUID = 7406317220299885759L;

	private final Class<? extends LocationQualifier> qualifier;

	public QualifiedReference(EObject referencedElement) {
		this(referencedElement, LocationQualifier.None.class);
	}

	public QualifiedReference(EObject referencedElement,
			Class<? extends LocationQualifier> qualifier) {
		super(referencedElement);
		this.qualifier = qualifier;
	}

	public QualifiedReference(Reference reference) {
		this(reference, LocationQualifier.None.class);
	}

	public QualifiedReference(Reference reference,
			Class<? extends LocationQualifier> qualifier) {
		super(reference);
		this.qualifier = qualifier;
	}

	public Class<? extends LocationQualifier> getQualifier() {
		return qualifier;
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

	public Reference asUnqualified() {
		return new Reference(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + qualifier.getCanonicalName().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj) || getClass() != obj.getClass()) {
			return false;
		}
		QualifiedReference other = (QualifiedReference) obj;
		return qualifier.getCanonicalName().equals(
				other.qualifier.getCanonicalName());
	}
}
