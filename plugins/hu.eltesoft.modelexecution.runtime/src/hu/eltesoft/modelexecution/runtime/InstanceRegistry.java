package hu.eltesoft.modelexecution.runtime;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import hu.eltesoft.modelexecution.runtime.base.ClassWithState;
import hu.eltesoft.modelexecution.runtime.base.StatefulClass;

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

	private List<InstanceListener> listeners = new LinkedList<>();

	private static final InstanceRegistry INSTANCE = new InstanceRegistry();

	private InstanceRegistry() {
	}

	/**
	 * Looks up an instance of the given class.
	 */
	public StatefulClass getInstance(Class<? extends StatefulClass> targetClass, int instanceID) {
		return instanceRegistry.get(new InstanceKey(targetClass, instanceID));
	}

	/**
	 * Registers an instance of a class that can receive messages. As long as an
	 * instance is registered, it cannot be garbage-collected.
	 */
	public void registerInstance(ClassWithState instance) {
		InstanceKey key = new InstanceKey(instance);
		instanceRegistry.put(key, instance);
		for (InstanceListener listener : listeners) {
			listener.instanceCreated(instance);
		}
	}

	/**
	 * Unregister an instance from the instance registry. Instance can only be
	 * unregistered if it is sure that they will not be a target of an external
	 * message.
	 */
	public void unregisterInstance(ClassWithState instance) {
		InstanceKey key = new InstanceKey(instance);
		instanceRegistry.remove(key);
		for (InstanceListener listener : listeners) {
			listener.instanceDeleted(instance);
		}
	}

	public boolean isEmpty() {
		return instanceRegistry.isEmpty();
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

	public static final class InstanceKey {
		private Class<? extends StatefulClass> klass;
		private int instanceID;

		public InstanceKey(StatefulClass instance) {
			this.klass = instance.getClass();
			this.instanceID = instance.getInstanceID();
		}

		public InstanceKey(Class<? extends StatefulClass> klass, int instanceID) {
			this.klass = klass;
			this.instanceID = instanceID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(klass, instanceID);
		}

		public Class<?> getKlass() {
			return klass;
		}

		public int getInstanceID() {
			return instanceID;
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
