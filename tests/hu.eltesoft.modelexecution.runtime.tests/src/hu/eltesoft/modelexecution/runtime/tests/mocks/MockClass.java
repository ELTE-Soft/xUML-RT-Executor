package hu.eltesoft.modelexecution.runtime.tests.mocks;

import hu.eltesoft.modelexecution.runtime.Runtime;
import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Message;

import java.util.LinkedList;
import java.util.List;

public class MockClass extends ClassWithState {

	private Runtime runtime;

	public MockClass(Runtime runtime) {
		super(runtime);
		this.runtime = runtime;
		instance = this;
	}

	private static MockClass instance = null;

	public static MockClass getInstance() {
		return instance;
	}

	List<Message> receivedEvents = new LinkedList<>();

	@Override
	public void init() {
	}

	@Override
	public void receive(Message message) {
		receivedEvents.add(message);
	}

	public List<Message> getReceivedEvents() {
		return receivedEvents;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null && obj instanceof MockClass);
	}

	public static void emptyFeed() {
	}

	public void feedEvent() {
		runtime.addEventToQueue(this, new DummySignal());
	}

}
