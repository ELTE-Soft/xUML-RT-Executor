package hu.eltesoft.modelexecution.m2m.logic.listeners;

import hu.eltesoft.modelexecution.m2m.logic.registry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.registry.RootNameStorage;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;

public class ListenerContext {

	private final AdvancedIncQueryEngine engine;
	private final ChangeRegistry changes;
	private final RootNameStorage rootNames;

	public AdvancedIncQueryEngine getEngine() {
		return engine;
	}

	public ChangeRegistry getChanges() {
		return changes;
	}

	public RootNameStorage getRootNames() {
		return rootNames;
	}

	public ListenerContext(AdvancedIncQueryEngine engine,
			ChangeRegistry changes, RootNameStorage rootNames) {
		this.engine = engine;
		this.changes = changes;
		this.rootNames = rootNames;
	}
}
