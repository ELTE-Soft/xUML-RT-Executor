package hu.eltesoft.modelexecution.m2m.logic.tasks;

/**
 * A task to revert some previously done action.
 */
public interface ReversionTask {

	/**
	 * Perform the reversion.
	 * 
	 * @return whether the reversion was successful
	 */
	boolean revert();
	
}
