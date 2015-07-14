package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociation
import hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationFactory
import hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2m.metamodel.base.ReferencedType
import hu.eltesoft.modelexecution.m2t.java.templates.AssociationTemplateSmap
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndMatcher
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndTypeMatcher
import hu.eltesoft.modelexecution.uml.incquery.AssociationMatch
import hu.eltesoft.modelexecution.uml.incquery.AssociationMatcher
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.Association

class AssociationTranslator extends RootElementTranslator<Association, AsAssociation, AssociationMatch> {

	static val AssociationFactory FACTORY = AssociationFactory.eINSTANCE;
	static val AssociationPackage PACKAGE = AssociationPackage.eINSTANCE;

	new(IncQueryEngine engine) throws IncQueryException {
		super(engine)
	}

	override protected buildMapper(IncQueryEngine engine) throws IncQueryException {
		val rootNode = fromRoot(AssociationMatcher.on(engine)) [
			val root = FACTORY.createAsAssociation
			root.reference = new NamedReference(association)
			return root
		]
		val endNode = rootNode.onEObject(PACKAGE.asAssociation_Ends, AssociationEndMatcher.on(engine)) [
			val elem = FACTORY.createAsAssociationEnd
			elem.reference = new NamedReference(end)
			return elem
		]
		endNode.on(PACKAGE.asAssociationEnd_Type, AssociationEndTypeMatcher.on(engine)) [
			cls.convert as ReferencedType
		]

		return rootNode
	}

	override createTemplate(AsAssociation association) {
		return new AssociationTemplateSmap(association)
	}

}