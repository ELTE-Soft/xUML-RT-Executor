package hu.eltesoft.modelexecution.runtime.base;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.InstanceRegistry;

/**
 * The base class of generated code from UML classes that have a state machine.
 */
public abstract class ClassWithState extends Class implements StatefulClass {

	private final int instanceID;
	private final StateMachineRegion stateMachine;

	public ClassWithState(int instanceID) {
		super();
		this.instanceID = instanceID;
		stateMachine = createStateMachine();
	}

	/**
	 * To be overridden by the generated child classes
	 */
	protected abstract StateMachineRegion createStateMachine();

	public int getInstanceID() {
		return instanceID;
	}
	
	public StateMachineRegion getStateMachine() {
		return stateMachine;
	}
	
	public void initializeStateMachine() {
		if (null != stateMachine) {
			stateMachine.doInitialTransition();
		}
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
	
	@Override
	public String toString() {
		return getOriginalClassName() + "#" + getInstanceID();
	}
}
