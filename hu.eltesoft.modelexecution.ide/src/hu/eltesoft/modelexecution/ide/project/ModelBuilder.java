package hu.eltesoft.modelexecution.ide.project;

import hu.eltesoft.modelexecution.filemanager.FileManager;
import hu.eltesoft.modelexecution.ide.PapyrusEditorListener;
import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.m2m.logic.ChangeListenerM2MTranslator;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * The model builder triggers the source code generation from the UML model. It
 * registers resources when they appear in the project. When the editor is used
 * it locks the editor when the model is under compilation.
 * 
 * Generated files are deleted on full build.
 * 
 * @author nboldi
 *
 */
public class ModelBuilder extends IncrementalProjectBuilder {
	// TODO: use the model loading interface instead of direct IncQuery usage.

	public static final String BUILDER_ID = "hu.eltesoft.modelexecution.builders.modelbuilder";

	private static final String UML_FILE_EXTENSION = "uml";

	private Set<String> trackedResources = new HashSet<>();

	private FileManager fileManager;

	private Map<IResource, ChangeListenerM2MTranslator> translators = new HashMap<>();

	private ResourceSet resourceSet = new ResourceSetImpl();

	@Override
	protected IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {

		TransactionalEditingDomain shared = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(PapyrusEditorListener.EDITING_DOMAIN);

		loadProjectProperties();

		if (shared != null) {
			// when an editor is present ask exclusive access to the resources
			try {
				shared.runExclusive(() -> build(kind));
			} catch (InterruptedException e) {
				// nothing to do: interrupted by user
			}
		} else {
			build(kind);
		}
		return null;
	}

	private void loadProjectProperties() {
		getFileManager().setRoot(getGenSourcePath());
	}

	private void build(int kind) {
		if (kind == AUTO_BUILD || kind == INCREMENTAL_BUILD) {
			incrementalBuild();
		} else if (kind == FULL_BUILD) {
			fullBuild();
		}
		refreshFolder();
	}

	/**
	 * Removes and regenerates the codes for the model resources.
	 */
	private void fullBuild() {
		getFileManager().cleanup();
		try {
			getProject().accept(new IResourceVisitor() {
				@Override
				public boolean visit(IResource resource) throws CoreException {
					if (isModelResource(resource)) {
						rebuildResource(resource);
					}
					return true;
				}
			});
		} catch (CoreException e) {
			IdePlugin.logError("Exception while doing full build.", e);
		}
	}

	/**
	 * Adds generators for new .uml files and regenerates the content of
	 * existing .uml files.
	 */
	private void incrementalBuild() {
		IResourceDelta delta = getDelta(getProject());
		try {
			delta.accept(new IResourceDeltaVisitor() {
				@Override
				public boolean visit(IResourceDelta delta) throws CoreException {
					IResource resource = delta.getResource();
					if (delta.getKind() == IResourceDelta.ADDED) {
						// add uml files that appeared in the project
						IPath path = delta.getProjectRelativePath();
						if (isModelResource(resource)
								&& !trackedResources.contains(path.toString())) {
							trackedResources.add(path.toString());
							rebuildResource(resource);
						}
					} else if (delta.getKind() == IResourceDelta.CHANGED) {
						// rebuild uml files that changed
						if (translators.containsKey(resource)) {
							translators.get(resource).rebuild();
						}
					}
					return true;
				}
			});
		} catch (CoreException e) {
			IdePlugin.logError("Exception while incremental build.", e);
		}
	}

	/**
	 * Refreshes folder after files have been written
	 */
	private void refreshFolder() {
		try {
			IResource genSourceDir = getProject().findMember(getGenSourceDir());
			if (genSourceDir != null && genSourceDir.exists()) {
				genSourceDir.refreshLocal(IResource.DEPTH_INFINITE, null);
			}
		} catch (CoreException e) {
			IdePlugin.logError("Exception while refreshing folder.", e);
		}
	}

	// TODO: find a way to test if the resource contains an UML model.
	protected boolean isModelResource(IResource resource) {
		return UML_FILE_EXTENSION.equals(resource.getFileExtension());
	}

	/**
	 * Rebuilds the code generated from the given resource and registers it for
	 * accumulating changes.
	 */
	protected void rebuildResource(IResource resource) {
		URI uri = URI.createFileURI((resource.getFullPath().toString()));
		Resource res = resourceSet.getResource(uri, true);

		if (res == null) {
			return;
		}
		try {
			ChangeListenerM2MTranslator translator;
			if (!translators.containsKey(resource)) {
				IncQueryEngine engine = IncQueryEngine.on(res);
				translator = ChangeListenerM2MTranslator.create(engine,
						new FileManagerTextChangeListener());
				translators.put(resource, translator);
			} else {
				translator = translators.get(resource);
			}
			FileUpdateTaskQueue fullBuild = translator.fullBuild();
			fullBuild.forEach(t -> t.perform());
		} catch (IncQueryException e) {
			IdePlugin.logError("IncQuery engine could not be created.", e);
		}
	}

	/**
	 * Uses the fileManager to apply textual changes in generated files.
	 */
	private final class FileManagerTextChangeListener implements
			TextChangesListener {
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
	}

	private FileManager getFileManager() {
		if (fileManager == null) {
			fileManager = new FileManager(getGenSourcePath());
		}
		return fileManager;
	}

	/**
	 * Gets the full file-system dependent path to the directory of the
	 * generated sources.
	 */
	private String getGenSourcePath() {
		return ResourcesPlugin.getWorkspace().getRoot().getLocation()
				.append(getProject().getFullPath()).append(getGenSourceDir())
				.toString();
	}

	private String getGenSourceDir() {
		return ExecutableModelProperties.getSourceGenPath(getProject());
	}

}
