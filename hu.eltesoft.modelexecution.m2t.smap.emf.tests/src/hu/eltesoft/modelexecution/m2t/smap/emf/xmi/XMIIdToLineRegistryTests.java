package hu.eltesoft.modelexecution.m2t.smap.emf.xmi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier;
import hu.eltesoft.modelexecution.m2t.smap.emf.ModelBasedTests;
import hu.eltesoft.modelexecution.m2t.smap.emf.QualifiedEObject;
import hu.eltesoft.modelexecution.m2t.smap.emf.xmi.TestQualifiers.First;
import hu.eltesoft.modelexecution.m2t.smap.emf.xmi.TestQualifiers.Second;

import org.junit.Before;
import org.junit.Test;

public class XMIIdToLineRegistryTests extends ModelBasedTests {

	private XMIIdToLineRegistry registry;

	@Before
	public void setUp() {
		super.setUp();
		registry = new XMIIdToLineRegistry(aClass.eResource());
	}

	@Test
	public void testGettingLineNumberWithoutQualification() {
		QualifiedEObject qualified = new QualifiedEObject(aClass,
				LocationQualifier.None.class);
		int firstLineNumber = registry.objectToLineNumber(qualified);
		int secondLineNumber = registry.objectToLineNumber(qualified);

		assertEquals(firstLineNumber, secondLineNumber);
	}

	@Test
	public void testGettingLineNumberWithDifferentQualification() {
		QualifiedEObject qualified1 = new QualifiedEObject(aClass, First.class);
		QualifiedEObject qualified2 = new QualifiedEObject(aClass, Second.class);
		int firstLineNumber = registry.objectToLineNumber(qualified1);
		int secondLineNumber = registry.objectToLineNumber(qualified2);

		assertNotEquals(firstLineNumber, secondLineNumber);
	}

	@Test
	public void testGettingObjectForInvalidLine() {
		QualifiedEObject qualified = registry.lineNumberToObject(42);
		assertNull(qualified);
	}

	@Test
	public void testGettingUnqualifiedObjectForValidLine() {
		QualifiedEObject qualified = new QualifiedEObject(aClass,
				LocationQualifier.None.class);
		int lineNumber = registry.objectToLineNumber(qualified);

		qualified = registry.lineNumberToObject(lineNumber);

		assertEquals(aClass, qualified.getEObject());
		assertTrue(qualified.isUnqualified());
	}

	@Test
	public void testGettingDifferentlyQualifiedObjectsForValidLines() {
		QualifiedEObject qualified1 = new QualifiedEObject(aClass, First.class);
		QualifiedEObject qualified2 = new QualifiedEObject(aClass, Second.class);
		int firstLineNumber = registry.objectToLineNumber(qualified1);
		int secondLineNumber = registry.objectToLineNumber(qualified2);

		qualified1 = registry.lineNumberToObject(firstLineNumber);
		qualified2 = registry.lineNumberToObject(secondLineNumber);

		assertEquals(aClass, qualified1.getEObject());
		assertEquals(aClass, qualified2.getEObject());
		assertTrue(qualified1.isQualifieddAs(First.class));
		assertTrue(qualified2.isQualifieddAs(Second.class));
	}
}
