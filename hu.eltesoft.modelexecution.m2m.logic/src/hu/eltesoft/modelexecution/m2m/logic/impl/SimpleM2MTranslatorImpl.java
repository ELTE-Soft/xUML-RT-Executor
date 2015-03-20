package hu.eltesoft.modelexecution.m2m.logic.impl;

import org.eclipse.incquery.runtime.api.IncQueryEngine;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.SimpleM2MTranslator;
import hu.eltesoft.modelexecution.m2m.logic.tasks.FileUpdateTaskQueue;

public class SimpleM2MTranslatorImpl  implements SimpleM2MTranslator {

	private final IncQueryEngine engine;
	@SuppressWarnings("unused") // TODO
	private final TextChangesListener listener;

	public SimpleM2MTranslatorImpl(IncQueryEngine engine, TextChangesListener listener) {
		this.engine = engine;
		this.listener = listener;
	}

	@Override
	public IncQueryEngine getIncQueryEngine() {
		return engine;
	}
	
	@Override
	public FileUpdateTaskQueue fullBuild() {
		// TODO Auto-generated method stub
		return null;
	}

}
