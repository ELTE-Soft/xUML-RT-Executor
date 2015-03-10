package hu.eltesoft.modelexecution.m2t.smap.emf;

import hu.eltesoft.modelexecution.m2t.smap.emf.xmi.XMILocationRegistry;
import hu.eltesoft.modelexecution.m2t.smap.xtend.DataWithLocation;
import hu.eltesoft.modelexecution.m2t.smap.xtend.Location;
import hu.eltesoft.modelexecution.m2t.smap.xtend.TraceExtensions;

import org.eclipse.emf.ecore.EObject;

/**
 * Extension methods to be used in templates annotated with
 * SourceMappedTemplate. These methods enable assigning a source position to
 * each EMF object. It is recommended to use this class as an extension.
 */
public class EmfTraceExtensions extends TraceExtensions {

	private LocationRegistry registry = new XMILocationRegistry();

	public <T> DataWithLocation<T> trace(EObject object, T data) {
		return trace(object, LocationQualifier.None.class, data);
	}

	public <T> DataWithLocation<T> trace(EObject object,
			Class<? extends LocationQualifier> classifier, T data) {
		Location location = registry.assignQualified(object, classifier);
		return trace(location, data);
	}
}
