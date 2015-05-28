package hu.eltesoft.modelexecution.ide.builder;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.m2m.logic.Translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.core.resources.IProject;
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

	private final Map<ResourceSet, Map<URI, Resource>> resources = new HashMap<>();
	private final Map<URI, Translator> translators = new HashMap<>();

	protected TranslatorRegistry() {
	}

	public synchronized void resourceSetLoaded(ResourceSet resourceSet) {
		Map<URI, Resource> m = resources.get(resourceSet);
		if (null == m) {
			m = new HashMap<>();
			resources.put(resourceSet, m);
		}

		for (Resource resource : resourceSet.getResources()) {
			if (!isUMLResource(resource)) {
				continue;
			}

			URI uri = resource.getURI();
			m.put(uri, resource);

			Translator translator = translatorFor(uri,
					Translator::createIncremental);
			translator.toIncremental(resource);
		}
	}

	public synchronized void resourceSetUnloaded(ResourceSet resourceSet) {
		resources.remove(resourceSet);
	}

	public synchronized void resourceLoaded(ResourceSet resourceSet,
			Resource resource) {
		URI uri = resource.getURI();
		// m should not be null as the domain were loaded before the
		// resource itself
		Map<URI, Resource> m = resources.get(resourceSet);
		m.put(uri, resource);
	}

	public synchronized void resourceUnloaded(ResourceSet resourceSet,
			Resource resource) {
		URI uri = resource.getURI();
		// m should not be null as the domain will be unloaded after the
		// resource itself
		Map<URI, Resource> m = resources.get(resourceSet);
		Translator translator = translators.get(uri);
		if (null != translator) {
			translator.dispose();
			translators.remove(uri);
		}
		m.remove(uri);
	}

	public synchronized void forgetResources(IProject project) {
		try {
			project.accept(new IResourceVisitor() {

				@Override
				public boolean visit(IResource resource) throws CoreException {
					if (isUMLResource(resource)) {
						forgetResource(resource);
					}
					return true;
				}
			});
		} catch (CoreException e) {
			IdePlugin.logError("Error while cleaning up project resources", e); //$NON-NLS-1$
		}
	}

	public synchronized void forgetResource(IResource file) {
		translators.remove(fileToURI(file));
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
		Resource loadedModel = get(uri);
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
		return get(fileToURI(file));
	}

	private Resource get(URI uri) {
		for (Map<URI, Resource> m : resources.values()) {
			Resource resource = m.get(uri);
			if (null != resource) {
				return resource;
			}
		}
		return null;
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
