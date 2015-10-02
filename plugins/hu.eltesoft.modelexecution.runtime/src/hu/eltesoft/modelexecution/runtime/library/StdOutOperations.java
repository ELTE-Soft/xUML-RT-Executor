package hu.eltesoft.modelexecution.runtime.library;

import java.util.ArrayList;

public class StdOutOperations {

	private static final String CLASS_PREFIX = StdOutOperations.class.getCanonicalName() + ".";

	public static final String PRINTLN = CLASS_PREFIX + "println";

	public static void println(ArrayList<?> wrapper) {
		if (wrapper.isEmpty()) {
			// empty wrapper means null value here
			System.out.println("null");
		} else {
			System.out.println(PrimitiveOperations.unwrap(wrapper));
		}
	}
}
