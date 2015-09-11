package hu.eltesoft.modelexecution.runtime.base;

public abstract class Class {

	private final int instanceID;
	private boolean deleted = false;

	public Class(int instanceID) {
		this.instanceID = instanceID;
	}

	public int getInstanceID() {
		return instanceID;
	}

	public boolean isDeleted() {
		return deleted;
	}

	protected void setDeleted() {
		deleted = true;
	}

	public abstract String getOriginalClassName();

	@Override
	public String toString() {
		return getOriginalClassName() + "#" + getInstanceID();
	}
}
