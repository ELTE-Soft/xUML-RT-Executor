package hu.eltesoft.modelexecution.ide.debug.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A utility class.
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
	public static <K,V> void addElemIntoList(Map<K, List<V>> map, K key, V value) {
		List<V> list = map.get(key);
		if (list == null)
			list = new ArrayList<>();
		list.add(value);
		map.put(key, list);
	}

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
	public static <K,V> void addElemIntoSet(Map<K, Set<V>> map, K key, V value) {
		Set<V> list = map.get(key);
		if (list == null)
			list = new HashSet<>();
		list.add(value);
		map.put(key, list);
	}
}
