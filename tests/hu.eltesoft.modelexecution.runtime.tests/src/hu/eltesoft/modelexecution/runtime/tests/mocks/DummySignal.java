package hu.eltesoft.modelexecution.runtime.tests.mocks;

import hu.eltesoft.modelexecution.runtime.base.Signal;

public class DummySignal extends Signal {

	public DummySignal() {
		super(null);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null && obj instanceof DummySignal);
	}

	@Override
	public int hashCode() {
		return 0;
	}

}
