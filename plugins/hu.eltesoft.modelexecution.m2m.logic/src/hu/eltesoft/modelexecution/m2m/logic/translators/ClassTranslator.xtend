package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplate
import hu.eltesoft.modelexecution.uml.incquery.AttributeLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher
import hu.eltesoft.modelexecution.uml.incquery.AttributeTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClsMatch
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Class
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBoundMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationUpperBoundMatcher

class ClassTranslator extends RootElementTranslator<Class, ClClass, ClsMatch> {

	static val ClassdefFactory FACTORY = ClassdefFactory.eINSTANCE;
	static val ClassdefPackage PACKAGE = ClassdefPackage.eINSTANCE;

	new(IncQueryEngine engine) throws IncQueryException {
		super(engine);
	}

	override buildMapper(IncQueryEngine engine) throws IncQueryException {
		val rootNode = fromRoot(ClsMatcher.on(engine)) [
			val root = FACTORY.createClClass
			root.setReference(new NamedReference(cls));
			return root;
		]
		
		// state machine
		
		rootNode.on(PACKAGE.clClass_Region, RegionOfClassMatcher.on(engine))[new NamedReference(region)]
		
		// attributes
		
		val attributeNode = rootNode.onEObject(PACKAGE.clClass_Attributes, AttributeMatcher.on(engine)) [
			val elem = FACTORY.createClAttribute
			elem.reference = new NamedReference(attribute)
			elem.isStatic = isStatic
			return elem;
		]
		val attributeType = attributeNode.onEObject(PACKAGE.clAttribute_Type, AttributeTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createFullType
			elem.baseType = type.convert
			return elem
		]
		attributeType.on(BASE_PACKAGE.fullType_LowerBound, AttributeLowerBoundMatcher.on(engine)) [
			lowerBound.toInt
		]
		attributeType.on(BASE_PACKAGE.fullType_UpperBound, AttributeUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]
		
		// operations
		
		val operationNode = rootNode.onEObject(PACKAGE.clClass_Operations, OperationMatcher.on(engine)) [
			val elem = FACTORY.createClOperation
			elem.reference = new NamedReference(operation)
			elem.isStatic = isStatic
			return elem
		]
		
		// operation parameters
		
		val parameterNode = operationNode.onEObject(PACKAGE.clOperation_Parameters, OperationParameterMatcher.on(engine)) [
			val elem = FACTORY.createClParameter
			elem.reference = new NamedReference(parameter)
			elem.direction = direction.convert
			return elem
		]
		val parameterTypeNode = parameterNode.onEObject(PACKAGE.clParameter_Type, OperationParameterTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createFullType
			elem.baseType = type.convert
			return elem
		]
		parameterTypeNode.on(BASE_PACKAGE.fullType_LowerBound, OperationParameterLowerBoundMatcher.on(engine)) [
			lowerBound.toInt
		]
		parameterTypeNode.on(BASE_PACKAGE.fullType_UpperBound, OperationParameterUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]
		
		// operation return type
		
		val operationReturn = operationNode.onEObject(PACKAGE.clOperation_ReturnType, OperationReturnTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createFullType
			elem.baseType = type.convert
			return elem
		]
		operationReturn.on(BASE_PACKAGE.fullType_LowerBound, OperationReturnLowerBoundMatcher.on(engine)) [
			lowerBound.toInt
		]
		operationReturn.on(BASE_PACKAGE.fullType_UpperBound, OperationReturnUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]
		
		// operation method
		
		operationNode.on(PACKAGE.clOperation_Method, MethodMatcher.on(engine)) [
			new NamedReference(method)
		]
		
		// associations
		
		val assocNode = rootNode.onEObject(PACKAGE.clClass_Associations, ClassAssociationMatcher.on(engine)) [
			val elem = FACTORY.createClAssociation
			elem.reference = new NamedReference(end)
			return elem
		]
		val assocType = assocNode.onEObject(PACKAGE.clAssociation_Type, ClassAssociationTypeMatcher.on(engine)) [
			val elem = BASE_FACTORY.createFullType
			elem.baseType = type.convert
			return elem
		]
		assocType.on(BASE_PACKAGE.fullType_LowerBound, ClassAssociationLowerBoundMatcher.on(engine)) [
			lowerBound.toInt
		]
		assocType.on(BASE_PACKAGE.fullType_UpperBound, ClassAssociationUpperBoundMatcher.on(engine)) [
			upperBound.toInt
		]
		
		//  receptions
		
		rootNode.onEObject(PACKAGE.clClass_Receptions, ReceptionMatcher.on(engine)) [
			val elem = FACTORY.createClReception
			elem.reference = new NamedReference(reception)
			elem.signal = new NamedReference(signal)
			return elem
		]
		return rootNode;
	}

	override createTemplate(ClClass cls) { 
		new ClassTemplate(cls)
	}
}
