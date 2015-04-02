package hu.eltesoft.modelexecution.runtime.trace;

import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Event;

import java.lang.reflect.InvocationTargetException;

/**
 * An event and the class object that will receive the event. The class is
 * stored indirectly, because it has to be serialized, deserialized and still
 * point to the same object. Currently it utilizes that only one class can
 * exist.
 */
public class TargetedEvent {
	
	private java.lang.Class<?> targetClass;
	private Event event;
	private boolean fromOutside = false;

	public TargetedEvent(Class target, Event event) {
		super();
		this.targetClass = target.getClass();
		this.event = event;
	}

	public static TargetedEvent createOutsideEvent(Class target, Event event) {
		TargetedEvent ret = new TargetedEvent(target, event);
		ret.fromOutside = true;
		return ret;
	}

	/**
	 * Sends the event to the target. Will throw an exception if the target
	 * cannot be accessed.
	 */
	public void send() {
		getTarget().receive(event);
	}

	/**
	 * Get the target of the targeted event. Works after the event had been serialized. 
	 */
	public Class getTarget() {
		Class instance;
		try {
			instance = (Class) targetClass.getMethod("getInstance")
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
		if (obj == null || !(obj instanceof TargetedEvent)) {
			return false;
		}
		TargetedEvent oth = (TargetedEvent) obj;
		return targetClass.equals(oth.targetClass) && event.equals(oth.event);
	}

	@Override
	public String toString() {
		return super.toString() + " target class: "
				+ targetClass.getCanonicalName() + ", event: "
				+ event.toString();
	}

	public Event getEvent() {
		return event;
	}

}
