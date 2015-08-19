package hu.eltesoft.modelexecution.ide.debug.jvm;

public interface ReactiveClassListener {

	void instanceCreated(String classId, int instanceId, String originalName);
	
	void instanceDestroyed(String classId, int instanceId);
	
}
