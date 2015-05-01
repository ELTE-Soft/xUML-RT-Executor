package hu.eltesoft.modelexecution.runtime;

/**
 * The possible conditions how the runtime can terminate. Each condition has an
 * exit code.
 */
public enum TerminationResult {

	/**
	 * The runtime exited successfully after every event was dispatched.
	 */
	SUCCESSFUL_TERMINATION(0),

	/**
	 * An internal error happened in the runtime so it was aborted.
	 */
	INTERNAL_ERROR(1),

	/**
	 * The runtime used a trace file that was not consistent with the executed
	 * model.
	 */
	INVALID_TRACEFILE(2);

	private TerminationResult(int errorCode) {
		this.errorCode = errorCode;
	}

	private int errorCode;

	/**
	 * @return The exit code of the application that is associated with the
	 *         result.
	 */
	public int getExitCode() {
		return errorCode;
	}
}
