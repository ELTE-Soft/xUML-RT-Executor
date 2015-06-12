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

	private BehaviorTranslator behaviorTranslator;
	private ClassTranslator classTranslator;
	private RegionTranslator regionTranslator;
	private SignalEventTranslator signalEventTranslator;
	private SignalTranslator signalTranslator;

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

			setupGenerators();

			if (incremental) {
				attachListeners();
			}
		} catch (IncQueryException e) {
			throw new RuntimeException(e);
		}
	}

	private void setupGenerators() throws IncQueryException {
		behaviorTranslator = new BehaviorTranslator(engine);
		classTranslator = new ClassTranslator(engine);
		regionTranslator = new RegionTranslator(engine);
		signalEventTranslator = new SignalEventTranslator(engine);
		signalTranslator = new SignalTranslator(engine);
	}

	private void attachListeners() {
		CompositeReversibleTask task = new CompositeReversibleTask();
		ListenerContext context = new ListenerContext(engine, changes,
				rootNames);
		task.add(behaviorTranslator.addListeners(context));
		task.add(classTranslator.addListeners(context));
		task.add(regionTranslator.addListeners(context));
		task.add(signalEventTranslator.addListeners(context));
		task.add(signalTranslator.addListeners(context));
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
		performBatchTranslation(updateTasks, behaviorTranslator);
		performBatchTranslation(updateTasks, classTranslator);
		performBatchTranslation(updateTasks, regionTranslator);
		performBatchTranslation(updateTasks, signalEventTranslator);
		performBatchTranslation(updateTasks, signalTranslator);
		return updateTasks;
	}

	private void performBatchTranslation(List<SourceCodeTask> updateTasks,
			RootElementTranslator<?, ?, ?> builder) {
		builder.getAllTemplates().forEach(
				t -> updateTasks.add(new UpdateSourceCodeTask(t)));
	}

	public List<SourceCodeTask> incrementalTranslation() {
		checkDisposed();

		if (!incremental) {
			return fullTranslation();
		}
		return changes.performTranslation();
	}
}
