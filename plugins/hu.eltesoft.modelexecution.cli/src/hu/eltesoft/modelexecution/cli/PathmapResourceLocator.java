package hu.eltesoft.modelexecution.cli;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.ResourceLocator;

public class PathmapResourceLocator extends ResourceLocator {

	private List<File> pathmapFolders;

	/**
	 * Automatically registers the created resource locator for the given
	 * resource set.
	 */
	public PathmapResourceLocator(ResourceSet resourceSet, List<File> pathmapFolders) {
		super((ResourceSetImpl) resourceSet);
		this.pathmapFolders = pathmapFolders;
	}
	
	@Override
	public Resource getResource(URI uri, boolean loadOnDemand) {
		if (uri.scheme().equals("pathmap")) {
			String uriFileString = uri.toFileString();
			System.out.println();
		}
		return basicGetResource(uri, loadOnDemand);
	}
}