package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores references for objects that can receive events. These events can come
 * from a serialized representation so they must be able to find their target
 * (an existing, not serialized object).
 * 
 * This class is a strictly loaded singleton.
 */
public final class InstanceRegistry {
	// if multiple runtimes are executed simultaneously, the mapping should be
	// partitioned by Runtime
	private Map<Class<?>, Map<Integer, ClassWithState>> instanceRegistry = new HashMap<>();

	private static final InstanceRegistry INSTANCE = new InstanceRegistry();

	private InstanceRegistry() {
	}

	/**
	 * Looks up an instance of the given class.
	 */
	public ClassWithState getInstance(Class<?> targetClass, int instanceID) {
		Map<Integer, ClassWithState> classRegistry = instanceRegistry
				.get(targetClass);
		return classRegistry == null ? null : classRegistry.get(instanceID);
	}

	/**
	 * Registers an instance of a class that can receive messages. As long as an
	 * instance is registered, it cannot be garbage-collected.
	 */
	public void registerInstance(ClassWithState instance) {
		Class<? extends ClassWithState> cls = instance.getClass();
		if (!instanceRegistry.containsKey(cls)) {
			instanceRegistry.put(cls, new HashMap<>());
		}
		instanceRegistry.get(cls).put(instance.getInstanceID(), instance);
	}

	/**
	 * Unregister an instance from the instance registry. Instance can only be
	 * unregistered if it is sure that they will not be a target of an external
	 * message.
	 */
	public void unregisterInstance(ClassWithState instance) {
		instanceRegistry.get(instance.getClass())
				.remove(instance.getInstanceID());
	}

	/**
	 * Gets the singleton instance of the registry.
	 */
	public static InstanceRegistry getInstanceRegistry() {
		return INSTANCE;
	}

}