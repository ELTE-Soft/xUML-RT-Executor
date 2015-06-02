package hu.eltesoft.modelexecution.runtime.base;

import hu.eltesoft.modelexecution.runtime.Runtime;

/**
 * The base class of generated code from UML classes.
 */
public abstract class ClassWithState extends Class {

	private Runtime runtime;
	private int instanceID;

	public ClassWithState(Runtime runtime, int instanceID) {
		super();
		this.runtime = runtime;
		this.instanceID = instanceID;
	}

	public abstract void init();

	public abstract void receive(Message message);

	public Runtime getRuntime() {
		return runtime;
	}
	
	/**
	 * Unregisters the instance to allow garbage-collection
	 */
	public abstract void dispose();
	
	public int getInstanceID() {
		return instanceID;
	}

}
