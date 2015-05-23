package hu.eltesoft.modelexecution.runtime.trace.json;

import org.json.JSONException;
import org.json.JSONObject;

public interface JSONSerializable {

	JSONObject jsonEncode();
	void jsonDecode(JSONDecoder reader, JSONObject obj) throws ClassNotFoundException, JSONException;
	
}
