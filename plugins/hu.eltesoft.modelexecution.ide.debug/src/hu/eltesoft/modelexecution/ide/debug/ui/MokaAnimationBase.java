package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.widgets.Display;

public class MokaAnimationBase {

	protected static final CustomAnimationUtils UTILS = CustomAnimationUtils.getInstance();

	public MokaAnimationBase() {
		super();
	}

	protected void openContainingDiagram(EObject element) {
		Display.getDefault().asyncExec(() -> {
			List<Diagram> diagrams = UTILS.getDiagrams(element);
			if (!diagrams.isEmpty()) {
				UTILS.openDiagram(diagrams.get(0), false);
			}
		});
	}

}