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
 */
public class ExecutableModelProperties {

	private static final String PROPERTY_PREFIX = "hu.eltesoft.modelexecution.attribute."; //$NON-NLS-1$

	public static final String PROP_SOURCE_GEN_PATH = PROPERTY_PREFIX
			+ "source_gen_path"; //$NON-NLS-1$

	public static final String DEFAULT_SOURCE_GEN_PATH = "model-gen-src"; //$NON-NLS-1$

	public static final String PROP_DEBUG_RES_PATH = PROPERTY_PREFIX
			+ "debug_res_path"; //$NON-NLS-1$

	public static final String DEFAULT_DEBUG_RES_PATH = "smap"; //$NON-NLS-1$

	public static final String PROP_INSTRUMENTED_CLASS_FILE_PATH = PROPERTY_PREFIX
			+ "instrumented_class_file_path"; //$NON-NLS-1$

	public static final String DEFAULT_INSTRUMENTED_CLASS_FILE_PATH = "bin-debug"; //$NON-NLS-1$

	public static IEclipsePreferences getProperties(IProject project) {
		IScopeContext projectScope = new ProjectScope(project);
		return projectScope.getNode(ExecutableModelNature.NATURE_ID);
	}
	
	// path for generated sources
	
	public static String getSourceGenPath(IProject project) {
		return getSourceGenPath(getProperties(project));
	}

	public static String getSourceGenPath(IEclipsePreferences properties) {
		return properties.get(PROP_SOURCE_GEN_PATH,
				DEFAULT_SOURCE_GEN_PATH);
	}

	public static void setSourceGenPath(IProject project, String path) {
		setSourceGenPath(getProperties(project), path);
	}

	private static void setSourceGenPath(IEclipsePreferences properties,
			String path) {
		properties.put(PROP_SOURCE_GEN_PATH, path);
	}

	// path for debug files
	
	public static String getDebugFilesPath(IProject project) {
		return getDebugFilesPath(getProperties(project));
	}

	public static String getDebugFilesPath(IEclipsePreferences properties) {
		return properties.get(PROP_DEBUG_RES_PATH,
				DEFAULT_DEBUG_RES_PATH);
	}

	public static void setDebugFilesPath(IProject project, String path) {
		setDebugFilesPath(getProperties(project), path);
	}

	private static void setDebugFilesPath(IEclipsePreferences properties,
			String path) {
		properties.put(PROP_DEBUG_RES_PATH, path);
	}
	
	// path for instrumented class files
	
	public static String getInstrumentedClassFilesPath(IProject project) {
		return getInstrumentedClassFilesPath(getProperties(project));
	}

	public static String getInstrumentedClassFilesPath(IEclipsePreferences properties) {
		return properties.get(PROP_INSTRUMENTED_CLASS_FILE_PATH,
				DEFAULT_INSTRUMENTED_CLASS_FILE_PATH);
	}

	public static void setInstrumentedClassFilesPath(IProject project, String path) {
		setInstrumentedClassFilesPath(getProperties(project), path);
	}

	private static void setInstrumentedClassFilesPath(IEclipsePreferences properties,
			String path) {
		properties.put(PROP_INSTRUMENTED_CLASS_FILE_PATH, path);
	}

}
