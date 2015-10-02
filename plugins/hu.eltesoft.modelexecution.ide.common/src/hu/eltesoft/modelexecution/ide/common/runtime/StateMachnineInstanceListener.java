package hu.eltesoft.modelexecution.ide.common.runtime;

/**
 * An interface for receiving events about state machine instances created or
 * destroyed. The instances are identified by the canonical name of their
 * classes and their instance IDs.
 */
public interface StateMachnineInstanceListener {

	void instanceCreated(String classId, long instanceId, String originalName);

	void instanceDestroyed(String classId, long instanceId);

}
