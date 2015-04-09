package hu.eltesoft.modelexecution.runtime.tests.mocks;

import hu.eltesoft.modelexecution.runtime.base.Event;

public class DummyEvent extends Event {

	@Override
	public boolean equals(Object obj) {
		return (obj != null && obj instanceof DummyEvent);
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
}
