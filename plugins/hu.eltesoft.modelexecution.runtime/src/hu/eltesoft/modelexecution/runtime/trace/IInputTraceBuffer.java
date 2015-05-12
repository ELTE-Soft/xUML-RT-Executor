package hu.eltesoft.modelexecution.runtime.trace;

public interface IInputTraceBuffer extends AutoCloseable {

	/**
	 * True, if getTracedEvent() can be called.
	 */
	public abstract boolean hasMoreElems();

	/**
	 * Takes the next event. If the queue becomes empty loads the next file.
	 */
	public abstract TargetedMessage getTracedEvent();

}