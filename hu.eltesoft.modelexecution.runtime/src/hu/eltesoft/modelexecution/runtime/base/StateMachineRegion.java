package hu.eltesoft.modelexecution.runtime.base;

/**
 * A base class for state machines (regions).
 * 
 * @author nboldi
 */
public abstract class StateMachineRegion {

	abstract public void step(Event event);
	
	abstract public void doInitialTransition();

}
