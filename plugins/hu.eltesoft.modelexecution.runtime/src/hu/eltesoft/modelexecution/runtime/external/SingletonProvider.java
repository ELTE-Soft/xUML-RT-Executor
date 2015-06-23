package hu.eltesoft.modelexecution.runtime.external;

/**
 * Uses a single instance for every external entity call. The instance will be
 * created on demand, right before the first method invocation.
 */
public class SingletonProvider extends ExternalEntityProvider {

	private final Object instance;

	SingletonProvider(Class<?> implementationClass) {
		super(implementationClass);
		instance = createInstance();
	}

	@Override
	public Object get() {
		return instance;
	}
}
