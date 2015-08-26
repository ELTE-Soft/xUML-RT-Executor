package hu.eltesoft.modelexecution.runtime.library;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimitiveOperations {

	public static <T> ArrayList<T> nullValue() {
		return new ArrayList<>();
	}

	public static <T> ArrayList<T> wrap(final T value) {
		return new ArrayList<>(Arrays.asList(value));
	}

	public static <T> T unwrap(final ArrayList<T> wrapper) {
		return wrapper.get(0);
	}

	public static <T> T setValue(final ArrayList<T> wrapper, T newValue) {
		wrapper.set(0, newValue);
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
