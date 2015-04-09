package hu.eltesoft.modelexecution.runtime.trace;

/**
 * A tracer that does not record traces. Used to turn off tracing.
 */
public class NoTracer implements Tracer {

	@Override
	public void traceEvent(TargetedEvent targetedEvent) {
		// nothing to do
	}

	@Override
	public void close() throws Exception {
	}

}
