package hu.eltesoft.modelexecution.m2t.smap.emf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import hu.eltesoft.modelexecution.m2t.smap.emf.TestQualifiers.First;
import hu.eltesoft.modelexecution.m2t.smap.emf.TestQualifiers.Second;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.Before;
import org.junit.Test;

public class ReferenceToLineMappingTests extends ModelBasedTests {

	private ReferenceToLineMapping mapping;

	@Before
	public void setUp() {
		super.setUp();
		mapping = new ReferenceToLineMapping();
	}

	@Test
	public void testGettingLineNumberWithoutQualification() {
		QualifiedReference qualified = new QualifiedReference(aClass,
				LocationQualifier.None.class);
		int firstLineNumber = mapping.toLineNumber(qualified);
		int secondLineNumber = mapping.toLineNumber(qualified);

		assertEquals(firstLineNumber, secondLineNumber);
	}

	@Test
	public void testGettingLineNumberWithDifferentQualification() {
		QualifiedReference first = new QualifiedReference(aClass, First.class);
		QualifiedReference second = new QualifiedReference(aClass, Second.class);
		int firstLineNumber = mapping.toLineNumber(first);
		int secondLineNumber = mapping.toLineNumber(second);

		assertNotEquals(firstLineNumber, secondLineNumber);
	}

	@Test
	public void testGettingObjectForInvalidLine() {
		QualifiedReference qualified = mapping.fromLineNumber(42);
		assertNull(qualified);
	}

	@Test
	public void testGettingUnqualifiedObjectForValidLine() {
		QualifiedReference qualified = new QualifiedReference(aClass,
				LocationQualifier.None.class);
		int lineNumber = mapping.toLineNumber(qualified);

		qualified = mapping.fromLineNumber(lineNumber);

		ResourceSet resourceSet = model.eResource().getResourceSet();
		assertEquals(aClass, qualified.resolve(resourceSet));
		assertTrue(qualified.isUnqualified());
	}

	@Test
	public void testGettingDifferentlyQualifiedObjectsForValidLines() {
		QualifiedReference first = new QualifiedReference(aClass, First.class);
		QualifiedReference second = new QualifiedReference(aClass, Second.class);
		int firstLineNumber = mapping.toLineNumber(first);
		int secondLineNumber = mapping.toLineNumber(second);

		first = mapping.fromLineNumber(firstLineNumber);
		second = mapping.fromLineNumber(secondLineNumber);

		ResourceSet resourceSet = model.eResource().getResourceSet();
		assertEquals(aClass, first.resolve(resourceSet));
		assertEquals(aClass, second.resolve(resourceSet));
		assertTrue(first.isQualifieddAs(First.class));
		assertTrue(second.isQualifieddAs(Second.class));
	}
}
