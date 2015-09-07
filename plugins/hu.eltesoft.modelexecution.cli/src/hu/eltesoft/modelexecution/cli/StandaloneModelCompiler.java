package hu.eltesoft.modelexecution.cli;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import hu.eltesoft.modelexecution.cli.exceptions.CliIncQueryException;
import hu.eltesoft.modelexecution.cli.exceptions.CliJavaCompilerException;
import hu.eltesoft.modelexecution.cli.exceptions.FileWriteException;
import hu.eltesoft.modelexecution.cli.exceptions.JavaFileGenerationError;
import hu.eltesoft.modelexecution.cli.exceptions.MissingJavaCompilerException;
import hu.eltesoft.modelexecution.cli.exceptions.ModelLoadFailedException;
import hu.eltesoft.modelexecution.cli.exceptions.RootDirCreationFailed;
import hu.eltesoft.modelexecution.filemanager.FileManager;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeChangeListener;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

public class StandaloneModelCompiler {

	private ConsoleLogger logger;

	public StandaloneModelCompiler(ConsoleLogger logger) {
		this.logger = logger;
	}
	
	public void compileModel(String modelPath, String rootDir) {
		preapareReducedAlfLanguage();

		List<String> generatedJavaFiles = generateSources(modelPath, rootDir);
		compileSources(rootDir, generatedJavaFiles);
	}

	private void preapareReducedAlfLanguage() {
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("ecore")) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore",
					new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		}
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xmi")) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi",
					new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		}
		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey("xtextbin")) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtextbin",
					new org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl());
		}
		if (!EPackage.Registry.INSTANCE.containsKey(org.eclipse.xtext.XtextPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(org.eclipse.xtext.XtextPackage.eNS_URI,
					org.eclipse.xtext.XtextPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.incquerylabs.com/uml/ralf/ReducedAlfLanguage")) {
			EPackage.Registry.INSTANCE.put("http://www.incquerylabs.com/uml/ralf/ReducedAlfLanguage",
					com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage.eINSTANCE);
		}
	}

	private List<String> generateSources(String modelPath, String rootDir) {
		List<String> generatedFiles = new ArrayList<>();

		try {
			logger.verboseTimeMsg(Messages.COMPILING_MODEL_TO_JAVA);
			registerUmlResourceType();

			logger.verboseTimeMsg(Messages.LOADING_MODEL, modelPath);
			URI fileURI = URI.createFileURI(modelPath);
			ModelSet modelSet = new ModelSet();
			new PathmapResourceLocator(modelSet, new LinkedList<File>());
			Resource resource = modelSet.getResource(fileURI, true);

			if (resource == null) {
				throw new ModelLoadFailedException(modelPath);
			}

			createRootDirIfNeeded(rootDir);

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

			logger.verboseTimeMsg(Messages.ANALYSING_MODEL);
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
			if (!(eObj instanceof Class)) {
				continue;
			}

			Class eClass = (Class) eObj;
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
		File mappingFile = new File(rootDir, StandaloneModelExecutor.MAPPING_FILE_NAME);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(mappingFile));) {
			oos.writeObject(nameMapping);
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileWriteException(mappingFile.getAbsolutePath());
		}
	}

	private void compileSources(String rootDir, List<String> generatedJavaFiles) {
		logger.verboseTimeMsg(Messages.COMPILING_JAVA_TO_CLASS);

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
			logger.verboseTimeMsg(Messages.USING_EXISTING_ROOT_DIR, rootDirName);
		} else {
			logger.verboseTimeMsg(Messages.CREATING_ROOT_DIR, rootDirName);
			boolean success = rootDir.mkdir();
			if (!success) {
				throw new RootDirCreationFailed(rootDirName);
			}
		}
	}

	private void registerUmlResourceType() {
		new ResourceSetImpl().getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
	}
	
}
