package hu.eltesoft.modelexecution.m2m.logic.listeners;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;

import hu.eltesoft.modelexecution.m2m.logic.registry.RootNameStorage;

/**
 * Parameter object needed to setup or remove incremental change listeners of a
 * translator.
 */
public class ListenerContext {

	private final AdvancedIncQueryEngine engine;
	private final RootNameStorage rootNames;

	public AdvancedIncQueryEngine getEngine() {
		return engine;
	}

	public RootNameStorage getRootNames() {
		return rootNames;
	}

	public ListenerContext(AdvancedIncQueryEngine engine, RootNameStorage rootNames) {
		this.engine = engine;
		this.rootNames = rootNames;
	}
}
