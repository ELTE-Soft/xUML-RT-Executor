package hu.eltesoft.modelexecution.runtime.base;

/**
 * The base class of code generated for UML signals.
 */
public abstract class Signal implements Message {

	private SignalEvent event;
	
	/**
	 * Use this constructor when there is no event carrying the signal.
	 */
	public Signal() {
	}
	
	/**
	 * @param event The event that carries the signal.
	 */
	public Signal(SignalEvent event) {
		this.event = event;	
	}
	
	public SignalEvent getEvent() {
		return event;
	}
	
}
