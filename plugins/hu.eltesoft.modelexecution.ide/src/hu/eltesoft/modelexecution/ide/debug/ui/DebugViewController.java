package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.function.Consumer;

import org.eclipse.debug.internal.ui.viewers.model.provisional.TreeModelViewer;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.model.DebugElement;

@SuppressWarnings("restriction")
public class DebugViewController {

	private static final Display DISPLAY = Display.getDefault();
	private static final String DEBUG_VIEW_ID = "org.eclipse.debug.ui.DebugView";

	/**
	 * @return the debug elements selected in the debug view or an empty array,
	 *         if the debug view is not open.
	 */
	public Object[] getSelectedDebugElements() {
		Object[][] ret = new Object[][] { new Object[] {} };
		accessViewer(v -> ret[0] = ((StructuredSelection) v.getSelection()).toArray());
		return ret[0];
	}

	
	public void expandAndSelect(DebugElement element) {
		expandElement(element);
		accessViewer(v -> { 
			if (v instanceof TreeModelViewer) {
				TreeModelViewer tmv = (TreeModelViewer) v;
				tmv.setSelection(new TreeSelection(tmv.getElementPaths(element)));
			}
		});
	}

	private void expandElement(DebugElement element) {
		DebugElement parent = element.getParent();
		if (parent != null) {
			expandElement(parent);
		}
		accessViewer(v -> {
			v.expandToLevel(element, 1);
		});
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			IdePlugin.logError("interrupted", e);
		}
		
	}
	
	public void addDebugElement(Object parent, Object child) {
		accessViewer(v -> v.add(parent, child));
	}

	public void removeDebugElement(Object removed) {
		accessViewer(v -> v.remove(removed));
	}

	public void updateElement(Object toUpdate) {
		accessViewer(v -> v.update(toUpdate, null));
	}

	public void refreshDebugElements() {
		accessViewer(v -> v.refresh());
	}

	public void reselect() {
		accessViewer(v -> {
			ISelection selection = v.getSelection();
			v.setSelection(selection);
		});
	}

	public void accessViewer(Consumer<TreeViewer> action) {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null) {
			// we must perform this operation on a UI thread
			DISPLAY.syncExec(() -> accessViewerUIThread(action));
		} else {
			accessViewerUIThread(action);
		}
	}

	private void accessViewerUIThread(Consumer<TreeViewer> action) {
		AbstractDebugView debugView = (AbstractDebugView) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().findView(DEBUG_VIEW_ID);
		if (debugView == null) {
			return; // debug view is not open
		}
		action.accept((TreeViewer) debugView.getViewer());
	}
}
