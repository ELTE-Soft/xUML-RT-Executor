package hu.eltesoft.modelexecution.cli;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.cli.CommandLine;

import hu.eltesoft.modelexecution.cli.exceptions.CliRuntimeException;

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

	public static Set<Opt> getPresentOpts(CommandLine cmd) {
		return Arrays.stream(Opt.values()).filter(opt -> opt.isPresent(cmd)).collect(Collectors.toSet());
	}

	/*
	 * @return If executed from the command line, returns the qualified name of
	 * the class. If executed from a jar file, returns the name of the jar.
	 */
	static String getProgramName() {
		if (isExecutedFromJar()) {
			return getJarFile().getName();
		} else {
			return ConsoleModelRunner.class.getCanonicalName();
		}
	}

	private static boolean isExecutedFromJar() {
		String classFile = "hu/eltesoft/modelexecution/cli/ConsoleModelRunner.class";
		return ClassLoader.getSystemResource(classFile).toString().startsWith("jar:");
	}

	/*
	 * Precondition: the program is run from a jar file.
	 * @return The jar file object.
	 */
	private static File getJarFile() {
		try {
			return urlToFile(classToUrl(ConsoleModelRunner.class));
		} catch (Exception e) {
			throw new CliRuntimeException(e);
		}
	}

	private static File urlToFile(URL url) throws URISyntaxException {
		return new File(url.toURI().getPath());
	}

	private static URL classToUrl(Class<?> clazz) {
		return clazz.getProtectionDomain().getCodeSource().getLocation();
	}

	static String getJarPath() throws UnsupportedEncodingException {
		return URLDecoder.decode(
				StandaloneModelCompiler.class.getProtectionDomain().getCodeSource().getLocation().getPath(),
				"UTF-8");
	}
}
