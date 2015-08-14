package hu.eltesoft.modelexecution.runtime.serialize;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystem;
import java.nio.file.Files;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import hu.eltesoft.modelexecution.runtime.trace.InvalidTraceException;

/**
 * A class for reading JSON objects from a given trace file.
 */
public class JSONObjectReader implements AutoCloseable {

	private JSONTokener tokener;
	private JSONObject nextMessage;
	private Reader reader;

	public JSONObjectReader(String fileName, FileSystem fileSystem) throws IOException {
		reader = Files.newBufferedReader(fileSystem.getPath(fileName));
		tokener = new JSONTokener(reader);
		readNextObject();
	}

	/**
	 * Reads the next JSON object and moves to the following. Safe to call when
	 * {@linkplain #hasJSONObject()} evaluates to true.
	 */
	public JSONObject nextJSONObject() throws ClassNotFoundException {
		JSONObject ret = nextMessage;
		if (nextMessage == null) {
			throw new IllegalStateException("nextEvent on empty JSONReader");
		} else {
			readNextObject();
			return ret;
		}
	}

	private void readNextObject() {
		if (tokener.nextClean() == 0) {
			// only whitespace remained before eof
			nextMessage = null;
		} else {
			// puts back the character read by nextClean()
			tokener.back();
			try {
				nextMessage = new JSONObject(tokener);
			} catch (JSONException e) {
				throw new InvalidTraceException("Syntax errors in trace", e);
			}
		}
	}

	/**
	 * Is there a next JSON object to read. If it return false,
	 * {@linkplain #nextJSONObject()} will fail.
	 */
	public boolean hasJSONObject() {
		return nextMessage != null;
	}

	@Override
	public void close() throws Exception {
		reader.close();
	}

}
