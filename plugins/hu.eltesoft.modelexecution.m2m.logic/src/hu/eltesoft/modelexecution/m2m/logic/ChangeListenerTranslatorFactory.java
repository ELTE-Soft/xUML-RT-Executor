package hu.eltesoft.modelexecution.m2m.logic;

import hu.eltesoft.modelexecution.m2m.logic.impl.ChangeListenerM2MTranslatorImpl;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class ChangeListenerTranslatorFactory implements IChangeListenerTranslatorFactory {

	@Override
	public ChangeListenerM2MTranslator createTranslator(IncQueryEngine engine,
			TextChangesListener listener) throws IncQueryException {
		return new ChangeListenerM2MTranslatorImpl(engine, listener);
	}

}
