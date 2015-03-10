package hu.eltesoft.modelexecution.m2t.smap.emf.xmi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import hu.eltesoft.modelexecution.m2t.smap.emf.LocationQualifier.None;
import hu.eltesoft.modelexecution.m2t.smap.emf.ModelBasedTests;
import hu.eltesoft.modelexecution.m2t.smap.emf.xmi.TestQualifiers.First;
import hu.eltesoft.modelexecution.m2t.smap.emf.xmi.TestQualifiers.Second;
import hu.eltesoft.modelexecution.m2t.smap.xtend.Location;

import org.junit.Before;
import org.junit.Test;

public class XMILocationRegistryTests extends ModelBasedTests {

	private XMILocationRegistry registry;

	@Before
	public void setUp() {
		super.setUp();
		registry = new XMILocationRegistry();
	}

	@Test
	public void testUnqualifiedAssignReturnsSameLocationsForSameEObjects() {
		Location first = registry.assign(aClass);
		Location second = registry.assign(aClass);

		assertEquals(first, second);
	}

	@Test
	public void testEquallyQualifiedAssignsReturnSameLocationsForSameEObjects() {
		Location first = registry.assignQualified(aClass, First.class);
		Location second = registry.assignQualified(aClass, First.class);

		assertEquals(first, second);
	}

	@Test
	public void testDifferentlyQualifiedAssignsReturnDifferentLocationsForSameEObjects() {
		Location first = registry.assignQualified(aClass, First.class);
		Location second = registry.assignQualified(aClass, Second.class);

		assertNotEquals(first, second);
	}

	@Test
	public void testQualificationOfUnqualifiedAssignIsNone() {
		Location first = registry.assign(aClass);
		Location second = registry.assignQualified(aClass, None.class);

		assertEquals(first, second);
	}
}
