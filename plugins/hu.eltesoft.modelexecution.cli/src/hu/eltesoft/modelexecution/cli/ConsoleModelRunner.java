package hu.eltesoft.modelexecution.cli;

import hu.eltesoft.modelexecution.cli.exceptions.BadArgCountException;
import hu.eltesoft.modelexecution.cli.exceptions.BadDirectoryException;
import hu.eltesoft.modelexecution.cli.exceptions.BadFileException;
import hu.eltesoft.modelexecution.cli.exceptions.CliIncQueryException;
import hu.eltesoft.modelexecution.cli.exceptions.CliJavaCompilerException;
import hu.eltesoft.modelexecution.cli.exceptions.CliRuntimeException;
import hu.eltesoft.modelexecution.cli.exceptions.DanglingArgumentsException;
import hu.eltesoft.modelexecution.cli.exceptions.IncompatibleOptsException;
import hu.eltesoft.modelexecution.cli.exceptions.JavaFileGenerationError;
import hu.eltesoft.modelexecution.cli.exceptions.MissingJavaCompilerException;
import hu.eltesoft.modelexecution.cli.exceptions.ModelLoadFailedException;
import hu.eltesoft.modelexecution.cli.exceptions.NothingToDoException;
import hu.eltesoft.modelexecution.cli.exceptions.RootDirCreationFailed;
import hu.eltesoft.modelexecution.cli.exceptions.UnknownArgForOptException;
import hu.eltesoft.modelexecution.filemanager.FileManager;
import hu.eltesoft.modelexecution.m2m.logic.FileUpdateTaskQueue;
import hu.eltesoft.modelexecution.m2m.logic.SimpleM2MTranslator;
import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;
import hu.eltesoft.modelexecution.runtime.XUMLRTRuntime;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.log.MinimalLogger;
import hu.eltesoft.modelexecution.runtime.log.NoLogger;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Console application that compiles and/or executes the model
 * based on the command line arguments.
 */
public class ConsoleModelRunner {
	/** Names for the arguments of the options. */
	public enum ArgValueName {
		LOGGER_NONE("none"),
		LOGGER_MINIMAL("minimal")
		;

		String name;

		private ArgValueName(String name) {
			this.name = name;
		}
	}

	/** Messages that are printed at some point.
	 *  The names in the resource bundle must be the lower case equivalents
	 *  of the enum labels. */
	public enum Message {
		EXECUTING_COMPILED_JAVA,
		DEFAULT_VALUE,
		POSSIBLE_VALUES,
		COMPILING_MODEL_TO_JAVA,
		UNKNOWN_OPT_PAR,
		NO_REQUIRED_OPTION_PRESENT_MANY,
		NO_REQUIRED_OPTION_PRESENT1,
		MISSING_ACTION_OPTIONS,
		OPTION,
		BAD_DIRECTORY,
		BAD_FILE,
		BAD_ARG_COUNT,
		DANGLING_ARG,
		RUNTIME_EXCEPTION,
		MODEL_LOAD_FAILED,
		USING_EXISTING_ROOT_DIR,
		CREATING_ROOT_DIR,
		ROOT_DIR_CREATION_FAILED,
		LOADING_MODEL,
		FINISHED_RUNNING,
		GENERATING_CLASS,
		ANALYSING_MODEL,
		JAVA_FILE_SAVE_FAILED,
		FAILURE_WHILE_GENERATING_JAVA_FILES,
		INCQUERY_EXCEPTION_OCCURRED,
		JAVA_COMPILER_FAILURE,
		MISSING_JAVA_COMPILER,
		COMPILING_JAVA_TO_CLASS,
		FINISHED_WITH_CODE
		;

		public String getMsg(Object... args) {
			String descrBundleName = getDescriptionBundleName();
			String format = getMsgs().getString(descrBundleName);
			return MessageFormat.format(format, args);
		}
		
		public String getDescriptionBundleName() {
			return name().toLowerCase();
		}
	}

	/** Describes the syntax of the options that come from the command line. */
	public enum Opt {
		HELP("help", "h", Util.list(), Util.list()),
		VERBOSE("verbose", "v", Util.list(), Util.list()),

		SETUP("setup", "s", Util.list(), Util.list(), "model"),

		EXECUTE("execute", "e", Util.list(), Util.list(), "class", "feed"),
		WRITE_TRACE("write-trace", "wtr", Util.list(EXECUTE), Util.list(), "dir"),
		READ_TRACE("read-trace", "rtr", Util.list(EXECUTE), Util.list(), "dir"),
		LOGGER("logger", "l", Util.list(EXECUTE),
			   Util.list(ArgValueName.LOGGER_NONE, ArgValueName.LOGGER_MINIMAL), "logger"),

		ROOT("root", "r", Util.list(EXECUTE, SETUP), Util.list(), "dir")
		;

		private static final String OPT_BUNDLE_POSTFIX = "_opt";

		private String longName;
		private String shortName;
		private List<String> argNames;
		/** If the current option is present, one of these must also be present. */
		public List<Opt> requiredOpts;
		/** If the option has a limited number of values, list them here.
		 *  An empty list means the values are not limited to a few items. */
		private List<ArgValueName> argValueNames;

		private Opt(String longName, String shortName, List<Opt> requiredOpts,
				List<ArgValueName> argValueNames, String... argNames) {
			this.longName = longName;
			this.shortName = shortName;
			this.requiredOpts = requiredOpts;
			this.argNames = Util.list(argNames);
			this.argValueNames = argValueNames;
		}

		private Option mkOpt() {
			OptionBuilder.withLongOpt(longName);
			OptionBuilder.hasArgs(argNames.size());
			OptionBuilder.withArgName(String.join(",", argNames));

			String descrBundleName = getDescriptionBundleName();
			String description = getDescription(descrBundleName);
			OptionBuilder.withDescription(description);
			
			return OptionBuilder.create(shortName);
		}

		public String getDescriptionBundleName() {
			return name().toLowerCase() + OPT_BUNDLE_POSTFIX;
		}

		private String getDescription(String descrBundleName) {
			String descr = getMsgs().getString(descrBundleName);
			return hasArgValues() ? descr : mkDescriptionWithArgValues(descr);
		}

		/** Returns whether the option has (named) values for its argument. */
		private boolean hasArgValues() {
			return argValueNames.size() == 0;
		}

		private String mkDescriptionWithArgValues(String descr) {
			String possibleValuesMsg = Message.POSSIBLE_VALUES.getMsg();
			List<String> possibleValues = getPossibleLoggerValues();
			return String.format("%s%n%s: %s", descr,
					possibleValuesMsg, Util.join(possibleValues, ", "));
		}

		private List<String> getPossibleLoggerValues() {
			List<String> argValuesTxt = new ArrayList<>();
			ArgValueName defaultValue = argValueNames.get(0);
			for (ArgValueName argValueName : new TreeSet<>(argValueNames)) {
				boolean isDefault = argValueName == defaultValue;
				String defaultTxt = " (" + Message.DEFAULT_VALUE.getMsg() + ")";
				String appendWhenDefault = isDefault ? defaultTxt : "";
				String loggerOpt = argValueName.name + appendWhenDefault;
				
				argValuesTxt.add(loggerOpt);
			}
			return argValuesTxt; 
		}
		
		private boolean isPresent(CommandLine cmd) {
			return cmd.hasOption(shortName) || cmd.hasOption(longName);
		}
		
		private Optional<String> getOption(CommandLine cmd, int idx) {
			Optional<String[]> options = getOptions(cmd);
			if (!options.isPresent())   return Optional.empty();
			return Optional.of(options.get()[idx]);
		}

		private Optional<String[]> getOptions(CommandLine cmd) {
			Optional<String> presentName = getPresentName(cmd);
			if (!presentName.isPresent())   return Optional.empty();
			return Optional.of(cmd.getOptionValues(presentName.get()));
		}

		private Optional<String> getPresentName(CommandLine cmd) {
			if (cmd.hasOption(longName))    return Optional.of(longName);
			if (cmd.hasOption(shortName))    return Optional.of(shortName);
			return Optional.empty();
		}
	};

	private static ResourceBundle msgs = getDefaultBundle();

	private static final int ERROR_EXIT_CODE = 1;

	private static final Map<String, Function<String, Logger>> LOGGERMAKER_BY_NAME = mkLoggerMaker();

	/** For displaying the time if {@link Opt.VERBOSE} is set. */
	private static Date startTime = new Date();
	
	/** The main actions that the program can do.
	 *  At least one of them must be present. */
	public static final List<String> ACTION_OPTS = Util.list(
			Opt.SETUP.longName, Opt.EXECUTE.longName);

	public static void main(String[] args) {
		Options parserOpts = mkParserOpts();

		try {
			doCli(args, parserOpts);
		} catch (IllegalArgumentException | ParseException e) {
			exitWithErrorMsg(parserOpts, e.getLocalizedMessage());
		}
	}

	public static void doCli(String[] args,
			Options parserOpts) throws ParseException {
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = parser.parse(parserOpts, args);
		processCmdLine(cmd, parserOpts);
	}

	private static void exitWithErrorMsg(Options parserOpts, String errMsg) {
		System.err.println(errMsg);
		printHelp(parserOpts);
		System.exit(ERROR_EXIT_CODE);
	}

	private static Map<String, Function<String, Logger>> mkLoggerMaker() {
		Map<String, Function<String, Logger>> loggerByName = new HashMap<>(); 
		loggerByName.put(ArgValueName.LOGGER_NONE.name, args -> new NoLogger());
		loggerByName.put(ArgValueName.LOGGER_MINIMAL.name, args -> new MinimalLogger());
		return loggerByName;
	}

	private static void processCmdLine(CommandLine cmd, Options parserOpts) {
		if (cmd.hasOption(Opt.HELP.shortName)) {
			showOptionsAndExit(parserOpts);
		}

		checkOptsValidity(cmd, parserOpts);

		processValidCmdLine(parserOpts, cmd);
	}

	private static void checkOptsValidity(CommandLine cmd,
			Options parserOpts) {
		checkMissingRequiredOpts(cmd, parserOpts);
		
		checkUnknownLoggerType(cmd, parserOpts);

		checkNothingToDo(cmd, parserOpts);
		
		boolean rootDirIsNeeded = Opt.EXECUTE.isPresent(cmd);
		boolean rootDirIsAutocreated = Opt.SETUP.isPresent(cmd);
		if (rootDirIsNeeded && !rootDirIsAutocreated) {
			checkIsParameterDir(cmd, parserOpts, Opt.ROOT, 0);
		}

		checkIsParameterDir(cmd, parserOpts, Opt.WRITE_TRACE, 0);
		checkIsParameterDir(cmd, parserOpts, Opt.READ_TRACE, 0);

		checkIsParameterFile(cmd, parserOpts, Opt.SETUP, 0);

		checkArgCount(cmd, parserOpts, Opt.EXECUTE, 2);
		
		checkNoDanglingArg(cmd, parserOpts);
	}

	private static void checkNoDanglingArg(CommandLine cmd, Options parserOpts) {
		String[] danglingArgs = cmd.getArgs();
		if (danglingArgs.length > 0) {
			throw new DanglingArgumentsException(danglingArgs, parserOpts);
		}
		
	}

	private static void checkArgCount(CommandLine cmd, Options parserOpts,
			Opt opt, int expectedArgCount) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		int foundArgCount = opt.getOptions(cmd).get().length;
		if (foundArgCount != expectedArgCount) {
			throw new BadArgCountException(opt.getPresentName(cmd).get(), foundArgCount, expectedArgCount, parserOpts);
		}
		
	}

	private static void checkIsParameterFile(CommandLine cmd, Options parserOpts,
			Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String model = opt.getOption(cmd, idx).get();

		if (!new File(model).canRead()) {
			throw new BadFileException(opt.getPresentName(cmd).get(), model, parserOpts);
		}
	}

	private static void checkIsParameterDir(CommandLine cmd, Options parserOpts,
			Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String root = opt.getOption(cmd, idx).get();

		if (!new File(root).isDirectory()) {
			throw new BadDirectoryException(opt.getPresentName(cmd).get(), root, parserOpts);
		}
	}

	private static void checkMissingRequiredOpts(CommandLine cmd,
			Options parserOpts) {
		Set<Opt> presentOpts = getPresentOpts(cmd);
		for (Opt opt : presentOpts) {
			if (opt.requiredOpts.isEmpty()) {
				continue;
			}
			
			boolean hasRequiredOpt = opt.requiredOpts.stream().anyMatch(
					opt2 -> opt2.isPresent(cmd));
			if (!hasRequiredOpt) {
				throw new IncompatibleOptsException(opt, parserOpts);
			}
		}
	}

	private static Set<Opt> getPresentOpts(CommandLine cmd) {
		return Arrays.stream(Opt.values()).filter(opt -> opt.isPresent(cmd))
				.collect(Collectors.toSet());
	}

	private static void checkNothingToDo(CommandLine cmd, Options parserOpts) {
		boolean isAtLeastOneOptPresent = ACTION_OPTS.stream().anyMatch(
				opt -> cmd.hasOption(opt));
		if (!isAtLeastOneOptPresent) {
			throw new NothingToDoException();
		}
	}

	/** This check is only activated when the user enters a logger type.
	 *  Checks if the entered logger type is unknown.
	 */
	private static void checkUnknownLoggerType(CommandLine cmd,
			Options parserOpts) {
		if (!Opt.LOGGER.isPresent(cmd))    return;

		String userLoggerType = Opt.LOGGER.getOption(cmd, 0).get();
		if (LOGGERMAKER_BY_NAME.containsKey(userLoggerType))    return;

		throw new UnknownArgForOptException(userLoggerType, Opt.LOGGER, parserOpts);
	}

	private static void processValidCmdLine(Options parserOpts, CommandLine cmd) {
		String rootDir = getRootDir(cmd);

		if (Opt.SETUP.isPresent(cmd)) {
			String modelPath = Opt.SETUP.getOption(cmd, 0).get();

			runCompilationStep(modelPath, rootDir, cmd);
		}

		if (Opt.EXECUTE.isPresent(cmd)) {
			String className = Opt.EXECUTE.getOption(cmd, 0).get();
			String feedName = Opt.EXECUTE.getOption(cmd, 1).get();
			
			runExecutionStep(className, feedName, cmd, rootDir);
		}

		verboseTimeMsg(cmd, Message.FINISHED_RUNNING);
	}

	private static void runCompilationStep(String modelPath, String rootDir, CommandLine cmd) {
		List<String> generatedJavaFiles = runJavaGenerationStep(modelPath, rootDir, cmd);
		runJavaCompilationStep(rootDir, cmd, generatedJavaFiles);
	}

	private static void runJavaCompilationStep(String rootDir, CommandLine cmd, List<String> generatedJavaFiles) {
		verboseTimeMsg(cmd, Message.COMPILING_JAVA_TO_CLASS);

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		
		if (compiler == null) {
			throw new MissingJavaCompilerException();
		}
		
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		try (
			StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
		) {
			Iterable<? extends JavaFileObject> compilationUnits = fileManager
					.getJavaFileObjectsFromStrings(generatedJavaFiles);
			List<String> compilationOptions = null;
			JavaCompiler.CompilationTask task = compiler.getTask(null,
					fileManager, diagnostics, compilationOptions, null, compilationUnits);
			boolean success = task.call();
			if (!success) {
				throw new CliJavaCompilerException();
			}
		} catch (IOException e) {
			throw new CliJavaCompilerException();
		}
	}

	private static List<String> runJavaGenerationStep(String modelPath, String rootDir, CommandLine cmd) {
		List<String> generatedFiles = new ArrayList<>();

		try {
			verboseTimeMsg(cmd, Message.COMPILING_MODEL_TO_JAVA);

			registerUmlResourceType();

			verboseTimeMsg(cmd, Message.LOADING_MODEL, modelPath);
			Resource resource = loadModel(modelPath);
			
			if (resource == null) {
				throw new ModelLoadFailedException(modelPath);
			}

			createRootDirIfNeeded(rootDir, cmd);
			
			FileManager fileMan = new FileManager(rootDir);

			boolean[] anyErrorsDuringGeneration = { false };
			
			IncQueryEngine engine = createIncQueryOn(resource);
			TextChangesListener listener = new TextChangesListener() {
				@Override
				public void contentChanged(String qualifiedName,
						SourceMappedText smTxt, DebugSymbols symbols) {
					String fileText = smTxt.getText().toString();
					try {
						verboseTimeMsg(cmd, Message.GENERATING_CLASS, qualifiedName);
						String path = fileMan.addOrUpdate(qualifiedName, fileText);
						generatedFiles.add(path);
					} catch (IOException e) {
						verboseTimeMsg(cmd, Message.JAVA_FILE_SAVE_FAILED, qualifiedName);
						anyErrorsDuringGeneration[0] = true;
					}
				};

				@Override
				public void contentDeleted(String qualifiedName) {
					fileMan.remove(qualifiedName);
				}
			};
			SimpleM2MTranslator translator = SimpleM2MTranslator.create(engine,
					listener);
			FileUpdateTaskQueue taskQueue = translator.fullBuild();

			verboseTimeMsg(cmd, Message.ANALYSING_MODEL);
			taskQueue.performAll();
			
			if (anyErrorsDuringGeneration[0]) {
				throw new JavaFileGenerationError();
			}
			
			return generatedFiles;
		} catch (IncQueryException e) {
			throw new CliIncQueryException(e);
		}
	}

	private static void createRootDirIfNeeded(String rootDirName, CommandLine cmd) {
		if (rootDirName == null)    return;
		
		File rootDir = new File(rootDirName);
		if (rootDir.exists()) {
			verboseTimeMsg(cmd, Message.USING_EXISTING_ROOT_DIR, rootDirName);
		} else {
			verboseTimeMsg(cmd, Message.CREATING_ROOT_DIR, rootDirName);
			boolean success = rootDir.mkdir();
			if (!success) {
				throw new RootDirCreationFailed(rootDirName);
			}
		}
	}

	private static void verboseTimeMsg(CommandLine cmd, Message msg, String... params) {
		if (!Opt.VERBOSE.isPresent(cmd))    return;
		
		Object[] objParams = (Object[])params;

		Date currentTime = new Date();
		long msecDiff = currentTime.getTime() - startTime.getTime();
		long msecPart = msecDiff % 1000;
		long secPart  = msecDiff / 1000;
		System.out.printf("[%d.%03ds] %s%n", secPart, msecPart, msg.getMsg(objParams));
	}

	/** @return Gets the absolute path of the {@link Opt.ROOT} option,
	 *  except when it is not present;
	 *  then it is null, as {@link FileManager} expects it so. */
	private static String getRootDir(CommandLine cmd) {
		if (!Opt.ROOT.isPresent(cmd))    return null;
		return Paths.get(Opt.ROOT.getOption(cmd, 0).get()).toAbsolutePath().toString();
	}

	/** This code is valid in IncQuery 0.8,
	 *  deprecated but available in IncQuery 0.9.
	 	*  The proper form for 0.9 would put the resource in an EMFScope first. */
	private static IncQueryEngine createIncQueryOn(Resource resource)
			throws IncQueryException {
		return IncQueryEngine.on(resource);
	}

    private static Resource loadModel(String modelPath) {
        URI fileURI = URI.createFileURI(modelPath);
        return loadModel(fileURI);
    }
    
    private static Resource loadModel(URI fileURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(fileURI, true);
	}

	private static void registerUmlResourceType() {
		new ResourceSetImpl().getPackageRegistry().put(UMLPackage.eNS_URI,
				UMLPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
	}

	private static void runExecutionStep(String className,
			String feedName, CommandLine cmd, String rootDir) {
		try {
			verboseTimeMsg(cmd, Message.EXECUTING_COMPILED_JAVA);

	        String javaHome = System.getProperty("java.home");
	        String javaBin = Paths.get(javaHome, "bin", "java").toString();
	        String runtimeJar = getRuntimeJarPath();
			String classpath = String.join(java.io.File.pathSeparatorChar + "", runtimeJar , rootDir);

	        String runtimeClassName = XUMLRTRuntime.class.getCanonicalName();

	        List<String> cmdLineArgs = Util.list(javaBin, "-cp", classpath, runtimeClassName, className, feedName);

	        addReadTraceArg(cmdLineArgs, cmd);
	        addWriteTraceArg(cmdLineArgs, cmd);
	        addLogArg(cmdLineArgs, cmd);
	        
			ProcessBuilder builder = new ProcessBuilder(cmdLineArgs);
			builder.redirectInput(Redirect.INHERIT);
			builder.redirectOutput(Redirect.INHERIT);
			builder.redirectError(Redirect.INHERIT);
			Process javaProcess = builder.start();

			int exitCode = javaProcess.waitFor();
			verboseTimeMsg(cmd, Message.FINISHED_WITH_CODE, "" + exitCode);
		} catch (Exception e) {
			throw new CliRuntimeException(e);
		}
	}

	private static void addLogArg(List<String> cmdLineArgs, CommandLine cmd) {
		if (!Opt.READ_TRACE.isPresent(cmd))   return;

		String readTraceFolder = Opt.READ_TRACE.getOption(cmd, 0).get();

		cmdLineArgs.add(XUMLRTRuntime.OPTION_READ_TRACE);
		cmdLineArgs.add(readTraceFolder);
	}

	private static void addWriteTraceArg(List<String> cmdLineArgs,
			CommandLine cmd) {
		if (!Opt.WRITE_TRACE.isPresent(cmd))   return;

		String writeTraceFolder = Opt.WRITE_TRACE.getOption(cmd, 0).get();

		cmdLineArgs.add(XUMLRTRuntime.OPTION_WRITE_TRACE);
		cmdLineArgs.add(writeTraceFolder);
	}

	private static void addReadTraceArg(List<String> cmdLineArgs,
			CommandLine cmd) {
		if (!Opt.LOGGER.isPresent(cmd))   return;

		String loggerArg = Opt.LOGGER.getOption(cmd, 0).get();

		if (loggerArg.equals("none"))    return;
		if (loggerArg.equals("minimal")) {
			cmdLineArgs.add(XUMLRTRuntime.OPTION_LOG);
		}
	}

	/** The jar file of {@link XUMLRTRuntime} will be on our path. */
	private static String getRuntimeJarPath() {
		return System.getProperty("java.class.path");
	}

	public static ResourceBundle getDefaultBundle() {
		String bundleId = ConsoleModelRunner.class.getSimpleName();
		return ResourceBundle.getBundle(bundleId);
	}

	public static Options mkParserOpts() {
		Options parserOpts = new Options();
		Arrays.stream(Opt.values()).map(opt -> opt.mkOpt()).forEach(parserOpts::addOption); 
		return parserOpts;
	}

	private static void showOptionsAndExit(Options parserOpts) {
		printHelp(parserOpts);
		System.exit(0);
	}

	private static void printHelp(Options parserOpts) {
		HelpFormatter formatter = new HelpFormatter();
		String headline = String.format("java %s%n\t\t [%s]...",
				ConsoleModelRunner.class.getCanonicalName(),
				Message.OPTION.getMsg());
		formatter.printHelp(headline, parserOpts);
	}

	public static ResourceBundle getMsgs() {
		return msgs;
	}

	public static void setMsgs(ResourceBundle newMsgs) {
		msgs = newMsgs;
	}

}
