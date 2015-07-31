package hu.eltesoft.modelexecution.m2t.java;

import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier;

/**
 * Location qualifiers for state entry and exit actions.
 */
public interface StateQualifiers {

	public interface Entry extends LocationQualifier {
	}

	public interface Exit extends LocationQualifier {
	}
}
