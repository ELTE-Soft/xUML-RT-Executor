package hu.eltesoft.modelexecution.runtime.base;

import hu.eltesoft.modelexecution.runtime.InstanceRegistry;

public abstract class Class {

	private final SubobjectsDestructor subobjectsDestructor;
	private final long instanceID;
	private boolean deleted = false;

	public Class(SubobjectsDestructor subobjectsDestructor, long instanceID) {
		this.subobjectsDestructor = subobjectsDestructor;
		this.instanceID = instanceID;
	}

	public long getInstanceID() {
		return instanceID;
	}

	public boolean isDeleted() {
		return deleted;
	}

	// deleter
	public void delete() {
		if (isDeleted()) {
			// verification error: double destruction
			return;
		}
		InstanceRegistry.getInstanceRegistry().unregisterInstance(this);
		destroy();
		subobjectsDestructor.destroySubobjects();
		deleted = true;
	}

	public abstract void destroy();

	public abstract String getOriginalClassName();

	@Override
	public String toString() {
		return getOriginalClassName() + "#" + getInstanceID();
	}
}
