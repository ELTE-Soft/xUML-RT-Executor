package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.log.Logger;

/**
 * The trace reader can read events from trace files, created by a {@linkplain Tracer}.
 */
public interface TraceReader extends AutoCloseable {

	/**
	 * Represents the source of the dispatched event.
	 */
	enum EventSource {
		Queue, Trace
	}

	boolean hasEvent();

	/**
	 * Dispatch the event loaded from the trace file.
	 * Precondition: hasEvent() is true.
	 */
	void dispatchEvent(Logger logger);

	/**
	 * Dispatch the given event or an event loaded from a tracefile (if there is
	 * an external event).
	 */
	EventSource dispatchEvent(TargetedEvent event, Logger logger);

}
