package hu.eltesoft.modelexecution.runtime.mocks;

import hu.eltesoft.modelexecution.runtime.InstanceRegistry;
import hu.eltesoft.modelexecution.runtime.Runtime;
import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Message;
import hu.eltesoft.modelexecution.runtime.base.StateMachineRegion;

import java.util.LinkedList;
import java.util.List;

public class MockClass extends ClassWithState {

	private static MockClass instance = null;

	private Runtime runtime;

	public MockClass(Runtime runtime) {
		super(runtime, 0);
		this.runtime = runtime;
		instance = this;
		InstanceRegistry.getInstanceRegistry().registerInstance(this);
	}

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
		instance.dispose();
	}

	public void feedEvent() {
		runtime.addEventToQueue(this, new DummySignal());
		dispose();
	}

	@Override
	protected StateMachineRegion createStateMachine() {
		// do not need a state machine since receive and init is overridden
		return null;
	}
}
