package hu.eltesoft.modelexecution.runtime.base;

import hu.eltesoft.modelexecution.runtime.Runtime;

/**
 * The base class of generated code from UML classes.
 * 
 * @author nboldi
 */
public abstract class Class {

	private String name;
	private Runtime runtime;

	public Class(Runtime runtime, String name) {
		super();
		this.runtime = runtime;
		this.name = name;
	}

	public abstract void receive(Event event);

	public String getName() {
		return name;
	}

	public Runtime getRuntime() {
		return runtime;
	}

}
