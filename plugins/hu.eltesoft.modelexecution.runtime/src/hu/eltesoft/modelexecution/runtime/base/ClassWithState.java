package hu.eltesoft.modelexecution.runtime.base;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;

/**
 * The base class of generated code from UML classes that have a state machine.
 */
public abstract class ClassWithState extends Class implements StatefulClass {

	private final StateMachineRegion stateMachine;

	public ClassWithState(SubobjectsDestructor subobjectsDestructor, int instanceID) {
		super(subobjectsDestructor, instanceID);
		stateMachine = createStateMachine();
	}

	/**
	 * To be overridden by the generated child classes
	 */
	protected abstract StateMachineRegion createStateMachine();

	public StateMachineRegion getStateMachine() {
		return stateMachine;
	}

	public void initializeStateMachine() {
		if (null != stateMachine) {
			stateMachine.doInitialTransition();
		}
	}

	@Override
	public void send(Event event) {
		if (isDeleted()) {
			// verification error: sending message to a deleted object
			return;
		}
		BaseRuntime.getInstance().addEventToQueue(this, event);
	}

	@Override
	public void sendExternal(Event event) {
		if (isDeleted()) {
			// verification error: sending message to a deleted object
			return;
		}
		BaseRuntime.getInstance().addExternalEventToQueue(this, event);
	}

	@Override
	public void receive(Event event) {
		if (!isDeleted()) {
			// deliver events only to non-deleted objects
			stateMachine.step(event);
		}
	}
}
