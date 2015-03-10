package hu.eltesoft.modelexecution.m2t.smap.emf.xmi;

import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier;

/**
 * Encapsulates an XMI identifier with a qualifier. Object instances of this
 * class are compared for equality by comparing the identifier values and the
 * canonical names of the qualified classes. Invariant: both field must contain
 * a valid objects, thus null references are not allowed.
 */
class QualifiedXMIId {
	private final String uuid;
	private final Class<? extends LocationQualifier> qualifier;

	public String getUuid() {
		return uuid;
	}

	public Class<? extends LocationQualifier> getQualifier() {
		return qualifier;
	}

	public QualifiedXMIId(String uuid,
			Class<? extends LocationQualifier> qualifier) {
		this.uuid = uuid;
		this.qualifier = qualifier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + qualifier.getName().hashCode();
		result = prime * result + uuid.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		QualifiedXMIId other = (QualifiedXMIId) obj;
		return uuid.equals(other.uuid)
				&& qualifier.getCanonicalName().equals(
						other.qualifier.getCanonicalName());
	}
}
