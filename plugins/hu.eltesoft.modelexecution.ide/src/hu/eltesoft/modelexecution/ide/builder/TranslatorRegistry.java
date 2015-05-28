package hu.eltesoft.modelexecution.ide.builder;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.m2m.logic.Translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * Holds translator instances for IResources.
 */
public class TranslatorRegistry {

	private static final String UML_EXTENSION = "uml"; //$NON-NLS-1$

	public static final TranslatorRegistry INSTANCE = new TranslatorRegistry();

	private final Map<URI, Resource> resources = new HashMap<>();
	private final Map<URI, Translator> translators = new HashMap<>();

	protected TranslatorRegistry() {
	}

	public synchronized void resourceLoaded(Resource resource) {
		if (!isUMLResource(resource)) {
			return;
		}

		URI uri = resource.getURI();
		resources.put(uri, resource);
		Translator t = translatorFor(uri, Translator::createIncremental);
		t.toIncremental(resource);
	}

	public synchronized void resourceUnloaded(Resource resource) {
		if (!isUMLResource(resource)) {
			return;
		}

		URI uri = resource.getURI();
		Translator translator = translators.get(uri);
		if (null != translator) {
			translator.dispose();
			translators.remove(uri);
		}
		resources.remove(uri);
	}

	public synchronized void resourceUnloaded(IResource resource) {
		try {
			resource.accept(new IResourceVisitor() {

				@Override
				public boolean visit(IResource resource) throws CoreException {
					Resource model = get(resource);
					if (null != model) {
						resourceUnloaded(model);
					}
					return true;
				}
			});
		} catch (CoreException e) {
			IdePlugin.logError("Error while cleaning up project resources", e); //$NON-NLS-1$
		}
	}

	public void runTranslatorFor(IResource file, Consumer<Translator> task) {
		if (!isUMLResource(file)) {
			return;
		}

		Translator translator;
		Resource model;
		TransactionalEditingDomain domain = null;

		synchronized (this) {
			translator = translatorFor(file);
			model = get(file);

			if (null != model) {
				ResourceSet resourceSet = model.getResourceSet();
				domain = DomainRegistry.INSTANCE.getDomain(resourceSet);
			}
		}

		if (null == model) {
			task.accept(translator);
			return;
		}

		try {
			domain.runExclusive(() -> task.accept(translator));
		} catch (InterruptedException e) {
			IdePlugin.logError("Error while rebuilding resource", e); //$NON-NLS-1$
		} catch (NullPointerException e) {
			// the editor had been closed while the task runs (the editor
			// and the transaction is disposed)
			task.accept(translator);
		}
	}

	private Translator translatorFor(IResource file) {
		URI uri = fileToURI(file);
		return translatorFor(uri);
	}

	private Translator translatorFor(URI uri) {
		return translatorFor(uri, Translator::create);
	}

	private Translator translatorFor(URI uri,
			Function<Resource, Translator> createTranslator) {
		Translator translator = translators.get(uri);
		if (null == translator) {
			Resource model = loadModelOnDemand(uri);
			translator = createTranslator.apply(model);
			translators.put(uri, translator);
		}
		return translator;
	}

	private Resource loadModelOnDemand(URI uri) {
		Resource loadedModel = resources.get(uri);
		if (null == loadedModel) {
			try {
				ResourceSet resourceSet = new ResourceSetImpl();
				loadedModel = resourceSet.getResource(uri, true);
			} catch (Exception e) {
				IdePlugin.logError("Error while rebuilding resource", e); //$NON-NLS-1$
				return null;
			}
		}
		return loadedModel;
	}

	private Resource get(IResource file) {
		return resources.get(fileToURI(file));
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

	private boolean isUMLResource(Resource resource) {
		String extension = resource.getURI().fileExtension();
		if (null == extension) {
			return false;
		}
		return extension.toLowerCase().equals(UML_EXTENSION);
	}
}
