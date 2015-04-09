package hu.eltesoft.modelexecution.runtime.trace;

public interface IOutputTraceBuffer extends AutoCloseable {

	/**
	 * Adds an event to the buffer.
	 */
	public abstract void traceEvent(TargetedEvent event);

}