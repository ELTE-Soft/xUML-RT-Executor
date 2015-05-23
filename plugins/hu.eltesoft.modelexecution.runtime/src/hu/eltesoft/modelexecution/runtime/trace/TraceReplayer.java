package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder;
import hu.eltesoft.modelexecution.runtime.util.PathConverter;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystem;
import java.nio.file.Files;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * This tracer replays the incoming events previously recorded in a set of XML
 * files.
 */
public class TraceReplayer implements TraceReader {

	private JSONTokener tokener;
	private JSONDecoder jsonReader;
	private TargetedMessage nextMessage;
	private Reader reader;

	public TraceReplayer(String fileName, FileSystem fileSystem,
			ClassLoader classLoader) throws IOException,
			ClassNotFoundException, JSONException {
		jsonReader = new JSONDecoder(classLoader);
		System.err.println(fileName);
		reader = Files.newBufferedReader(PathConverter
				.workspaceToProjectBasedPath(fileSystem, fileName));
		tokener = new JSONTokener(reader);
		readNextEvent();
	}

	@Override
	public void dispatchEvent(Logger logger) {
		if (hasEvent()) {
			try {
				TargetedMessage readMessage = nextEvent();
				if (!readMessage.isFromOutside()) {
					throw new InvalidTraceException(nextMessage);
				} else {
					sendAndLog(logger, readMessage);
				}
			} catch (ClassNotFoundException e) {
				throw new DeserializationException(e);
			}
		} else {
			throw new RuntimeException("dispatchEvent() on empty queue");
		}
	}

	private void readNextEvent() {
		if (tokener.nextClean() == 0) {
			// only whitespace remained before eof
			nextMessage = null;
		} else {
			// puts back the character read by nextClean()
			tokener.back();
			try {
				nextMessage = new TargetedMessage(jsonReader, new JSONObject(tokener));
			} catch (ClassNotFoundException e) {
				throw new InvalidTraceException(e);
			} catch (JSONException e) {
				throw new DeserializationException(e);
			}
		}
	}

	@Override
	public boolean hasEvent() {
		return nextMessage != null;
	}

	private TargetedMessage nextEvent() throws ClassNotFoundException {
		TargetedMessage ret = nextMessage;
		readNextEvent();
		return ret;
	}

	@Override
	public EventSource dispatchEvent(TargetedMessage event, Logger logger) {
		if (hasEvent()) {
			try {
				TargetedMessage readMessage = nextEvent();
				if (readMessage.isFromOutside()) {
					sendAndLog(logger, readMessage);
					return EventSource.Trace;
				} else if (!event.equals(readMessage)) {
					throw new InvalidTraceException(event, nextMessage);
				}
			} catch (ClassNotFoundException e) {
				throw new DeserializationException(e);
			}
		}
		sendAndLog(logger, event);
		return EventSource.Queue;
	}

	private void sendAndLog(Logger logger, TargetedMessage tracedEvent) {
		tracedEvent.send();
		logger.messageDispatched(tracedEvent.getTarget(),
				tracedEvent.getMessage());
	}

	@Override
	public void close() throws Exception {
		reader.close();
	}

}
