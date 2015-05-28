package hu.eltesoft.modelexecution.ide.builder;

import hu.eltesoft.modelexecution.filemanager.FileManagerFactory;
import hu.eltesoft.modelexecution.filemanager.IFileManagerFactory;
import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTask;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * The model builder triggers the source code generation from the UML model.
 * Generated files are deleted on full build.
 */
public class ModelBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "hu.eltesoft.modelexecution.builders.modelbuilder"; //$NON-NLS-1$

	private final IFileManagerFactory fileManagerFactory;
	private ModelBuilderFileManager builderFileManager;

	/**
	 * Default constructor used by Eclipse
	 */
	public ModelBuilder() {
		this(new FileManagerFactory());
	}

	/**
	 * A more configurable version.
	 */
	public ModelBuilder(IFileManagerFactory fileManagerFactory) {
		this.fileManagerFactory = fileManagerFactory;
	}

	@Override
	protected void startupOnInitialize() {
		super.startupOnInitialize();
		builderFileManager = new ModelBuilderFileManager(getProject(),
				fileManagerFactory);
	}

	@Override
	public IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {
		if (kind == AUTO_BUILD || kind == INCREMENTAL_BUILD) {
			incrementalBuild();
		} else if (kind == FULL_BUILD) {
			fullBuild();
		}
		builderFileManager.refreshFolder();
		return null;
	}

	/**
	 * Removes all generated source files.
	 */
	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		builderFileManager.cleanUp();
		builderFileManager.refreshFolder();
	}

	/**
	 * Removes and regenerates generated files.
	 */
	private void fullBuild() {
		try {
			clean(new NullProgressMonitor());

			final List<FileUpdateTask> queue = Collections
					.synchronizedList(new LinkedList<>());

			getProject().accept(new IResourceVisitor() {

				@Override
				public boolean visit(IResource resource) throws CoreException {
					TranslatorRegistry.INSTANCE.runTranslatorFor(resource,
							t -> queue.addAll(t.fullBuild()));
					return true;
				}
			});

			performAllTasks(queue);
		} catch (CoreException e) {
			IdePlugin.logError("Error while rebuilding resources", e); //$NON-NLS-1$
		}
	}

	/**
	 * Adds generators for new .uml files and regenerates the content of
	 * existing .uml files.
	 */
	private void incrementalBuild() {
		IResourceDelta delta = getDelta(getProject());
		final List<FileUpdateTask> queue = Collections
				.synchronizedList(new LinkedList<>());
		try {
			delta.accept(new IResourceDeltaVisitor() {
				@Override
				public boolean visit(IResourceDelta delta) throws CoreException {
					IResource resource = delta.getResource();
					if (delta.getKind() == IResourceDelta.ADDED
							|| delta.getKind() == IResourceDelta.CHANGED) {
						TranslatorRegistry.INSTANCE.runTranslatorFor(resource,
								t -> queue.addAll(t.incrementalBuild()));
					} else if (delta.getKind() == IResourceDelta.REMOVED) {
						TranslatorRegistry.INSTANCE.resourceUnloaded(resource);
					}
					return true;
				}
			});

			performAllTasks(queue);
		} catch (CoreException e) {
			IdePlugin.logError("Exception while incremental build.", e); //$NON-NLS-1$
		}
	}

	private void performAllTasks(final List<FileUpdateTask> queue) {
		queue.forEach(task -> task.perform(builderFileManager));
	}
}
