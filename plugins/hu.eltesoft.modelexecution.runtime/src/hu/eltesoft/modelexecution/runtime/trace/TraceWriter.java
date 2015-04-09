package hu.eltesoft.modelexecution.runtime.trace;

/**
 * This tracer serializes incoming events into a file. The file contains no root
 * element, so it can be read while still being written.
 */
public class TraceWriter extends Tracer {

	private IOutputTraceBuffer buffer;

	public TraceWriter(IOutputTraceBuffer outputTraceBuffer) {
		buffer = outputTraceBuffer;
	}
	
	@Override
	public void traceEvent(TargetedEvent event) {
		buffer.traceEvent(event);
	}

	@Override
	public void close() throws Exception {
		buffer.close();
	}

}
