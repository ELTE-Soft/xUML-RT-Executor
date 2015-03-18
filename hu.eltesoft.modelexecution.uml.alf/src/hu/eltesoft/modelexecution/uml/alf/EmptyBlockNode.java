package hu.eltesoft.modelexecution.uml.alf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.AlfFactory;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;

public class EmptyBlockNode extends CompositeNodeWithSemanticElement {

	public EmptyBlockNode() {
		EObject block = AlfFactory.eINSTANCE.createBlock();
		basicSetSemanticElement(block);
	}
}
