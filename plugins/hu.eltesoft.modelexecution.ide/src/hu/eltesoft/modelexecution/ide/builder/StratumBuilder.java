package hu.eltesoft.modelexecution.ide.builder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import hu.eltesoft.modelexecution.filemanager.FileManager;
import hu.eltesoft.modelexecution.ide.common.ProjectProperties;
import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.common.util.SDEInstaller;

/**
 * A builder that activates after the Java builder runs. Takes the class files
 * that are produced by the Java compiler and adds debug information to them.
 * The debug information is produced by {@linkplain ModelBuilder}.
 */
public class StratumBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "hu.eltesoft.modelexecution.builders.stratumbuilder"; //$NON-NLS-1$ ;

	private static final String CLASS_FILE_EXTENSION = "class"; //$NON-NLS-1$
	private static final String SMAP_FILE_EXTENSION = "smap"; //$NON-NLS-1$

	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		if (kind == AUTO_BUILD || kind == INCREMENTAL_BUILD) {
			incrementalBuild();
		} else if (kind == FULL_BUILD) {
			fullBuild();
		}
		return null;
	}

	/**
	 * Removes all generated source files.
	 */
	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		getFileManager().cleanup();
	}

	private void fullBuild() {
		try {
			clean(new NullProgressMonitor());
			getProject().accept(res -> {
				build(res);
				return true;
			});
		} catch (CoreException e) {
			PluginLogger.logError("Error while rebuilding resources", e); //$NON-NLS-1$
		}
	}

	private void incrementalBuild() {
		IResourceDelta delta = getDelta(getProject());
		try {
			delta.accept(d -> {
				if (d.getKind() == IResourceDelta.ADDED || d.getKind() == IResourceDelta.CHANGED) {
					build(d.getResource());
				}
				return true;
			});
		} catch (CoreException e) {
			PluginLogger.logError("Error while doing incremental stratum build", e); //$NON-NLS-1$
		}
	}

	private void build(IResource res) {
		if (res.getFileExtension() != null && res.getFileExtension().equals(CLASS_FILE_EXTENSION)) {
			IProject project = res.getProject();
			IPath projectLoc = project.getLocation();
			IPath smapPath = projectLoc.append(ProjectProperties.getDebugFilesPath(project))
					.append(res.getProjectRelativePath().removeFileExtension().removeFirstSegments(1)
							.addFileExtension(SMAP_FILE_EXTENSION));
			IPath instrumentedBinFolder = projectLoc
					.append(ProjectProperties.getInstrumentedClassFilesPath(project));
			IPath newLocation = instrumentedBinFolder.append(res.getProjectRelativePath().removeFirstSegments(1));
			try {
				Files.createDirectories(Paths.get(instrumentedBinFolder.toString()));
			} catch (IOException e) {
				PluginLogger.logError("Cannot create directories for instrumented class file", e); //$NON-NLS-1$
				return;
			}
			if (newLocation.equals(res.getLocation()) || !res.getLocation().toFile().exists()) {
				return;
			}
			try {
				if (smapPath.toFile().exists()) {
					SDEInstaller.install(res.getLocation().toFile(), smapPath.toFile(), newLocation.toFile());
				} else {
					Files.copy(res.getLocation().toFile().toPath(), newLocation.toFile().toPath(),
							StandardCopyOption.REPLACE_EXISTING);
				}
			} catch (IOException e) {
				PluginLogger.logError("Error while trying to install stratum.", e); //$NON-NLS-1$
			}
		}
	}

	private FileManager getFileManager() {
		return new FileManager(getProject().getLocation()
				.append(ProjectProperties.getInstrumentedClassFilesPath(getProject())).toString());
	}
}
