package hu.eltesoft.modelexecution.runtime.mocks;

import hu.eltesoft.modelexecution.runtime.InstanceRegistry;
import hu.eltesoft.modelexecution.runtime.Runtime;
import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.Event;
import hu.eltesoft.modelexecution.runtime.base.SignalEvent;
import hu.eltesoft.modelexecution.runtime.base.StateMachineRegion;

public class MockClass extends ClassWithState {

	private static MockClass instance = null;

	private Runtime runtime;

	public static MockClass create(Runtime runtime) {
		return new MockClass(runtime);
	}

	public MockClass(Runtime runtime) {
		super(runtime, 0);
		this.runtime = runtime;
		instance = this;
		InstanceRegistry.getInstanceRegistry().registerInstance(this);
	}

	public static void emptyFeed() {
		instance.dispose();
	}

	public void feedEvent() {
		runtime.addEventToQueue(this, new SignalEvent(new DummySignal()));
		// do not dispose the instance here as it will be
		// unregistered before entering the event loop
	}

	@Override
	public void receive(Event event) {
		// dispose the instance after the event is delivered
		// to let the dispatch loop terminate
		dispose();
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
}
