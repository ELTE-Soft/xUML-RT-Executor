package hu.eltesoft.modelexecution.runtime.meta;

import org.json.JSONObject;

public class AttributeM extends LeftValueM {

	private String identifier;
	private BoundsM bounds;

	public AttributeM(String name, String identifier, BoundsM bounds) {
		this.name = name;
		this.identifier = identifier;
		this.bounds = bounds;
	}

	public String getIdentifier() {
		return identifier;
	}

	public BoundsM getBounds() {
		return bounds;
	}

	// serialization and deserialization
	
	private AttributeM() {
	}
	
	public JSONObject serializeToJson() {
		JSONObject obj = super.serializeToJson();
		obj.put("identifier", identifier);
		obj.put("bounds", bounds.serializeToJson());
		return obj;
	}
	
	public static AttributeM deserialize(String serialized) {
		return deserialize(new JSONObject(serialized));
	}

	public static AttributeM deserialize(JSONObject json) {
		AttributeM ret = new AttributeM();
		ret.deserializeFromJson(json);
		return ret;
	}
	
	public void deserializeFromJson(JSONObject json) {
		super.deserializeFromJson(json);
		identifier = json.getString("identifier");
		bounds = BoundsM.deserialize(json.getJSONObject("bounds"));
	}

}
