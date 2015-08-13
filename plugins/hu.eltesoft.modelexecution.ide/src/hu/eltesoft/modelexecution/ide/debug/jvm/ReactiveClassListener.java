package hu.eltesoft.modelexecution.ide.debug.jvm;

public interface ReactiveClassListener {

	void instanceCreated(String classId);
	
	void instanceDestroyed(String classId);
	
}
