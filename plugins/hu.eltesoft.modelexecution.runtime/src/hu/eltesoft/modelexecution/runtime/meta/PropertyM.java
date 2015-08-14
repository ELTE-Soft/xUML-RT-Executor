package hu.eltesoft.modelexecution.runtime.meta;

import org.json.JSONException;
import org.json.JSONObject;

import hu.eltesoft.modelexecution.runtime.serialize.JSONDecoder;
import hu.eltesoft.modelexecution.runtime.serialize.JSONSerializable;

/**
 * Meta-representation of an attribute. Needs to be serialized because it is a
 * part of {@linkplain ClassM}
 */
public class PropertyM extends LeftValueM implements JSONSerializable {

	private static final String BOUNDS_FIELD = "bounds";

	private static final String IDENTIFIER_FIELD = "identifier";

	private static final String NAME_FIELD = "name";

	/**
	 * The actual name of the property, how it is referenced in the generated
	 * class file.
	 */
	private String identifier;

	/**
	 * Multiplicity of the property.
	 */
	private BoundsM bounds;

	public PropertyM(String name, String identifier, BoundsM bounds) {
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

	private PropertyM() {
	}

	public static PropertyM deserialize(String serialized) {
		return deserialize(new JSONObject(serialized));
	}

	public static PropertyM deserialize(JSONObject json) {
		PropertyM ret = new PropertyM();
		try {
			ret.jsonDecode(new JSONDecoder(PropertyM.class.getClassLoader()), json);
			return ret;
		} catch (ClassNotFoundException | JSONException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public JSONObject jsonEncode() {
		JSONObject obj = new JSONObject();
		obj.put(NAME_FIELD, name);
		obj.put(IDENTIFIER_FIELD, identifier);
		obj.put(BOUNDS_FIELD, bounds.serializeToJson());
		return obj;
	}

	@Override
	public void jsonDecode(JSONDecoder reader, JSONObject obj) throws ClassNotFoundException, JSONException {
		name = obj.getString(NAME_FIELD);
		identifier = obj.getString(IDENTIFIER_FIELD);
		bounds = BoundsM.deserialize(obj.getJSONObject(BOUNDS_FIELD));
	}

}
