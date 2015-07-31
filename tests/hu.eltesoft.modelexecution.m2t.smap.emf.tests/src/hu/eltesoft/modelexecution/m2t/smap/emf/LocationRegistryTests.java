package hu.eltesoft.modelexecution.m2t.smap.emf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Class;
import org.junit.Before;
import org.junit.Test;

import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier.None;
import hu.eltesoft.modelexecution.m2t.smap.emf.TestQualifiers.First;
import hu.eltesoft.modelexecution.m2t.smap.emf.TestQualifiers.Second;
import hu.eltesoft.modelexecution.m2t.smap.xtend.Location;
import hu.eltesoft.modelexecution.test.utils.ModelBasedTestCase;

public class LocationRegistryTests extends ModelBasedTestCase {

	private static final String UML_TEST_MODEL_PATH = "resources/model.uml";

	private LocationRegistry registry;
	private EObject aClass;
	private Reference aClassRef;

	public LocationRegistryTests() {
		super(UML_TEST_MODEL_PATH);
	}

	@Before
	public void setUp() {
		super.setUp();
		registry = new LocationRegistry();
		aClass = namedChild(model, Class.class, "A");
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
	public void testUnqualifiedResolutionOfInvalidLocationIsNull() {
		Location location = new Location("test", 1, 1);

		assertNull(registry.resolve(location));
	}

	@Test
	public void testUnqualifiedResolutionOfValidLocationGivesTheOriginalEObject() {
		Location location = registry.assign(aClassRef);
		Reference reference = registry.resolve(location);
		ResourceSet resourceSet = aClass.eResource().getResourceSet();

		assertSame(aClassRef.resolve(resourceSet), reference.resolve(resourceSet));
	}

	@Test
	public void testQualifiedResolutionOfValidLocationGivesTheOriginalEObject() {
		Location location = registry.assignQualified(aClassRef, First.class);
		QualifiedReference reference = registry.resolveQualified(location);
		ResourceSet resourceSet = aClass.eResource().getResourceSet();

		assertSame(aClassRef.resolve(resourceSet), reference.resolve(resourceSet));
		assertTrue(reference.isQualifiedAs(First.class));
	}

	@Test
	public void testUnqualifiedResolutionOfInvalidEObjectIsNull() {
		assertNull(registry.resolve(aClassRef));
	}

	@Test
	public void testUnqualifiedResolutionOfValidEObjectIsCorrect() {
		Location assigned = registry.assign(aClassRef);
		Location resolved = registry.resolve(aClassRef);

		assertEquals(assigned, resolved);
	}

	@Test
	public void testQualifiedResolutionOfValidEObjectIsCorrect() {
		Location assigned = registry.assignQualified(aClassRef, First.class);
		Location resolved = registry.resolveQualified(aClassRef, First.class);

		assertEquals(assigned, resolved);
	}

	@Test
	public void testResolutionOfValidQualifiedEObjectIsNull() {
		registry.assignQualified(aClassRef, First.class);
		Location resolved = registry.resolve(aClassRef);

		assertNull(resolved);
	}

	@Test
	public void testNoneQualifiedResolutionOfValidQualifiedEObjectIsCorrect() {
		Location assigned = registry.assign(aClassRef);
		Location resolved = registry.resolveQualified(aClassRef, None.class);

		assertEquals(assigned, resolved);
	}

	@Test
	public void testSerializationWorks() throws IOException, ClassNotFoundException {
		Location location = registry.assign(aClassRef);

		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(registry);
			oos.flush();

			byte[] buffer = bos.toByteArray();
			try (ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
					ObjectInputStream ois = new ObjectInputStream(bis)) {
				registry = (LocationRegistry) ois.readObject();
			}
		}

		ResourceSet resourceSet = model.eResource().getResourceSet();
		assertSame(aClass, registry.resolve(location).resolve(resourceSet));
	}
}
