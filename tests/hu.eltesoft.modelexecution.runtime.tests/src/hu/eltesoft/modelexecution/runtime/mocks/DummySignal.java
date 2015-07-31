package hu.eltesoft.modelexecution.runtime.mocks;

import org.json.JSONException;
import org.json.JSONObject;

import hu.eltesoft.modelexecution.runtime.base.Signal;
import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder;

public class DummySignal extends Signal {

	@Override
	public boolean equals(Object obj) {
		return (obj != null && obj instanceof DummySignal);
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public JSONObject jsonEncode() {
		return new JSONObject().put("class", getClass().getCanonicalName());
	}

	@Override
	public void jsonDecode(JSONDecoder reader, JSONObject obj) throws ClassNotFoundException, JSONException {
		// nothing to do
	}

}
