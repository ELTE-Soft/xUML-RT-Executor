package hu.eltesoft.modelexecution.m2t.smap.emf;

import hu.eltesoft.modelexecution.m2t.smap.xtend.Location;

import org.eclipse.emf.ecore.EObject;

/**
 * Provides mapping between EMF objects and virtual locations. Assigning
 * location twice to the same EObject must result equal location objects. This
 * is also true for the qualified version, except that with different qualifiers
 * it must give different locations even for the same object. The unqualified
 * version of an object must be equal to the one that is qualified with
 * LocationQualifier.None.
 */
public interface LocationRegistry {

	public abstract Location assign(EObject object);

	public abstract Location assignQualified(EObject object,
			Class<? extends LocationQualifier> qualified);

	public abstract EObject resolve(Location location);

	public abstract QualifiedEObject resolveQualified(Location location);
}
