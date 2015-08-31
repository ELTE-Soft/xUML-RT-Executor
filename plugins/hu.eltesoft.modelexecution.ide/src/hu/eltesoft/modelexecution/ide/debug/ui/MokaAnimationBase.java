package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;

public class MokaAnimationBase {

	protected static final AnimationUtils UTILS = AnimationUtils.getInstance();

	public MokaAnimationBase() {
		super();
	}

	protected void openContainingDiagram(EObject element) {
		List<Diagram> diagrams = UTILS.getDiagrams(element);
		for (Diagram diagram : diagrams) {
			UTILS.openDiagram(diagram, false);
		}
	}

}