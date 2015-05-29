package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.InstanceRegistry;
import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Message;
import hu.eltesoft.modelexecution.runtime.trace.json.JSONDecoder;
import hu.eltesoft.modelexecution.runtime.trace.json.JSONSerializable;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * An event and the class object that will receive the event. The class is
 * stored indirectly, because it has to be serialized, deserialized and still
 * point to the same object.
 */
public class TargetedMessage implements JSONSerializable {

	private static final String JSON_KEY_FROM_OUTSIDE = "fromOutside";
	private static final String JSON_KEY_MESSAGE = "message";
	private static final String JSON_KEY_TARGET_CLASS = "targetClass";
	private static final String JSON_INSTANCE_ID = "instanceID";

	private Message message;
	private boolean fromOutside = false;
	private ClassWithState target;

	public TargetedMessage(JSONDecoder reader, JSONObject obj)
			throws ClassNotFoundException, JSONException {
		jsonDecode(reader, obj);
	}

	public TargetedMessage(ClassWithState target, Message message) {
		super();
		this.target = target;
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
		target.receive(message);
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
		return target == oth.target // must be the same object
				&& message.equals(oth.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(target, message, fromOutside);
	}

	@Override
	public String toString() {
		return super.toString() + " target: " + target + ", event: "
				+ message.toString();
	}

	public Message getMessage() {
		return message;
	}

	public ClassWithState getTarget() {
		return target;
	}

	@Override
	public JSONObject jsonEncode() {
		return new JSONObject()
				.put(JSON_KEY_TARGET_CLASS, target.getClass().getCanonicalName())
				.put(JSON_INSTANCE_ID, target.getInstanceID())
				.put(JSON_KEY_MESSAGE, message.jsonEncode())
				.put(JSON_KEY_FROM_OUTSIDE, fromOutside);
	}

	@Override
	public void jsonDecode(JSONDecoder decoder, JSONObject obj)
			throws ClassNotFoundException, JSONException {
		Class<?> targetClass = (Class<?>) decoder.decodeClass(obj.getString(JSON_KEY_TARGET_CLASS));
		int instanceID = obj.getInt(JSON_INSTANCE_ID);
		target = InstanceRegistry.getInstanceRegistry().getInstance(targetClass, instanceID);
		message = (Message) decoder.decodeJSON(obj.get(JSON_KEY_MESSAGE));
		fromOutside = obj.getBoolean(JSON_KEY_FROM_OUTSIDE);
	}

}
