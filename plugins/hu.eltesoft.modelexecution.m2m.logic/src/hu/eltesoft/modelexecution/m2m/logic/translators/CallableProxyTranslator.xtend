package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.callable.CaCallable
import hu.eltesoft.modelexecution.m2m.metamodel.callable.CallableFactory
import hu.eltesoft.modelexecution.m2m.metamodel.callable.CallablePackage
import hu.eltesoft.modelexecution.m2t.java.templates.CallableProxyTemplateSmap
import hu.eltesoft.modelexecution.profile.xumlrt.Stereotypes
import hu.eltesoft.modelexecution.uml.incquery.NamedClsMatch
import hu.eltesoft.modelexecution.uml.incquery.NamedClsMatcher
import hu.eltesoft.modelexecution.uml.incquery.NamedReceptionMatcher
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Class

class CallableProxyTranslator extends RootElementTranslator<Class, CaCallable, NamedClsMatch> {

	static val CallableFactory FACTORY = CallableFactory.eINSTANCE;
	static val CallablePackage PACKAGE = CallablePackage.eINSTANCE;

	new(IncQueryEngine engine) throws IncQueryException {
		super(engine);
	}

	override buildMapper(IncQueryEngine engine) throws IncQueryException {
		val rootNode = fromRoot(NamedClsMatcher.on(engine)) [
			val root = FACTORY.createCaCallable
			root.reference = new NamedReference(cls)
			return root
		]
		rootNode.on(PACKAGE.caCallable_Receptions, NamedReceptionMatcher.on(engine)) [
			new NamedReference(reception)
		]
		return rootNode
	}

	override createTemplate(CaCallable cls) {
		new CallableProxyTemplateSmap(cls)
	}

	override shouldMap(Class cls) {

		// generate code only for callable classes using this builder
		Stereotypes.isCallable(cls)
	}

	override getRootName(Class cls) {
		cls.name
	}
}
