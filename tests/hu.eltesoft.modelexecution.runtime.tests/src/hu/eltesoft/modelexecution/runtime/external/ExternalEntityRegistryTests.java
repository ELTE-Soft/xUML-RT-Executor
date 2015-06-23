package hu.eltesoft.modelexecution.runtime.external;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class ExternalEntityRegistryTests {

	private ExternalEntityRegistry registry;

	@Before
	public void setUp() {
		registry = new ExternalEntityRegistry(getClass().getClassLoader());
	}

	@Test(expected = ExternalEntityException.class)
	public void testRegistrationOfUnannotatedEntityClass() {
		registry.register(Integer.class);
	}

	@Test(expected = ExternalEntityException.class)
	public void testGetInstanceWithUnannotatedEntityClass() {
		registry.getInstance(Integer.class);
	}

	public void testGetInstanceWithUnRegisteredEntityClass() {
		assertNotNull(registry.getInstance(StatelessEntity.class));
	}

	@Test(expected = ExternalEntityException.class)
	public void testRegistrationOfAnnotatedEntityClassIsSuccesful() {
		registry.register(Integer.class);
	}

	@Test
	public void testStatelessCreatesNewInstanceEachTime() {
		registry.register(StatelessEntity.class);
		StatelessEntity a = registry.getInstance(StatelessEntity.class);
		StatelessEntity b = registry.getInstance(StatelessEntity.class);
		assertNotSame(a, b);
	}

	@Test
	public void testSingletonUsesSameInstanceEachTime() {
		registry.register(SingletonEntity.class);
		SingletonEntity a = registry.getInstance(SingletonEntity.class);
		SingletonEntity b = registry.getInstance(SingletonEntity.class);
		assertSame(a, b);
	}

	@ExternalEntity(implementationClass = "hu.eltesoft.modelexecution.runtime.external.ExternalEntityRegistryTests$StatelessEntityImpl", type = ExternalEntityType.Stateless)
	public static abstract class StatelessEntity {
	}

	public static class StatelessEntityImpl extends StatelessEntity {
	}

	@ExternalEntity(implementationClass = "hu.eltesoft.modelexecution.runtime.external.ExternalEntityRegistryTests$SingletonEntityImpl", type = ExternalEntityType.Singleton)
	public static abstract class SingletonEntity {
	}

	public static class SingletonEntityImpl extends SingletonEntity {
	}
}
