package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.generators.BehaviorGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.ClassGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.RegionGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.SignalEventGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.SignalGenerator;
import hu.eltesoft.modelexecution.m2m.logic.tasks.CompositeReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ModelGenerationTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class Translator {

	public static Translator createIncremental(Resource resource) {
		return new Translator(resource, true);
	}

	public static Translator create(Resource resource) {
		return new Translator(resource, false);
	}

	private final ChangeRegistry changeRegistry = new ChangeRegistry();
	private Resource resource;
	private boolean incremental;
	private boolean disposed;
	private AdvancedIncQueryEngine engine;
	private ReversibleTask attachListeners;

	private BehaviorGenerator behaviorGenerator;
	private ClassGenerator classGenerator;
	private RegionGenerator regionGenerator;
	private SignalEventGenerator signalEventGenerator;
	private SignalGenerator signalGenerator;

	private Translator(Resource resource, boolean incremental) {
		this.resource = resource;
		this.incremental = incremental;
		setupEngine();
	}

	private void setupEngine() {
		disposed = false;

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
		behaviorGenerator = new BehaviorGenerator(engine);
		classGenerator = new ClassGenerator(engine);
		regionGenerator = new RegionGenerator(engine);
		signalEventGenerator = new SignalEventGenerator(engine);
		signalGenerator = new SignalGenerator(engine);
	}

	private void attachListeners() {
		CompositeReversibleTask t = new CompositeReversibleTask();
		t.add(behaviorGenerator.addListeners(engine, changeRegistry));
		t.add(classGenerator.addListeners(engine, changeRegistry));
		t.add(regionGenerator.addListeners(engine, changeRegistry));
		t.add(signalEventGenerator.addListeners(engine, changeRegistry));
		t.add(signalGenerator.addListeners(engine, changeRegistry));
		attachListeners = t;
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

	public List<FileUpdateTask> fullBuild() {
		checkDisposed();

		changeRegistry.clear();

		ModelGenerationTaskQueue genTasks = new ModelGenerationTaskQueue();

		behaviorGenerator.runOn(behavior -> genTasks.addNew(behavior,
				behaviorGenerator));
		classGenerator.runOn(cls -> genTasks.addNew(cls, classGenerator));
		regionGenerator.runOn(region -> genTasks
				.addNew(region, regionGenerator));
		signalEventGenerator.runOn(event -> genTasks.addNew(event,
				signalEventGenerator));
		signalGenerator.runOn(signal -> genTasks
				.addNew(signal, signalGenerator));

		List<FileUpdateTask> updateTasks = new LinkedList<>();
		genTasks.forEach(task -> updateTasks.add(task.perform()));

		return updateTasks;
	}

	public List<FileUpdateTask> incrementalBuild() {
		checkDisposed();

		if (!incremental) {
			return fullBuild();
		}
		return changeRegistry.performAllChanges();
	}
}
