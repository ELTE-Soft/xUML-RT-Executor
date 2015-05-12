package hu.eltesoft.modelexecution.runtime.trace;

/**
 * The tracer can store dispatched events. The events can be replayed by a
 * {@linkplain TraceReader}.
 */
public interface Tracer extends AutoCloseable {

	void traceEvent(TargetedMessage targetedEvent);

}
