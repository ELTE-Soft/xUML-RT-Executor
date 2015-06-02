package hu.eltesoft.modelexecution.ide.debug.util;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A utility class for maps which are holding other containers.
 **/
public class MapUtils {

	/**
	 * Includes the {@code value} in the list associated with the {@code key}.
	 * Creates the list if necessary.
	 * 
	 * @param map
	 *            A non-null map.
	 * @param key
	 *            A non-null key.
	 * @param value
	 *            A non-null value.
	 **/
	public static <K, V> void addElemIntoSet(Map<K, Set<V>> map, K key, V value) {
		Set<V> list = map.get(key);
		if (list == null) {
			list = new HashSet<>();
		}
		list.add(value);
		map.put(key, list);
	}
}
