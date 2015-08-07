package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.InstanceRegistry.InstanceKey;

public interface InstanceListener {

	void instanceCreated(InstanceKey key);

	void instanceDeleted(InstanceKey key);
	
}
