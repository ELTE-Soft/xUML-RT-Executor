package hu.eltesoft.modelexecution.runtime.meta;

import org.json.JSONObject;

public class LeftValueM {

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

	public JSONObject serializeToJson() {
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		return obj;
	}

	public void deserializeFromJson(JSONObject json) {
		name = json.getString("name");
	}

}