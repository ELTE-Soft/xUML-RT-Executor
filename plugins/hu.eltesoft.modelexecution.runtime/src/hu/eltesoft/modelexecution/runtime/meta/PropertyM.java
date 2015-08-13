package hu.eltesoft.modelexecution.runtime.meta;

import org.json.JSONException;
import org.json.JSONObject;

import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder;
import hu.eltesoft.modelexecution.runtime.trace.json.JSONSerializable;

/**
 * Meta-representation of an attribute.
 */
public class PropertyM extends LeftValueM implements JSONSerializable {

	/**
	 * The actual name of the property, how it is referenced in the generated class file.
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
		JSONObject obj = super.jsonEncode();
		obj.put("identifier", identifier);
		obj.put("bounds", bounds.serializeToJson());
		return obj;
	}

	@Override
	public void jsonDecode(JSONDecoder reader, JSONObject obj) throws ClassNotFoundException, JSONException {
		super.jsonDecode(reader, obj);
		identifier = obj.getString("identifier");
		bounds = BoundsM.deserialize(obj.getJSONObject("bounds"));
	}

}
