package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExEntityType
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExExternalEntity
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalFactory
import hu.eltesoft.modelexecution.m2m.metamodel.external.ExternalPackage
import hu.eltesoft.modelexecution.m2t.java.templates.ExternalEntityTemplateSmap
import hu.eltesoft.modelexecution.profile.xumlrt.EntityType
import hu.eltesoft.modelexecution.profile.xumlrt.Stereotypes
import hu.eltesoft.modelexecution.uml.incquery.NamedClsMatch
import hu.eltesoft.modelexecution.uml.incquery.NamedClsMatcher
import hu.eltesoft.modelexecution.uml.incquery.NamedOperationMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBoundMatcher
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Class

class ExternalEntityTranslator extends RootElementTranslator<Class, ExExternalEntity, NamedClsMatch> {

	static val ExternalFactory FACTORY = ExternalFactory.eINSTANCE;
	static val ExternalPackage PACKAGE = ExternalPackage.eINSTANCE;

	new(AdvancedIncQueryEngine engine) throws IncQueryException {
		super(engine);
	}

	override protected createMapper(AdvancedIncQueryEngine engine) {
		val rootNode = fromRoot(NamedClsMatcher.on(engine)) [
			val root = FACTORY.createExExternalEntity
			root.reference = new NamedReference(cls)
			root.implementationClass = Stereotypes.implementationClassOf(cls)
			root.type = Stereotypes.externalEntityTypeOf(cls).convert
			return root
		]
		return rootNode
	}

	override protected initMapper(RootNode<?, ?, ?> rootNode, AdvancedIncQueryEngine engine) {
		val operationNode = rootNode.onEObject(PACKAGE.exExternalEntity_Operations, NamedOperationMatcher.on(engine)) [
			val elem = FACTORY.createExOperation
			elem.reference = new NamedReference(operation)
			return elem
		]
		
		// operation parameters
		val parameterNode = operationNode.onEObject(PACKAGE.exOperation_Parameters,
			OperationParameterMatcher.on(engine)) [
			val elem = BASE_FACTORY.createParameter
			elem.reference = new NamedReference(parameter)
			elem.direction = direction.convert
			return elem
		]
		val parameterTypeNode = parameterNode.onEObject(BASE_PACKAGE.typed_Type,
			OperationParameterTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createType
			elem.baseType = type.convert
			elem.isOrdered = ordered
			elem.isUnique = unique
			return elem
		]
		parameterTypeNode.on(BASE_PACKAGE.multiplicity_LowerBound, OperationParameterLowerBoundMatcher.on(engine)) [
			lowerBound
		]
		parameterTypeNode.on(BASE_PACKAGE.multiplicity_UpperBound, OperationParameterUpperBoundMatcher.on(engine)) [
			upperBound
		]

		// operation return type
		val operationReturn = operationNode.onEObject(PACKAGE.exOperation_ReturnType,
			OperationReturnTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createType
			elem.baseType = type.convert
			elem.isOrdered = ordered
			elem.isUnique = unique
			return elem
		]
		operationReturn.on(BASE_PACKAGE.multiplicity_LowerBound, OperationReturnLowerBoundMatcher.on(engine)) [
			lowerBound
		]
		operationReturn.on(BASE_PACKAGE.multiplicity_UpperBound, OperationReturnUpperBoundMatcher.on(engine)) [
			upperBound
		]
	}

	def convert(EntityType type) {
		switch (type) {
			case STATELESS: ExEntityType.STATELESS
			case SINGLETON: ExEntityType.SINGLETON
		}
	}

	override createTemplate(ExExternalEntity externalEntity) {
		new ExternalEntityTemplateSmap(externalEntity)
	}

	override shouldMap(Class cls) {
		// generate code only for external entities using this builder
		super.shouldMap(cls) && Stereotypes.isExternalEntity(cls)
	}

	override getRootName(Class cls) {
		cls.name
	}
}
