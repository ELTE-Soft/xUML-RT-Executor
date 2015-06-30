package hu.eltesoft.modelexecution.m2m.logic.translators;

import hu.eltesoft.modelexecution.m2m.logic.SourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.UpdateSourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.listeners.ListenerContext;
import hu.eltesoft.modelexecution.m2m.logic.registry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.registry.RootNameStorage;
import hu.eltesoft.modelexecution.m2m.logic.tasks.CompositeReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * This translator converts model resources into a set of translational models
 * and finally to templates. Collects translators for different kind of root
 * elements (UML elements that are translated into separate java files), and
 * handles the resource-specific conversion details concerning incremental
 * changes.
 */
public class ResourceTranslator {

	public static ResourceTranslator createIncremental(Resource resource) {
		return new ResourceTranslator(resource, true);
	}

	public static ResourceTranslator create(Resource resource) {
		return new ResourceTranslator(resource, false);
	}

	private final ChangeRegistry changes = new ChangeRegistry();
	private final RootNameStorage rootNames = new RootNameStorage();

	private Resource resource;
	private boolean incremental;
	private boolean disposed;
	private AdvancedIncQueryEngine engine;
	private ReversibleTask attachListeners;

	private List<RootElementTranslator<?, ?, ?>> translators;

	private ResourceTranslator(Resource resource, boolean incremental) {
		this.resource = resource;
		this.incremental = incremental;
		setupEngine();
	}

	private void setupEngine() {
		disposed = false;

		changes.clear();
		rootNames.clear();

		try {
			if (incremental) {
				engine = AdvancedIncQueryEngine.from(IncQueryEngine
						.on(resource));
			} else {
				engine = AdvancedIncQueryEngine.createUnmanagedEngine(resource);
			}

			setupTranslators();

			if (incremental) {
				attachListeners();
			}
		} catch (IncQueryException e) {
			throw new RuntimeException(e);
		}
	}

	private void setupTranslators() throws IncQueryException {
		translators = new LinkedList<>();
		translators.add(new AssociationTranslator(engine));
		translators.add(new BehaviorTranslator(engine));
		translators.add(new CallableProxyTranslator(engine));
		translators.add(new ClassTranslator(engine));
		translators.add(new ExternalEntityTranslator(engine));
		translators.add(new RegionTranslator(engine));
		translators.add(new SignalEventTranslator(engine));
		translators.add(new SignalTranslator(engine));
	}

	private void attachListeners() {
		CompositeReversibleTask task = new CompositeReversibleTask();
		ListenerContext context = new ListenerContext(engine, changes,
				rootNames);
		for (RootElementTranslator<?, ?, ?> translator : translators) {
			task.add(translator.addListeners(context));
		}
		attachListeners = task;
	}

	public void toIncremental(Resource resource) {
		checkDisposed();

		if (incremental) {
			if (this.resource == resource) {
				// do nothing, we are already upgraded
				return;
			}
			incremental = false;
			attachListeners.revert();
		}

		incremental = true;
		this.resource = resource;
		setupEngine();
	}

	private void checkDisposed() {
		if (disposed) {
			throw new IllegalStateException(
					"Cannot use Translator after dispose."); //$NON-NLS-1$
		}
	}

	public void dispose() {
		if (disposed) {
			return;
		}

		if (incremental) {
			attachListeners.revert();
		} else {
			engine.dispose();
		}
		disposed = true;
	}

	public List<SourceCodeTask> fullTranslation() {
		checkDisposed();

		changes.clear();

		List<SourceCodeTask> updateTasks = new LinkedList<>();
		for (RootElementTranslator<?, ?, ?> translator : translators) {
			performBatchTranslation(updateTasks, translator);
		}
		return updateTasks;
	}

	private void performBatchTranslation(List<SourceCodeTask> updateTasks,
			RootElementTranslator<?, ?, ?> translator) {
		translator.getAllTemplates().forEach((rootName, template) -> {
			updateTasks.add(new UpdateSourceCodeTask(rootName, template));
		});
	}

	public List<SourceCodeTask> incrementalTranslation() {
		checkDisposed();

		if (!incremental) {
			return fullTranslation();
		}
		return changes.performTranslation();
	}
}