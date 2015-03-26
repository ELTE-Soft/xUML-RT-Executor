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

/**
 * BaseRuntime with main. Parses tracing and logging flags.
 */
public class TestRuntime extends BaseRuntime {

	public static final String OPTION_LOG = "-log";
	public static final String OPTION_READ_TRACE = "-read-trace";
	public static final String OPTION_WRITE_TRACE = "-write-trace";
	private static final String USAGE = "java Q1Runtime class-name feed-function-name "
			+ "[-write-trace output-folder] [-read-trace input-folder] [-log]";

	public TestRuntime(Tracer tracer, TraceReader traceReader, Logger logger) {
		super(tracer, traceReader, logger);
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
				tracer = new TraceWriter(args[++i]);
				break;

			case OPTION_READ_TRACE:
				traceReader = new TraceReplayer(args[++i]);
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

		new TestRuntime(tracer, traceReader, logger).run(clsName, feedName);
	}
}
