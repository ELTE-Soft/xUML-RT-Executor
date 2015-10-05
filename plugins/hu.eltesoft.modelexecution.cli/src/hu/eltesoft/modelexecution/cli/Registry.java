package hu.eltesoft.modelexecution.cli;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.uml2.uml.resource.UMLResource;

import hu.eltesoft.modelexecution.cli.exceptions.CliRuntimeException;

public class Registry {

	static void registerReducedAlfLanguage() {
		Map<String, Object> extMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extMap.putIfAbsent("ecore", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		extMap.putIfAbsent("xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		extMap.putIfAbsent("xtextbin", new org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl());
	
		EPackage.Registry pkgRegistry = EPackage.Registry.INSTANCE;
		pkgRegistry.putIfAbsent(org.eclipse.xtext.XtextPackage.eNS_URI,
					org.eclipse.xtext.XtextPackage.eINSTANCE);
		pkgRegistry.putIfAbsent("http://www.incquerylabs.com/uml/ralf/ReducedAlfLanguage",
					com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage.eINSTANCE);
	}

	static void registerPathMaps(ModelSet modelSet, String jarPath) {
		Map<URI, URI> uriMap = modelSet.getURIConverter().getURIMap();
		URI uri = URI.createURI("jar:file:" + jarPath + "!/");
		uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), uri.appendSegment("libraries").appendSegment(""));
		uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), uri.appendSegment("metamodels").appendSegment(""));
		uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), uri.appendSegment("profiles").appendSegment(""));
	
		uriMap.put(URI.createURI(StandaloneModelCompiler.ACTION_LANGUAGE_PATHMAP),
				uri.appendSegment("resources").appendSegment("action-language-profile").appendSegment(""));
	
		uriMap.put(URI.createURI(StandaloneModelCompiler.RALF_LIBRARY_PATHMAP),
				uri.appendSegment("model").appendSegment("collections").appendSegment("collections.uml"));
	
		uriMap.put(URI.createURI(StandaloneModelCompiler.XUMLRT_PROFILE_PATHMAP), uri.appendSegment("profile").appendSegment(""));
	}

	static void registerPathMaps(ModelSet modelSet) {
		try {
			String jarPath = Utils.getJarPath();
			registerPathMaps(modelSet, jarPath);
		} catch (UnsupportedEncodingException e) {
			throw new CliRuntimeException(e);
		}
	}

}
