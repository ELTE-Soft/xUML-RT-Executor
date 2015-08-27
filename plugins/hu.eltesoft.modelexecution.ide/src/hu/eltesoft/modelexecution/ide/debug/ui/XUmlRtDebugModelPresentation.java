package hu.eltesoft.modelexecution.ide.debug.ui;

import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Allows to switch between state machine instances and each time the
 * corresponding stack frame is highlighted in the state machine.
 */
public class XUmlRtDebugModelPresentation {

	private static final String DEBUG_VIEW_ID = "org.eclipse.debug.ui.DebugView";

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
