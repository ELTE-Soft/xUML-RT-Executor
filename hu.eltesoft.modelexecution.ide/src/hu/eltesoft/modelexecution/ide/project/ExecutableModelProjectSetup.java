package hu.eltesoft.modelexecution.ide.project;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.runtime.RuntimePlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.osgi.framework.Bundle;

/**
 * Initializes the executable model project. Sets attributes that are not
 * directly related to {@linkplain ExecutableModelNature}. Creates the projects,
 * its folders, the build path and a sample launch config.
 * 
 * @author nboldi
 *
 */
public class ExecutableModelProjectSetup {

	private static final String ECLIPSE_PLUGINS_PATH = "plugins/";

	private static final String JAVA_COMPILER_OUTPUT_FOLDER = "bin";

	private static final String DEFAULT_SOURCE_GEN_PATH = "model-gen-src";

	public static void createProject(String projectName) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);

		project.create(null);
		project.open(null);
		configureProject(projectName, project);
	}

	private static void configureProject(String projectName, IProject project)
			throws CoreException, JavaModelException {
		setProjectNatures(project);

		IJavaProject javaProject = JavaCore.create(project);

		createBinFolder(project, javaProject);
		createGenSourceFolder(project, DEFAULT_SOURCE_GEN_PATH);
		setupClassPath(javaProject, DEFAULT_SOURCE_GEN_PATH);
	}

	private static void setProjectNatures(IProject project)
			throws CoreException {
		IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { JavaCore.NATURE_ID,
				ExecutableModelNature.NATURE_ID });
		project.setDescription(description, null);
	}

	private static void createBinFolder(IProject project,
			IJavaProject javaProject) throws CoreException, JavaModelException {
		IFolder binFolder = createFolder(project, JAVA_COMPILER_OUTPUT_FOLDER);
		javaProject.setOutputLocation(binFolder.getFullPath(), null);
	}

	private static void createGenSourceFolder(IProject project, String name)
			throws CoreException {
		createFolder(project, name);
	}

	private static IFolder createFolder(IProject project, String name) {
		IFolder sourceFolder = project.getFolder(name);
		try {
			sourceFolder.create(false, true, null);
		} catch (CoreException e) {
			IdePlugin.logError("Error while creating folder.", e);
		}
		return sourceFolder;
	}

	private static void setupClassPath(IJavaProject javaProject,
			String sourceFolder) throws JavaModelException {
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
		IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
		LibraryLocation[] locations = JavaRuntime
				.getLibraryLocations(vmInstall);
		for (LibraryLocation element : locations) {
			entries.add(JavaCore.newLibraryEntry(
					element.getSystemLibraryPath(), null, null));
		}
		entries.add(JavaCore.newSourceEntry(javaProject.getPath().append(
				sourceFolder)));
		File pluginJar = getPluginJar();
		entries.add(JavaCore.newLibraryEntry(
				new Path(pluginJar.getAbsolutePath()), null,
				new Path(String.valueOf(Path.SEPARATOR))));
		// add libs to project class path
		javaProject.setRawClasspath(
				entries.toArray(new IClasspathEntry[entries.size()]), null);
	}

	private static File getPluginJar() {
		// TODO: make the detection more robust
		// The working directory of the plugin is the ECLIPSE_HOME directory
		Bundle bundle = Platform.getBundle(RuntimePlugin.PLUGIN_ID);
		return new File(ECLIPSE_PLUGINS_PATH + RuntimePlugin.PLUGIN_ID + "_"
				+ bundle.getVersion() + ".jar");
	}

}
