package hu.eltesoft.modelexecution.runtime.trace;

import java.io.IOException;
import java.nio.file.FileSystem;

import org.json.JSONException;

import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder;
import hu.eltesoft.modelexecution.runtime.trace.json.JSONObjectReader;

/**
 * This tracer replays the incoming events previously recorded in a JSON file.
 */
public class TraceReplayer implements TraceReader {

	private JSONDecoder jsonDecoder;
	private JSONObjectReader jsonReader;

	public TraceReplayer(String fileName, FileSystem fileSystem, ClassLoader classLoader)
			throws IOException, ClassNotFoundException, JSONException {
		jsonReader = new JSONObjectReader(fileName, fileSystem);
		jsonDecoder = new JSONDecoder(classLoader);
	}

	@Override
	public void dispatchEvent(Logger logger) {
		if (hasEvent()) {
			TargetedEvent readMessage = nextEvent();
			if (!readMessage.isFromOutside()) {
				throw new TraceMessageUnexpectedException(readMessage);
			} else {
				sendAndLog(logger, readMessage);
			}
		} else {
			throw new RuntimeException("dispatchEvent() on empty queue");
		}
	}

	private TargetedEvent nextEvent() {
		try {
			return jsonDecoder.decodeTargetedEvent(jsonReader.nextJSONObject());
		} catch (JSONException e) {
			throw new InvalidTraceException("Malformed trace", e);
		} catch (ClassNotFoundException e) {
			throw new InvalidTraceException("Classes in trace are not compatible with classes used by the runtime", e);
		}
	}

	@Override
	public boolean hasEvent() {
		return jsonReader.hasJSONObject();
	}

	@Override
	public EventSource dispatchEvent(TargetedEvent event, Logger logger) {
		if (hasEvent()) {
			TargetedEvent readMessage = nextEvent();
			if (readMessage.isFromOutside()) {
				sendAndLog(logger, readMessage);
				return EventSource.Trace;
			} else if (!event.equals(readMessage)) {
				throw new TraceMessageMismatchException(event, readMessage);
			}
		}
		sendAndLog(logger, event);
		return EventSource.Queue;
	}

	private void sendAndLog(Logger logger, TargetedEvent tracedEvent) {
		tracedEvent.send();
		logger.messageDispatched(tracedEvent.getTarget(), tracedEvent.getEvent());
	}

	@Override
	public void close() throws Exception {
		jsonReader.close();
	}

}
