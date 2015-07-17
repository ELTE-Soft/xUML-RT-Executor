package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClassSpec
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefFactory
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClassdefPackage
import hu.eltesoft.modelexecution.m2t.java.templates.ClassSpecTemplateSmap
import hu.eltesoft.modelexecution.profile.xumlrt.Stereotypes
import hu.eltesoft.modelexecution.uml.incquery.AttributeMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationMatcher
import hu.eltesoft.modelexecution.uml.incquery.ClassOrAssocClassMatch
import hu.eltesoft.modelexecution.uml.incquery.ClassOrAssocClassMatcher
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher
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
			val elem = FACTORY.createClAttributeSpec
			elem.reference = new NamedReference(attribute)
			return elem;
		]
		
		ClassConvertHelper.fillAttribute(attributeNode, engine)

		// operations
		val operationNode = rootNode.onEObject(PACKAGE.clClassSpec_Operations, OperationMatcher.on(engine)) [
			val elem = FACTORY.createClOperationSpec
			elem.reference = new NamedReference(operation)
			return elem
		]

		ClassConvertHelper.fillOperation(operationNode, engine)

		// associations
		val assocNode = rootNode.onEObject(PACKAGE.clClassSpec_Associations, ClassAssociationMatcher.on(engine)) [
			val elem = FACTORY.createClAssociation
			elem.reference = new NamedReference(end)
			return elem
		]

		ClassConvertHelper.fillAssociation(assocNode, engine)

		// receptions
		val receptionNode = rootNode.onEObject(PACKAGE.clClassSpec_Receptions, ReceptionMatcher.on(engine)) [
			val elem = FACTORY.createClReceptionSpec
			elem.reference = new NamedReference(reception)
			return elem
		]

		ClassConvertHelper.fillReception(receptionNode, engine)
	}

	override createTemplate(ClClassSpec cls) {
		new ClassSpecTemplateSmap(cls)
	}

	override shouldMap(Class cls) {

		// do not generate code for external entities using this builder
		!Stereotypes.isExternalEntity(cls)
	}
}
