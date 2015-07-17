package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage
import hu.eltesoft.modelexecution.m2t.java.templates.ClassSpecTemplateSmap
import hu.eltesoft.modelexecution.profile.xumlrt.Stereotypes
import hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher
import hu.eltesoft.modelexecution.uml.incquery.AttributeTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassOrAssocClassMatch
import hu.eltesoft.modelexecution.uml.incquery.ClassOrAssocClassMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Class

// FIXME: define these subtransformers only once
class ClassSpecTranslator extends RootElementTranslator<Class, ClClassSpec, ClassOrAssocClassMatch> {

	static val ClassdefFactory FACTORY = ClassdefFactory.eINSTANCE;
	static val ClassdefPackage PACKAGE = ClassdefPackage.eINSTANCE;

	new(IncQueryEngine engine) throws IncQueryException {
		super(engine);
	}

	override protected createMapper(IncQueryEngine engine) {
		val rootNode = fromRoot(ClassOrAssocClassMatcher.on(engine)) [
			val root = FACTORY.createClClassSpec
			root.setReference(new NamedReference(cls));
			return root;
		]
		return rootNode
	}

	override protected initMapper(RootNode<?, ?, ?> rootNode, IncQueryEngine engine) {
		rootNode.on(PACKAGE.clClassSpec_HasStateMachine, RegionOfClassMatcher.on(engine))[true]

		// attributes
		val attributeNode = rootNode.onEObject(PACKAGE.clClassSpec_Attributes, AttributeMatcher.on(engine)) [
			val elem = FACTORY.createClAttribute
			elem.reference = new NamedReference(attribute)
			elem.isStatic = isStatic
			return elem;
		]
		val attributeType = attributeNode.onEObject(BASE_PACKAGE.typed_Type, AttributeTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createType
			elem.baseType = type.convert
			elem.isOrdered = ordered
			elem.isUnique = unique
			return elem
		]
		attributeType.on(BASE_PACKAGE.multiplicity_LowerBound, AttributeLowerBoundMatcher.on(engine)) [
			lowerBound.toInt
		]
		attributeType.on(BASE_PACKAGE.multiplicity_UpperBound, AttributeUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]

		// operations
		val operationNode = rootNode.onEObject(PACKAGE.clClassSpec_Operations, OperationMatcher.on(engine)) [
			val elem = FACTORY.createClOperationSpec
			elem.reference = new NamedReference(operation)
			return elem
		]

		// operation parameters
		val parameterNode = operationNode.onEObject(PACKAGE.clOperationSpec_Parameters,
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
			lowerBound.toInt
		]
		parameterTypeNode.on(BASE_PACKAGE.multiplicity_UpperBound, OperationParameterUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]

		// operation return type
		val operationReturn = operationNode.onEObject(PACKAGE.clOperationSpec_ReturnType,
			OperationReturnTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createType
			elem.baseType = type.convert
			elem.isOrdered = ordered
			elem.isUnique = unique
			return elem
		]
		operationReturn.on(BASE_PACKAGE.multiplicity_LowerBound, OperationReturnLowerBoundMatcher.on(engine)) [
			lowerBound.toInt
		]
		operationReturn.on(BASE_PACKAGE.multiplicity_UpperBound, OperationReturnUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]

		// associations
		val assocNode = rootNode.onEObject(PACKAGE.clClassSpec_Associations, ClassAssociationMatcher.on(engine)) [
			val elem = FACTORY.createClAssociation
			elem.reference = new NamedReference(end)
			return elem
		]
		val assocType = assocNode.onEObject(BASE_PACKAGE.typed_Type, ClassAssociationTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createType
			elem.baseType = type.convert
			elem.isOrdered = ordered
			elem.isUnique = unique
			return elem
		]
		assocType.on(BASE_PACKAGE.multiplicity_LowerBound, ClassAssociationLowerBoundMatcher.on(engine)) [
			lowerBound.toInt
		]
		assocType.on(BASE_PACKAGE.multiplicity_UpperBound, ClassAssociationUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]

		// receptions
		val receptionNode = rootNode.onEObject(PACKAGE.clClassSpec_Receptions, ReceptionMatcher.on(engine)) [
			val elem = FACTORY.createClReception
			elem.reference = new NamedReference(reception)
			elem.signal = new NamedReference(signal)
			return elem
		]
		val receptionParameter = receptionNode.onEObject(PACKAGE.clReceptionSpec_Parameters,
			ReceptionParameterMatcher.on(engine)) [
			val elem = FACTORY.createClReceptionParameter
			elem.reference = new NamedReference(parameter)
			elem.isOrdered = ordered
			elem.isUnique = unique
			elem.type = type.convert as PrimitiveType
			return elem
		]
		receptionParameter.on(BASE_PACKAGE.multiplicity_LowerBound, ReceptionParameterLowerBoundMatcher.on(engine)) [
			lowerBound.toInt
		]
		receptionParameter.on(BASE_PACKAGE.multiplicity_UpperBound, ReceptionParameterUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]
	}

	override createTemplate(ClClassSpec cls) {
		new ClassSpecTemplateSmap(cls)
	}

	override shouldMap(Class cls) {

		// do not generate code for external entities using this builder
		!Stereotypes.isExternalEntity(cls)
	}
}
