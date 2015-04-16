package hu.eltesoft.modelexecution.m2m.logic.impl;

import hu.eltesoft.modelexecution.m2m.logic.ChangeListenerM2MTranslator;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.ContainerNameProvider;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Default implementation for the {@link ChangeListenerM2MTranslator} interface.
 * 
 * @author Gábor Ferenc Kovács
 *
 */
public class ChangeListenerM2MTranslatorImpl extends SimpleM2MTranslatorImpl
		implements ChangeListenerM2MTranslator {

	private final AdvancedIncQueryEngine advancedEngine;
	private final ChangeRegistry changeRegistry;
	private boolean listeningToModelChanges = false;
	private boolean modelBuilt = false;

	public ChangeListenerM2MTranslatorImpl(IncQueryEngine engine,
			TextChangesListener listener) throws IncQueryException {
		super(engine, listener);

		this.advancedEngine = AdvancedIncQueryEngine.from(engine);
		this.changeRegistry = ChangeRegistry.create(listener);

		regionGenerator.setChangeRegistry(changeRegistry);

		startListeningToModelChanges();
	}

	@Override
	public FileUpdateTaskQueue fullBuild() {
		startListeningToModelChanges();
		modelBuilt = true;
		return super.fullBuild();
	}

	private boolean startListeningToModelChanges() {
		if (listeningToModelChanges) {
			return false;
		}

		behaviorGenerator.addMatchUpdateListeners(advancedEngine,
				changeRegistry);
		classGenerator.addMatchUpdateListeners(advancedEngine, changeRegistry);
		regionGenerator.addMatchUpdateListeners(advancedEngine, changeRegistry);
		signalEventGenerator.addMatchUpdateListeners(advancedEngine,
				changeRegistry);
		signalGenerator.addMatchUpdateListeners(advancedEngine, changeRegistry);

		listeningToModelChanges = true;

		return true;
	}

	@Override
	public FileUpdateTaskQueue rebuild() {
		if (!modelBuilt) {
			return super.fullBuild();
		}
		return changeRegistry.performAllChanges();
	}

	@Override
	public ContainerNameProvider getContainerNameProvider() {
		return changeRegistry;
	}

}
