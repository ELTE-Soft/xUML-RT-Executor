package hu.eltesoft.modelexecution.runtime.external;

/**
 * Provides instances from an external entity implementation class. This is the
 * base class for several different strategies.
 */
public abstract class ExternalEntityProvider {

	private Class<?> implementationClass;

	ExternalEntityProvider(Class<?> implementationClass) {
		this.implementationClass = implementationClass;
	}

	protected Object createInstance() {
		try {
			return implementationClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new ExternalEntityException("Unable to instantiate external entity class " + implementationClass, e);
		}
	}

	public abstract Object get();
}
