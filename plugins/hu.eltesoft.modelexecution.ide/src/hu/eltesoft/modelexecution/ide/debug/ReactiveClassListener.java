package hu.eltesoft.modelexecution.ide.debug;

public interface ReactiveClassListener {

	void instanceCreated(String classId);
	
	void instanceDestroyed(String classId);
	
}
