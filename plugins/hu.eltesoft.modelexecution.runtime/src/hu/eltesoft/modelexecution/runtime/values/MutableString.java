package hu.eltesoft.modelexecution.runtime.values;

public class MutableString {

	private String value;

	public MutableString(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
