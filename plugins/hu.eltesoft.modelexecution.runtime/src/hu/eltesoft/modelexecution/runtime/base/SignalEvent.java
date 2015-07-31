package hu.eltesoft.modelexecution.runtime.base;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder;

/**
 * A base class for events that carry a signal. We do not distinguish between
 * SignalEvents carrying the same signal.
 */
public class SignalEvent extends Event {

	private static final String JSON_SIGNAL_FIELD = "signal";

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

	public Signal getSignal() {
		return signal;
	}

	@Override
	public JSONObject jsonEncode() {
		JSONObject ret = new JSONObject();
		ret.put(JSONDecoder.JSON_CLASS, getClass().getCanonicalName());
		ret.put(JSON_SIGNAL_FIELD, signal.jsonEncode());
		return ret;
	}

	@Override
	public void jsonDecode(JSONDecoder reader, JSONObject obj) throws ClassNotFoundException, JSONException {
		JSONObject signalJSON = obj.getJSONObject(JSON_SIGNAL_FIELD);
		signal = (Signal) reader.decodeJSON(signalJSON);
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
		return signal.equals(other.signal);
	}

}
