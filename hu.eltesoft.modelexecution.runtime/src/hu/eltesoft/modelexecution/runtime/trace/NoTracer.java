package hu.eltesoft.modelexecution.runtime.trace;

/**
 * A tracer that does not record traces. Used to turn off tracing.
 * 
 * @author nboldi
 */
public class NoTracer extends Tracer {

	@Override
	public void traceEvent(TargetedEvent targetedEvent) {
		// nothing to do
	}

	@Override
	public void close() throws Exception {
	}

}
