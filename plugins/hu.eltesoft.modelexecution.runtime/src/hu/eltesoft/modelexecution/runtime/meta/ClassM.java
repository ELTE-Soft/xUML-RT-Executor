package hu.eltesoft.modelexecution.runtime.meta;

import org.json.JSONArray;
import org.json.JSONObject;

public class ClassM {

	public AttributeM[] attributes;
	public ClassM[] parents;

	public ClassM() {
	}

	public ClassM(ClassM[] parents, AttributeM[] attributes) {
		this.attributes = attributes;
		this.parents = parents;
	}
	
	// serialization and deserialization
	
	public String serialize() {
		return serializeToJson().toString();
	}

	public JSONObject serializeToJson() {
		JSONObject ret = new JSONObject();
		JSONArray attributesJSON = new JSONArray();
		for (AttributeM attribute : attributes) {
			attributesJSON.put(attribute.serializeToJson());
		}
		ret.put("attributes", attributesJSON);
		JSONArray parentsJSON = new JSONArray();
		for (ClassM parent : parents) {
			parentsJSON.put(parent.serializeToJson());
		}
		ret.put("parents", parentsJSON);
		return ret;
	}

	public static ClassM deserialize(String serialized) {
		ClassM ret = new ClassM();
		ret.deserializeFromJson(new JSONObject(serialized));
		return ret;
	}
	
	public void deserializeFromJson(JSONObject classJSON) {
		JSONArray attribArray = classJSON.getJSONArray("attributes");
		this.attributes = new AttributeM[attribArray.length()];
		for (int i = 0; i < attribArray.length(); ++i) {
			AttributeM attribute = new AttributeM();
			attribute.deserializeFromJson(attribArray.getJSONObject(i));
			attributes[i] = attribute;
		}
		JSONArray parentArray = classJSON.getJSONArray("parents");
		this.parents = new ClassM[parentArray.length()];
		for (int i = 0; i < parentArray.length(); ++i) {
			ClassM parent = new ClassM();
			parent.deserializeFromJson(attribArray.getJSONObject(i));
			parents[i] = parent;
		}

	}

}
