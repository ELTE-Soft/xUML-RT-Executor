package hu.eltesoft.modelexecution.runtime;

import hu.eltesoft.modelexecution.runtime.log.MinimalLogger;
import hu.eltesoft.modelexecution.runtime.trace.TraceReplayer;
import hu.eltesoft.modelexecution.runtime.trace.TraceWriter;
import hu.eltesoft.modelexecution.runtime.trace.Tracer;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import org.json.JSONException;

/**
 * Entry point of the model execution. Parses command line arguments.
 */
public class XUMLRTRuntime extends BaseRuntime {
	public XUMLRTRuntime(ClassLoader classLoader) {
		super(classLoader);
	}

	public static final String OPTION_LOG = "-log";
	public static final String OPTION_CONTROL_SOCK = "-control-sock";
	public static final String OPTION_READ_TRACE = "-read-trace";
	public static final String OPTION_WRITE_TRACE = "-write-trace";
	private static final String USAGE = "java " + XUMLRTRuntime.class.getName()
			+ " class-name feed-function-name " + "[" + OPTION_WRITE_TRACE
			+ " output-folder] [" + OPTION_READ_TRACE + "input-folder] ["
			+ OPTION_LOG + "]";
	private static Socket socket;

	public static void main(String[] args) {
		TerminationResult result = null;
		try (XUMLRTRuntime runtime = new XUMLRTRuntime(
				XUMLRTRuntime.class.getClassLoader())) {
			if (args.length < 2) {
				System.err.println("Not enough parameters. Usage: \n" + USAGE);
			}
			String clsName = args[0];
			String feedName = args[1];
			runtime.applyCommandLineArguments(args);
			logInfo("Command line arguments parsed");
			result = runtime.run(clsName, feedName);
		} catch (Throwable e) {
			logError("Error while running model execution", e);
			result = TerminationResult.INTERNAL_ERROR;
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					logError("Cannot close socket", e);
				}
			}
			System.exit(result.getExitCode());
		}
	}

	protected void applyCommandLineArguments(String[] args) throws Exception {
		for (int i = 2; i < args.length; ++i) {
			switch (args[i]) {
			case OPTION_WRITE_TRACE:
				setTraceWriter(getDefaultTraceWriter(args[++i]));
				break;
			case OPTION_READ_TRACE:
				setTraceReader(getDefaultTraceReplayer(args[++i]));
				break;
			case OPTION_LOG:
				setLogger(new MinimalLogger());
				break;
			case OPTION_CONTROL_SOCK:
				addControlStream(createControlStream(args[++i]));
				break;
			default:
				System.err.println("Could not parse argument " + args[i]
						+ ". Usage: \n" + USAGE);
				break;
			}
		}
	}

	private static InputStream createControlStream(String port) throws NumberFormatException, IOException {
		logInfo("Creating control stream: " + port);
		if (socket != null) {
			throw new RuntimeException("Cannot connect to multiple control streams.");
		}
		socket = new Socket("localhost", Integer.parseInt(port));
		return socket.getInputStream();
	}

	/**
	 * Constructs a tracer that actually creates trace files.
	 */
	public static Tracer getDefaultTraceWriter(String traceParameter)
			throws IOException {
		return new TraceWriter(traceParameter, defaultFileSystem());
	}

	/**
	 * Constructs a trace replayer that actually reads trace files.
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
