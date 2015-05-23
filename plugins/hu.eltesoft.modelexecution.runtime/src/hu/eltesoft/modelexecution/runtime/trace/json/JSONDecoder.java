package hu.eltesoft.modelexecution.runtime.trace.json;

import hu.eltesoft.modelexecution.runtime.trace.InvalidTraceException;
import hu.eltesoft.modelexecution.runtime.trace.TargetedMessage;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A class for loading Java objects from JSON objects.
 */
public class JSONDecoder {

	private ClassLoader classLoader;

	public JSONDecoder(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	/**
	 * Decode an object using encoded type. Should only be used when we do not
	 * know the type of the extracted Java object.
	 */
	public Object decodeJSON(Object obj) throws ClassNotFoundException {
		if (obj instanceof JSONObject) {
			return decodeJSON((JSONObject) obj);
		} else {
			throw new JSONException(
					"Cannot deserialize object, it is not a json object");
		}
	}

	/**
	 * Decode an object using encoded type. Should only be used when we do not
	 * know the type of the extracted Java object.
	 */
	public Object decodeJSON(JSONObject obj) throws ClassNotFoundException {
		String encodedClass = obj.getString("class");
		Object instance;
		try {
			instance = classLoader.loadClass(encodedClass).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new InvalidTraceException(e);
		}
		if (instance instanceof JSONSerializable) {
			((JSONSerializable) instance).jsonDecode(this, obj);
			return instance;
		} else {
			throw new InvalidTraceException("Loaded class is not instanceof "
					+ JSONSerializable.class.getName());
		}
	}

	public TargetedMessage decodeMessage(JSONObject obj)
			throws ClassNotFoundException, JSONException {
		return new TargetedMessage(this, obj);
	}

}
