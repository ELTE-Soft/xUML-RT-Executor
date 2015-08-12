package hu.eltesoft.modelexecution.runtime.meta;

import org.json.JSONObject;

public class AttributeM {

	public String name;
	public String identifier;
	public VisibilityM visibility;

	public AttributeM() {
	}
	
	public AttributeM(String name, String identifier, VisibilityM visibility) {
		this.name = name;
		this.visibility = visibility;
		this.identifier = identifier;
	}

	public JSONObject serializeToJson() {
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("identifier", identifier);
		obj.put("visibility", visibility.toString());
		return obj;
	}

	public void deserializeFromJson(JSONObject json) {
		name = json.getString("name");
		identifier = json.getString("identifier");
		visibility = VisibilityM.valueOf(json.getString("visibility"));
	}

}
