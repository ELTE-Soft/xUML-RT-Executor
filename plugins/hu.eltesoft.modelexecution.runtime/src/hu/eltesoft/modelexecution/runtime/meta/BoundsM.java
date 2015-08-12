package hu.eltesoft.modelexecution.runtime.meta;

import org.json.JSONObject;

public class BoundsM {

	public static BoundsM SINGLE = new BoundsM(1, 1);
	public static BoundsM OPTIONAL = new BoundsM(0, 1);
	public static BoundsM ANY = new BoundsM(0, -1);
	public static BoundsM MANY = new BoundsM(1, -1);
	
	private int upper;
	private int lower;

	public BoundsM(int upper, int lower) {
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

	private BoundsM() {
	}
	
	public JSONObject serializeToJson() {
		JSONObject obj = new JSONObject();
		obj.put("upper", upper);
		obj.put("lower", lower);
		return obj;
	}
	
	public static BoundsM deserialize(String serialized) {
		return deserialize(new JSONObject(serialized));
	}

	public static BoundsM deserialize(JSONObject json) {
		BoundsM ret = new BoundsM();
		ret.deserializeFromJson(json);
		return ret;
	}
	
	public void deserializeFromJson(JSONObject json) {
		upper = json.getInt("upper");
		lower = json.getInt("lower");
	}

	public boolean isAtMostSingle() {
		return upper == 0 || upper == 1;
	}

}
