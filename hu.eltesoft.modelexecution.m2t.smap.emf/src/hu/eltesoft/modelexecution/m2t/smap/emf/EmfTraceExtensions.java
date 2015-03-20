package hu.eltesoft.modelexecution.m2t.smap.emf;

import hu.eltesoft.modelexecution.m2t.smap.xtend.DataWithLocation;
import hu.eltesoft.modelexecution.m2t.smap.xtend.Location;
import hu.eltesoft.modelexecution.m2t.smap.xtend.TraceExtensions;

import org.eclipse.emf.ecore.EObject;

/**
 * Extension methods to be used in templates annotated with
 * {@link hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
 * SourceMappedTemplate}. These methods enable assigning a source position to
 * each EMF object. It is recommended to inherit generators from this class.
 */
public class EmfTraceExtensions extends TraceExtensions {

	private final LocationRegistry registry = new LocationRegistry();

	public LocationRegistry getLocationRegistry() {
		return registry;
	}

	public DataWithLocation<String> trace(Reference reference) {
		return trace(reference, LocationQualifier.None.class);
	}

	public DataWithLocation<String> trace(Reference reference,
			Class<? extends LocationQualifier> classifier) {
		Location location = registry.assignQualified(reference, classifier);
		return trace(location, "");
	}

	public <T> DataWithLocation<T> trace(EObject object, T data) {
		return trace(object, LocationQualifier.None.class, data);
	}

	public <T> DataWithLocation<T> trace(EObject object,
			Class<? extends LocationQualifier> classifier, T data) {
		Reference reference = new Reference(object);
		Location location = registry.assignQualified(reference, classifier);
		return trace(location, data);
	}
}
