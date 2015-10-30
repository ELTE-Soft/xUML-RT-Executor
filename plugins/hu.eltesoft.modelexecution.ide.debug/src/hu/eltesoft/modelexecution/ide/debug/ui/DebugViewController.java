package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.internal.ui.model.elements.ElementContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.TreeModelContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IModelDelta;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ModelDelta;
import org.eclipse.debug.internal.ui.viewers.model.provisional.PresentationContext;
import org.eclipse.debug.internal.ui.viewers.model.provisional.TreeModelViewer;
import org.eclipse.debug.internal.ui.viewers.provisional.AbstractModelProxy;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.debug.model.DebugElement;
import hu.eltesoft.modelexecution.ide.debug.model.XUMLRTDebugTarget;
import hu.eltesoft.modelexecution.ide.debug.model.utils.CombiningContentProvider;

@SuppressWarnings("restriction")
public class DebugViewController extends AbstractModelProxy {

	private static final Display DISPLAY = Display.getDefault();
	private static final int MAX_WAIT_TIME = 5000;
	private static final long WAIT_INTERVAL = 10;

	private static final PresentationContext DEBUG_VIEW_CONTEXT = new PresentationContext(
			IDebugUIConstants.ID_DEBUG_VIEW);

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
		} , postAction);
	}

	public void expandAndSelect(DebugElement element) {
		accessViewer(v -> {
			v.refresh();
		});
		performWhenVisible(element, (v, path) -> {
			v.setSelection(new TreeSelection(new TreePath[] { path }));
			v.setAutoExpandLevel(0);
		} , () -> {
		});
	}

	/**
	 * Starts a new thread that waits until the element is visible in the debug
	 * view and then executes the given action.
	 */
	public void performWhenVisible(Object element, BiConsumer<TreeModelViewer, TreePath> action, Runnable failure) {
		new Thread(() -> {
			boolean selectionCompleted[] = new boolean[] { false };
			long start_time = System.currentTimeMillis();
			while (!selectionCompleted[0] && System.currentTimeMillis() - start_time < MAX_WAIT_TIME) {
				try {
					Thread.sleep(WAIT_INTERVAL);
				} catch (Exception e) {
					PluginLogger.logError("interrupted", e);
				}
				accessViewer(v -> {
					TreePath[] toSelect = v.getElementPaths(element);
					if (toSelect.length > 0) {
						action.accept(v, toSelect[0]);
						selectionCompleted[0] = true;
					}
				});
			}
			if (!selectionCompleted[0]) {
				failure.run();
			}
		}).start();
	}

	public void init() {
		accessViewer(v -> {
			v.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
		});
	}

	public void addDebugElement(DebugElement parent, DebugElement child) {
		accessViewer(v -> {
			TreeModelContentProvider contentProvider = (TreeModelContentProvider) v.getContentProvider();
			try {
				contentProvider.modelChanged(createNewAddDelta(parent, child), this);
			} catch (Exception e) {
				PluginLogger.logError("Error while updating model", e);
			}
		});
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

	public void refresh(Object toRefresh) {
		accessViewer(v -> v.refresh(toRefresh));
	}

	private IModelDelta createNewAddDelta(DebugElement parent, DebugElement child) throws CoreException {
		ModelDelta delta = unchangedDelta(parent);
		delta.addNode(child, IModelDelta.ADDED);
		ModelDelta newDelta;
		while (null != (newDelta = (ModelDelta) delta.getParentDelta())) {
			delta = newDelta;
		}
		return delta;
	}

	private ModelDelta unchangedDelta(DebugElement modelElement) throws CoreException {
		ModelDelta launchDelta = deltaToDebugTarget(modelElement.getXUmlRtDebugTarget());
		return unchangedDeltaOfElem(launchDelta, modelElement);
	}

	private ModelDelta unchangedDeltaOfElem(ModelDelta rootDelta, DebugElement modelElement) throws CoreException {
		DebugElement parentElem = modelElement.getParent();
		if (parentElem != null) {
			IElementContentProvider adapter = parentElem.getAdapter(IElementContentProvider.class);
			if (adapter != null && adapter instanceof CombiningContentProvider<?>) {
				CombiningContentProvider<?> contentProvider = (CombiningContentProvider<?>) adapter;
				int numChildren = contentProvider.getChildCount(parentElem, DEBUG_VIEW_CONTEXT, null);
				Object[] children = contentProvider.getChildren(parentElem, 0, numChildren, DEBUG_VIEW_CONTEXT, null);
				int indexOf = Arrays.asList(children).indexOf(modelElement);
				ModelDelta delta = unchangedDeltaOfElem(rootDelta, parentElem);
				return delta.addNode(parentElem, indexOf, IModelDelta.NO_CHANGE);
			}
		}
		return rootDelta;
	}

	private ModelDelta deltaToDebugTarget(XUMLRTDebugTarget debugTarget) {
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ModelDelta delta = new ModelDelta(launchManager, IModelDelta.NO_CHANGE);

		ILaunch launch = debugTarget.getLaunch();
		int launchIndex = Arrays.asList(launchManager.getLaunches()).indexOf(launch);
		int debugTargetIndex = Arrays.asList(launch.getDebugTargets()).indexOf(debugTarget);

		ModelDelta launchDelta = delta.addNode(launch, launchIndex, IModelDelta.NO_CHANGE,
				launchManager.getLaunches().length);
		return launchDelta.addNode(debugTarget, debugTargetIndex, IModelDelta.NO_CHANGE, debugTarget.getComponents().length);
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
				.getActivePage().findView(IDebugUIConstants.ID_DEBUG_VIEW);
		if (debugView == null) {
			return; // debug view is not open
		}
		action.accept((TreeModelViewer) debugView.getViewer());
	}
}
