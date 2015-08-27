package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;

public interface InstanceListener {

	void instanceCreated(ClassWithState instance);

	void instanceDeleted(ClassWithState instance);
	
}
