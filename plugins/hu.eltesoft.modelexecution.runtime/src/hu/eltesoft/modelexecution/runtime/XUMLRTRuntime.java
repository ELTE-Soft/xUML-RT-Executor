package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.log.MinimalLogger;
import hu.eltesoft.modelexecution.runtime.log.NoLogger;
import hu.eltesoft.modelexecution.runtime.trace.InputTraceBuffer;
import hu.eltesoft.modelexecution.runtime.trace.NoTraceReader;
import hu.eltesoft.modelexecution.runtime.trace.NoTracer;
import hu.eltesoft.modelexecution.runtime.trace.OutputTraceBuffer;
import hu.eltesoft.modelexecution.runtime.trace.TraceReader;
import hu.eltesoft.modelexecution.runtime.trace.TraceReplayer;
import hu.eltesoft.modelexecution.runtime.trace.TraceWriter;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/**
 * BaseRuntime with main. Parses tracing and logging flags.
 */
public class XUMLRTRuntime extends BaseRuntime {

	private static final String TRACING_FOLDER_NAME = "traces";
	private static final int DEFAULT_OUTPUT_BUFFER_SIZE = 1024;
	public static final String OPTION_LOG = "-log";
	public static final String OPTION_READ_TRACE = "-read-trace";
	public static final String OPTION_WRITE_TRACE = "-write-trace";
	private static final String USAGE = "java Q1Runtime class-name feed-function-name "
			+ "[-write-trace output-folder] [-read-trace input-folder] [-log]";
	public static final String OPTION_DEFAULT_TRACE = "-default-trace";

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
		Tracer tracer = new NoTracer();
		TraceReader traceReader = new NoTraceReader();
		Logger logger = new NoLogger();

		for (int i = 2; i < args.length; ++i) {
			switch (args[i]) {
			case OPTION_WRITE_TRACE:
				tracer = new TraceWriter(getDefaultOutputTraceBuffer(args[++i]));
				break;
			case OPTION_READ_TRACE:
				traceReader = new TraceReplayer(
						getDefaultInputTraceBuffer(args[++i]));
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

		TerminationResult result = new XUMLRTRuntime(
				XUMLRTRuntime.class.getClassLoader(), tracer, traceReader,
				logger).run(clsName, feedName);
		System.exit(result.getExitCode());
	}

	/**
	 * Constructs a tracer that actually creates tracefiles.
	 */
	public static Tracer getDefaultTraceWriter(String inputFolder) {
		return new TraceWriter(getDefaultOutputTraceBuffer(inputFolder));
	}

	private static OutputTraceBuffer getDefaultOutputTraceBuffer(
			String folderName) {
		if (folderName.equals(OPTION_DEFAULT_TRACE)) {
			return new OutputTraceBuffer(DEFAULT_OUTPUT_BUFFER_SIZE,
					defaultFileSystem());
		} else {
			return new OutputTraceBuffer(folderName + File.separator
					+ TRACING_FOLDER_NAME, DEFAULT_OUTPUT_BUFFER_SIZE,
					defaultFileSystem());
		}
	}

	/**
	 * Constructs a trace replayer that actually reads tracefiles.
	 */
	public static TraceReplayer getDefaultTraceReplayer(String inputFolder) {
		return new TraceReplayer(getDefaultInputTraceBuffer(inputFolder));
	}

	private static InputTraceBuffer getDefaultInputTraceBuffer(
			String inputFolder) {
		return new InputTraceBuffer(inputFolder + File.separator
				+ TRACING_FOLDER_NAME, defaultFileSystem());
	}

	private static FileSystem defaultFileSystem() {
		return FileSystems.getDefault();
	}
}
