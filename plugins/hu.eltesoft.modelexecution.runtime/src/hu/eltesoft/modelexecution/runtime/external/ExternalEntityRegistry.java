package hu.eltesoft.modelexecution.runtime.external;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime support for external entities. This registry is used by the generated
 * code in the behaviors to lookup the appropriate external entities by their
 * skeleton class name. It is important that our generated code could contain
 * the user-specified implementation class name only as a string literal. This
 * is ensured by storing only the generated skeleton class's name. The
 * implementation class is then linked to the skeleton class with an annotation
 * on the generated skeleton.
 */
public final class ExternalEntityRegistry {

	private final Map<String, ExternalEntityProvider> providers = new HashMap<>();
	private final ClassLoader classLoader;

	public ExternalEntityRegistry(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@SuppressWarnings("unchecked")
	public <Impl> Impl getInstance(Class<? super Impl> entityClass) {
		String entityName = entityClass.getCanonicalName();
		ExternalEntityProvider provider = providers.get(entityName);
		if (null == provider) {
			provider = register(entityClass);
		}

		try {
			return (Impl) provider.get();
		} catch (ClassCastException e) {
			throw new ExternalEntityException("Unable to cast external entity class: " + entityName);
		}
	}

	public ExternalEntityProvider register(Class<?> entityClass) {
		String entityName = entityClass.getCanonicalName();
		ExternalEntity info = entityClass.getAnnotation(ExternalEntity.class);
		if (null == info) {
			throw new ExternalEntityException("Unannotated external entity class: " + entityName);
		}

		ExternalEntityProvider provider = createProvider(info);
		providers.put(entityName, provider);
		return provider;
	}

	private ExternalEntityProvider createProvider(ExternalEntity info) {
		String implementationName = info.implementationClass();

		Class<?> implementationClass;
		try {
			implementationClass = classLoader.loadClass(implementationName);
		} catch (ClassNotFoundException e) {
			throw new ExternalEntityException("Missing external entity implementation: " + implementationName);
		}

		switch (info.type()) {
		default:
		case Stateless:
			return new StatelessProvider(implementationClass);

		case Singleton:
			return new SingletonProvider(implementationClass);
		}
	}
}
