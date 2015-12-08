package hu.eltesoft.modelexecution.cli;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.cli.ParseException;

public class TestUtils {

	private static final boolean ENABLE_REMOTE_DEBUG = false;

	static final String VERSION = "0.8.1";
	static final String FULL_VERSION = VERSION + "-SNAPSHOT.jar";
	static final String JAR_NAME = "xumlrt-executor-cli-" + FULL_VERSION;
	static final Path JAR_PATH = Paths.get("..", "..", "plugins", "hu.eltesoft.modelexecution.cli", "target", JAR_NAME);

	static final String JACOCO_ARG_PREFIX = "-javaagent:";
	static final String JACOCO_DEST_FILE_FORMAT = "=destfile=target/jacoco-run%d.exec";

	static int runCounter = 0;

	static String nextJacocoArgs() {
		String jacocoVersion = System.getProperty("jacoco.version");
		if (null == jacocoVersion) {
			return "";
		}

		String mavenLocalRepository = System.getProperty("maven.localRepository");
		if (null == mavenLocalRepository) {
			return "";
		}

		Path jacocoRelativeJar = Paths.get("org", "jacoco", "org.jacoco.agent", jacocoVersion,
				"org.jacoco.agent-" + jacocoVersion + "-runtime.jar");
		String jacocoAbsoluteJar = Paths.get(mavenLocalRepository, jacocoRelativeJar.toString()).toString();
		return JACOCO_ARG_PREFIX + jacocoAbsoluteJar + String.format(JACOCO_DEST_FILE_FORMAT, runCounter++);
	}

	/*
	 * Executes the CLI.
	 * 
	 * @param argsTxt Plays the role of the command line arguments.
	 * 
	 * @param timeout A runtime limit in seconds.
	 */
	public static boolean runCli(int timeout, String... args) throws ParseException, IOException, InterruptedException {
		List<String> procArgs = makeProcArgs(args);

		ProcessBuilder processBuilder = new ProcessBuilder(procArgs);
		Process process = processBuilder.start();

		// unfortunately, inheritIO will not work here, as it redirects the
		// underlying file descriptors, not the streams.
		inheritStreamIO(process.getInputStream(), System.out);
		inheritStreamIO(process.getErrorStream(), System.err);
		boolean finished = false;
		try {
			finished = process.waitFor(timeout, TimeUnit.SECONDS);
		} finally {
			if (!finished) {
				process.destroyForcibly();
				return false;
			}
		}
		return true;
	}

	private static void inheritStreamIO(final InputStream src, final PrintStream dest) {
		new Thread(new Runnable() {
			public void run() {
				try (Scanner scanner = new Scanner(src)) {
					while (scanner.hasNextLine()) {
						dest.println(scanner.nextLine());
					}
				}
			}
		}).start();
	}

	private static List<String> makeProcArgs(String... args) {
		List<String> procArgs = new ArrayList<>();
		addAllTo(procArgs, new String[] { "java" });

		if (ENABLE_REMOTE_DEBUG) {
			addAllTo(procArgs, new String[] { "-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=8000" });
		}

		String jacocoArgs = nextJacocoArgs();
		if (!jacocoArgs.isEmpty()) {
			procArgs.add(jacocoArgs);
		}

		addAllTo(procArgs, new String[] { "-jar", JAR_PATH.toAbsolutePath().toString() });
		addAllTo(procArgs, args);
		return procArgs;
	}

	private static void addAllTo(List<String> procArgs, String[] args) {
		for (String arg : args) {
			procArgs.add(arg);
		}
	}

	public static SimpleEntry<String, String> withRedirectedIO(RunnableWithException r) throws Exception {
		PrintStream oldStdOut = System.out;
		PrintStream oldStdErr = System.err;

		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				ByteArrayOutputStream err = new ByteArrayOutputStream();
				PrintStream newStdOut = new PrintStream(out);
				PrintStream newStdErr = new PrintStream(err)) {
			System.setOut(newStdOut);
			System.setErr(newStdErr);

			r.run();

			String outString = out.toString();
			String errString = err.toString();
			return new SimpleEntry<>(outString, errString);
		} finally {
			System.setOut(oldStdOut);
			System.setErr(oldStdErr);
		}
	}
}
