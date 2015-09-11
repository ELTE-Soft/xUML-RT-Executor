package hu.eltesoft.modelexecution.runtime.trace;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

import hu.eltesoft.modelexecution.runtime.InstanceRegistry;
import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Event;
import hu.eltesoft.modelexecution.runtime.serialize.JSONDecoder;
import hu.eltesoft.modelexecution.runtime.serialize.JSONSerializable;

/**
 * An event and the class object that will receive the event. The class is
 * stored indirectly, because it has to be serialized, deserialized and still
 * point to the same object.
 */
public class TargetedEvent implements JSONSerializable {

	private static final String JSON_KEY_FROM_OUTSIDE = "fromOutside";
	private static final String JSON_KEY_EVENT = "message";
	private static final String JSON_KEY_TARGET_CLASS = "targetClass";
	private static final String JSON_INSTANCE_ID = "instanceID";

	private Event event;
	private boolean fromOutside = false;
	private ClassWithState target;

	public TargetedEvent(JSONDecoder reader, JSONObject obj) throws ClassNotFoundException, JSONException {
		jsonDecode(reader, obj);
	}

	public TargetedEvent(ClassWithState target, Event event) {
		super();
		this.target = target;
		this.event = event;
	}

	public static TargetedEvent createOutsideEvent(ClassWithState target, Event event) {
		TargetedEvent ret = new TargetedEvent(target, event);
		ret.fromOutside = true;
		return ret;
	}

	/**
	 * Sends the event to the target. Will throw an exception if the target
	 * cannot be accessed.
	 */
	public void send() {
		target.receive(event);
	}

	/**
	 * True, if the event is originated from an external system.
	 */
	public boolean isFromOutside() {
		return fromOutside;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof TargetedEvent)) {
			return false;
		}
		TargetedEvent oth = (TargetedEvent) obj;
		return target == oth.target // must be the same object
				&& event.equals(oth.event);
	}

	@Override
	public int hashCode() {
		return Objects.hash(target, event, fromOutside);
	}

	@Override
	public String toString() {
		return super.toString() + " target: " + target + ", event: " + event.toString();
	}

	public Event getEvent() {
		return event;
	}

	public ClassWithState getTarget() {
		return target;
	}

	@Override
	public JSONObject jsonEncode() {
		return new JSONObject().put(JSON_KEY_TARGET_CLASS, target.getClass().getCanonicalName())
				.put(JSON_INSTANCE_ID, target.getInstanceID()).put(JSON_KEY_EVENT, event.jsonEncode())
				.put(JSON_KEY_FROM_OUTSIDE, fromOutside);
	}

	@Override
	public void jsonDecode(JSONDecoder decoder, JSONObject obj) throws ClassNotFoundException, JSONException {
		@SuppressWarnings("unchecked")
		Class<? extends hu.eltesoft.modelexecution.runtime.base.Class> targetClass = (Class<? extends hu.eltesoft.modelexecution.runtime.base.Class>) decoder
				.decodeClass(obj.getString(JSON_KEY_TARGET_CLASS));
		int instanceID = obj.getInt(JSON_INSTANCE_ID);
		target = (ClassWithState) InstanceRegistry.getInstanceRegistry().getInstance(targetClass, instanceID);
		event = (Event) decoder.decodeJSON(obj.get(JSON_KEY_EVENT));
		fromOutside = obj.getBoolean(JSON_KEY_FROM_OUTSIDE);
	}

}
