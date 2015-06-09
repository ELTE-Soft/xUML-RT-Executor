package hu.eltesoft.modelexecution.runtime;

public class Reference<T> {
	
	private T data;
	
	/**
	 * Creates an empty Reference
	 */
	public Reference() {
	}

	/**
	 * Creates a Reference with initial value
	 */
	public Reference(T data) {
		this.data = data;
	}

	public T get() {
		return data;
	}

	public void set(T data) {
		this.data = data;
	}
	
}
