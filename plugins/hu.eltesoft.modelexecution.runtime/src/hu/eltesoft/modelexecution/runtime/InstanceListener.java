package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.Class;

public interface InstanceListener {

	void instanceCreated(Class instance);

	void instanceDeleted(Class instance);
}
