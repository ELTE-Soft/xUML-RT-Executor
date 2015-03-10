package hu.eltesoft.modelexecution.runtime.trace;

/**
 * A trace reader that does not read traces. Used to turn off trace reading
 * support.
 * 
 * @author nboldi
 */
public class NoTraceReader extends TraceReader {

	@Override
	public boolean hasEvent() {
		return false;
	}

	@Override
	public void dispatchEvent() {
		throw new RuntimeException("dispatchEvent() when no trace is present");
	}

	@Override
	public EventSource dispatchEvent(TargetedEvent event) {
		event.send();
		return EventSource.Queue;
	}

	@Override
	public void close() throws Exception {
	}

}
