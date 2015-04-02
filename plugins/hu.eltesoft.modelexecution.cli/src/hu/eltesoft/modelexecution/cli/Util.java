package hu.eltesoft.modelexecution.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Utility functions. */
public class Util {
	public static String join(List<String> strings, String separator) {
		return strings.stream().collect(Collectors.joining(separator));
	}

	@SafeVarargs
	static <T> ArrayList<T> list(T... elems) {
		return new ArrayList<>(Arrays.asList(elems));
	}

}
