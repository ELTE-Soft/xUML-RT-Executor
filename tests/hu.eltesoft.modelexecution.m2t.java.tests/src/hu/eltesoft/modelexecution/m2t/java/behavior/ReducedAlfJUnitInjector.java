package hu.eltesoft.modelexecution.m2t.java.behavior;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.incquerylabs.uml.ralf.api.IReducedAlfParser;
import com.incquerylabs.uml.ralf.api.impl.ReducedAlfParser;
import com.incquerylabs.uml.ralf.scoping.IUMLContextProvider;

import hu.eltesoft.modelexecution.m2t.java.ModelProperties;

public class ReducedAlfJUnitInjector extends ReducedAlfLanguageInjectorProvider {

	@Override
	protected Injector internalCreateInjector() {
		// register default ePackages
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
		// Create the base rALF module
		Module runtimeModule = new com.incquerylabs.uml.ralf.ReducedAlfLanguageRuntimeModule();
		// create a new module that binds the API classes
		Module customizations = new Module() {
			@Override
			public void configure(Binder binder) {
				IUMLContextProvider provider = new TestModelUMLContextProvider(ModelProperties.PATH);
				binder.bind(IUMLContextProvider.class).toInstance(provider);
				binder.bind(IReducedAlfParser.class).to(ReducedAlfParser.class);
			}
		};
		// create a new injector based off the modules
		return Guice.createInjector(runtimeModule, customizations);
	}
}
