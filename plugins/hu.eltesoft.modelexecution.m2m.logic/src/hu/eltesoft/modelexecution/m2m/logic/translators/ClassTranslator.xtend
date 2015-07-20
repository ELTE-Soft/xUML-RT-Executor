package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage
import hu.eltesoft.modelexecution.m2t.java.templates.ClassTemplateSmap
import hu.eltesoft.modelexecution.profile.xumlrt.Stereotypes
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassCtorRecordMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClsMatch
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher
import hu.eltesoft.modelexecution.uml.incquery.InheritedAttributeMatcher
import hu.eltesoft.modelexecution.uml.incquery.InheritedAttributeParentMatcher
import hu.eltesoft.modelexecution.uml.incquery.InheritedRegionMatcher
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher
import hu.eltesoft.modelexecution.uml.incquery.ParentMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher
import java.util.Comparator
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Class
import hu.eltesoft.modelexecution.uml.incquery.ClassCtorRecordMatch
import hu.eltesoft.modelexecution.uml.incquery.ClassCtorRecordArgMatcher

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

		// construction
		val ctorRecordNode = rootNode.onSorted(
			PACKAGE.clClass_CtorRecords,
			ClassCtorRecordMatcher.on(engine),
			Comparator.comparingInt([ClassCtorRecordMatch m|m.order])
		) [
			val elem = FACTORY.createClCtorRecord
			elem.reference = new NamedReference(ancestor)
			return elem
		]
		ctorRecordNode.onEObject(PACKAGE.clCtorRecord_UsedArgs, ClassCtorRecordArgMatcher.on(engine)) [
			val elem = BASE_FACTORY.createNameWrapper
			elem.reference = new NamedReference(parent)
			return elem
		]

		// state machine
		rootNode.on(PACKAGE.clClass_Region, RegionOfClassMatcher.on(engine))[new NamedReference(region)]
		rootNode.on(PACKAGE.clClass_InheritedRegion, InheritedRegionMatcher.on(engine))[new NamedReference(region)]

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

		inheritedAttributes.on(PACKAGE.inherited_Parent, InheritedAttributeParentMatcher.on(engine)) [
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
		super.getRootName(source) + "_impl"
	}

	override shouldMap(Class cls) {

		// do not generate code for external entities using this builder
		!Stereotypes.isExternalEntity(cls)
	}
}
