package hu.eltesoft.modelexecution.runtime.mocks;

public class DifferentDummySignal extends DummySignal {

	public DifferentDummySignal(int code) {
		this.code = code;
	}

	private int code;

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
		if (!(obj instanceof DifferentDummySignal)) {
			return false;
		}
		DifferentDummySignal other = (DifferentDummySignal) obj;
		if (code != other.code) {
			return false;
		}
		return true;
	}

}
