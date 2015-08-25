package hu.eltesoft.modelexecution.cli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.resource.UMLResource;

import hu.eltesoft.modelexecution.cli.exceptions.BadArgCountException;
import hu.eltesoft.modelexecution.cli.exceptions.BadDirectoryException;
import hu.eltesoft.modelexecution.cli.exceptions.BadFileException;
import hu.eltesoft.modelexecution.cli.exceptions.CannotLoadNameMappingException;
import hu.eltesoft.modelexecution.cli.exceptions.CliIncQueryException;
import hu.eltesoft.modelexecution.cli.exceptions.CliJavaCompilerException;
import hu.eltesoft.modelexecution.cli.exceptions.CliRuntimeException;
import hu.eltesoft.modelexecution.cli.exceptions.DanglingArgumentsException;
import hu.eltesoft.modelexecution.cli.exceptions.FileWriteException;
import hu.eltesoft.modelexecution.cli.exceptions.IncompatibleOptsException;
import hu.eltesoft.modelexecution.cli.exceptions.JavaFileGenerationError;
import hu.eltesoft.modelexecution.cli.exceptions.MissingFileException;
import hu.eltesoft.modelexecution.cli.exceptions.MissingJavaCompilerException;
import hu.eltesoft.modelexecution.cli.exceptions.ModelLoadFailedException;
import hu.eltesoft.modelexecution.cli.exceptions.NoClassAndFeedException;
import hu.eltesoft.modelexecution.cli.exceptions.NothingToDoException;
import hu.eltesoft.modelexecution.cli.exceptions.RootDirCreationFailed;
import hu.eltesoft.modelexecution.cli.exceptions.UnknownArgForOptException;
import hu.eltesoft.modelexecution.filemanager.FileManager;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeChangeListener;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;
import hu.eltesoft.modelexecution.runtime.XUMLRTRuntime;
import hu.eltesoft.modelexecution.runtime.log.Logger;
import hu.eltesoft.modelexecution.runtime.log.MinimalLogger;
import hu.eltesoft.modelexecution.runtime.log.NoLogger;

/**
 * Console application that compiles and/or executes the model based on the
 * command line arguments.
 */
/* Needed by the import of EMF UML2 ClassImpl */
@SuppressWarnings("restriction")
public class ConsoleModelRunner {
	static String MAPPING_FILE_NAME = "symbols.data";

	private static final int ERROR_EXIT_CODE = 1;

	private static final Map<String, Supplier<Logger>> LOGGER_FACTORY = new HashMap<>();

	static {
		LOGGER_FACTORY.put(LoggerType.LOGGER_NONE.name, () -> new NoLogger());
		LOGGER_FACTORY.put(LoggerType.LOGGER_MINIMAL.name, () -> new MinimalLogger());
	}

	/**
	 * The main actions that the program can do. At least one of these must be
	 * present.
	 */
	public static final List<String> ACTION_OPTS = Utils.list(Opt.SETUP.longName, Opt.EXECUTE.longName);

	/** For displaying the time if {@link Opt.VERBOSE} is set. */
	private final Date startTime = new Date();

	private final Options options = createParserOptions();

	private CommandLine cmd;

	public static void main(String[] args) {
		ConsoleModelRunner runner = new ConsoleModelRunner();
		try {
			runner.run(args);
		} catch (IllegalArgumentException | ParseException e) {
			runner.exitWithErrorMsg(e.getLocalizedMessage());
		}
	}

	private void exitWithErrorMsg(String errorMessage) {
		System.err.println(errorMessage);
		printHelp();
		System.exit(ERROR_EXIT_CODE);
	}

	public void run(String[] args) throws ParseException {
		CommandLineParser parser = new PosixParser();
		cmd = parser.parse(options, args);
		processCommands();
	}

	public Options createParserOptions() {
		Options options = new Options();
		Arrays.stream(Opt.values()).map(opt -> opt.createOption()).forEach(options::addOption);
		return options;
	}

	private void processCommands() {
		if (cmd.hasOption(Opt.HELP.shortName)) {
			showOptionsAndExit();
		}
		checkOptionsValidity();
		processValidCommands();
	}

	private void showOptionsAndExit() {
		printHelp();
		System.exit(0);
	}

	private void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
		String headline = String.format("java %s%n\t\t [%s]...", ConsoleModelRunner.class.getCanonicalName(),
				Messages.OPTION.getMsg());
		formatter.printHelp(headline, options);
	}

	private void checkOptionsValidity() {
		checkMissingRequiredOptions();

		checkUnknownLoggerType();

		checkNothingToDo();

		boolean rootDirIsNeeded = Opt.EXECUTE.isPresent(cmd);
		boolean rootDirIsAutocreated = Opt.SETUP.isPresent(cmd);
		if (rootDirIsNeeded && !rootDirIsAutocreated) {
			checkIsParameterDir(Opt.ROOT, 0);
		}

		checkIsParameterDir(Opt.WRITE_TRACE, 0);
		checkIsParameterDir(Opt.READ_TRACE, 0);

		checkIsParameterFile(Opt.SETUP, 0);

		checkArgCount(Opt.EXECUTE, 2);

		checkNoDanglingArg();
	}

	private void checkNoDanglingArg() {
		String[] danglingArgs = cmd.getArgs();
		if (danglingArgs.length > 0) {
			throw new DanglingArgumentsException(danglingArgs, options);
		}
	}

	private void checkArgCount(Opt opt, int expectedArgCount) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		int foundArgCount = opt.getOptions(cmd).get().length;
		if (foundArgCount != expectedArgCount) {
			throw new BadArgCountException(opt.getPresentName(cmd).get(), foundArgCount, expectedArgCount, options);
		}
	}

	private void checkIsParameterFile(Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String model = opt.getOption(cmd, idx).get();
		if (!new File(model).canRead()) {
			throw new BadFileException(opt.getPresentName(cmd).get(), model, options);
		}
	}

	private void checkIsParameterDir(Opt opt, int idx) {
		if (!opt.isPresent(cmd)) {
			return;
		}

		String root = opt.getOption(cmd, idx).get();
		if (!new File(root).isDirectory()) {
			throw new BadDirectoryException(opt.getPresentName(cmd).get(), root, options);
		}
	}

	private void checkMissingRequiredOptions() {
		Set<Opt> presentOpts = getPresentOpts();
		for (Opt opt : presentOpts) {
			if (opt.requiredOpts.isEmpty()) {
				continue;
			}

			boolean hasRequiredOpt = opt.requiredOpts.stream().anyMatch(opt2 -> opt2.isPresent(cmd));
			if (!hasRequiredOpt) {
				throw new IncompatibleOptsException(opt, options);
			}
		}
	}

	private Set<Opt> getPresentOpts() {
		return Arrays.stream(Opt.values()).filter(opt -> opt.isPresent(cmd)).collect(Collectors.toSet());
	}

	private void checkNothingToDo() {
		boolean isAtLeastOneOptPresent = ACTION_OPTS.stream().anyMatch(opt -> cmd.hasOption(opt));
		if (!isAtLeastOneOptPresent) {
			throw new NothingToDoException();
		}
	}

	/**
	 * This check is only activated when the user enters a logger type. Checks
	 * if the entered logger type is unknown.
	 */
	private void checkUnknownLoggerType() {
		if (!Opt.LOGGER.isPresent(cmd)) {
			return;
		}

		String userLoggerType = Opt.LOGGER.getOption(cmd, 0).get();
		if (LOGGER_FACTORY.containsKey(userLoggerType)) {
			return;
		}

		throw new UnknownArgForOptException(userLoggerType, Opt.LOGGER, options);
	}

	private void processValidCommands() {
		String rootDir = getRootDir(cmd);

		if (Opt.SETUP.isPresent(cmd)) {
			String modelPath = Opt.SETUP.getOption(cmd, 0).get();
			compileModel(modelPath, rootDir);
		}

		if (Opt.EXECUTE.isPresent(cmd)) {
			String className = Opt.EXECUTE.getOption(cmd, 0).get();
			String feedName = Opt.EXECUTE.getOption(cmd, 1).get();
			executeModel(className, feedName, cmd, rootDir);
		}

		verboseTimeMsg(Messages.FINISHED_RUNNING);
	}

	private void compileModel(String modelPath, String rootDir) {
		List<String> generatedJavaFiles = generateSources(modelPath, rootDir);
		compileSources(rootDir, generatedJavaFiles);
	}

	private List<String> generateSources(String modelPath, String rootDir) {
		List<String> generatedFiles = new ArrayList<>();

		try {
			verboseTimeMsg(Messages.COMPILING_MODEL_TO_JAVA);
			registerUmlResourceType();

			verboseTimeMsg(Messages.LOADING_MODEL, modelPath);
			URI fileURI = URI.createFileURI(modelPath);
			ModelSet modelSet = new ModelSet();
			Resource resource = modelSet.getResource(fileURI, true);

			if (resource == null) {
				throw new ModelLoadFailedException(modelPath);
			}

			createRootDirIfNeeded(rootDir);

			FileManager fileMan = new FileManager(rootDir);

			boolean[] anyErrorsDuringGeneration = { false };
			Map<String, String> nameMapping = new HashMap<>();

			SourceCodeChangeListener listener = new SourceCodeChangeListener() {
				@Override
				public void sourceCodeChanged(String qualifiedName, SourceMappedText smTxt, DebugSymbols symbols) {
					String fileText = smTxt.getText().toString();
					try {
						Map<String, String> localNameMapping = symbols.getNameMapping();
						nameMapping.putAll(localNameMapping);

						String javaFileName = qualifiedName + ".java";
						String objName = localNameMapping.get(qualifiedName);
						if (objName != null) {
							verboseTimeMsg(Messages.GENERATING_CLASS_NAMED, objName, javaFileName);
						} else {
							verboseTimeMsg(Messages.GENERATING_CLASS, javaFileName);
						}

						String path = fileMan.addOrUpdate(qualifiedName, fileText);
						generatedFiles.add(path);
					} catch (IOException e) {
						verboseTimeMsg(Messages.JAVA_FILE_SAVE_FAILED, qualifiedName);
						anyErrorsDuringGeneration[0] = true;
					}
				};

				@Override
				public void sourceCodeDeleted(String qualifiedName) {
					fileMan.remove(qualifiedName);
				}
			};
			ResourceTranslator translator = ResourceTranslator.create(modelSet);
			List<SourceCodeTask> taskQueue = translator.fullTranslation();

			verboseTimeMsg(Messages.ANALYSING_MODEL);
			taskQueue.forEach(t -> t.perform(listener));

			saveNameMapping(rootDir, resource);

			if (anyErrorsDuringGeneration[0]) {
				throw new JavaFileGenerationError();
			}

			return generatedFiles;
		} catch (RuntimeException e) {
			if (e.getCause() instanceof IncQueryException) {
				throw new CliIncQueryException((IncQueryException) e.getCause());
			}
			throw e;
		}
	}

	/*
	 * @return EClass-EOperation name pairs in the model are mapped onto their
	 * internal representations.
	 */
	private Map<AbstractMap.SimpleImmutableEntry<String, String>, AbstractMap.SimpleImmutableEntry<String, String>> getNameMapping(
			String rootDir, Resource resource) {
		Map<AbstractMap.SimpleImmutableEntry<String, String>, AbstractMap.SimpleImmutableEntry<String, String>> classAndOpMapping = new HashMap<>();

		TreeIterator<EObject> eObjIt = resource.getAllContents();
		while (eObjIt.hasNext()) {
			EObject eObj = eObjIt.next();
			if (!(eObj instanceof ClassImpl)) {
				continue;
			}

			ClassImpl eClass = (ClassImpl) eObj;
			String eClassId = NamedReference.getIdentifier(eClass);

			for (Operation eOperation : eClass.getAllOperations()) {
				String eOperationId = NamedReference.getIdentifier(eOperation);

				classAndOpMapping.put(new AbstractMap.SimpleImmutableEntry<>(eClass.getName(), eOperation.getName()),
						new AbstractMap.SimpleImmutableEntry<>(eClassId, eOperationId));
			}
		}

		return classAndOpMapping;
	}

	private void saveNameMapping(String rootDir, Resource resource) {
		Map<AbstractMap.SimpleImmutableEntry<String, String>, AbstractMap.SimpleImmutableEntry<String, String>> nameMapping = getNameMapping(
				rootDir, resource);
		File mappingFile = new File(rootDir, MAPPING_FILE_NAME);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(mappingFile));) {
			oos.writeObject(nameMapping);
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileWriteException(mappingFile.getAbsolutePath());
		}
	}

	private void compileSources(String rootDir, List<String> generatedJavaFiles) {
		verboseTimeMsg(Messages.COMPILING_JAVA_TO_CLASS);

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		if (compiler == null) {
			throw new MissingJavaCompilerException();
		}

		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);) {
			Iterable<? extends JavaFileObject> compilationUnits = fileManager
					.getJavaFileObjectsFromStrings(generatedJavaFiles);
			List<String> compilationOptions = null;
			JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, compilationOptions,
					null, compilationUnits);
			boolean success = task.call();
			if (!success) {
				throw new CliJavaCompilerException(diagnostics.getDiagnostics());
			}
		} catch (IOException e) {
			throw new CliJavaCompilerException();
		}
	}

	private void createRootDirIfNeeded(String rootDirName) {
		if (rootDirName == null) {
			return;
		}

		File rootDir = new File(rootDirName);
		if (rootDir.exists()) {
			verboseTimeMsg(Messages.USING_EXISTING_ROOT_DIR, rootDirName);
		} else {
			verboseTimeMsg(Messages.CREATING_ROOT_DIR, rootDirName);
			boolean success = rootDir.mkdir();
			if (!success) {
				throw new RootDirCreationFailed(rootDirName);
			}
		}
	}

	/**
	 * @return Gets the absolute path of the {@link Opt.ROOT} option, except
	 *         when it is not present; then it is null, as {@link FileManager}
	 *         expects it so.
	 */
	private String getRootDir(CommandLine cmd) {
		if (!Opt.ROOT.isPresent(cmd))
			return null;
		return Paths.get(Opt.ROOT.getOption(cmd, 0).get()).toAbsolutePath().toString();
	}

	private void registerUmlResourceType() {
		new ResourceSetImpl().getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
	}

	private void executeModel(String className, String feedName, CommandLine cmd, String rootDir) {
		try {
			verboseTimeMsg(Messages.EXECUTING_COMPILED_JAVA);

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
			verboseTimeMsg(Messages.FINISHED_WITH_CODE, "" + exitCode);
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

	private void verboseTimeMsg(Messages msg, String... params) {
		if (!Opt.VERBOSE.isPresent(cmd)) {
			return;
		}

		Object[] objParams = (Object[]) params;
		Date currentTime = new Date();
		long msecDiff = currentTime.getTime() - startTime.getTime();
		long msecPart = msecDiff % 1000;
		long secPart = msecDiff / 1000;
		System.out.printf("[%d.%03ds] %s%n", secPart, msecPart, msg.getMsg(objParams));
	}
}
