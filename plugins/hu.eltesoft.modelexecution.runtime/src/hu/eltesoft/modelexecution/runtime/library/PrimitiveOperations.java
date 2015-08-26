package hu.eltesoft.modelexecution.runtime.library;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimitiveOperations {

	private static final String CLASS_PREFIX = PrimitiveOperations.class.getCanonicalName() + ".";

	public static final String NULL_VALUE = CLASS_PREFIX + "nullValue";
	public static final String WRAP = CLASS_PREFIX + "wrap";
	public static final String UNWRAP = CLASS_PREFIX + "unwrap";
	public static final String SET_VALUE = CLASS_PREFIX + "setValue";
	public static final String BOOLEAN_LITERAL = CLASS_PREFIX + "booleanLiteral";
	public static final String INTEGER_LITERAL = CLASS_PREFIX + "integerLiteral";
	public static final String REAL_LITERAL = CLASS_PREFIX + "realLiteral";
	public static final String STRING_LITERAL = CLASS_PREFIX + "stringLiteral";

	public static <T> ArrayList<T> nullValue() {
		return new ArrayList<>();
	}

	public static <T> ArrayList<T> wrap(final T value) {
		return new ArrayList<>(Arrays.asList(value));
	}

	public static <T> T unwrap(final ArrayList<T> wrapper) {
		return wrapper.get(0);
	}

	public static <T> ArrayList<T> setValue(final ArrayList<T> wrapper, final ArrayList<T> newValue) {
		wrapper.set(0, unwrap(newValue));
		return newValue;
	}

	public static ArrayList<Boolean> booleanLiteral(final boolean value) {
		return wrap(value);
	}

	public static ArrayList<BigInteger> integerLiteral(final String value, final int radix) {
		return wrap(new BigInteger(value, radix));
	}

	public static ArrayList<Double> realLiteral(final double value) {
		return wrap(value);
	}

	public static ArrayList<String> stringLiteral(final String value) {
		return wrap(value);
	}
}
