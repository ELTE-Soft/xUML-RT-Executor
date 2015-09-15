package hu.eltesoft.modelexecution.runtime.library;

import java.util.ArrayList;
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

	public static final String FILTER = CLASS_PREFIX + "filter";

	/**
	 * Returns filtered elements while preserving the container type. The
	 * predicate works on wrapped values.
	 */
	@SuppressWarnings("unchecked")
	public static <E, C extends Collection<E>> C filter(C collection, Predicate<ArrayList<E>> predicate) {
		Supplier<C> supplier = null;
		if (collection instanceof ArrayList<?>) {
			supplier = () -> (C) new ArrayList<E>();
		} else if (collection instanceof HashSet<?>) {
			supplier = () -> (C) new HashSet<E>();
		} else if (collection instanceof HashMultiset<?>) {
			supplier = () -> (C) HashMultiset.create();
		}
		return collection.stream().filter(e -> predicate.test(PrimitiveOperations.wrap(e)))
				.collect(Collectors.toCollection(supplier));
	}
}
