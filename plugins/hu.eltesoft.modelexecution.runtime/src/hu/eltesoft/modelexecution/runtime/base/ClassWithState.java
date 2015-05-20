package hu.eltesoft.modelexecution.runtime.base;

import hu.eltesoft.modelexecution.runtime.Runtime;

/**
 * The base class of generated code from UML classes.
 */
public abstract class ClassWithState extends Class {

	private Runtime runtime;

	public ClassWithState(Runtime runtime) {
		super();
		this.runtime = runtime;
	}

	public abstract void init();

	public abstract void receive(Message message);

	public Runtime getRuntime() {
		return runtime;
	}

}
