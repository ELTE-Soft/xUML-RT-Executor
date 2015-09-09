package hu.eltesoft.modelexecution.runtime.library;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implements primitive operations used by the runtime.
 */
// TODO: verifications must be implemented
// like division by zero, or invalid casts.
// TODO: review compatibility of setValue, valueEquality, referenceEquality and
// cast with collections
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

	public static final String BOOLEAN_NEGATE = CLASS_PREFIX + "booleanNegate";
	public static final String INTEGER_NEGATE = CLASS_PREFIX + "integerNegate";
	public static final String REAL_NEGATE = CLASS_PREFIX + "realNegate";

	public static final String INTEGER_PREFIX_DECREMENT = CLASS_PREFIX + "integerPrefixDecrement";
	public static final String INTEGER_PREFIX_INCREMENT = CLASS_PREFIX + "integerPrefixIncrement";
	public static final String INTEGER_POSTFIX_DECREMENT = CLASS_PREFIX + "integerPostfixDecrement";
	public static final String INTEGER_POSTFIX_INCREMENT = CLASS_PREFIX + "integerPostfixIncrement";

	public static final String STRING_CONCATENATION = CLASS_PREFIX + "stringConcatenation";

	public static final String INTEGER_ADD_INTEGER = CLASS_PREFIX + "integerAddInteger";
	public static final String INTEGER_ADD_REAL = CLASS_PREFIX + "integerAddReal";
	public static final String REAL_ADD_INTEGER = CLASS_PREFIX + "realAddInteger";
	public static final String REAL_ADD_REAL = CLASS_PREFIX + "realAddReal";

	public static final String INTEGER_SUBTRACT_INTEGER = CLASS_PREFIX + "integerSubtractInteger";
	public static final String INTEGER_SUBTRACT_REAL = CLASS_PREFIX + "integerSubtractReal";
	public static final String REAL_SUBTRACT_INTEGER = CLASS_PREFIX + "realSubtractInteger";
	public static final String REAL_SUBTRACT_REAL = CLASS_PREFIX + "realSubtractReal";

	public static final String INTEGER_MULTIPLY_INTEGER = CLASS_PREFIX + "integerMultiplyInteger";
	public static final String INTEGER_MULTIPLY_REAL = CLASS_PREFIX + "integerMultiplyReal";
	public static final String REAL_MULTIPLY_INTEGER = CLASS_PREFIX + "realMultiplyInteger";
	public static final String REAL_MULTIPLY_REAL = CLASS_PREFIX + "realMultiplyReal";

	public static final String INTEGER_DIVIDE_INTEGER = CLASS_PREFIX + "integerDivideInteger";
	public static final String INTEGER_DIVIDE_REAL = CLASS_PREFIX + "integerDivideReal";
	public static final String REAL_DIVIDE_INTEGER = CLASS_PREFIX + "realDivideInteger";
	public static final String REAL_DIVIDE_REAL = CLASS_PREFIX + "realDivideReal";

	public static final String INTEGER_MODULO_INTEGER = CLASS_PREFIX + "integerModuloInteger";

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

	public static final String INTEGER_LESS_THAN_INTEGER = CLASS_PREFIX + "integerLessThanInteger";
	public static final String INTEGER_LESS_THAN_REAL = CLASS_PREFIX + "integerLessThanReal";
	public static final String REAL_LESS_THAN_INTEGER = CLASS_PREFIX + "realLessThanInteger";
	public static final String REAL_LESS_THAN_REAL = CLASS_PREFIX + "realLessThanReal";

	public static final String VALUE_EQUALITY = CLASS_PREFIX + "valueEquality";
	public static final String REFERENCE_EQUALITY = CLASS_PREFIX + "referenceEquality";

	public static final String CAST = CLASS_PREFIX + "cast";

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

	public static ArrayList<Boolean> booleanNegate(final ArrayList<Boolean> value) {
		return wrap(!unwrap(value));
	}

	public static ArrayList<BigInteger> integerNegate(final ArrayList<BigInteger> value) {
		return wrap(unwrap(value).negate());
	}

	public static ArrayList<Double> realNegate(final ArrayList<Double> value) {
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

	public static ArrayList<String> stringConcatenation(final ArrayList<String> lhs, final ArrayList<String> rhs) {
		return wrap(unwrap(lhs) + unwrap(rhs));
	}

	public static ArrayList<BigInteger> integerAddInteger(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs).add(unwrap(rhs)));
	}

	public static ArrayList<Double> integerAddReal(final ArrayList<BigInteger> lhs, final ArrayList<Double> rhs) {
		return wrap(unwrap(lhs).doubleValue() + unwrap(rhs));
	}

	public static ArrayList<Double> realAddInteger(final ArrayList<Double> lhs, final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs) + unwrap(rhs).doubleValue());
	}

	public static ArrayList<Double> realAddReal(final ArrayList<Double> lhs, final ArrayList<Double> rhs) {
		return wrap(unwrap(lhs) + unwrap(rhs));
	}

	public static ArrayList<BigInteger> integerSubtractInteger(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs).subtract(unwrap(rhs)));
	}

	public static ArrayList<Double> integerSubtractReal(final ArrayList<BigInteger> lhs, final ArrayList<Double> rhs) {
		return wrap(unwrap(lhs).doubleValue() - unwrap(rhs));
	}

	public static ArrayList<Double> realSubtractInteger(final ArrayList<Double> lhs, final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs) - unwrap(rhs).doubleValue());
	}

	public static ArrayList<Double> realSubtractReal(final ArrayList<Double> lhs, final ArrayList<Double> rhs) {
		return wrap(unwrap(lhs) - unwrap(rhs));
	}

	public static ArrayList<BigInteger> integerMultiplyInteger(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs).multiply(unwrap(rhs)));
	}

	public static ArrayList<Double> integerMultiplyReal(final ArrayList<BigInteger> lhs, final ArrayList<Double> rhs) {
		return wrap(unwrap(lhs).doubleValue() * unwrap(rhs));
	}

	public static ArrayList<Double> realMultiplyInteger(final ArrayList<Double> lhs, final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs) * unwrap(rhs).doubleValue());
	}

	public static ArrayList<Double> realMultiplyReal(final ArrayList<Double> lhs, final ArrayList<Double> rhs) {
		return wrap(unwrap(lhs) * unwrap(rhs));
	}

	public static ArrayList<BigInteger> integerDivideInteger(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs).divide(unwrap(rhs)));
	}

	public static ArrayList<Double> integerDivideReal(final ArrayList<BigInteger> lhs, final ArrayList<Double> rhs) {
		return wrap(unwrap(lhs).doubleValue() / unwrap(rhs));
	}

	public static ArrayList<Double> realDivideInteger(final ArrayList<Double> lhs, final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs) / unwrap(rhs).doubleValue());
	}

	public static ArrayList<Double> realDivideReal(final ArrayList<Double> lhs, final ArrayList<Double> rhs) {
		return wrap(unwrap(lhs) / unwrap(rhs));
	}

	public static ArrayList<BigInteger> integerModuloInteger(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs).mod(unwrap(rhs)));
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

	public static ArrayList<Boolean> integerLessThanInteger(final ArrayList<BigInteger> lhs,
			final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs).compareTo(unwrap(rhs)) < 0);
	}

	public static ArrayList<Boolean> integerLessThanReal(final ArrayList<BigInteger> lhs, final ArrayList<Double> rhs) {
		return wrap(unwrap(lhs).doubleValue() < unwrap(rhs));
	}

	public static ArrayList<Boolean> realLessThanInteger(final ArrayList<Double> lhs, final ArrayList<BigInteger> rhs) {
		return wrap(unwrap(lhs) < unwrap(rhs).doubleValue());
	}

	public static ArrayList<Boolean> realLessThanReal(final ArrayList<Double> lhs, final ArrayList<Double> rhs) {
		return wrap(unwrap(lhs) < unwrap(rhs));
	}

	public static ArrayList<Boolean> valueEquality(final ArrayList<Object> lhs, final ArrayList<Object> rhs) {
		return wrap(unwrap(lhs).equals(unwrap(rhs)));
	}

	public static ArrayList<Boolean> referenceEquality(final ArrayList<Object> lhs, final ArrayList<Object> rhs) {
		return wrap(unwrap(lhs) == unwrap(rhs));
	}

	public static <TargetType, SourceType> ArrayList<TargetType> cast(Class<TargetType> targetType,
			ArrayList<SourceType> sourceExpression) {
		return wrap(targetType.cast(unwrap(sourceExpression)));
	}
}
