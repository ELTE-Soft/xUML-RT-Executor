package hu.eltesoft.modelexecution.m2m.logic.impl;

import hu.eltesoft.modelexecution.m2m.logic.ChangeListenerM2MTranslator;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Default implementation for the {@link ChangeListenerM2MTranslator} interface.
 */
public class ChangeListenerM2MTranslatorImpl extends SimpleM2MTranslatorImpl
		implements ChangeListenerM2MTranslator {

	private final AdvancedIncQueryEngine advancedEngine;
	private final ChangeRegistry changeRegistry;
	private boolean listenersActive = false;
	
	/**
	 * Non-null if {@link #listenersActive} is <code>true</code>;
	 */
	private ReversionTask removeListenersTask = null;

	public ChangeListenerM2MTranslatorImpl(IncQueryEngine engine,
			TextChangesListener listener) throws IncQueryException {
		super(engine, listener);
		this.advancedEngine = AdvancedIncQueryEngine.from(engine);
		this.changeRegistry = ChangeRegistry.create(listener);
		activateListeners(false);
	}

	@Override
	public FileUpdateTaskQueue fullBuild() {
		activateListeners(false);
		
		changeRegistry.clear();
		
		return super.fullBuild();
	}

	@Override
	public FileUpdateTaskQueue rebuild() {
		if (!listenersActive) {
			return fullBuild();
		}
		
		return changeRegistry.performAllChanges();
	}

	@Override
	public boolean activateListeners(boolean force) {
		if (listenersActive && !force) {
			return false;
		}

		inactivateListeners();

		removeListenersTask = new ReversionTask() {

			private final ReversionTask[] subtasks;

			{
				subtasks = new ReversionTask[5];
				subtasks[0] = behaviorGenerator.addMatchUpdateListeners(
						advancedEngine, changeRegistry);
				subtasks[1] = classGenerator.addMatchUpdateListeners(
						advancedEngine, changeRegistry);
				subtasks[2] = regionGenerator.addMatchUpdateListeners(
						advancedEngine, changeRegistry);
				subtasks[3] = signalEventGenerator.addMatchUpdateListeners(
						advancedEngine, changeRegistry);
				subtasks[4] = signalGenerator.addMatchUpdateListeners(
						advancedEngine, changeRegistry);
			}

			@Override
			public boolean revert() {

				for (ReversionTask subtask : subtasks) {
					subtask.revert();
				}

				return true;
			}

		};

		listenersActive = true;

		return true;
	}

	@Override
	public boolean inactivateListeners() {
		if (!listenersActive) {
			return false;
		}

		removeListenersTask.revert();
		removeListenersTask = null;

		return true;
	}

}
