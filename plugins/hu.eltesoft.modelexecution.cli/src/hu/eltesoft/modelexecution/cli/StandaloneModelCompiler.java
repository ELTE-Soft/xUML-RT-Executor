package hu.eltesoft.modelexecution.cli;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import hu.eltesoft.modelexecution.cli.exceptions.CliIncQueryException;
import hu.eltesoft.modelexecution.cli.exceptions.CliJavaCompilerException;
import hu.eltesoft.modelexecution.cli.exceptions.FileWriteException;
import hu.eltesoft.modelexecution.cli.exceptions.JavaFileGenerationError;
import hu.eltesoft.modelexecution.cli.exceptions.MissingJavaCompilerException;
import hu.eltesoft.modelexecution.cli.exceptions.ModelLoadFailedException;
import hu.eltesoft.modelexecution.cli.exceptions.RootDirCreationFailed;
import hu.eltesoft.modelexecution.cli.logger.ConsoleLogger;
import hu.eltesoft.modelexecution.filemanager.FileManager;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeChangeListener;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

public class StandaloneModelCompiler {

	static final String ACTION_LANGUAGE_PATHMAP = "pathmap://PAPYRUS_ACTIONLANGUAGE_PROFILE/";
	static final String RALF_LIBRARY_PATHMAP = "pathmap://RALF/library.uml";
	static final String XUMLRT_PROFILE_PATHMAP = "pathmap://XUMLRT_PROFILE/";

	private ConsoleLogger logger;

	public StandaloneModelCompiler(ConsoleLogger logger) {
		this.logger = logger;
	}

	public void compileModel(String modelPath, String rootDir) {
		List<String> generatedJavaFiles = generateSources(modelPath, rootDir);

		logger.verboseTimeMsg(Messages.COMPILING_JAVA_TO_CLASS);
		compileSources(rootDir, generatedJavaFiles);
	}

	private List<String> generateSources(String modelPath, String rootDirName) {
		try {
			List<String> generatedFiles = new ArrayList<>();

			logger.verboseTimeMsg(Messages.COMPILING_MODEL_TO_JAVA);
			ModelSet modelSet = compileModelToJava();

			logger.verboseTimeMsg(Messages.LOADING_MODEL, modelPath);
			Resource resource = loadModel(modelPath, modelSet);

			boolean isCreatingRootDir = createRootDirIfNeeded(rootDirName);
			logRootDirCreation(rootDirName, isCreatingRootDir);

			logger.verboseTimeMsg(Messages.ANALYSING_MODEL);
			boolean anyErrorsDuringGeneration = analyseModel(generatedFiles, modelSet, rootDirName);

			saveNameMapping(rootDirName, resource);

			if (anyErrorsDuringGeneration) {
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

	private void logRootDirCreation(String rootDirName, boolean isCreatingRootDir) {
		if (rootDirName != null && !isCreatingRootDir) {
			logger.verboseTimeMsg(Messages.USING_EXISTING_ROOT_DIR, rootDirName);
		}
		if (rootDirName != null && isCreatingRootDir) {
			logger.verboseTimeMsg(Messages.CREATING_ROOT_DIR, rootDirName);
		}
	}

	private Resource loadModel(String modelPath, ModelSet modelSet) {
		URI fileURI = URI.createFileURI(modelPath);
		Resource resource = modelSet.getResource(fileURI, true);

		if (resource == null) {
			throw new ModelLoadFailedException(modelPath);
		}
		return resource;
	}

	private ModelSet compileModelToJava() {
		ModelSet modelSet = new ModelSet();
		UMLResourcesUtil.init(modelSet);
		hu.eltesoft.modelexecution.cli.Registry.registerPathMaps(modelSet);
		hu.eltesoft.modelexecution.cli.Registry.registerReducedAlfLanguage();
		return modelSet;
	}

	private boolean analyseModel(List<String> generatedFiles, ModelSet modelSet, String rootDir) {
		FileManager fileMan = new FileManager(rootDir);

		boolean[] anyErrorsDuringGeneration = { false };

		SourceCodeChangeListener listener = new SourceCodeChangeListener() {
			@Override
			public void sourceCodeChanged(String qualifiedName, SourceMappedText smTxt, DebugSymbols symbols) {
				String fileText = smTxt.getText().toString();
				try {
					String path = fileMan.addOrUpdate(qualifiedName, fileText);
					generatedFiles.add(path);
				} catch (IOException e) {
					logger.verboseTimeMsg(Messages.JAVA_FILE_SAVE_FAILED, qualifiedName);
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

		taskQueue.forEach(t -> t.perform(listener));
		return anyErrorsDuringGeneration[0];
	}

	/*
	 * @return EClass-EOperation name pairs in the model are mapped onto their
	 * internal representations.
	 */
	private static Map<SimpleImmutableEntry<String, String>, SimpleImmutableEntry<String, String>> getNameMapping(
			String rootDir, Resource resource) {
		Map<SimpleImmutableEntry<String, String>, SimpleImmutableEntry<String, String>> classAndOpMapping = new HashMap<>();

		TreeIterator<EObject> eObjIt = resource.getAllContents();
		while (eObjIt.hasNext()) {
			EObject eObj = eObjIt.next();
			if (!(eObj instanceof Class)) {
				continue;
			}

			Class eClass = (Class) eObj;
			String eClassId = NamedReference.getIdentifier(eClass);

			for (Operation eOperation : eClass.getAllOperations()) {
				String eOperationId = NamedReference.getIdentifier(eOperation);

				classAndOpMapping.put(new SimpleImmutableEntry<>(eClass.getName(), eOperation.getName()),
						new SimpleImmutableEntry<>(eClassId, eOperationId));
			}
		}

		return classAndOpMapping;
	}

	private static void saveNameMapping(String rootDir, Resource resource) {
		Map<SimpleImmutableEntry<String, String>, SimpleImmutableEntry<String, String>> nameMapping = getNameMapping(
				rootDir, resource);
		File mappingFile = new File(rootDir, StandaloneModelExecutor.MAPPING_FILE_NAME);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(mappingFile));) {
			oos.writeObject(nameMapping);
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileWriteException(mappingFile.getAbsolutePath());
		}
	}

	private static void compileSources(String rootDir, List<String> generatedJavaFiles) {
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

	/*
	 * @return {@code true} if creating new root directory
	 */
	private boolean createRootDirIfNeeded(String rootDirName) {
		if (rootDirName == null) {
			return false;
		}

		File rootDir = new File(rootDirName);
		if (rootDir.exists()) {
			return false;
		}
		
		boolean success = rootDir.mkdir();
		if (!success) {
			throw new RootDirCreationFailed(rootDirName);
		}
		
		return true;
	}
}
