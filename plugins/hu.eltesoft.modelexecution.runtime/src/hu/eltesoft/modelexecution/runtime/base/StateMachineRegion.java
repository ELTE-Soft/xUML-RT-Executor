package hu.eltesoft.modelexecution.runtime.base;

/**
 * A base class for state machines (regions).
 */
public abstract class StateMachineRegion {

	abstract public void step(Message message);

	abstract public void doInitialTransition();

}
