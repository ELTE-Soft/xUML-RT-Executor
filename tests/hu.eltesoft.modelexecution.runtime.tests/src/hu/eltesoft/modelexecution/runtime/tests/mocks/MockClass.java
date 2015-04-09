package hu.eltesoft.modelexecution.runtime.tests.mocks;

import java.util.LinkedList;
import java.util.List;

import hu.eltesoft.modelexecution.runtime.Runtime;
import hu.eltesoft.modelexecution.runtime.base.Class;
import hu.eltesoft.modelexecution.runtime.base.Event;

public class MockClass extends Class {

	private Runtime runtime;

	public MockClass(Runtime runtime) {
		super(runtime, "MockClass");
		this.runtime = runtime;
		instance = this;
	}

	private static MockClass instance = null;

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
	
	public static void emptyFeed() {
	}
	
	public void feedEvent() {
		runtime.addEventToQueue(this, new DummyEvent());
	}

}
