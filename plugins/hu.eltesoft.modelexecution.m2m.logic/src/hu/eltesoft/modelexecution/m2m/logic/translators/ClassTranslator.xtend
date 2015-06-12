package hu.eltesoft.modelexecution.m2m.logic.translators

import org.eclipse.uml2.uml.Class
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage
import hu.eltesoft.modelexecution.uml.incquery.ClsMatch
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplate

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
		rootNode.on(PACKAGE.clClass_Region, RegionOfClassMatcher.on(engine))[new NamedReference(region)]
		rootNode.onEObject(PACKAGE.clClass_Attributes, AttributeMatcher.on(engine)) [
			val elem = FACTORY.createClAttribute
			elem.reference = new NamedReference(attribute)
			elem.isStatic = isStatic
			elem.type = type.convert
			elem.multiplicity = convert(attribute.lowerValue, attribute.upperValue)
			return elem;
		]
		val operationNode = rootNode.onEObject(PACKAGE.clClass_Operations, OperationMatcher.on(engine)) [
			val elem = FACTORY.createClOperation
			elem.reference = new NamedReference(operation)
			elem.isStatic = isStatic
			return elem
		]
		operationNode.onEObject(PACKAGE.clOperation_Parameters, OperationParameterMatcher.on(engine)) [
			val elem = FACTORY.createClParameter
			elem.reference = new NamedReference(parameter)
			elem.type = type.convert
			elem.direction = direction.convert
			return elem
		]
		operationNode.onEObject(PACKAGE.clOperation_ReturnType, OperationReturnTypeMatcher.on(engine)) [
			type.convert
		]
		operationNode.on(PACKAGE.clOperation_Method, MethodMatcher.on(engine)) [
			new NamedReference(method)
		]
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
