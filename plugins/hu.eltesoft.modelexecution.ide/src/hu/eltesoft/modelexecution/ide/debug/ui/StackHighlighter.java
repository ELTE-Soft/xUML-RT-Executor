package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;

public class StackHighlighter {

	private static final AnimationUtils UTILS = AnimationUtils.getInstance();
	
	public void setHighlighted(EObject element) {
		removeHighlight();
		UTILS.addSuspendedMarker(element);
		openContainingDiagram(element);
	}
	
	public void removeHighlight() {
		// actually removes all suspended markers
		UTILS.removeSuspendedMarker(null);
	}
	
	private void openContainingDiagram(EObject element) {
		List<Diagram> diagrams = UTILS.getDiagrams(element);
		for (Diagram diagram : diagrams) {
			UTILS.openDiagram(diagram, false);
		}
	}
	
}
