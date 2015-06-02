package hu.eltesoft.modelexecution.m2m.logic.tasks;

/**
 * A task which is able to revert some previously done action.
 */
public interface ReversibleTask {

	/**
	 * Perform the reversion. The original action is usually done in the
	 * constructor of the implementation class.
	 * 
	 * @return whether the reversion was successful
	 */
	boolean revert();
}
