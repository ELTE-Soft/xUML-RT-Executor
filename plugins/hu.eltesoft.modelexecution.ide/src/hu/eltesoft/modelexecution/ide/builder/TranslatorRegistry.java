package hu.eltesoft.modelexecution.ide.builder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;

/**
 * Holds translator instances for IResources.
 */
public class TranslatorRegistry {

	private static final String UML_EXTENSION = "uml"; //$NON-NLS-1$

	public static final TranslatorRegistry INSTANCE = new TranslatorRegistry();

	private final Map<ModelSet, ResourceTranslator> translators = new HashMap<>();
	private final Map<URI, ModelSet> modelContainment = new HashMap<>();

	protected TranslatorRegistry() {
	}

	public void modelSetLoaded(ModelSet modelSet) {
		ResourceTranslator t = translatorFor(modelSet, ResourceTranslator::createIncremental);
		t.toIncremental(modelSet);

		for (Resource resource : modelSet.getResources()) {
			modelContainment.put(resource.getURI(), modelSet);
		}
	}

	public void modelSetUnloaded(ModelSet modelSet) {
	}

	public synchronized void resourceRemoved(IResource resource) {
		try {
			resource.accept(new IResourceVisitor() {

				@Override
				public boolean visit(IResource resource) throws CoreException {
					ModelSet removed = modelContainment.remove(resource.getLocationURI());
					if (removed != null) {
						checkIfUsed(removed);
					}
					return true;
				}

				private void checkIfUsed(ModelSet removed) {
					if (!modelContainment.values().contains(removed)) {
						// TODO: release resource
					}
				}
			});
		} catch (CoreException e) {
			// silently ignore, would write an error for every missing file
			// this is a cleaunup operation, no problems could arise from
			// skipping it for some resources that are not even in the registry
		}
	}

	public void runTranslatorFor(IResource file, Consumer<ResourceTranslator> task) {
		if (!isUMLResource(file)) {
			return;
		}

		ResourceTranslator translator;
		ModelSet model;
		TransactionalEditingDomain domain = null;

		synchronized (this) {
			translator = translatorFor(file);
			model = get(file);

			if (null != model) {
				domain = model.getTransactionalEditingDomain();
			}
		}

		if (null == model) {
			task.accept(translator);
			return;
		}

		try {
			domain.runExclusive(() -> task.accept(translator));
		} catch (InterruptedException e) {
			PluginLogger.logError("Error while rebuilding resource", e); //$NON-NLS-1$
		} catch (NullPointerException e) {
			// the editor had been closed while the task runs (the editor
			// and the transaction is disposed)
			task.accept(translator);
		}
	}

	private ResourceTranslator translatorFor(IResource file) {
		return translatorFor(fileToURI(file));
	}

	private ResourceTranslator translatorFor(URI uri) {
		return translatorFor(uri, ResourceTranslator::create);
	}

	private ResourceTranslator translatorFor(URI uri, Function<ModelSet, ResourceTranslator> createTranslator) {
		ModelSet modelSet = modelContainment.get(uri);
		if (null == modelSet) {
			modelSet = loadModelOnDemand(uri);
		}
		return translatorFor(modelSet, createTranslator);
	}

	private ResourceTranslator translatorFor(ModelSet modelSet,
			Function<ModelSet, ResourceTranslator> createTranslator) {
		ResourceTranslator translator = translators.get(modelSet);
		if (null == translator) {
			translator = createTranslator.apply(modelSet);
			translators.put(modelSet, translator);
		}
		return translator;
	}

	private ModelSet loadModelOnDemand(URI uri) {
		ModelSet modelSet = modelContainment.get(uri);
		if (null == modelSet) {
			try {
				modelSet = new ModelSet();
				modelSet.getResource(uri, true);
			} catch (Exception e) {
				PluginLogger.logError("Error while rebuilding resource", e); //$NON-NLS-1$
			}
		}
		return modelSet;
	}

	private ModelSet get(IResource file) {
		return modelContainment.get(fileToURI(file));
	}

	private URI fileToURI(IResource file) {
		String workspacePath = file.getFullPath().toString();
		URI uri = URI.createPlatformResourceURI(workspacePath, true);
		return uri;
	}

	private boolean isUMLResource(IResource resource) {
		String extension = resource.getFileExtension();
		if (null == extension) {
			return false;
		}
		return extension.toLowerCase().equals(UML_EXTENSION);
	}

}
