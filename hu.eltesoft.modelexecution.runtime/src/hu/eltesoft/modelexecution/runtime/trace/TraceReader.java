package hu.eltesoft.modelexecution.runtime.trace;

/**
 * The trace reader can read events from trace files, created by a {@linkplain Tracer}.
 * 
 * @author nboldi
 */
public abstract class TraceReader implements AutoCloseable {

	/**
	 * Represents the source of the dispatched event.
	 */
	public enum EventSource {
		Queue, Trace
	}

	public abstract boolean hasEvent();

	/**
	 * Dispatch the event loaded from the trace file.
	 * Precondition: hasEvent() is true.
	 */
	public abstract void dispatchEvent();

	/**
	 * Dispatch the given event or an event loaded from a tracefile (if there is
	 * an external event).
	 */
	public abstract EventSource dispatchEvent(TargetedEvent event);

}
