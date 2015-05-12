package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.log.Logger;

/**
 * This tracer replays the incoming events previously recorded in a set of XML
 * files.
 */
public class TraceReplayer implements TraceReader {

	private IInputTraceBuffer source;

	public TraceReplayer(IInputTraceBuffer buffer) {
		source = buffer;
	}

	@Override
	public void dispatchEvent(Logger logger) {
		if (source.hasMoreElems()) {
			TargetedMessage tracedEvent = source.getTracedEvent();
			sendAndLog(logger, tracedEvent);
		} else {
			throw new RuntimeException("dispatchEvent() on empty queue");
		}
	}

	@Override
	public boolean hasEvent() {
		return source.hasMoreElems();
	}

	@Override
	public EventSource dispatchEvent(TargetedMessage event, Logger logger) {
		if (source.hasMoreElems()) {
			TargetedMessage tracedEvent = source.getTracedEvent();
			if (tracedEvent.isFromOutside()) {
				sendAndLog(logger, tracedEvent);
				return EventSource.Trace;
			} else if (!event.equals(tracedEvent)) {
				throw new InvalidTraceException(event, tracedEvent);
			}
		}
		sendAndLog(logger, event);
		return EventSource.Queue;
	}

	private void sendAndLog(Logger logger, TargetedMessage tracedEvent) {
		tracedEvent.send();
		logger.messageDispatched(tracedEvent.getTarget(), tracedEvent.getMessage());
	}

	@Override
	public void close() throws Exception {
		source.close();
	}

}
