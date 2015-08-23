package hu.eltesoft.modelexecution.ide.debug;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;
import org.eclipse.papyrus.moka.ui.presentation.MokaDebugModelPresentation;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * Allows to switch between state machine instances and each time the
 * corresponding stack frame is highlighted in the state machine.
 */
public class XUmlRtDebugModelPresentation extends MokaDebugModelPresentation {

	private static final String DEBUG_VIEW_ID = "org.eclipse.debug.ui.DebugView";

	@Override
	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		AnimationUtils.getInstance().removeSuspendedMarker(frame.getThread());
		AbstractDebugView debugView = (AbstractDebugView) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().findView(DEBUG_VIEW_ID);
		if (debugView == null) {
			// debug view is not open
			return true;
		}
		TreeSelection selection = (TreeSelection) debugView.getViewer().getSelection();
		if (frame.equals(selection.getFirstElement())) {
			return super.addAnnotations(editorPart, frame);
		} else {
			// not the selected stack frame
			return true;
		}
	}

}
