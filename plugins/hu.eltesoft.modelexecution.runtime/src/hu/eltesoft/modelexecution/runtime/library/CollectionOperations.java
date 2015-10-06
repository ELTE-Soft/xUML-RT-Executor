package hu.eltesoft.modelexecution.runtime.library;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

import com.google.common.collect.HashMultiset;

/**
 * Implements standard collection operations used by the runtime.
 */
public final class CollectionOperations {

	private static final String CLASS_PREFIX = CollectionOperations.class.getCanonicalName() + ".";

	public static final String SEQUENCE_LITERAL = CLASS_PREFIX + "sequenceLiteral";
	public static final String SET_LITERAL = CLASS_PREFIX + "setLiteral";
	public static final String BAG_LITERAL = CLASS_PREFIX + "bagLiteral";

	public static final String IS_EMPTY = CLASS_PREFIX + "isEmpty";
	public static final String SIZE = CLASS_PREFIX + "size";
	public static final String ONE = CLASS_PREFIX + "one";
	public static final String FILTER = CLASS_PREFIX + "filter";

	public static final String ADD = CLASS_PREFIX + "add";
	public static final String ADD_ALL = CLASS_PREFIX + "addAll";

	public static final String GET = CLASS_PREFIX + "get";

	@SafeVarargs
	public static <E> ArrayList<E> sequenceLiteral(E... items) {
		return new ArrayList<E>(Arrays.asList(items));
	}

	@SafeVarargs
	public static <E> HashSet<E> setLiteral(E... items) {
		return new HashSet<E>(Arrays.asList(items));
	}

	@SafeVarargs
	public static <E> HashMultiset<E> bagLiteral(E... items) {
		return HashMultiset.create(Arrays.asList(items));
	}

	public static ArrayList<Boolean> isEmpty(Collection<?> collection) {
		return PrimitiveOperations.wrap(collection.isEmpty());
	}

	public static ArrayList<BigInteger> size(Collection<?> collection) {
		return PrimitiveOperations.wrap(BigInteger.valueOf(collection.size()));
	}

	/**
	 * Currently it always extracts the first item of the collection.
	 */
	public static <E> ArrayList<E> one(Collection<? extends E> collection) {
		if (collection.isEmpty()) {
			return PrimitiveOperations.nullValue();
		}
		return PrimitiveOperations.wrap(collection.iterator().next());
	}

	/**
	 * Returns filtered elements. The predicate works on wrapped values.
	 */
	public static <E> ArrayList<E> filter(ArrayList<E> collection, Predicate<ArrayList<E>> predicate) {
		ArrayList<E> result = new ArrayList<>();
		for (E item : collection) {
			if (predicate.test(PrimitiveOperations.wrap(item))) {
				result.add(item);
			}
		}
		return result;
	}

	public static <E> HashSet<E> filter(HashSet<E> collection, Predicate<ArrayList<E>> predicate) {
		HashSet<E> result = new HashSet<>();
		for (E item : collection) {
			if (predicate.test(PrimitiveOperations.wrap(item))) {
				result.add(item);
			}
		}
		return result;
	}

	public static <E> HashMultiset<E> filter(HashMultiset<E> collection, Predicate<ArrayList<E>> predicate) {
		HashMultiset<E> result = HashMultiset.create();
		for (E item : collection) {
			if (predicate.test(PrimitiveOperations.wrap(item))) {
				result.add(item);
			}
		}
		return result;
	}

	public static <E, C extends Collection<E>> ArrayList<Boolean> add(C collection, ArrayList<E> newItem) {
		return PrimitiveOperations.wrap(collection.add(PrimitiveOperations.unwrap(newItem)));
	}

	public static <E> ArrayList<Boolean> addAll(Collection<E> collection, Collection<E> newItems) {
		return PrimitiveOperations.wrap(collection.addAll(newItems));
	}

	public static <E> ArrayList<E> get(ArrayList<E> collection, ArrayList<BigInteger> index) {
		return PrimitiveOperations.wrap(collection.get(PrimitiveOperations.unwrap(index).intValue()));
	}

	public static <E> void add(ArrayList<E> collection, ArrayList<BigInteger> index, ArrayList<E> newItem) {
		int i = PrimitiveOperations.unwrap(index).intValue();
		while (collection.size() - 1 < i) {
			collection.add(defaultValueOf(PrimitiveOperations.unwrap(newItem).getClass()));
		}
		collection.set(i, PrimitiveOperations.unwrap(newItem));
	}

	@SuppressWarnings("unchecked")
	private static <E> E defaultValueOf(Class<?> type) {
		if (Boolean.class.equals(type)) {
			return (E) new Boolean(false);
		} else if (BigInteger.class.equals(type)) {
			return (E) BigInteger.valueOf(0);
		} else if (Double.class.equals(type)) {
			return (E) new Double(0.0);
		} else if (String.class.equals(type)) {
			return (E) "";
		} else
			return null;
	}
}
