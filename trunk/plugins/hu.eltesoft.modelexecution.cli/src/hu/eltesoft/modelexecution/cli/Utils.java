package hu.eltesoft.modelexecution.cli;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Utility functions. */
public class Utils {

	public static String join(List<String> strings, String separator) {
		return strings.stream().collect(Collectors.joining(separator));
	}

	@SafeVarargs
	static <T> ArrayList<T> list(T... elems) {
		return new ArrayList<>(Arrays.asList(elems));
	}

	public static String stackTraceToString(Exception e) {
		try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
			e.printStackTrace(pw);
			return sw.toString();
		} catch (IOException e1) {
			// this should never happen
			return null;
		}
	}

	public static String toResourceKey(Enum<?> value) {
		return value.name().toLowerCase();
	}
}
