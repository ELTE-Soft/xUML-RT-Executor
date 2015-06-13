package hu.eltesoft.modelexecution.runtime.values;

import java.math.BigInteger;

public class MutableInt {

	private BigInteger value;

	public MutableInt(BigInteger value) {
		super();
		this.value = value;
	}

	public BigInteger getValue() {
		return value;
	}

	public void setValue(BigInteger value) {
		this.value = value;
	}
	
}
