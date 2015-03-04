package hu.eltesoft.modelexecution.runtime.trace;

import java.io.FileNotFoundException;

/**
 * This tracer replays the incoming events previously recorded in a set of XML files. Uses 
 * 
 * @author nboldi
 */
public class TraceReplayer extends TraceReader {

	private InputTraceBuffer source;

	public TraceReplayer(String logFileName) throws FileNotFoundException {
		source = new InputTraceBuffer(logFileName);
	}

	@Override
	public void dispatchEvent() {
		if (source.hasMoreElems()) {
			TargetedEvent tracedEvent = source.getTracedEvent();
			tracedEvent.send();
		} else {
			throw new RuntimeException("dispatchEvent() on empty queue");
		}
	}

	@Override
	public boolean hasEvent() {
		return source.hasMoreElems();
	}

	@Override
	public EventSource dispatchEvent(TargetedEvent event) {
		if (source.hasMoreElems()) {
			TargetedEvent tracedEvent = source.getTracedEvent();
			if (tracedEvent.isFromOutside()) {
				tracedEvent.send();
				return EventSource.Trace;
			} else if (!event.equals(tracedEvent)) {
				String msg = "The event read from queue is not the same as the event read from the trace. Queue: "
						+ event + ", Trace: " + tracedEvent;
				throw new RuntimeException(msg);
			}
		}
		event.send();
		return EventSource.Queue;
	}

	@Override
	public void close() throws Exception {
		source.close();
	}

}
