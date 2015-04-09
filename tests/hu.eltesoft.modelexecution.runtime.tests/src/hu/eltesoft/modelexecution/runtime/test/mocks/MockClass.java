package hu.eltesoft.modelexecution.runtime.test.mocks;

import java.util.LinkedList;
import java.util.List;

import hu.eltesoft.modelexecution.runtime.Runtime;
import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Event;

public class MockClass extends Class {

	public MockClass(Runtime runtime, String name) {
		super(runtime, name);
	}

	private static MockClass instance = new MockClass(null, "MockClass");

	public static MockClass getInstance() {
		return instance;
	}

	List<Event> receivedEvents = new LinkedList<>();

	@Override
	public void init() {
	}

	@Override
	public void receive(Event event) {
		receivedEvents.add(event);
	}

	public List<Event> getReceivedEvents() {
		return receivedEvents;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj != null && obj instanceof MockClass);
	}

}
