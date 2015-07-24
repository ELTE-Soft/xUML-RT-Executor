package hu.eltesoft.modelexecution.runtime.base;

import hu.eltesoft.modelexecution.runtime.InstanceRegistry;
import hu.eltesoft.modelexecution.runtime.Runtime;

/**
 * The base class of generated code from UML classes.
 */
public abstract class ClassWithState extends Class implements StatefulClass {

	private final Runtime runtime;
	private final int instanceID;
	private final StateMachineRegion stateMachine;

	public ClassWithState(Runtime runtime, int instanceID) {
		super();
		this.runtime = runtime;
		this.instanceID = instanceID;
		stateMachine = createStateMachine();
	}

	/**
	 * To be overridden by the generated child classes
	 */
	protected abstract StateMachineRegion createStateMachine();

	@Override
	public Runtime getRuntime() {
		return runtime;
	}

	@Override
	public int getInstanceID() {
		return instanceID;
	}

	public void init() {
		stateMachine.doInitialTransition();
	}

	@Override
	public void receive(Event event) {
		stateMachine.step(event);
	}

	@Override
	public void dispose() {
		InstanceRegistry.getInstanceRegistry().unregisterInstance(this);
	}
}
