package hu.eltesoft.modelexecution.ide.builder;

import hu.eltesoft.modelexecution.filemanager.IFileManager;
import hu.eltesoft.modelexecution.filemanager.IFileManagerFactory;
import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProperties;
import hu.eltesoft.modelexecution.ide.util.ClasspathUtils;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

import java.io.IOException;
import java.util.function.Function;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * File operation interface for {@linkplain ModelBuilder}.
 */
public class ModelBuilderFileManager implements TextChangesListener {

	private final IProject project;
	private final IFileManagerFactory fileManagerFactory;

	private final IFileManager genSrcFileManager;
	private final IFileManager debugSymbolsFileManager;
	private final IFileManager binDebugFileManager;

	public ModelBuilderFileManager(IProject project,
			IFileManagerFactory fileManagerFactory) {
		this.project = project;
		this.fileManagerFactory = fileManagerFactory;

		genSrcFileManager = createFileManager(ExecutableModelProperties::getSourceGenPath);
		debugSymbolsFileManager = createFileManager(ExecutableModelProperties::getDebugFilesPath);
		binDebugFileManager = createFileManager(ExecutableModelProperties::getInstrumentedClassFilesPath);
	}

	private IFileManager createFileManager(
			Function<IProject, String> pathSelector) {
		IPath root = project.getLocation().append(pathSelector.apply(project));
		return fileManagerFactory.createFileManager(root.toString());
	}

	@Override
	public void contentDeleted(String fileName) {
		genSrcFileManager.remove(fileName);
	}

	@Override
	public void contentChanged(String fileName, SourceMappedText output,
			DebugSymbols symbols) {
		try {
			checkGenDirIsSrcDir();
			genSrcFileManager
					.addOrUpdate(fileName, output.getText().toString());
			String smap = output.getSmap().toString();
			if (smap != null) {
				debugSymbolsFileManager.addOrUpdateFile(
						fileName + ".smap", smap); //$NON-NLS-1$
			}
			if (symbols != null) {
				debugSymbolsFileManager.addOrUpdateFile(fileName + ".symbols", //$NON-NLS-1$
						symbols);
			}
		} catch (IOException e) {
			IdePlugin.logError("Error while writing file: " + fileName, e); //$NON-NLS-1$
		} catch (CoreException e) {
			IdePlugin.logError("Error while updating classpath: ", e); //$NON-NLS-1$
		}
	}

	/**
	 * Ensures that the directory where the java source files are generated is a
	 * source directory.
	 */
	private void checkGenDirIsSrcDir() throws CoreException {
		IJavaProject javaProject = JavaCore.create(project);
		String outputPath = ExecutableModelProperties.getSourceGenPath(project);

		IFolder folder = project.getFolder(outputPath);
		folder.refreshLocal(IFolder.DEPTH_ZERO, null);
		IResource outputDir = project.findMember(outputPath);
		if (outputDir == null) {
			folder.create(false, false, null);
			outputDir = project.findMember(outputPath);
		}
		if (javaProject.findPackageFragmentRoot(outputDir.getFullPath()) == null) {
			IClasspathEntry newSourceEntry = JavaCore.newSourceEntry(outputDir
					.getFullPath());
			ClasspathUtils.addClasspathEntry(javaProject, newSourceEntry);
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
		genSrcFileManager.cleanup();
		debugSymbolsFileManager.cleanup();
		binDebugFileManager.cleanup();
	}
}
