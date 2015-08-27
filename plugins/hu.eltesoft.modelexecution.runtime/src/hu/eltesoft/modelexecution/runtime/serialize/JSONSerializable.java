package hu.eltesoft.modelexecution.runtime.serialize;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A type for objects that can be serialized into JSON and can be deserialized
 * from.
 */
public interface JSONSerializable {

	JSONObject jsonEncode();

	void jsonDecode(JSONDecoder reader, JSONObject obj) throws ClassNotFoundException, JSONException;

}
