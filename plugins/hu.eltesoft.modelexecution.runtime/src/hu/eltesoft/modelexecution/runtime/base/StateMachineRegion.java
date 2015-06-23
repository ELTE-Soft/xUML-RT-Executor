package hu.eltesoft.modelexecution.runtime.base;

/**
 * Interface for state machines (regions).
 */
public interface StateMachineRegion {

	void doInitialTransition();

	void step(Message message);
}
