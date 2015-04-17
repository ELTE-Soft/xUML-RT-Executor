package hu.eltesoft.modelexecution.ide.builder;

import hu.eltesoft.modelexecution.filemanager.FileManager;
import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProjectSetup;
import hu.eltesoft.modelexecution.ide.util.SDEInstaller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

public class StratumBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "hu.eltesoft.modelexecution.builders.stratumbuilder"; //$NON-NLS-1$;

	@Override
	protected IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {

		if (kind == AUTO_BUILD || kind == INCREMENTAL_BUILD) {
			incrementalBuild();
		} else if (kind == FULL_BUILD) {
			fullBuild();
		}

		return null;
	}

	private void fullBuild() {
		getFileManager().cleanup();
		try {
			getProject().accept(res -> {
				rebuild(res);
				return true;
			});
		} catch (CoreException e) {
			IdePlugin.logError("Error while rebuilding resources", e); //$NON-NLS-1$
		}
	}

	private void incrementalBuild() {
		IResourceDelta delta = getDelta(getProject());
		try {
			delta.accept(d -> {
				if (d.getKind() == IResourceDelta.ADDED
						|| d.getKind() == IResourceDelta.CHANGED) {
					rebuild(d.getResource());
				}
				return true;
			});
		} catch (CoreException e) {
			IdePlugin
					.logError("Error while doing incremental stratum build", e);
		}
	}

	private void rebuild(IResource res) {
		if (res.getFileExtension() != null
				&& res.getFileExtension().equals("class")) {
			IPath projectLoc = res.getProject().getLocation();
			IPath smapPath = projectLoc.append(
					ExecutableModelProjectSetup.SMAP_FOLDER).append(
					res.getProjectRelativePath().removeFileExtension()
							.removeFirstSegments(1).addFileExtension("smap"));
			IPath newLocation = projectLoc
					.append(ExecutableModelProjectSetup.JAVA_INSTRUMENTED_CLASS_FOLDER)
					.append(res.getProjectRelativePath().removeFirstSegments(1));
			if (newLocation.equals(res.getLocation())
					|| !res.getLocation().toFile().exists()) {
				return;
			}
			try {
				if (smapPath.toFile().exists()) {
					SDEInstaller.install(res.getLocation().toFile(),
							smapPath.toFile(), newLocation.toFile());
				} else {
					Files.copy(res.getLocation().toFile().toPath(), newLocation
							.toFile().toPath(),
							StandardCopyOption.REPLACE_EXISTING);
				}
			} catch (IOException e) {
				IdePlugin.logError("Error while trying to install stratum.", e);
			}
		}
	}

	private FileManager getFileManager() {
		return new FileManager(
				getProject()
						.getLocation()
						.append(ExecutableModelProjectSetup.JAVA_INSTRUMENTED_CLASS_FOLDER)
						.toString());
	}
}
