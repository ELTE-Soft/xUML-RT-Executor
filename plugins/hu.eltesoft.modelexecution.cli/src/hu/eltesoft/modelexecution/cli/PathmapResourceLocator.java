package hu.eltesoft.modelexecution.cli;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.ResourceLocator;
import org.eclipse.uml2.uml.resource.UMLResource;

public class PathmapResourceLocator extends ResourceLocator {

	private final Map<String, String> uriMapping = new HashMap<>();

	{
		// FIXME: how to reference these files from the actual jar? is this version correct?
		uriMapping.put(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI, "jar:file:libraries/UMLPrimitiveTypes.library.uml");
		uriMapping.put(UMLResource.STANDARD_PROFILE_URI, "jar:file:profiles/Standard.profile.uml");
		
		// FIXME: how to resolve these?
		uriMapping.put("pathmap://PAPYRUS_ACTIONLANGUAGE_PROFILE/ActionLanguage-Profile.profile.uml", "");
		uriMapping.put("pathmap://RALF/library.uml", "");
		
		// FIXME: it seems that the profile is not yet present in the cli jar
		uriMapping.put("pathmap://XUMLRT_PROFILE/xumlrt.profile.uml",
				"jar:file:hu/eltesoft/modelexecution/profile/xumlrt.profile.uml");
	}

	/**
	 * Automatically registers the created resource locator for the given
	 * resource set.
	 */
	public PathmapResourceLocator(ResourceSet resourceSet) {
		super((ResourceSetImpl) resourceSet);
	}

	@Override
	public Resource getResource(URI uri, boolean loadOnDemand) {
		if ("pathmap".equals(uri.scheme())) {
			String uriString = uri.toString();
			System.out.println("PATHMAP URI: " + uriString);
			if (uriMapping.containsKey(uriString)) {
				URI newUri = URI.createURI(uriMapping.get(uriString));
				return basicGetResource(newUri, loadOnDemand);
			} else {
				return new ResourceImpl(uri);
			}
		}
		return basicGetResource(uri, loadOnDemand);
	}
}