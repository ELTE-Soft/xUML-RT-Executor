package hu.eltesoft.modelexecution.m2t.smap.emf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier.None;
import hu.eltesoft.modelexecution.m2t.smap.emf.TestQualifiers.First;
import hu.eltesoft.modelexecution.m2t.smap.emf.TestQualifiers.Second;
import hu.eltesoft.modelexecution.m2t.smap.xtend.Location;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.Before;
import org.junit.Test;

public class LocationRegistryTests extends ModelBasedTests {

	private LocationRegistry registry;
	private Reference aClassRef;

	@Before
	public void setUp() {
		super.setUp();
		registry = new LocationRegistry();
		aClassRef = new Reference(aClass);
	}

	@Test
	public void testUnqualifiedAssignReturnsSameLocationsForSameEObjects() {
		Location first = registry.assign(aClassRef);
		Location second = registry.assign(aClassRef);

		assertEquals(first, second);
	}

	@Test
	public void testEquallyQualifiedAssignsReturnSameLocationsForSameEObjects() {
		Location first = registry.assignQualified(aClassRef, First.class);
		Location second = registry.assignQualified(aClassRef, First.class);

		assertEquals(first, second);
	}

	@Test
	public void testDifferentlyQualifiedAssignsReturnDifferentLocationsForSameEObjects() {
		Location first = registry.assignQualified(aClassRef, First.class);
		Location second = registry.assignQualified(aClassRef, Second.class);

		assertNotEquals(first, second);
	}

	@Test
	public void testQualificationOfUnqualifiedAssignIsNone() {
		Location first = registry.assign(aClassRef);
		Location second = registry.assignQualified(aClassRef, None.class);

		assertEquals(first, second);
	}

	@Test
	public void testSerializationWorks() {
		Location location = registry.assign(aClassRef);

		byte[] buffer = null;
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(registry);
			buffer = bos.toByteArray();
		} catch (IOException e) {
			fail(e.getMessage());
		}

		try (ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
				ObjectInputStream ois = new ObjectInputStream(bis)) {
			registry = (LocationRegistry) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			fail(e.getMessage());
		}

		ResourceSet resourceSet = model.eResource().getResourceSet();
		assertSame(aClass, registry.resolve(location).resolve(resourceSet));
	}
}
