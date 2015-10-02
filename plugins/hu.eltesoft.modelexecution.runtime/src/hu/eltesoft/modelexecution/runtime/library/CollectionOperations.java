package hu.eltesoft.modelexecution.runtime.library;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
	 * Returns filtered elements while preserving the container type. The
	 * predicate works on wrapped values.
	 */
	public static <E, C extends Collection<E>> C filter(C collection, Predicate<ArrayList<E>> predicate) {
		return collection.stream().filter(e -> predicate.test(PrimitiveOperations.wrap(e)))
				.collect(Collectors.toCollection(factoryOf(collection)));
	}

	@SuppressWarnings("unchecked")
	public static <E, C extends Collection<E>> Supplier<C> factoryOf(C collection) {
		if (collection instanceof ArrayList<?>) {
			return () -> (C) new ArrayList<E>();
		} else if (collection instanceof HashSet<?>) {
			return () -> (C) new HashSet<E>();
		} else if (collection instanceof HashMultiset<?>) {
			return () -> (C) HashMultiset.create();
		}
		return null;
	}

	public static <E, C extends Collection<?>> Supplier<? extends Collection<E>> factoryOf(C collection,
			Class<E> newItemType) {
		if (collection instanceof ArrayList<?>) {
			return ArrayList::new;
		} else if (collection instanceof HashSet<?>) {
			return HashSet::new;
		} else if (collection instanceof HashMultiset<?>) {
			return HashMultiset::create;
		}
		return null;
	}

	public static <E, C extends Collection<E>> ArrayList<Boolean> add(C collection, ArrayList<E> newItem) {
		return PrimitiveOperations.wrap(collection.add(PrimitiveOperations.unwrap(newItem)));
	}

	public static <E, C extends Collection<E>, C2 extends Collection<E>> ArrayList<Boolean> addAll(C collection,
			C2 newItems) {
		return PrimitiveOperations.wrap(collection.addAll(newItems));
	}

	public static <E> ArrayList<E> get(ArrayList<E> collection, ArrayList<BigInteger> index) {
		return PrimitiveOperations.wrap(collection.get(PrimitiveOperations.unwrap(index).intValue()));
	}

	public static <E> void add(ArrayList<E> collection, ArrayList<BigInteger> index, ArrayList<E> newItem) {
		int i = PrimitiveOperations.unwrap(index).intValue();
		while (collection.size() - 1 < i) {
			// FIXME: fill empty places with the default value of the item type
			collection.add(null);
		}
		collection.set(i, PrimitiveOperations.unwrap(newItem));
	}
}
