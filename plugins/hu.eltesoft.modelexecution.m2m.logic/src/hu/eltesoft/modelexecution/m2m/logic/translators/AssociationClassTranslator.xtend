package hu.eltesoft.modelexecution.m2m.logic.translators

import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode
import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationClass
import hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationFactory
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import hu.eltesoft.modelexecution.m2t.java.templates.AssociationClassTemplateSmap
import hu.eltesoft.modelexecution.uml.incquery.AssociationClassMatch
import hu.eltesoft.modelexecution.uml.incquery.AssociationClassMatcher
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.uml2.uml.AssociationClass

class AssociationClassTranslator extends RootElementTranslator<AssociationClass, AsAssociationClass, AssociationClassMatch> {

	static val AssociationFactory FACTORY = AssociationFactory.eINSTANCE;

	new(AdvancedIncQueryEngine engine) throws IncQueryException {
		super(engine)
	}

	override createMapper(AdvancedIncQueryEngine engine) {
		val rootNode = fromRoot(AssociationClassMatcher.on(engine)) [
			val root = FACTORY.createAsAssociationClass
			root.reference = new NamedReference(assocClass)
			return root
		]
		return rootNode;
	}

	override initMapper(RootNode<?, ?, ?> rootNode, AdvancedIncQueryEngine engine) {
		val assocTrans = new AssociationTranslator(engine)
		assocTrans.initMapper(rootNode, engine)
		val classTrans = new ClassTranslator(engine)
		classTrans.initMapper(rootNode, engine)
	}

	override createTemplate(AsAssociationClass association) {
		return new AssociationClassTemplateSmap(association)
	}

	override getRootName(AssociationClass source) {
		val superName = super.getRootName(source)
		if (superName != null) {
			superName + "_impl"
		} else {
			null
		}
	}

}