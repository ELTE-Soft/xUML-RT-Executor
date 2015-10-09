package hu.eltesoft.modelexecution.runtime.base;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

import hu.eltesoft.modelexecution.runtime.serialize.JSONDecoder;

/**
 * A base class for events that carry a signal. We do not distinguish between
 * SignalEvents carrying the same signal.
 */
public class SignalEvent extends Event {

	private static final String JSON_SIGNAL_FIELD = "signal";
	private static final String JSON_PRIORITY_FIELD = "priority";
	private static final String JSON_SEQUENCE_NUMBER_FIELD = "sequenceNumber";

	/**
	 * The signal carried by the event. Cannot be null.
	 */
	private Signal signal;

	/**
	 * Empty constructor used for deserialization.
	 */
	public SignalEvent() {
	}

	public SignalEvent(Signal signal) {
		this.signal = signal;
	}

	public SignalEvent(Signal signal, Event.Priority priority) {
		this.signal = signal;
		this.priority = priority;
	}

	public Signal getSignal() {
		return signal;
	}

	@Override
	public JSONObject jsonEncode() {
		JSONObject ret = new JSONObject();
		ret.put(JSONDecoder.JSON_CLASS, getClass().getCanonicalName());
		ret.put(JSON_SIGNAL_FIELD, signal.jsonEncode());
		ret.put(JSON_PRIORITY_FIELD, priority.ordinal());
		ret.put(JSON_SEQUENCE_NUMBER_FIELD, sequenceNumber);
		return ret;
	}

	@Override
	public void jsonDecode(JSONDecoder reader, JSONObject obj) throws ClassNotFoundException, JSONException {
		JSONObject signalJSON = obj.getJSONObject(JSON_SIGNAL_FIELD);
		signal = (Signal) reader.decodeJSON(signalJSON);
		priority = Event.Priority.values()[obj.getInt(JSON_PRIORITY_FIELD)];
		sequenceNumber = obj.getInt(JSON_SEQUENCE_NUMBER_FIELD);
	}

	@Override
	public int hashCode() {
		return Objects.hash(signal);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof SignalEvent)) {
			return false;
		}
		SignalEvent other = (SignalEvent) obj;
		return priority.equals(other.priority) && signal.equals(other.signal);
	}

}
