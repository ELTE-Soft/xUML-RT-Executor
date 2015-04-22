package hu.eltesoft.modelexecution.ide.builder;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.PapyrusEditorListener;
import hu.eltesoft.modelexecution.m2m.logic.ChangeListenerM2MTranslator;
import hu.eltesoft.modelexecution.m2m.logic.IChangeListenerTranslatorFactory;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Provides services for tracking changes for a builder.
 */
public class BuilderListenerInterface {
	public IChangeListenerTranslatorFactory translatorFactory;
	public Map<IResource, ChangeListenerM2MTranslator> translators = new HashMap<>();
	public Map<Resource, ChangeListenerM2MTranslator> translatorsFromEmfRes = new HashMap<>();
	private TextChangesListener textChangesListener;

	public BuilderListenerInterface(IProject builtProject,
			TextChangesListener textChangesListener,
			IChangeListenerTranslatorFactory translatorFactory) {
		this.project = builtProject;
		this.textChangesListener = textChangesListener;
		this.translatorFactory = translatorFactory;
		builders.add(this);
	}

	private static List<BuilderListenerInterface> builders = new LinkedList<>();
	private IProject project;

	/**
	 * Registers resources for the compilation pipeline for all active builders.
	 * Without it, the project only supports incremental build after a clean
	 * operation.
	 * 
	 * Should be called after {@linkplain initializeBuilders}.
	 */
	public static void hookupAllChangeListeners() {
		for (BuilderListenerInterface modelBuilder : builders) {
			modelBuilder.hookupChangeListeners();
		}
	}

	/**
	 * Registers all uml resources in the project of the builder.
	 */
	public void hookupChangeListeners() {
		try {
			if (!project.isOpen()) {
				return;
			}
			project.accept(new IResourceVisitor() {
				@Override
				public boolean visit(IResource resource) throws CoreException {
					registerResource(resource);
					return true;
				}
			});
		} catch (CoreException e) {
			IdePlugin
					.logError("Exception while hooking up model listeners.", e); //$NON-NLS-1$
		}
	}

	/**
	 * Registers the resource for accumulating changes.
	 */
	protected void registerResource(IResource resource) {

		TransactionalEditingDomain domain = PapyrusEditorListener.getDomain();
		if (domain == null) {
			return;
		}

		URI uri = URI.createPlatformResourceURI(resource.getFullPath()
				.toString(), false);
		Resource res;
		try {
			res = domain.getResourceSet().getResource(uri, true);
		} catch (Exception e) {
			// probably not a model resource
			return;
		}
		if (res == null) {
			IdePlugin.logError("Resource does not exist: " + uri); //$NON-NLS-1$
			return;
		}
		try {
			IncQueryEngine engine = IncQueryEngine.on(res);
			ChangeListenerM2MTranslator translator = translatorFactory
					.createTranslator(engine, textChangesListener);
			translators.put(resource, translator);
			translatorsFromEmfRes.put(res, translator);
		} catch (IncQueryException e) {
			IdePlugin.logError("IncQuery engine could not be created.", e); //$NON-NLS-1$
		}
	}

	/**
	 * Returns the translator of the resource. Will return null, if the
	 * translator is not set for the resource. {@linkplain initializeBuilders}
	 * should be called before calling this method.
	 */
	public static ChangeListenerM2MTranslator getTranslatorOfEmfRes(Resource res) {
		for (BuilderListenerInterface modelBuilder : builders) {
			if (modelBuilder.translatorsFromEmfRes.containsKey(res)) {
				return modelBuilder.translatorsFromEmfRes.get(res);
			}
		}
		return null;
	}

}