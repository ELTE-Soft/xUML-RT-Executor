package hu.eltesoft.modelexecution.runtime.meta;

import org.json.JSONArray;
import org.json.JSONObject;

public class ClassM {

	private String name;
	private AttributeM[] attributes;
	private ClassM[] parents;

	public ClassM(String name, ClassM[] parents, AttributeM[] attributes) {
		this.name = name;
		this.attributes = attributes;
		this.parents = parents;
	}
	
	public String getName() {
		return name;
	}
	
	public AttributeM[] getAttributes() {
		return attributes;
	}

	public ClassM[] getParents() {
		return parents;
	}
	
	// serialization and deserialization

	private ClassM() {
	}
	
	public String serialize() {
		return serializeToJson().toString();
	}

	public JSONObject serializeToJson() {
		JSONObject ret = new JSONObject();
		ret.put("name", name);
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
		return deserialize(new JSONObject(serialized));
	}

	public static ClassM deserialize(JSONObject classJSON) {
		ClassM ret = new ClassM();
		ret.deserializeFromJson(classJSON);
		return ret;
	}
	
	public void deserializeFromJson(JSONObject classJSON) {
		name = classJSON.getString("name");
		JSONArray attribArray = classJSON.getJSONArray("attributes");
		this.attributes = new AttributeM[attribArray.length()];
		for (int i = 0; i < attribArray.length(); ++i) {
			attributes[i] = AttributeM.deserialize(attribArray.getJSONObject(i));
		}
		JSONArray parentArray = classJSON.getJSONArray("parents");
		this.parents = new ClassM[parentArray.length()];
		for (int i = 0; i < parentArray.length(); ++i) {
			parents[i] = deserialize(attribArray.getJSONObject(i));
		}

	}

}
