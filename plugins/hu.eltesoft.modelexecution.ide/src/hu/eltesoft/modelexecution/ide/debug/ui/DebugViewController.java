package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.eclipse.debug.internal.ui.viewers.model.provisional.TreeModelViewer;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
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

	public void expandAndSelect(DebugElement element, Runnable postAction) {
		accessViewer(v -> {
			v.refresh();
		});
		performWhenVisible(element, (v, path) -> {
			v.setSelection(new TreeSelection(new TreePath[] { path }));
			v.setAutoExpandLevel(0);
			postAction.run();
		});

	}

	/**
	 * Starts a new thread that waits until the element is visible in the debug
	 * view and then executes the given action.
	 */
	public void performWhenVisible(Object element, BiConsumer<TreeModelViewer, TreePath> action) {
		new Thread(() -> {
			boolean selectionCompleted[] = new boolean[] { false };
			while (!selectionCompleted[0]) {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					IdePlugin.logError("interrupted", e);
				}
				accessViewer(v -> {
					TreePath[] toSelect = v.getElementPaths(element);
					if (toSelect.length > 0) {
						action.accept(v, toSelect[0]);
						selectionCompleted[0] = true;
					}

				});
			}
		}).start();
	}

	public void init() {
		accessViewer(v -> {
			v.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
		});
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

	public void accessViewer(Consumer<TreeModelViewer> action) {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null) {
			// we must perform this operation on a UI thread
			DISPLAY.syncExec(() -> accessViewerUIThread(action));
		} else {
			accessViewerUIThread(action);
		}
	}

	private void accessViewerUIThread(Consumer<TreeModelViewer> action) {
		AbstractDebugView debugView = (AbstractDebugView) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().findView(DEBUG_VIEW_ID);
		if (debugView == null) {
			return; // debug view is not open
		}
		action.accept((TreeModelViewer) debugView.getViewer());
	}
}
