package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode
import hu.eltesoft.modelexecution.m2m.logic.translators.helpers.ClassConvertHelper
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplateSmap
import hu.eltesoft.modelexecution.profile.xumlrt.Stereotypes
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClsMatch
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher
import hu.eltesoft.modelexecution.uml.incquery.InheritedAssociationMatcher
import hu.eltesoft.modelexecution.uml.incquery.InheritedAttributeMatcher
import hu.eltesoft.modelexecution.uml.incquery.InheritedAttributeParentMatcher
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher
import hu.eltesoft.modelexecution.uml.incquery.ParentMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Class
import hu.eltesoft.modelexecution.uml.incquery.InheritedAssociationParentMatcher

/**
 * Creates the metamodel for implementation classes of UML classes.
 */
class ClassTranslator extends RootElementTranslator<Class, ClClass, ClsMatch> {

	static val ClassdefFactory FACTORY = ClassdefFactory.eINSTANCE;
	static val ClassdefPackage PACKAGE = ClassdefPackage.eINSTANCE;

	new(IncQueryEngine engine) throws IncQueryException {
		super(engine);
	}

	override protected createMapper(IncQueryEngine engine) {
		val rootNode = fromRoot(ClsMatcher.on(engine)) [
			val root = FACTORY.createClClass
			root.setReference(new NamedReference(cls));
			return root;
		]
		return rootNode
	}

	override protected initMapper(RootNode<?, ?, ?> rootNode, IncQueryEngine engine) {

		// parent classes
		rootNode.on(PACKAGE.clClass_Parents, ParentMatcher.on(engine))[new NamedReference(parent)]

		// state machine
		rootNode.on(PACKAGE.clClass_Region, RegionOfClassMatcher.on(engine))[new NamedReference(region)]

		// attributes
		val attributeNode = rootNode.onEObject(PACKAGE.clClass_Attributes, AttributeMatcher.on(engine)) [
			val elem = FACTORY.createClAttribute
			elem.reference = new NamedReference(attribute)
			elem.isStatic = isStatic
			return elem;
		]

		ClassConvertHelper.fillAttribute(attributeNode, engine)

		val inheritedAttributes = rootNode.onEObject(PACKAGE.clClass_InheritedAttributes,
			InheritedAttributeMatcher.on(engine)) [
			val elem = FACTORY.createClInheritedAttribute
			elem.reference = new NamedReference(attribute)
			return elem;
		]

		inheritedAttributes.on(BASE_PACKAGE.inherited_Parent, InheritedAttributeParentMatcher.on(engine)) [
			new NamedReference(parent)
		]

		ClassConvertHelper.fillAttribute(inheritedAttributes, engine)

		// operations
		val operationNode = rootNode.onEObject(PACKAGE.clClass_Operations, OperationMatcher.on(engine)) [
			val elem = FACTORY.createClOperation
			elem.reference = new NamedReference(operation)
			elem.isStatic = isStatic
			return elem
		]

		ClassConvertHelper.fillOperation(operationNode, engine)

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

		ClassConvertHelper.fillAssociation(assocNode, engine)
		
		// inherited associations
		val inheritedAssoc = rootNode.onEObject(PACKAGE.clClass_InheritedAssociations, InheritedAssociationMatcher.on(engine)) [
			val elem = FACTORY.createClInheritedAssociation
			elem.reference = new NamedReference(end)
			return elem
		]
		
		inheritedAssoc.on(BASE_PACKAGE.inherited_Parent, InheritedAssociationParentMatcher.on(engine)) [
			new NamedReference(parent)
		]
		
		ClassConvertHelper.fillAssociation(inheritedAssoc, engine)

		// receptions
		val receptionNode = rootNode.onEObject(PACKAGE.clClass_Receptions, ReceptionMatcher.on(engine)) [
			val elem = FACTORY.createClReception
			elem.reference = new NamedReference(reception)
			elem.signal = new NamedReference(signal)
			return elem
		]

		ClassConvertHelper.fillReception(receptionNode, engine)
	}

	override createTemplate(ClClass cls) {
		new ClassTemplateSmap(cls)
	}

	override getRootName(Class source) {
		val superName = super.getRootName(source)
		if (superName != null) {
			superName + "_impl"
		} else
			null
	}

	override shouldMap(Class cls) {

		// do not generate code for external entities using this builder
		!Stereotypes.isExternalEntity(cls)
	}
}
