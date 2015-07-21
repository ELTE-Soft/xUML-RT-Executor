package hu.eltesoft.modelexecution.ide.project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.resources.ProjectDescription;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.launching.StandardVMType;
import org.eclipse.jdt.launching.JavaRuntime;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.buildpath.RuntimeLibraryContainerInitializer;
import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.log.StandardOutHandler;

/**
 * Initializes the executable model project. Sets attributes that are not
 * directly related to {@linkplain ExecutableModelNature}. Creates the projects,
 * its folders, the build path and a sample launch config.
 */
@SuppressWarnings("restriction")
public class ExecutableModelProjectSetup {

	private static final String JAVA_SE_VERSION = "JavaSE-1.8"; //$NON-NLS-1$

	public static final IPath JRE_CONTAINER_PATH = JavaRuntime.newDefaultJREContainerPath()
			.append(StandardVMType.ID_STANDARD_VM_TYPE).append(JAVA_SE_VERSION);

	private static final String JAVA_COMPILER_OUTPUT_FOLDER = "bin"; //$NON-NLS-1$

	/**
	 * Creates an xUMLRt project with the given name, at the given location.
	 */
	public static void createProject(String projectName, URI location) throws CoreException {
		ProjectDescription description = new ProjectDescription();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		description.setLocationURI(location);
		description.setName(projectName);
		IProject project = workspace.getRoot().getProject(projectName);
		project.create(description, null);
		project.open(null);
		configureProject(project);
	}

	/**
	 * Sets up natures, adds necessary folders and sets up classpath.
	 */
	private static void configureProject(IProject project) throws CoreException, JavaModelException {
		setProjectNatures(project);

		IJavaProject javaProject = JavaCore.create(project);

		createBinFolders(project, javaProject);
		createTracesFolder(project, javaProject);
		createGenSourceFolder(project, ExecutableModelProperties.DEFAULT_SOURCE_GEN_PATH);
		createLoggingPropertiesFile(project);
		setupClassPath(javaProject, ExecutableModelProperties.DEFAULT_SOURCE_GEN_PATH);
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
	}

	private static void createLoggingPropertiesFile(IProject project) {
		File createdLoggingPropsFile = project.getLocation()
				.append(Messages.ExecutableModelProjectSetup_default_logging_properties_file_location).toFile();
		try (OutputStreamWriter stream = new OutputStreamWriter(new FileOutputStream(createdLoggingPropsFile))) {
			createdLoggingPropsFile.createNewFile();
			stream.append(MessageFormat.format(Messages.ExecutableModelProjectSetup_default_logging_properties_file,
					BaseRuntime.STATES_LOGGER_ID, BaseRuntime.TRANSITIONS_LOGGER_ID, BaseRuntime.MESSAGES_LOGGER_ID,
					StandardOutHandler.class.getCanonicalName()));
		} catch (IOException e) {
			IdePlugin.logError("Error while creating logging properties file.", e); //$NON-NLS-1$
		}
	}

	private static void setProjectNatures(IProject project) throws CoreException {
		IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { JavaCore.NATURE_ID, ExecutableModelNature.NATURE_ID });
		project.setDescription(description, null);
	}

	private static void createBinFolders(IProject project, IJavaProject javaProject)
			throws CoreException, JavaModelException {
		IFolder binFolder = createFolder(project, JAVA_COMPILER_OUTPUT_FOLDER);
		IFolder instrumentedBinFolder = createFolder(project,
				ExecutableModelProperties.getInstrumentedClassFilesPath(project));
		instrumentedBinFolder.setTeamPrivateMember(true);
		instrumentedBinFolder.setDerived(true, null);
		IFolder smapFolder = createFolder(project, ExecutableModelProperties.getDebugFilesPath(project));
		smapFolder.setTeamPrivateMember(true);
		smapFolder.setDerived(true, null);
		javaProject.setOutputLocation(binFolder.getFullPath(), null);
	}

	private static void createTracesFolder(IProject project, IJavaProject javaProject) {
		createFolder(project, ExecutableModelProperties.getTraceFilesPath(project));
	}

	private static void createGenSourceFolder(IProject project, String name) throws CoreException {
		createFolder(project, name);
	}

	private static IFolder createFolder(IProject project, String name) {
		IFolder sourceFolder = project.getFolder(name);
		try {
			sourceFolder.create(false, true, null);
		} catch (CoreException e) {
			IdePlugin.logError("Error while creating folder.", e); //$NON-NLS-1$
		}
		return sourceFolder;
	}

	private static void setupClassPath(IJavaProject javaProject, String sourceFolder) {
		try {
			List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
			entries.add(JavaCore.newSourceEntry(javaProject.getPath().append(sourceFolder)));
			IClasspathEntry jreEntry = JavaCore.newContainerEntry(JRE_CONTAINER_PATH);
			entries.add(jreEntry);
			IClasspathEntry containerEntry = JavaCore
					.newContainerEntry(RuntimeLibraryContainerInitializer.LIBRARY_PATH);
			entries.add(containerEntry);
			javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
		} catch (JavaModelException e) {
			IdePlugin.logError("Cannot setup class path", e); //$NON-NLS-1$
		}
	}
}
