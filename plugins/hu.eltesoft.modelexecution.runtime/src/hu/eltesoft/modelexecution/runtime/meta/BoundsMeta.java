package hu.eltesoft.modelexecution.runtime.meta;

import org.json.JSONObject;

/**
 * Stores the multiplicity of an attribute on the meta-level.
 */
public class BoundsMeta {

	private static final String LOWER_FIELD = "lower";
	private static final String UPPER_FIELD = "upper";
	public static BoundsMeta SINGLE = new BoundsMeta(1, 1);
	public static BoundsMeta OPTIONAL = new BoundsMeta(0, 1);
	public static BoundsMeta ANY = new BoundsMeta(0, -1);
	public static BoundsMeta MANY = new BoundsMeta(1, -1);
	
	/**
	 * Upper bound on the multiplicity. -1 means no upper bound.
	 */
	private int upper;
	
	/**
	 * Lower bound on the multiplicity
	 */
	private int lower;

	public BoundsMeta(int upper, int lower) {
		this.upper = upper;
		this.lower = lower;
	}

	public int getUpper() {
		return upper;
	}

	public int getLower() {
		return lower;
	}
	
	// serialization and deserialization

	private BoundsMeta() {
	}
	
	public JSONObject serializeToJson() {
		JSONObject obj = new JSONObject();
		obj.put(UPPER_FIELD, upper);
		obj.put(LOWER_FIELD, lower);
		return obj;
	}
	
	public static BoundsMeta deserialize(String serialized) {
		return deserialize(new JSONObject(serialized));
	}

	public static BoundsMeta deserialize(JSONObject json) {
		BoundsMeta ret = new BoundsMeta();
		ret.deserializeFromJson(json);
		return ret;
	}
	
	public void deserializeFromJson(JSONObject json) {
		upper = json.getInt(UPPER_FIELD);
		lower = json.getInt(LOWER_FIELD);
	}

	/**
	 * @return true, if the multiplicity cannot be greater than 1.
	 */
	public boolean isAtMostSingle() {
		return upper == 0 || upper == 1;
	}

}
