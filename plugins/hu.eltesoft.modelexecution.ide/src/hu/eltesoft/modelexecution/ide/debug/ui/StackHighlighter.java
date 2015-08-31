package hu.eltesoft.modelexecution.ide.debug.ui;

import org.eclipse.emf.ecore.EObject;

public class StackHighlighter extends MokaAnimationBase {

	public void setHighlighted(EObject element) {
		removeHighlight();
		UTILS.addSuspendedMarker(element);
		openContainingDiagram(element);
	}
	
	public void removeHighlight() {
		// actually removes all suspended markers
		UTILS.removeSuspendedMarker(null);
	}
	
}
