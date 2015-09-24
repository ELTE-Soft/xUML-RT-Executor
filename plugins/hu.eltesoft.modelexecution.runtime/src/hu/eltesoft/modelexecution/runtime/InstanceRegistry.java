package hu.eltesoft.modelexecution.runtime;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;

/**
 * Stores references for objects that can receive events. These events can come
 * from a serialized representation so they must be able to find their target
 * (an existing, not serialized object).
 * 
 * This class is a strictly loaded singleton.
 */
public final class InstanceRegistry {
	// If multiple runtimes are executed simultaneously, the mapping should be
	// partitioned by Runtime and synchronized.
	private ClassMap instanceRegistry = new ClassMap();

	private long numberOfReactiveInstances = 0;

	private List<InstanceListener> listeners = new LinkedList<>();

	private static final InstanceRegistry INSTANCE = new InstanceRegistry();

	private InstanceRegistry() {
	}

	public <C extends hu.eltesoft.modelexecution.runtime.base.Class> HashSet<C> allInstances(Class<C> targetClass) {
		return instanceRegistry.allInstances(targetClass);
	}

	/**
	 * Looks up an instance of the given class.
	 */
	public hu.eltesoft.modelexecution.runtime.base.Class getInstance(
			Class<? extends hu.eltesoft.modelexecution.runtime.base.Class> targetClass, long instanceID) {
		return instanceRegistry.getInstance(targetClass, instanceID);
	}

	/**
	 * Registers an instance of a class that can receive messages. As long as an
	 * instance is registered, it cannot be garbage-collected.
	 */
	public void registerInstance(hu.eltesoft.modelexecution.runtime.base.Class instance) {
		if (!instanceRegistry.addInstance(instance)) {
			// the registry already contained this instance
			return;
		}
		if (instance instanceof ClassWithState) {
			++numberOfReactiveInstances;
		}
		for (InstanceListener listener : listeners) {
			listener.instanceCreated(instance);
		}
	}

	/**
	 * Unregister an instance from the instance registry. Instance can only be
	 * unregistered if it is sure that they will not be a target of an external
	 * message.
	 */
	public void unregisterInstance(hu.eltesoft.modelexecution.runtime.base.Class instance) {
		if (!instanceRegistry.removeInstance(instance)) {
			// the instance was not contained by the registry
			return;
		}
		if (instance instanceof ClassWithState) {
			--numberOfReactiveInstances;
		}
		for (InstanceListener listener : listeners) {
			listener.instanceDeleted(instance);
		}
	}

	public boolean hasReactiveInstances() {
		return numberOfReactiveInstances > 0;
	}

	public void addInstanceListener(InstanceListener listener) {
		listeners.add(listener);
	}

	/**
	 * Gets the singleton instance of the registry.
	 */
	public static InstanceRegistry getInstanceRegistry() {
		return INSTANCE;
	}

	private class ClassMap {

		private final Map<Class<? extends hu.eltesoft.modelexecution.runtime.base.Class>, IdMap> map = new HashMap<>();

		public boolean addInstance(hu.eltesoft.modelexecution.runtime.base.Class instance) {
			Class<? extends hu.eltesoft.modelexecution.runtime.base.Class> targetClass = instance.getClass();
			return getIdMap(targetClass).put(instance.getInstanceID(), instance);
		}

		public boolean removeInstance(hu.eltesoft.modelexecution.runtime.base.Class instance) {
			Class<? extends hu.eltesoft.modelexecution.runtime.base.Class> targetClass = instance.getClass();
			return getIdMap(targetClass).remove(instance.getInstanceID());
		}

		public <C extends hu.eltesoft.modelexecution.runtime.base.Class> HashSet<C> allInstances(
				Class<? extends hu.eltesoft.modelexecution.runtime.base.Class> targetClass) {
			return getIdMap(targetClass).allInstances();
		}

		public hu.eltesoft.modelexecution.runtime.base.Class getInstance(
				Class<? extends hu.eltesoft.modelexecution.runtime.base.Class> targetClass, long instanceID) {
			return getIdMap(targetClass).getByInstanceID(instanceID);
		}

		private IdMap getIdMap(Class<? extends hu.eltesoft.modelexecution.runtime.base.Class> targetClass) {
			IdMap idMap = map.get(targetClass);
			if (null == idMap) {
				idMap = new IdMap();
				map.put(targetClass, idMap);
			}
			return idMap;
		}
	}

	private class IdMap {

		private final Map<Long, hu.eltesoft.modelexecution.runtime.base.Class> map = new HashMap<>();

		/** Returns whether the inserted instance is new. */
		public boolean put(long instanceID, hu.eltesoft.modelexecution.runtime.base.Class instance) {
			return null == map.put(instanceID, instance);
		}

		/** Returns whether the registry contained the instance. */
		public boolean remove(long instanceID) {
			return null != map.remove(instanceID);
		}

		public hu.eltesoft.modelexecution.runtime.base.Class getByInstanceID(long instanceID) {
			return map.get(instanceID);
		}

		@SuppressWarnings("unchecked")
		public <C extends hu.eltesoft.modelexecution.runtime.base.Class> HashSet<C> allInstances() {
			return new HashSet<C>((Collection<C>) map.values());
		}
	}
}
