package hu.eltesoft.modelexecution.runtime.base;

public abstract class Class {

	private final int instanceID;

	public Class(int instanceID) {
		this.instanceID = instanceID;
	}

	public int getInstanceID() {
		return instanceID;
	}

	public abstract String getOriginalClassName();

	@Override
	public String toString() {
		return getOriginalClassName();
	}

}