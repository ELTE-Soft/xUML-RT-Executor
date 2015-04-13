package hu.eltesoft.modelexecution.ide.util;

import org.eclipse.core.resources.IResource;

public class ResourceAnalyzer {
	
	private static final String UML_FILE_EXTENSION = "uml";
	
	public static boolean isModelResource(IResource resource) {
		return UML_FILE_EXTENSION.equals(resource.getFileExtension());
	}

}
