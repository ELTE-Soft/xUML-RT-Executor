package hu.eltesoft.modelexecution.ide.project;

import hu.eltesoft.modelexecution.filemanager.FileManagerFactory;
import hu.eltesoft.modelexecution.filemanager.IFileManagerFactory;
import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.PapyrusEditorListener;
import hu.eltesoft.modelexecution.ide.util.ResourceAnalyzer;
import hu.eltesoft.modelexecution.m2m.logic.ChangeListenerTranslatorFactory;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.IChangeListenerTranslatorFactory;
import hu.eltesoft.modelexecution.m2m.logic.SimpleM2MTranslator;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
 */
public class ModelBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "hu.eltesoft.modelexecution.builders.modelbuilder"; //$NON-NLS-1$

	private IFileManagerFactory fileManagerFactory;

	private BuilderListenerInterface listenerInterface;

	/**
	 * Caches resources that are not open in an editor.
	 */
	private ResourceSet resourceSet = new ResourceSetImpl();

	private BuilderFileManager builderFileManager;

	private IChangeListenerTranslatorFactory translatorFactory;

	/**
	 * Default constructor used by Eclipse
	 */
	public ModelBuilder() {
		this(new FileManagerFactory(), new ChangeListenerTranslatorFactory());
	}

	/**
	 * A more configurable version.
	 */
	public ModelBuilder(IFileManagerFactory fileManagerFactory,
			IChangeListenerTranslatorFactory translatorFactory) {
		this.fileManagerFactory = fileManagerFactory;
		this.translatorFactory = translatorFactory;
	}

	@Override
	protected void startupOnInitialize() {
		builderFileManager = new BuilderFileManager(getBuiltProject(),
				fileManagerFactory);
		listenerInterface = new BuilderListenerInterface(getBuiltProject(),
				builderFileManager, translatorFactory);
		super.startupOnInitialize();
	}

	@Override
	public IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {

		TransactionalEditingDomain shared = PapyrusEditorListener.getDomain();

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

	public void build(int kind) {
		if (kind == AUTO_BUILD || kind == INCREMENTAL_BUILD) {
			incrementalBuild();
		} else if (kind == FULL_BUILD) {
			fullBuild();
		}
		builderFileManager.refreshFolder();
	}

	/**
	 * Removes and regenerates the codes for the model resources.
	 */
	private void fullBuild() {
		listenerInterface.hookupChangeListeners();
		FileUpdateTaskQueue queue = new FileUpdateTaskQueue();
		try {
			getBuiltProject().accept(res -> {
				if (ResourceAnalyzer.isModelResource(res)) {
					queue.addAll(rebuild(res));
				}
				return true;
			});
		} catch (CoreException e) {
			IdePlugin.logError("Error while rebuilding resources", e); //$NON-NLS-1$
		}
		queue.performAll();
	}

	/**
	 * Forces model builders to be initialized. See
	 * {@linkplain startupOnInitialize}.
	 */
	public static void initializeBuilders() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		for (IProject project : projects) {
			try {
				if (project.isOpen()
						&& project.hasNature(ExecutableModelNature.NATURE_ID)) {
					project.build(AUTO_BUILD, null);
				}
			} catch (CoreException e) {
				IdePlugin.logError("Cannot initialize builders", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Adds generators for new .uml files and regenerates the content of
	 * existing .uml files.
	 */
	private void incrementalBuild() {
		IResourceDelta delta = getDelta(getBuiltProject());
		FileUpdateTaskQueue rebuild = new FileUpdateTaskQueue();
		try {
			delta.accept(new IResourceDeltaVisitor() {
				@Override
				public boolean visit(IResourceDelta delta) throws CoreException {
					IResource resource = delta.getResource();
					if (delta.getKind() == IResourceDelta.ADDED) {
						if (ResourceAnalyzer.isModelResource(resource)) {
							listenerInterface.registerResource(resource);
							rebuild.addAll(rebuild(resource));
						}
					} else if (delta.getKind() == IResourceDelta.CHANGED) {
						if (ResourceAnalyzer.isModelResource(resource)) {
							rebuild.addAll(rebuild(resource));
						}
					}
					return true;
				}
			});
			rebuild.performAll();
		} catch (CoreException e) {
			IdePlugin.logError("Exception while incremental build.", e); //$NON-NLS-1$
		}
	}

	/**
	 * Rebuilds the files that are generated from the given resource. Uses
	 * incremental compilation if the current resource is opened in an editor,
	 * or simply performs a full build on the resource if not.
	 */
	private FileUpdateTaskQueue rebuild(IResource resource) {
		// FIXME: also register?
		FileUpdateTaskQueue rebuild = new FileUpdateTaskQueue();
		if (listenerInterface.translators.containsKey(resource)) {
			rebuild.addAll(listenerInterface.translators.get(resource)
					.rebuild());
		} else {
			try {
				// reads the model resource when it isn't open in an editor
				URI uri = URI.createFileURI(resource.getLocation().toString());
				Resource res = resourceSet.getResource(uri, true);
				if (res != null) {
					IncQueryEngine engine;
					engine = IncQueryEngine.on(res);
					SimpleM2MTranslator translator = listenerInterface.translatorFactory
							.createTranslator(engine, builderFileManager);
					rebuild.addAll(translator.fullBuild());
				} else {
					IdePlugin.logError("Resource to rebuild is not found: " //$NON-NLS-1$
							+ resource);
				}
			} catch (IncQueryException e) {
				IdePlugin.logError("Error while rebuilding resource", e); //$NON-NLS-1$
			}
		}
		return rebuild;
	}

	protected IProject getBuiltProject() {
		return getProject();
	}

}
