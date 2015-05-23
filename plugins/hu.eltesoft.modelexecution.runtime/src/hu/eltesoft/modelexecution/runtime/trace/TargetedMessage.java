package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Message;
import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder;
import hu.eltesoft.modelexecution.runtime.trace.json.JSONSerializable;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * An event and the class object that will receive the event. The class is
 * stored indirectly, because it has to be serialized, deserialized and still
 * point to the same object. Currently it utilizes that only one class can
 * exist.
 */
public class TargetedMessage implements JSONSerializable {

	private java.lang.Class<?> targetClass;
	private Message message;
	private boolean fromOutside = false;

	public TargetedMessage(JSONDecoder reader, JSONObject obj)
			throws ClassNotFoundException, JSONException {
		jsonDecode(reader, obj);
	}

	public TargetedMessage(ClassWithState target, Message message) {
		super();
		this.targetClass = target.getClass();
		this.message = message;
	}

	public static TargetedMessage createOutsideEvent(ClassWithState target,
			Message message) {
		TargetedMessage ret = new TargetedMessage(target, message);
		ret.fromOutside = true;
		return ret;
	}

	/**
	 * Sends the event to the target. Will throw an exception if the target
	 * cannot be accessed.
	 */
	public void send() {
		getTarget().receive(message);
	}

	/**
	 * Get the target of the targeted event. Works after the event had been
	 * serialized.
	 */
	public ClassWithState getTarget() {
		ClassWithState instance;
		try {
			instance = (ClassWithState) targetClass.getMethod("getInstance")
					.invoke(null);
			if (instance == null) {
				throw new RuntimeException(
						"The target of the event does not exist.");
			}
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new RuntimeException(
					"Cannot access instance of the event target.", e);
		}
		return instance;
	}

	/**
	 * True, if the event is originated from an external system.
	 */
	public boolean isFromOutside() {
		return fromOutside;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof TargetedMessage)) {
			return false;
		}
		TargetedMessage oth = (TargetedMessage) obj;
		return targetClass.equals(oth.targetClass)
				&& message.equals(oth.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(targetClass, message, fromOutside);
	}

	@Override
	public String toString() {
		return super.toString() + " target class: "
				+ targetClass.getCanonicalName() + ", event: "
				+ message.toString();
	}

	public Message getMessage() {
		return message;
	}

	@Override
	public JSONObject jsonEncode() {
		return new JSONObject()
				.put("targetClass", targetClass.getCanonicalName())
				.put("message", message.jsonEncode())
				.put("fromOutside", fromOutside);
	}

	@Override
	public void jsonDecode(JSONDecoder reader, JSONObject obj)
			throws ClassNotFoundException, JSONException {
		targetClass = Class.forName(obj.getString("targetClass"));
		message = (Message) reader.decodeJSON(obj.get("message"));
		fromOutside = obj.getBoolean("fromOutside");
	}

}
