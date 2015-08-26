package hu.eltesoft.modelexecution.ide.debug.ui;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;
import org.eclipse.papyrus.moka.ui.presentation.MokaDebugModelPresentation;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Allows to switch between state machine instances and each time the
 * corresponding stack frame is highlighted in the state machine.
 */
public class XUmlRtDebugModelPresentation extends MokaDebugModelPresentation {

	private static final String DEBUG_VIEW_ID = "org.eclipse.debug.ui.DebugView";

	private static final AnimationUtils UTIL = AnimationUtils.getInstance();

	@Override
	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		if (frame == null || !(frame instanceof MokaStackFrame) || ((MokaStackFrame) frame).getModelElement() == null) {
			return false;
		}
		UTIL.removeSuspendedMarker(frame.getThread());
		Object[] selected = getSelectedDebugElements();

		for (Object selectedFrame : selected) {
			if (frame.equals(selectedFrame)) {
				return super.addAnnotations(editorPart, frame);
			}
		}
		return false;
	}

	/**
	 * @return the debug elements selected in the debug view or an empty array,
	 *         if the debug view is not open.
	 */
	public static Object[] getSelectedDebugElements() {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null) {
			// we must perform this operation on a UI thread
			Object[][] ret = new Object[1][];
			Display.getDefault().syncExec(() -> ret[0] = getSelectedDebugElementsUIThread());
			return ret[0];
		} else {
			return getSelectedDebugElementsUIThread();
		}
	}

	private static Object[] getSelectedDebugElementsUIThread() {
		AbstractDebugView debugView = (AbstractDebugView) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().findView(DEBUG_VIEW_ID);
		if (debugView == null) {
			// debug view is not open
			return new Object[0];
		}
		StructuredSelection selection = (StructuredSelection) debugView.getViewer().getSelection();
		return selection.toArray();
	}

}
