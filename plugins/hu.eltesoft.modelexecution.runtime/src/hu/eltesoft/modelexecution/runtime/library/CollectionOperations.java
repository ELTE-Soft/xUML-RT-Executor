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
	public static <E> Collection<E> filter(Collection<E> collection, Predicate<Collection<E>> predicate) {
		return collection.stream().filter(e -> predicate.test(PrimitiveOperations.wrap(e)))
				.collect(Collectors.toCollection(factoryOf(collection)));
	}

	public static <E> Supplier<Collection<E>> factoryOf(Collection<?> collection) {
		if (collection instanceof ArrayList<?>) {
			return ArrayList::new;
		} else if (collection instanceof HashSet<?>) {
			return HashSet::new;
		} else if (collection instanceof HashMultiset<?>) {
			return HashMultiset::create;
		}
		return null;
	}
}
