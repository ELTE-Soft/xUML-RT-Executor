package hu.eltesoft.modelexecution.m2m.logic;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public interface IChangeListenerTranslatorFactory {

	ChangeListenerM2MTranslator createTranslator(IncQueryEngine engine,
			TextChangesListener listener) throws IncQueryException;

}
