package hu.eltesoft.modelexecution.runtime;

import java.util.Objects;

import hu.eltesoft.modelexecution.runtime.base.Signal;
import hu.eltesoft.modelexecution.runtime.base.SignalEvent;

/**
 * This event can carry UML signals when we don't know if there is a generated
 * SignalEvent class dedicated for that type of Signal. Because triggered
 * transition is chosen using the {@linkplain Event.eventCode} method, if an
 * event is a DynamicSignalEvent it will behave exactly as it was the
 * SignalEvent for the signal it carries.
 */
public class DynamicSignalEvent extends SignalEvent {

	private Signal signal;

	public DynamicSignalEvent(Signal signal) {
		this.signal = signal;
	}

	@Override
	public String toString() {
		return super.toString() + ", signal : " + signal;
	}

	public Signal getSignal() {
		return signal;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof DynamicSignalEvent)) {
			return false;
		}
		DynamicSignalEvent oth = (DynamicSignalEvent) obj;
		return signal.equals(oth.signal);
	}

	@Override
	public int hashCode() {
		return Objects.hash(signal.hashCode());
	}

}
