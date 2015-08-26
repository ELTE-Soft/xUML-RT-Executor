package hu.eltesoft.modelexecution.runtime.base;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.InstanceRegistry;

/**
 * The base class of generated code from UML classes.
 */
public abstract class ClassWithState extends Class implements StatefulClass {

	private final int instanceID;
	private final StateMachineRegion stateMachine;

	public ClassWithState(int instanceID) {
		super();
		this.instanceID = instanceID;
		stateMachine = createStateMachine();
		if (null != stateMachine) {
			stateMachine.doInitialTransition();
		}
	}

	/**
	 * To be overridden by the generated child classes
	 */
	protected abstract StateMachineRegion createStateMachine();

	public int getInstanceID() {
		return instanceID;
	}

	public void send(Event event) {
		BaseRuntime.getInstance().addEventToQueue(this, event);
	}

	public void sendExternal(Event event) {
		BaseRuntime.getInstance().addExternalEventToQueue(this, event);
	}

	public void receive(Event event) {
		stateMachine.step(event);
	}

	public void dispose() {
		InstanceRegistry.getInstanceRegistry().unregisterInstance(this);
	}
}
