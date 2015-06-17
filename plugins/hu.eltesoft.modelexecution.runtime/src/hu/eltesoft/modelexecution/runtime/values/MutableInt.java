package hu.eltesoft.modelexecution.runtime.values;

import java.math.BigInteger;

public class MutableInt {

	private BigInteger value;

	public MutableInt(int value) {
		super();
		
		this.value = BigInteger.valueOf(value);
	}

	public BigInteger getValue() {
		return value;
	}

	public void setValue(BigInteger value) {
		this.value = value;
	}
	
}
