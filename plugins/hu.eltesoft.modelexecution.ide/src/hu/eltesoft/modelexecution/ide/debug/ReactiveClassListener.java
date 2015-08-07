package hu.eltesoft.modelexecution.ide.debug;

public interface ReactiveClassListener {

	void instanceCreated(String classId, int id);
	
	void instanceDestroyed(String classId, int id);
	
}
