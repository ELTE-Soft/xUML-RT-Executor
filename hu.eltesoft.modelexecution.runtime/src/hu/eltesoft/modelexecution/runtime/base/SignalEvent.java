package hu.eltesoft.modelexecution.runtime.base;

/**
 * A base class for events that carry a signal. We do not distinguish between
 * SignalEvents carrying the same signal.
 * 
 * @author nboldi
 */
public abstract class SignalEvent extends Event {

	@Override
	public int eventCode() {
		return signalCode();
	}

	public abstract int signalCode();

}
