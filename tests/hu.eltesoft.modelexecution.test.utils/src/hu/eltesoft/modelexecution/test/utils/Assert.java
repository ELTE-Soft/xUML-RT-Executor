package hu.eltesoft.modelexecution.test.utils;

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
	 * Asserts string equality, without checking any line breaks.
	 */
	public static void assertStringEqualsWithoutBreaks(Object expected, Object actual) {
		assertEquals(withoutLineBreaks(expected.toString()), withoutLineBreaks(actual.toString()));
	}

	/**
	 * Converts Windows ('\r\n') or old Mac ('\r') line endings to Unix-style.
	 */
	private static String toLfLines(String string) {
		return string.replace("\r\n", "\n").replace('\r', '\n');
	}

	/**
	 * Remove all line breaks from a string.
	 */
	private static String withoutLineBreaks(String string) {
		return string.replace("\n", "").replace("\r", "");
	}
}
