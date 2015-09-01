package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.function.Consumer;

import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class DebugViewController {

	private static final String DEBUG_VIEW_ID = "org.eclipse.debug.ui.DebugView";
	
	/**
	 * @return the debug elements selected in the debug view or an empty array,
	 *         if the debug view is not open.
	 */
	public Object[] getSelectedDebugElements() {
		Object[][] ret = new Object[1][];
		accessViewer(v -> ret[0] = ((StructuredSelection) v.getSelection()).toArray());
		return ret[0];
	}
	
	public void refreshDebugElements() {
		accessViewer(v -> v.refresh(false));
	}
	
	public void accessViewer(Consumer<StructuredViewer> action) {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null) {
			// we must perform this operation on a UI thread
			Display.getDefault().syncExec(() -> accessViewerUIThread(action));
		} else {
			accessViewerUIThread(action);
		}
	}
	
	private void accessViewerUIThread(Consumer<StructuredViewer> action) {
		AbstractDebugView debugView = (AbstractDebugView) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().findView(DEBUG_VIEW_ID);
		if (debugView == null) {
			return; // debug view is not open
		}
		action.accept((StructuredViewer) debugView.getViewer());
	}
	
}
