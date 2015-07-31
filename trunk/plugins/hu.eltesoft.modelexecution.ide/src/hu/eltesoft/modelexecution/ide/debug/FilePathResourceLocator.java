package hu.eltesoft.modelexecution.ide.debug;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.ResourceLocator;

public class FilePathResourceLocator extends ResourceLocator {

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
