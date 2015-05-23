package hu.eltesoft.modelexecution.runtime.trace.json;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONDecoder {
	
	private ClassLoader classLoader;

	public JSONDecoder(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public Object decodeJSON(Object obj) throws ClassNotFoundException {
		if (obj instanceof JSONObject) {
			return decodeJSON((JSONObject) obj);
		} else {
			throw new JSONException("Cannot deserialize object, it is not a json object");
		}
	}
	
	public Object decodeJSON(JSONObject obj) throws ClassNotFoundException {
		String encodedClass = obj.getString("class");
		Object instance;
		try {
			instance = classLoader.loadClass(encodedClass).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new JSONException(e);
		}
		if (instance instanceof JSONSerializable) {
			((JSONSerializable) instance).jsonDecode(this, obj);
			return instance;
		} else {
			throw new JSONException("Loaded class is not instanceof " + JSONSerializable.class.getName());
		}
	}
	
}
