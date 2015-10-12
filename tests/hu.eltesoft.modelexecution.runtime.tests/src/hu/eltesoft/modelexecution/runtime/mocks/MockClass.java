package hu.eltesoft.modelexecution.runtime.mocks;

import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import hu.eltesoft.modelexecution.runtime.InstanceRegistry;
import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Event;
import hu.eltesoft.modelexecution.runtime.base.SignalEvent;
import hu.eltesoft.modelexecution.runtime.base.StateMachineRegion;
import hu.eltesoft.modelexecution.runtime.base.Event.Priority;

public class MockClass extends ClassWithState {

	private int eventsToReceive = 0;

	public static MockClass create() {
		return new MockClass();
	}

	public MockClass() {
		super(() -> {
		} , 0);
		InstanceRegistry.getInstanceRegistry().registerInstance(this);
	}

	public static void emptyFeed() {
		MockClass instance = create();
		instance.delete();
	}

	public static void feedEvent() {
		MockClass instance = create();
		instance.eventsToReceive = 1;
		BaseRuntime.getInstance().addEventToQueue(instance, new SignalEvent(new DummySignal()));
		// do not dispose the instance here as it will be
		// unregistered before entering the event loop
	}
	
	public static void priorityFeed() {
		MockClass instance = create();
		instance.eventsToReceive = 2;
		BaseRuntime.getInstance().addEventToQueue(instance, new SignalEvent(new DummySignal()));
		BaseRuntime.getInstance().addEventToQueue(instance, new SignalEvent(new DummySignal(), Priority.HIGH));
		// do not dispose the instance here as it will be
		// unregistered before entering the event loop
	}

	@Override
	public void receive(Event event) {
		// dispose the instance after the event is delivered
		// to let the dispatch loop terminate
		if (--eventsToReceive <= 0) {
			delete();
		}
	}

	@Override
	public void destroy() {
		// intentionally left blank, empty destructor
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null && obj instanceof MockClass);
	}

	@Override
	protected StateMachineRegion createStateMachine() {
		// do not need a state machine since receive and init is overridden
		return null;
	}

	@Override
	public String getOriginalClassName() {
		return "MockClass";
	}
}
