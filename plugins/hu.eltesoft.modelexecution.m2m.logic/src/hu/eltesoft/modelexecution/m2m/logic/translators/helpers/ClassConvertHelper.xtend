package hu.eltesoft.modelexecution.m2m.logic.translators.helpers

import hu.eltesoft.modelexecution.m2m.logic.translators.base.AbstractFeatureNode
import hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory
import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAssociationSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClAttributeSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClOperationSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClReceptionSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage
import hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.AttributeTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatch
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterUpperBoundMatcher
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.uml2.uml.ParameterDirectionKind
import org.eclipse.uml2.uml.Type
import org.eclipse.uml2.uml.ValueSpecification

/**
 * A helper class for translating UML classes. From UML classes both implementation classes and interfaces 
 * are generated and this helper class collects common features that should not be duplicated.
 */
class ClassConvertHelper {

	static final ClassdefFactory FACTORY = ClassdefFactory.eINSTANCE;
	static final ClassdefPackage PACKAGE = ClassdefPackage.eINSTANCE;

	static final BaseFactory BASE_FACTORY = BaseFactory.eINSTANCE;
	static final BasePackage BASE_PACKAGE = BasePackage.eINSTANCE;

	static val typeConverter = new TypeConverter

	def static convert(ParameterDirectionKind dir) { typeConverter.convert(dir) }

	def static convert(Type typ) { typeConverter.convert(typ) }

	def static toInt(ValueSpecification spec) { typeConverter.toInt(spec) }

	def static fillAttribute(AbstractFeatureNode<? extends ClAttributeSpec, ?> node, IncQueryEngine engine) {
		val attributeType = node.onEObject(BASE_PACKAGE.typed_Type, AttributeTypeMatcher.on(engine)) [
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
	}

	def static fillOperation(AbstractFeatureNode<? extends ClOperationSpec, ?> operationNode, IncQueryEngine engine) {
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
	}

	def static fillAssociation(AbstractFeatureNode<? extends ClAssociationSpec, ?> node, IncQueryEngine engine) {
		val assocType = node.onEObject(BASE_PACKAGE.typed_Type, ClassAssociationTypeMatcher.on(engine)) [
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
	}

	def static fillReception(AbstractFeatureNode<? extends ClReceptionSpec, ReceptionMatch> node,
		IncQueryEngine engine) {
		val receptionParameter = node.onEObject(PACKAGE.clReceptionSpec_Parameters,
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

}