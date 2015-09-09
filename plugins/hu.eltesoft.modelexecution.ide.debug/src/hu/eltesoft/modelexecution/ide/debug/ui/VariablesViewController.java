package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.function.Consumer;

import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Controls the view where the variables (or attributes) are presented.
 */
public class VariablesViewController {

	private static final Display DISPLAY = Display.getDefault();

	public void refresh() {
		accessViewer(v -> v.refresh());
	}

	public void accessViewer(Consumer<Viewer> action) {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null) {
			// we must perform this operation on a UI thread
			DISPLAY.syncExec(() -> accessViewerUIThread(action));
		} else {
			accessViewerUIThread(action);
		}
	}

	private void accessViewerUIThread(Consumer<Viewer> action) {
		AbstractDebugView debugView = (AbstractDebugView) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().findView(IDebugUIConstants.ID_VARIABLE_VIEW);
		if (debugView == null) {
			return; // debug view is not open
		}
		action.accept(debugView.getViewer());
	}

}
