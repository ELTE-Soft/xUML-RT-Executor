package hu.eltesoft.modelexecution.m2t.smap.xtend;

import static org.junit.Assert.assertEquals;

public class Assert {

	public static void assertStringEquals(Object expected, Object actual) {
		assertEquals(expected.toString(), actual.toString());
	}
}
