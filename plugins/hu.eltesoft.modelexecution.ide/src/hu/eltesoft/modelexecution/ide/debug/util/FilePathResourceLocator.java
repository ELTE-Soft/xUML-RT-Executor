package hu.eltesoft.modelexecution.ide.debug.util;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.ResourceLocator;

/**
 * A resource locator that is able to find the resources if they are given by
 * their file-URIs.
 */
public class FilePathResourceLocator extends ResourceLocator {

	/**
	 * Automatically registers the created resource locator for the given
	 * resource set.
	 */
	public FilePathResourceLocator(ResourceSet resourceSet) {
		super((ResourceSetImpl) resourceSet);
	}

	@Override
	public Resource getResource(URI uri, boolean loadOnDemand) {
		for (Resource resource : resourceSet.getResources()) {
			URI u = resource.getURI();
			if (u.equals(uri) || CommonPlugin.asLocalURI(u).equals(uri)) {
				return resource;
			}
		}
		return null;
	}
}
