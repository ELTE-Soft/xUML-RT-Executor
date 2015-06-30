package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalFactory
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage
import hu.eltesoft.modelexecution.m2t.java.templates.ExternalEntityTemplate
import hu.eltesoft.modelexecution.profile.xumlrt.EntityType
import hu.eltesoft.modelexecution.profile.xumlrt.Stereotypes
import hu.eltesoft.modelexecution.uml.incquery.ExternalOperationParameterMatcher
import hu.eltesoft.modelexecution.uml.incquery.NamedClsMatch
import hu.eltesoft.modelexecution.uml.incquery.NamedClsMatcher
import hu.eltesoft.modelexecution.uml.incquery.NamedOperationMatcher
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Class

import static hu.eltesoft.modelexecution.profile.xumlrt.EntityType.*

class ExternalEntityTranslator extends RootElementTranslator<Class, ExExternalEntity, NamedClsMatch> {

	static val ExternalFactory FACTORY = ExternalFactory.eINSTANCE;
	static val ExternalPackage PACKAGE = ExternalPackage.eINSTANCE;

	new(IncQueryEngine engine) throws IncQueryException {
		super(engine);
	}

	override buildMapper(IncQueryEngine engine) throws IncQueryException {
		val rootNode = fromRoot(NamedClsMatcher.on(engine)) [
			val root = FACTORY.createExExternalEntity
			root.reference = new NamedReference(cls)
			root.implementationClass = Stereotypes.implementationClassOf(cls)
			root.type = Stereotypes.externalEntityTypeOf(cls).convert
			return root
		]
		val operationNode = rootNode.onEObject(PACKAGE.exExternalEntity_Operations, NamedOperationMatcher.on(engine)) [
			val elem = FACTORY.createExOperation
			elem.reference = new NamedReference(operation)
			return elem
		]
		operationNode.on(PACKAGE.exOperation_ProxyClass, ExternalOperationParameterMatcher.on(engine)) [
			typeName
		]
		return rootNode
	}

	def convert(EntityType type) {
		switch (type) {
			case STATELESS: ExEntityType.STATELESS
			case SINGLETON: ExEntityType.SINGLETON
		}
	}

	override createTemplate(ExExternalEntity externalEntity) {
		new ExternalEntityTemplate(externalEntity)
	}

	override shouldMap(Class cls) {

		// generate code only for external entities using this builder
		Stereotypes.isExternalEntity(cls)
	}

	override getRootName(Class cls) {
		cls.name
	}
}