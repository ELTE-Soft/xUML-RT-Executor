package hu.eltesoft.modelexecution.m2m.logic.translators;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

import com.incquerylabs.uml.papyrus.IncQueryEngineService;

import hu.eltesoft.modelexecution.m2m.logic.SourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.UpdateSourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.CompositeReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.uml.incquery.Queries;

/**
 * This translator converts model resources into a set of translational models
 * and finally to templates. Collects translators for different kind of root
 * elements (UML elements that are translated into separate java files), and
 * handles the resource-specific conversion details concerning incremental
 * changes.
 */
public class ResourceTranslator {

	public static ResourceTranslator createIncremental(ModelSet modelSet) {
		return new ResourceTranslator(modelSet, true);
	}

	public static ResourceTranslator create(ModelSet modelSet) {
		return new ResourceTranslator(modelSet, false);
	}

	private ModelSet resource;
	private boolean incremental;
	private boolean disposed;
	private AdvancedIncQueryEngine engine;
	private ReversibleTask attachListeners;

	private List<RootElementTranslator<?, ?, ?>> translators;

	private ResourceTranslator(ModelSet modelSet, boolean incremental) {
		this.resource = modelSet;
		this.incremental = incremental;
		setupEngine();
	}

	private void setupEngine() {
		disposed = false;
		
		try {
			IncQueryEngine incQueryEngine = IncQueryEngineService.getOrCreateEngineEvenIfModelIsClosed(resource);
			engine = AdvancedIncQueryEngine.from(incQueryEngine);

			Queries.instance().prepare(engine);
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
		translators.add(new AssociationClassTranslator(engine));
		translators.add(new BehaviorTranslator(engine));
		translators.add(new CallableProxyTranslator(engine));
		translators.add(new ClassTranslator(engine));
		translators.add(new ClassSpecTranslator(engine));
		translators.add(new ExternalEntityTranslator(engine));
		translators.add(new RegionTranslator(engine));
		translators.add(new SignalTranslator(engine));
	}

	private void attachListeners() {
		CompositeReversibleTask task = new CompositeReversibleTask();
		for (RootElementTranslator<?, ?, ?> translator : translators) {
			task.add(translator.addListeners());
		}
		attachListeners = task;
	}

	public void toIncremental(ModelSet resource) {
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
			throw new IllegalStateException("Cannot use Translator after dispose."); //$NON-NLS-1$
		}
	}

	public void dispose() {
		if (disposed) {
			return;
		}

		if (incremental) {
			attachListeners.revert();
		}

		disposed = true;
	}

	public List<SourceCodeTask> fullTranslation() {
		checkDisposed();

		List<SourceCodeTask> updateTasks = new LinkedList<>();
		for (RootElementTranslator<?, ?, ?> translator : translators) {
			performBatchTranslation(updateTasks, translator);
		}
		return updateTasks;
	}

	private void performBatchTranslation(List<SourceCodeTask> updateTasks, RootElementTranslator<?, ?, ?> translator) {
		translator.clear();
		translator.getAllTemplates().forEach((rootName, template) -> {
			updateTasks.add(new UpdateSourceCodeTask(rootName, template));
		});
	}

	public List<SourceCodeTask> incrementalTranslation() {
		checkDisposed();

		if (!incremental) {
			return fullTranslation();
		}
		
		List<SourceCodeTask> changes = new LinkedList<>();
		for (RootElementTranslator<?, ?, ?> translator : translators) {
			changes.addAll(translator.incrementalTranslation());
		}
		return changes;
	}
}
