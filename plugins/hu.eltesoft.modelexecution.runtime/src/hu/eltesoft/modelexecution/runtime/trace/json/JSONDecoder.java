package hu.eltesoft.modelexecution.runtime.trace.json;

import org.json.JSONException;
import org.json.JSONObject;

import hu.eltesoft.modelexecution.runtime.trace.InvalidTraceException;
import hu.eltesoft.modelexecution.runtime.trace.TargetedEvent;

/**
 * A class for loading Java objects from JSON objects.
 */
public class JSONDecoder {

	public static final String JSON_CLASS = "class";
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
			throw new JSONException("Cannot deserialize object, it is not a json object");
		}
	}

	/**
	 * Decode an object using encoded type. Should only be used when we do not
	 * know the type of the extracted Java object.
	 */
	public Object decodeJSON(JSONObject obj) throws ClassNotFoundException {
		String encodedClass = obj.getString(JSON_CLASS);
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
			throw new InvalidTraceException("Loaded class is not instanceof " + JSONSerializable.class.getName());
		}
	}

	public TargetedEvent decodeTargetedEvent(JSONObject obj) throws ClassNotFoundException, JSONException {
		return new TargetedEvent(this, obj);
	}

	public Class<?> decodeClass(String className) throws ClassNotFoundException {
		return classLoader.loadClass(className);
	}

}
