package hu.eltesoft.modelexecution.runtime.tests.mocks;

public class DifferentDummyEvent extends DummyEvent {

	private int code;

	public DifferentDummyEvent(int code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		return code;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (obj instanceof DifferentDummyEvent) {
			return false;
		}
		DifferentDummyEvent other = (DifferentDummyEvent) obj;
		if (code != other.code) {
			return false;
		}
		return true;
	}

}
