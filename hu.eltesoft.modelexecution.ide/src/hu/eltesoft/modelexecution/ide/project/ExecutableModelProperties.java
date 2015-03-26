package hu.eltesoft.modelexecution.ide.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;

/**
 * Utility functions for handling project properties of executable model
 * projects. The properties are not initialized on nature configuration but have
 * default values that are used when the given property cannot be found.
 * 
 * Properties are stored under
 * .settings/hu.eltesoft.modelexecution.natures.executableModelNature.prefs
 * 
 * @author nboldi
 *
 */
public class ExecutableModelProperties {

	private static final String SOURCE_GEN_PATH_PROPERTY_NAME = "sourceGenPath";

	private static final String DEFAULT_SOURCE_GEN_PATH = "model-gen-src";

	public static IEclipsePreferences getProperties(IProject project) {
		IScopeContext projectScope = new ProjectScope(project);
		return projectScope.getNode(ExecutableModelNature.NATURE_ID);
	}

	public static String getSourceGenPath(IProject project) {
		return getSourceGenPath(getProperties(project));
	}

	public static String getSourceGenPath(IEclipsePreferences properties) {
		return properties.get(SOURCE_GEN_PATH_PROPERTY_NAME,
				DEFAULT_SOURCE_GEN_PATH);
	}

	public static void setSourceGenPath(IProject project, String path) {
		setSourceGenPath(getProperties(project), path);
	}
	
	private static void setSourceGenPath(IEclipsePreferences properties,
			String path) {
		properties.put(SOURCE_GEN_PATH_PROPERTY_NAME, path);
		
	}

}
