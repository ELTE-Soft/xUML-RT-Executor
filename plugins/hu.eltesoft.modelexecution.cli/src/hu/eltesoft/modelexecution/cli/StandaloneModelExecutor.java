package hu.eltesoft.modelexecution.cli;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleImmutableEntry;

import org.apache.commons.cli.CommandLine;

import hu.eltesoft.modelexecution.cli.exceptions.CannotLoadNameMappingException;
import hu.eltesoft.modelexecution.cli.exceptions.CliRuntimeException;
import hu.eltesoft.modelexecution.cli.exceptions.MissingFileException;
import hu.eltesoft.modelexecution.cli.exceptions.NoClassAndFeedException;
import hu.eltesoft.modelexecution.runtime.XUMLRTRuntime;

public class StandaloneModelExecutor {

	static String MAPPING_FILE_NAME = "symbols.data";
	
	private ConsoleLogger logger;
	private CommandLine cmd;
	private String className;
	private String feedName;

	public StandaloneModelExecutor(ConsoleLogger logger, CommandLine cmd) {
		this.logger = logger;
		this.cmd = cmd;
		this.className = Opt.EXECUTE.getOption(cmd, 0).get();
		this.feedName = Opt.EXECUTE.getOption(cmd, 1).get();
	}

	public void executeModel(String rootDir) {
		try {
			logger.verboseTimeMsg(Messages.EXECUTING_COMPILED_JAVA);

			String javaHome = System.getProperty("java.home");
			String javaBin = Paths.get(javaHome, "bin", "java").toString();
			String runtimeJar = getRuntimeJarPath();
			String classpath = String.join(java.io.File.pathSeparatorChar + "", runtimeJar, rootDir);
			String runtimeClassName = XUMLRTRuntime.class.getCanonicalName();

			AbstractMap.SimpleImmutableEntry<String, String> mappedNamePair = getClassFeedMappedName(rootDir, className,
					feedName);
			String mappedClassName = mappedNamePair.getKey();
			String mappedFeedName = mappedNamePair.getValue();

			List<String> cmdLineArgs = Utils.list(javaBin, "-cp", classpath, runtimeClassName, mappedClassName,
					mappedFeedName);
			addReadTraceArg(cmdLineArgs);
			addWriteTraceArg(cmdLineArgs);
			addLogArg(cmdLineArgs);

			ProcessBuilder builder = new ProcessBuilder(cmdLineArgs);
			builder.redirectInput(Redirect.INHERIT);
			builder.redirectOutput(Redirect.INHERIT);
			builder.redirectError(Redirect.INHERIT);
			Process javaProcess = builder.start();

			int exitCode = javaProcess.waitFor();
			logger.verboseTimeMsg(Messages.FINISHED_WITH_CODE, "" + exitCode);
		} catch (Exception e) {
			throw new CliRuntimeException(e);
		}
	}

	private AbstractMap.SimpleImmutableEntry<String, String> getClassFeedMappedName(String rootDir, String className,
			String feedName) {
		Map<AbstractMap.SimpleImmutableEntry<String, String>, AbstractMap.SimpleImmutableEntry<String, String>> nameMapping = getNameMap(
				rootDir);
		SimpleImmutableEntry<String, String> classAndFeed = new AbstractMap.SimpleImmutableEntry<>(className, feedName);

		if (!nameMapping.containsKey(classAndFeed)) {
			throw new NoClassAndFeedException(nameMapping);
		}

		return nameMapping.get(classAndFeed);
	}

	@SuppressWarnings("unchecked")
	private Map<AbstractMap.SimpleImmutableEntry<String, String>, AbstractMap.SimpleImmutableEntry<String, String>> getNameMap(
			String rootDir) {
		File mappingFile = new File(rootDir, MAPPING_FILE_NAME);
		String mappingFileName = mappingFile.toString();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(mappingFile));) {
			return (Map<AbstractMap.SimpleImmutableEntry<String, String>, AbstractMap.SimpleImmutableEntry<String, String>>) ois
					.readObject();
		} catch (IOException e) {
			throw new MissingFileException(mappingFileName);
		} catch (Exception e) {
			throw new CannotLoadNameMappingException(mappingFileName);
		}
	}

	private void addLogArg(List<String> cmdLineArgs) {
		if (!Opt.READ_TRACE.isPresent(cmd))
			return;

		String readTraceFolder = Opt.READ_TRACE.getOption(cmd, 0).get();

		cmdLineArgs.add(XUMLRTRuntime.OPTION_READ_TRACE);
		cmdLineArgs.add(readTraceFolder);
	}

	private void addWriteTraceArg(List<String> cmdLineArgs) {
		if (!Opt.WRITE_TRACE.isPresent(cmd))
			return;

		String writeTraceFolder = Opt.WRITE_TRACE.getOption(cmd, 0).get();

		cmdLineArgs.add(XUMLRTRuntime.OPTION_WRITE_TRACE);
		cmdLineArgs.add(writeTraceFolder);
	}

	private void addReadTraceArg(List<String> cmdLineArgs) {
		if (!Opt.LOGGER.isPresent(cmd)) {
			return;
		}

		String loggerArg = Opt.LOGGER.getOption(cmd, 0).get();
		if (loggerArg.equals("none")) {
			return;
		}

		if (loggerArg.equals("minimal")) {
			cmdLineArgs.add(XUMLRTRuntime.OPTION_LOG);
		}
	}

	/** The jar file of {@link XUMLRTRuntime} will be on our path. */
	private String getRuntimeJarPath() {
		return System.getProperty("java.class.path");
	}

}
