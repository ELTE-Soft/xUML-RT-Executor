package hu.eltesoft.modelexecution.m2t.smap.xtend;

import static org.junit.Assert.assertEquals;

public class Assert {

	/**
	 * Asserts string equality. Both expected and actual values are converted to
	 * use Unix line terminators, a single line feed ('\n' character).
	 */
	public static void assertStringEquals(Object expected, Object actual) {
		assertEquals(toLfLines(expected.toString()), toLfLines(actual.toString()));
	}

	/**
	 * Converts Windows ('\r\n') or old Mac ('\r') line endings to Unix-style.
	 */
	private static String toLfLines(String string) {
		return string.replace("\r\n", "\n").replace('\r', '\n');
	}
}
