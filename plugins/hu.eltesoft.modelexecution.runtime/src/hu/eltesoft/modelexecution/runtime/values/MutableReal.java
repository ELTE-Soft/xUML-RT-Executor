package hu.eltesoft.modelexecution.runtime.values;

public class MutableReal {

	private double value;

	public MutableReal(double value) {
		super();
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}
