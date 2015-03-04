package hu.eltesoft.modelexecution.runtime.trace;


/**
 * This tracer serializes incoming events into a file. The file contains no root
 * element, so it can be read while still being written. The serialization is a
 * naive reflection based solution.
 * 
 * @author nboldi
 */
public class TraceWriter extends Tracer {

	private OutputTraceBuffer output;
	private static final int TRACE_BUFFER_SIZE = 10;

	public TraceWriter(String folderName) {
		output = new OutputTraceBuffer(folderName, TRACE_BUFFER_SIZE);
	}
	
	@Override
	public void traceEvent(TargetedEvent event) {
		output.traceEvent(event);
	}

	@Override
	public void close() throws Exception {
		output.close();
	}

}
