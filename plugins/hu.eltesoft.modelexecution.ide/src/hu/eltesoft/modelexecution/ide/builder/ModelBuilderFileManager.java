package hu.eltesoft.modelexecution.ide.builder;

import java.io.IOException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

import hu.eltesoft.modelexecution.filemanager.IFileManager;
import hu.eltesoft.modelexecution.filemanager.IFileManagerFactory;
import hu.eltesoft.modelexecution.ide.common.ProjectProperties;
import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.common.util.ClasspathUtils;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeChangeListener;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

/**
 * File operation interface for {@linkplain ModelBuilder}.
 */
public class ModelBuilderFileManager implements SourceCodeChangeListener {

	private IProject project;
	private IFileManagerFactory fileManagerFactory;

	public ModelBuilderFileManager(IProject project, IFileManagerFactory fileManagerFactory) {
		this.project = project;
		this.fileManagerFactory = fileManagerFactory;
	}

	@Override
	public void sourceCodeDeleted(String fileName) {
		getGenSrcFileManager().remove(fileName);
	}

	@Override
	public void sourceCodeChanged(String fileName, SourceMappedText output, DebugSymbols symbols) {
		try {
			checkGenDirIsSrcDir();
			getGenSrcFileManager().addOrUpdate(fileName, output.getText().toString());
			String smap = output.getSmap().toString();
			if (smap != null) {
				getDebugInfoFileManager().addOrUpdateFile(fileName + ".smap", smap); //$NON-NLS-1$
			}
			if (symbols != null) {
				getDebugInfoFileManager().addOrUpdateFile(fileName + ".symbols", //$NON-NLS-1$
						symbols);
			}
		} catch (IOException e) {
			PluginLogger.logError("Error while writing file: " + fileName, e); //$NON-NLS-1$
		} catch (CoreException e) {
			PluginLogger.logError("Error while updating classpath: ", e); //$NON-NLS-1$
		}
	}

	/**
	 * Ensures that the directory where the java source files are generated is a
	 * source directory.
	 */
	private void checkGenDirIsSrcDir() throws CoreException {
		IJavaProject javaProject = JavaCore.create(project);
		String outputPath = ProjectProperties.getSourceGenPath(project);

		IFolder folder = project.getFolder(outputPath);
		folder.refreshLocal(IFolder.DEPTH_ZERO, null);
		IResource outputDir = project.findMember(outputPath);
		if (outputDir == null) {
			folder.create(false, false, null);
			outputDir = project.findMember(outputPath);
		}
		if (javaProject.findPackageFragmentRoot(outputDir.getFullPath()) == null) {
			IClasspathEntry newSourceEntry = JavaCore.newSourceEntry(outputDir.getFullPath());
			ClasspathUtils.addClasspathEntry(javaProject, newSourceEntry);
		}
	}

	/**
	 * Refreshes folder after files have been written.
	 */
	public void refreshFolder() {
		try {
			IResource genSourceDir = project.findMember(ProjectProperties.getSourceGenPath(project));
			if (genSourceDir != null && genSourceDir.exists()) {
				genSourceDir.refreshLocal(IResource.DEPTH_INFINITE, null);
			}
		} catch (CoreException e) {
			PluginLogger.logError("Exception while refreshing folder.", e); //$NON-NLS-1$
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
		return fileManagerFactory.createFileManager(
				project.getLocation().append(ProjectProperties.getSourceGenPath(project)).toString());
	}

	private IFileManager getDebugInfoFileManager() {
		return fileManagerFactory.createFileManager(
				project.getLocation().append(ProjectProperties.getDebugFilesPath(project)).toString());
	}

}
