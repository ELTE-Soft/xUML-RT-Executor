package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.log.Logger;

/**
 * A trace reader that does not read traces. Used to turn off trace reading
 * support.
 */
public class NoTraceReader implements TraceReader {

	@Override
	public boolean hasEvent() {
		return false;
	}

	@Override
	public void dispatchEvent(Logger logger) {
		throw new RuntimeException("dispatchEvent() when no trace is present");
	}

	@Override
	public EventSource dispatchEvent(TargetedEvent event, Logger logger) {
		event.send();
		logger.eventDispatched(event.getTarget(), event.getEvent());
		return EventSource.Queue;
	}

	@Override
	public void close() throws Exception {
	}

}
