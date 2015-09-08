package hu.eltesoft.modelexecution.ide.runtime;

/**
 * An interface for receiving events about state machine instances created or
 * destroyed. The instances are identified by the canonical name of their
 * classes and their instance IDs.
 */
public interface StateMachnineInstanceListener {

	void instanceCreated(String classId, int instanceId, String originalName);

	void instanceDestroyed(String classId, int instanceId);

}
