package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.generators.BehaviorGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.ClassGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.RegionGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.SignalEventGenerator;
import hu.eltesoft.modelexecution.m2m.logic.generators.SignalGenerator;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ModelGenerationTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class Translator {

	public static Translator createUpgraded(Resource resource) {
		return new Translator(resource, true);
	}

	public static Translator create(Resource resource) {
		return new Translator(resource, false);
	}

	private final ChangeRegistry changeRegistry = ChangeRegistry.create();
	private Resource resource;
	private boolean upgraded;
	private AdvancedIncQueryEngine engine;
	private ReversionTask attachListeners;

	private BehaviorGenerator behaviorGenerator;
	private ClassGenerator classGenerator;
	private RegionGenerator regionGenerator;
	private SignalEventGenerator signalEventGenerator;
	private SignalGenerator signalGenerator;

	private Translator(Resource resource, boolean upgraded) {
		this.resource = resource;
		this.upgraded = upgraded;
		setupEngine();
	}

	private void setupEngine() {
		try {
			if (upgraded) {
				engine = AdvancedIncQueryEngine.from(IncQueryEngine
						.on(resource));
			} else {
				engine = AdvancedIncQueryEngine.createUnmanagedEngine(resource);
			}

			behaviorGenerator = new BehaviorGenerator(engine);
			classGenerator = new ClassGenerator(engine);
			regionGenerator = new RegionGenerator(engine);
			signalEventGenerator = new SignalEventGenerator(engine);
			signalGenerator = new SignalGenerator(engine);

			if (upgraded) {
				attachListeners();
			}
		} catch (IncQueryException e) {
			throw new RuntimeException(e);
		}
	}

	private void attachListeners() {
		attachListeners = new ReversionTask() {

			private final ReversionTask[] subtasks;

			{
				subtasks = new ReversionTask[5];
				subtasks[0] = behaviorGenerator.addMatchUpdateListeners(engine,
						changeRegistry);
				subtasks[1] = classGenerator.addMatchUpdateListeners(engine,
						changeRegistry);
				subtasks[2] = regionGenerator.addMatchUpdateListeners(engine,
						changeRegistry);
				subtasks[3] = signalEventGenerator.addMatchUpdateListeners(
						engine, changeRegistry);
				subtasks[4] = signalGenerator.addMatchUpdateListeners(engine,
						changeRegistry);
			}

			@Override
			public boolean revert() {
				for (ReversionTask subtask : subtasks) {
					subtask.revert();
				}
				return true;
			}
		};
	}

	public void upgrade(Resource resource) {
		if (upgraded) {
			if (this.resource == resource) {
				// do nothing, we are already upgraded
				return;
			}
			dispose();
		}

		this.resource = resource;
		setupEngine();
	}

	public void dispose() {
		attachListeners.revert();
	}

	public List<FileUpdateTask> fullBuild() {
		changeRegistry.clear();

		ModelGenerationTaskQueue generationTaskQueue = new ModelGenerationTaskQueue();

		behaviorGenerator.runOn(behavior -> generationTaskQueue.addNew(
				behavior, behaviorGenerator));
		classGenerator.runOn(cls -> generationTaskQueue.addNew(cls,
				classGenerator));
		regionGenerator.runOn(region -> generationTaskQueue.addNew(region,
				regionGenerator));
		signalEventGenerator.runOn(event -> generationTaskQueue.addNew(event,
				signalEventGenerator));
		signalGenerator.runOn(signal -> generationTaskQueue.addNew(signal,
				signalGenerator));

		List<FileUpdateTask> updateTaskQueue = new LinkedList<>();
		generationTaskQueue
				.forEach(task -> updateTaskQueue.add(task.perform()));

		return updateTaskQueue;
	}

	public List<FileUpdateTask> incrementalBuild() {
		if (!upgraded) {
			return fullBuild();
		}

		return changeRegistry.performAllChanges();
	}
}
