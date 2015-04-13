package hu.eltesoft.modelexecution.ide.project;

import java.io.IOException;

import hu.eltesoft.modelexecution.filemanager.IFileManager;
import hu.eltesoft.modelexecution.filemanager.IFileManagerFactory;
import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * File operation interface for builder.
 */
public class BuilderFileManager implements TextChangesListener {

	private IProject project;
	private IFileManagerFactory fileManagerFactory;

	public BuilderFileManager(IProject project,
			IFileManagerFactory fileManagerFactory) {
		this.project = project;
		this.fileManagerFactory = fileManagerFactory;

	}

	@Override
	public void contentDeleted(String fileName) {
		getFileManager().remove(fileName);
	}

	@Override
	public void contentChanged(String fileName, SourceMappedText output,
			DebugSymbols symbols) {
		try {
			getFileManager().addOrUpdate(fileName, output.getText().toString());
		} catch (IOException e) {
			IdePlugin.logError("Error while writing file: " + fileName, e);
		}
	}
	
	/**
	 * Refreshes folder after files have been written
	 */
	public void refreshFolder() {
		try {
			IResource genSourceDir = project.findMember(getGenSourceDir());
			if (genSourceDir != null && genSourceDir.exists()) {
				genSourceDir.refreshLocal(IResource.DEPTH_INFINITE, null);
			}
		} catch (CoreException e) {
			IdePlugin.logError("Exception while refreshing folder.", e);
		}
	}
	
	public void cleanUp() {
		getFileManager().cleanup();
	}

	private IFileManager getFileManager() {
		return fileManagerFactory.createFileManager(getGenSourcePath());
	}

	/**
	 * Gets the full file-system dependent path to the directory of the
	 * generated sources.
	 */
	private String getGenSourcePath() {
		return project.getLocation().append(getGenSourceDir()).toString();
	}

	private String getGenSourceDir() {
		return ExecutableModelProperties.getSourceGenPath(project);
	}

}
