package hu.eltesoft.modelexecution.runtime.meta;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder;
import hu.eltesoft.modelexecution.runtime.trace.json.JSONSerializable;

/**
 * The meta-representation of a class. It can be used to store the structure of
 * the model-level object while it has already gone through code generation and
 * represented as a java class.
 */
public class ClassM implements JSONSerializable {

	private static final String PARENTS_FIELD = "parents";

	private static final String PROPERTIES_FIELD = "properties";

	private static final String NAME_FIELD = "name";

	/**
	 * The original name of the class.
	 */
	private String name;

	/**
	 * Owned properties.
	 */
	private PropertyM[] properties;

	/**
	 * Classes that are connected to this class through a generalization
	 * connection.
	 */
	private ClassM[] parents;

	public ClassM(String name, ClassM[] parents, PropertyM[] attributes) {
		this.name = name;
		this.properties = attributes;
		this.parents = parents;
	}

	public String getName() {
		return name;
	}

	public PropertyM[] getAttributes() {
		return properties;
	}

	public ClassM[] getParents() {
		return parents;
	}

	// serialization and deserialization

	private ClassM() {
	}

	public String serialize() {
		return jsonEncode().toString();
	}

	public static ClassM deserialize(String serialized) {
		return deserialize(new JSONObject(serialized));
	}

	public static ClassM deserialize(JSONObject classJSON) {
		ClassM ret = new ClassM();
		try {
			ret.jsonDecode(new JSONDecoder(ClassM.class.getClassLoader()), classJSON);
			return ret;
		} catch (ClassNotFoundException | JSONException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public JSONObject jsonEncode() {
		JSONObject ret = new JSONObject();
		ret.put(NAME_FIELD, name);
		JSONArray propertiesJSON = new JSONArray();
		for (PropertyM attribute : properties) {
			propertiesJSON.put(attribute.jsonEncode());
		}
		ret.put(PROPERTIES_FIELD, propertiesJSON);
		JSONArray parentsJSON = new JSONArray();
		for (ClassM parent : parents) {
			parentsJSON.put(parent.jsonEncode());
		}
		ret.put(PARENTS_FIELD, parentsJSON);
		return ret;
	}

	@Override
	public void jsonDecode(JSONDecoder reader, JSONObject obj) throws ClassNotFoundException, JSONException {
		name = obj.getString(NAME_FIELD);
		JSONArray attribArray = obj.getJSONArray(PROPERTIES_FIELD);
		this.properties = new PropertyM[attribArray.length()];
		for (int i = 0; i < attribArray.length(); ++i) {
			properties[i] = PropertyM.deserialize(attribArray.getJSONObject(i));
		}
		JSONArray parentArray = obj.getJSONArray(PARENTS_FIELD);
		this.parents = new ClassM[parentArray.length()];
		for (int i = 0; i < parentArray.length(); ++i) {
			parents[i] = deserialize(attribArray.getJSONObject(i));
		}
	}

}
