package hu.eltesoft.modelexecution.m2m.logic.impl;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryEngine;

import hu.eltesoft.modelexecution.m2m.logic.ChangeListenerM2MTranslator;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileUpdateTaskQueue;

public class ChangeListenerM2MTranslatorImpl extends SimpleM2MTranslatorImpl implements ChangeListenerM2MTranslator {

	@SuppressWarnings("unused")
	private final AdvancedIncQueryEngine advancedEngine;
	
	
	public ChangeListenerM2MTranslatorImpl(IncQueryEngine engine, TextChangesListener listener) {
		super(engine, listener);
		this.advancedEngine = AdvancedIncQueryEngine.from(engine);
	}

	@Override
	public FileUpdateTaskQueue fullBuild() {
		startListeningToModelChanges();
		super.fullBuild();
		return null;
		// TODO
	}
	
	private void startListeningToModelChanges() {
		//advancedEngine.addMatchUpdateListener(matcher, listener, fireNow);
	}

	@Override
	public FileUpdateTaskQueue rebuild() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
