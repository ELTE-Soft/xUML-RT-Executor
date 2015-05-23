package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.log.MinimalLogger;
import hu.eltesoft.modelexecution.runtime.log.NoLogger;
import hu.eltesoft.modelexecution.runtime.trace.NoTraceReader;
import hu.eltesoft.modelexecution.runtime.trace.NoTracer;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader;
import hu.eltesoft.modelexecution.runtime.trace.TraceReplayer;
import hu.eltesoft.modelexecution.runtime.trace.TraceWriter;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import org.json.JSONException;

/**
 * BaseRuntime with main. Parses tracing and logging flags.
 */
public class XUMLRTRuntime extends BaseRuntime {
	public static final String OPTION_LOG = "-log";
	public static final String OPTION_READ_TRACE = "-read-trace";
	public static final String OPTION_WRITE_TRACE = "-write-trace";
	private static final String USAGE = "java Q1Runtime class-name feed-function-name "
			+ "[-write-trace output-folder] [-read-trace input-folder] [-log]";

	public XUMLRTRuntime(ClassLoader classLoader, Tracer tracer,
			TraceReader traceReader, Logger logger) {
		super(classLoader, tracer, traceReader, logger);
	}

	public static void main(String[] args) throws Exception {

		if (args.length < 2) {
			System.err.println("Not enough parameters. Usage: \n" + USAGE);
		}
		String clsName = args[0];
		String feedName = args[1];
		Tracer tracer = null;
		TraceReader traceReader = null;
		Logger logger = null;

		for (int i = 2; i < args.length; ++i) {
			switch (args[i]) {
			case OPTION_WRITE_TRACE:
				tracer = getDefaultTraceWriter(args[++i]);
				break;
			case OPTION_READ_TRACE:
				traceReader = getDefaultTraceReplayer(args[++i]);
				break;
			case OPTION_LOG:
				logger = new MinimalLogger();
				break;
			default:
				System.err.println("Could not parse argument " + args[i]
						+ ". Usage: \n" + USAGE);
				break;
			}
		}
		if (tracer == null) {
			tracer = new NoTracer();
		}
		if (traceReader == null) {
			traceReader = new NoTraceReader();
		}
		if (logger == null) {
			logger = new NoLogger();
		}

		TerminationResult result = new XUMLRTRuntime(
				XUMLRTRuntime.class.getClassLoader(), tracer, traceReader,
				logger).run(clsName, feedName);

		tracer.close();
		traceReader.close();
		logger.close();
		System.exit(result.getExitCode());
	}

	/**
	 * Constructs a tracer that actually creates tracefiles.
	 */
	public static Tracer getDefaultTraceWriter(String traceParameter) {
		try {
			return new TraceWriter(traceParameter, defaultFileSystem());
		} catch (IOException e) {
			throw new RuntimeException("trace writer cannot be initialized", e);
		}
	}

	/**
	 * Constructs a trace replayer that actually reads tracefiles.
	 */
	public static TraceReplayer getDefaultTraceReplayer(String inputFolder)
			throws ClassNotFoundException, JSONException, IOException {
		return new TraceReplayer(inputFolder, defaultFileSystem(),
				XUMLRTRuntime.class.getClassLoader());
	}

	private static FileSystem defaultFileSystem() {
		return FileSystems.getDefault();
	}
}
