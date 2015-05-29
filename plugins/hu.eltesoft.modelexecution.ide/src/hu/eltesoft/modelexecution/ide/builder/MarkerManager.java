package hu.eltesoft.modelexecution.ide.builder;

import hu.eltesoft.modelexecution.ide.IdePlugin;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * A class for handling UML-related markers.
 */
public class MarkerManager {

	public static final String UML_MARKER_ID = "hu.eltesoft.modelexecution.markers.umlProblemMarker";

	/**
	 * Puts an UML marker on the given resource if there is none.
	 */
	public void putMarkerOnResource(IResource resource, String message) {
		try {
			if (resource.findMarkers(UML_MARKER_ID, true, IResource.DEPTH_ZERO).length == 0) {
				IMarker marker = resource.createMarker(UML_MARKER_ID);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				marker.setAttribute(IMarker.MESSAGE, message);
				marker.setAttribute(IMarker.LOCATION, resource.getLocation()
						.toString());
			}
		} catch (CoreException ce) {
			IdePlugin.logError("Cannot set up error markers", ce);
		}
	}

	/**
	 * Removes all UML markers from a resource
	 */
	public void removeUmlMarkersFromResource(IResource resource) {
		try {
			IMarker[] markers = resource.findMarkers(UML_MARKER_ID, true,
					IResource.DEPTH_ZERO);
			for (IMarker marker : markers) {
				marker.delete();
			}
		} catch (CoreException e) {
			IdePlugin.logError("Cannot remove markers from resource", e);
		}
	}

	public void removeMarkersFromProject(IProject project) {
		try {
			IMarker[] markers = project.findMarkers(UML_MARKER_ID, true, IResource.DEPTH_INFINITE);
			for (IMarker marker : markers) {
				marker.delete();
			}
		} catch (CoreException e) {
			IdePlugin.logError("Cannot remove markers from project", e);
		}
	}
	
}