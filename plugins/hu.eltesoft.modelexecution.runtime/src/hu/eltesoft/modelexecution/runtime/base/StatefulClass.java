package hu.eltesoft.modelexecution.runtime.base;

public interface StatefulClass {

	void send(Event event);

	void sendExternal(Event event);

	void receive(Event event);

	/**
	 * Unregisters the instance to allow garbage-collection
	 */
	void dispose();
}