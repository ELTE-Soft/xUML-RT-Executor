package hu.eltesoft.modelexecution.runtime.meta;

import org.json.JSONException;
import org.json.JSONObject;

import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder;
import hu.eltesoft.modelexecution.runtime.trace.json.JSONSerializable;

/**
 * The meta representation of a left value is something with a name
 */
public abstract class LeftValueM implements JSONSerializable {

	private static final String NAME_FIELD = "name";
	protected String name;

	public LeftValueM(String name) {
		super();
		this.name = name;
	}

	protected LeftValueM() {
		super();
	}

	public String getName() {
		return name;
	}

	// serialization and deserialization

	public JSONObject jsonEncode() {
		JSONObject obj = new JSONObject();
		obj.put(NAME_FIELD, name);
		return obj;
	};

	@Override
	public void jsonDecode(JSONDecoder reader, JSONObject obj) throws ClassNotFoundException, JSONException {
		name = obj.getString(NAME_FIELD);
	}

}