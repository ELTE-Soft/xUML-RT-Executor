package hu.eltesoft.modelexecution.runtime.base;

/**
 * A base class for UML events in the system. Events with the same source
 * (signal, operation, timer) are considered to be equal.
 * 
 * @author nboldi
 *
 */
public abstract class Event {

	/**
	 * When used in state machines, the triggered transition is chosen by
	 * inspection of this method.
	 */
	public abstract int eventCode();

	@Override
	public String toString() {
		return super.toString() + "( eventCode: " + eventCode() + " )";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Event)) {
			return false;
		}
		Event oth = (Event) obj;
		return eventCode() == oth.eventCode();
	}

}
