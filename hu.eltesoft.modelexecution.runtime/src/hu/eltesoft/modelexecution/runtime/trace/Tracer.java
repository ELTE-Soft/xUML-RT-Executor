package hu.eltesoft.modelexecution.runtime.trace;

/**
 * The tracer can store dispatched events. The events can be replayed by a {@linkplain TraceReader}.
 * 
 * @author nboldi
 *
 */
public abstract class Tracer implements AutoCloseable {

	public abstract void traceEvent(TargetedEvent targetedEvent);

}
