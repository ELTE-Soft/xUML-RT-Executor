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

	public static final String NEGATE_BOOLEAN = CLASS_PREFIX + "negateBoolean";
	public static final String NEGATE_INTEGER = CLASS_PREFIX + "negateInteger";
	public static final String NEGATE_REAL = CLASS_PREFIX + "negateReal";

	public static final String INTEGER_PREFIX_DECREMENT = CLASS_PREFIX + "integerPrefixDecrement";
	public static final String INTEGER_PREFIX_INCREMENT = CLASS_PREFIX + "integerPrefixIncrement";
	public static final String INTEGER_POSTFIX_DECREMENT = CLASS_PREFIX + "integerPostfixDecrement";
	public static final String INTEGER_POSTFIX_INCREMENT = CLASS_PREFIX + "integerPostfixIncrement";

	public static final String BOOLEAN_AND = CLASS_PREFIX + "booleanAnd";
	public static final String BOOLEAN_OR = CLASS_PREFIX + "booleanOr";

	public static final String BOOLEAN_BITWISE_AND = CLASS_PREFIX + "booleanBitwiseAnd";
	public static final String BOOLEAN_BITWISE_OR = CLASS_PREFIX + "booleanBitwiseOr";
	public static final String BOOLEAN_BITWISE_XOR = CLASS_PREFIX + "booleanBitwiseXor";

	public static final String INTEGER_BITWISE_AND = CLASS_PREFIX + "integerBitwiseAnd";
	public static final String INTEGER_BITWISE_OR = CLASS_PREFIX + "integerBitwiseOr";
	public static final String INTEGER_BITWISE_XOR = CLASS_PREFIX + "integerBitwiseXor";

	public static final String INTEGER_SHIFT_LEFT = CLASS_PREFIX + "integerShiftLeft";
	public static final String INTEGER_SHIFT_RIGHT = CLASS_PREFIX + "integerShiftRight";
	public static final String INTEGER_SHIFT_RIGHT_UNSIGNED = CLASS_PREFIX + "integerShiftRightUnsigned";

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

	public static ArrayList<Boolean> negateBoolean(final ArrayList<Boolean> value) {
		return wrap(!unwrap(value));
	}

	public static ArrayList<BigInteger> negateInteger(final ArrayList<BigInteger> value) {
		return wrap(unwrap(value).negate());
	}

	public static ArrayList<Double> negateReal(final ArrayList<Double> value) {
		return wrap(-unwrap(value));
	}

	public static ArrayList<BigInteger> integerPrefixDecrement(final ArrayList<BigInteger> value) {
		value.set(0, unwrap(value).subtract(BigInteger.ONE));
		return value;
	}

	public static ArrayList<BigInteger> integerPrefixIncrement(final ArrayList<BigInteger> value) {
		value.set(0, unwrap(value).add(BigInteger.ONE));
		return value;
	}

	public static ArrayList<BigInteger> integerPostfixDecrement(final ArrayList<BigInteger> value) {
		BigInteger old = unwrap(value);
		value.set(0, old.subtract(BigInteger.ONE));
		return wrap(old);
	}

	public static ArrayList<BigInteger> integerPostfixIncrement(final ArrayList<BigInteger> value) {
		BigInteger old = unwrap(value);
		value.set(0, old.add(BigInteger.ONE));
		return wrap(old);
	}

	public static ArrayList<Boolean> booleanAnd(final ArrayList<Boolean> lhs, final ArrayList<Boolean> rhs) {
		return wrap(unwrap(lhs) && unwrap(rhs));
	}

	public static ArrayList<Boolean> booleanOr(final ArrayList<Boolean> lhs, final ArrayList<Boolean> rhs) {
		return wrap(unwrap(lhs) || unwrap(rhs));
	}

	public static ArrayList<Boolean> booleanBitwiseAnd(final ArrayList<Boolean> lhs, final ArrayList<Boolean> rhs) {
		return wrap(unwrap(lhs) & unwrap(rhs));
	}

	public static ArrayList<Boolean> booleanBitwiseOr(final ArrayList<Boolean> lhs, final ArrayList<Boolean> rhs) {
		return wrap(unwrap(lhs) | unwrap(rhs));
	}

	public static ArrayList<Boolean> booleanBitwiseXor(final ArrayList<Boolean> lhs, final ArrayList<Boolean> rhs) {
		return wrap(unwrap(lhs) ^ unwrap(rhs));
	}

	public static ArrayList<BigInteger> integerBitwiseAnd(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs).and(unwrap(rhs)));
	}

	public static ArrayList<BigInteger> integerBitwiseOr(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs).or(unwrap(rhs)));
	}

	public static ArrayList<BigInteger> integerBitwiseXor(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs).xor(unwrap(rhs)));
	}

	public static ArrayList<BigInteger> integerShiftLeft(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs).shiftLeft(unwrap(rhs).intValue()));
	}

	public static ArrayList<BigInteger> integerShiftRight(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs).shiftRight(unwrap(rhs).intValue()));
	}

	public static ArrayList<BigInteger> integerShiftRightUnsigned(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		// The unsigned shift is the same as the signed.
		// This is guaranteed by the representation of BigInteger class.
		return integerShiftRight(lhs, rhs);
	}
}
