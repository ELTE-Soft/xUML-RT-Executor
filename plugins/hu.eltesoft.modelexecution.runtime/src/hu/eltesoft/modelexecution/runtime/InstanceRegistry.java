package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
	private Map<InstanceKey, ClassWithState> instanceRegistry = new HashMap<>();

	private static final InstanceRegistry INSTANCE = new InstanceRegistry();

	private InstanceRegistry() {
	}

	/**
	 * Looks up an instance of the given class.
	 */
	public ClassWithState getInstance(Class<?> targetClass, int instanceID) {
		return instanceRegistry.get(new InstanceKey(targetClass, instanceID));
	}

	/**
	 * Registers an instance of a class that can receive messages. As long as an
	 * instance is registered, it cannot be garbage-collected.
	 */
	public void registerInstance(ClassWithState instance) {
		instanceRegistry.put(new InstanceKey(instance), instance);
	}

	/**
	 * Unregister an instance from the instance registry. Instance can only be
	 * unregistered if it is sure that they will not be a target of an external
	 * message.
	 */
	public void unregisterInstance(ClassWithState instance) {
		instanceRegistry.remove(new InstanceKey(instance));
	}

	/**
	 * Gets the singleton instance of the registry.
	 */
	public static InstanceRegistry getInstanceRegistry() {
		return INSTANCE;
	}

	private static final class InstanceKey {
		public InstanceKey(ClassWithState instance) {
			this.klass = instance.getClass();
			this.instanceID = instance.getInstanceID();
		}

		public InstanceKey(Class<?> klass, int instanceID) {
			this.klass = klass;
			this.instanceID = instanceID;
		}

		private Class<?> klass;
		private int instanceID;

		@Override
		public int hashCode() {
			return Objects.hash(klass, instanceID);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof InstanceKey)) {
				return false;
			}
			InstanceKey other = (InstanceKey) obj;
			return instanceID == other.instanceID && klass.equals(other.klass);
		}

	}

}