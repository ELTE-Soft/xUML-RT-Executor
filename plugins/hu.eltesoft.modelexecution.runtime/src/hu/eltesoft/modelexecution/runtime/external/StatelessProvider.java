package hu.eltesoft.modelexecution.runtime.external;

/**
 * Generates a new instance for every external entity call.
 */
public class StatelessProvider extends ExternalEntityProvider {

	StatelessProvider(Class<?> implementationClass) {
		super(implementationClass);
	}

	@Override
	public Object get() {
		return createInstance();
	}
}
