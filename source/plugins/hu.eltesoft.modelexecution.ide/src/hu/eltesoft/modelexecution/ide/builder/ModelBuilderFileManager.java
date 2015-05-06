package hu.eltesoft.modelexecution.ide.builder;

import hu.eltesoft.modelexecution.filemanager.IFileManager;
import hu.eltesoft.modelexecution.filemanager.IFileManagerFactory;
import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProperties;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * File operation interface for {@linkplain ModelBuilder}.
 */
public class ModelBuilderFileManager implements TextChangesListener {

	private IProject project;
	private IFileManagerFactory fileManagerFactory;

	public ModelBuilderFileManager(IProject project,
			IFileManagerFactory fileManagerFactory) {
		this.project = project;
		this.fileManagerFactory = fileManagerFactory;
	}

	@Override
	public void contentDeleted(String fileName) {
		getGenSrcFileManager().remove(fileName);
	}

	@Override
	public void contentChanged(String fileName, SourceMappedText output,
			DebugSymbols symbols) {
		try {
			getGenSrcFileManager().addOrUpdate(fileName,
					output.getText().toString());
			String smap = output.getSmap().toString();
			if (smap != null) {
				getDebugInfoFileManager().addOrUpdateFile(
						fileName + ".smap", smap); //$NON-NLS-1$
			}
			if (symbols != null) {
				getDebugInfoFileManager().addOrUpdateFile(
						fileName + ".symbols", //$NON-NLS-1$
						symbols);
			}
		} catch (IOException e) {
			IdePlugin.logError("Error while writing file: " + fileName, e); //$NON-NLS-1$
		}
	}

	/**
	 * Refreshes folder after files have been written.
	 */
	public void refreshFolder() {
		try {
			IResource genSourceDir = project
					.findMember(ExecutableModelProperties
							.getSourceGenPath(project));
			if (genSourceDir != null && genSourceDir.exists()) {
				genSourceDir.refreshLocal(IResource.DEPTH_INFINITE, null);
			}
		} catch (CoreException e) {
			IdePlugin.logError("Exception while refreshing folder.", e); //$NON-NLS-1$
		}
	}

	/**
	 * Deletes generated files.
	 */
	public void cleanUp() {
		getGenSrcFileManager().cleanup();
		getDebugInfoFileManager().cleanup();
	}

	private IFileManager getGenSrcFileManager() {
		return fileManagerFactory.createFileManager(project.getLocation()
				.append(ExecutableModelProperties.getSourceGenPath(project))
				.toString());
	}

	private IFileManager getDebugInfoFileManager() {
		return fileManagerFactory.createFileManager(project.getLocation()
				.append(ExecutableModelProperties.getDebugFilesPath(project))
				.toString());
	}

}
