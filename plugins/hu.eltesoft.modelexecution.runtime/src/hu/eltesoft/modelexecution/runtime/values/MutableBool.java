package hu.eltesoft.modelexecution.runtime.values;

public class MutableBool {

	private boolean value;

	public MutableBool(boolean value) {
		super();
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
}
