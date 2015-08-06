package hu.eltesoft.modelexecution.runtime.base;

import hu.eltesoft.modelexecution.runtime.Runtime;

public interface StatefulClass {

	Runtime getRuntime();

	int getInstanceID();

	void send(Event event);

	void sendExternal(Event event);

	void receive(Event event);

	/**
	 * Unregisters the instance to allow garbage-collection
	 */
	void dispose();

}