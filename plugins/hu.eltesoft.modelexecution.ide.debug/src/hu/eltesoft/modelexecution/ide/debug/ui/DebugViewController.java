package hu.eltesoft.modelexecution.ide.debug.ui;

import java.util.Arrays;
import java.util.function.Consumer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.internal.ui.viewers.model.TreeModelContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IModelDelta;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ModelDelta;
import org.eclipse.debug.internal.ui.viewers.model.provisional.PresentationContext;
import org.eclipse.debug.internal.ui.viewers.model.provisional.TreeModelViewer;
import org.eclipse.debug.internal.ui.viewers.provisional.AbstractModelProxy;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.debug.model.DebugElement;
import hu.eltesoft.modelexecution.ide.debug.model.StateMachineInstance;
import hu.eltesoft.modelexecution.ide.debug.model.XUMLRTDebugTarget;
import hu.eltesoft.modelexecution.ide.debug.model.utils.CombiningContentProvider;

/**
 * Performs changes on the debug tree view. Modifications in the debug model
 * should call methods of this class.
 */
@SuppressWarnings("restriction")
public class DebugViewController extends AbstractModelProxy {

	private static final Display DISPLAY = Display.getDefault();

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

	/**
	 * Adds a new debug element to the debug tree.
	 */
	public void addDebugElement(DebugElement added) {
		try {
			updateModel(getTopLevelDelta(createNewAddDelta(added)));
		} catch (CoreException e) {
			PluginLogger.logError("Error while trying to add model element", e);
		}
	}

	/**
	 * Adds a new debug element to the debug tree and immediately reveal and
	 * select it.
	 */
	public void addDebugElementSelected(StateMachineInstance added) {
		try {
			ModelDelta addDelta = createNewAddDelta(added);
			addDelta.setFlags(addDelta.getFlags() | IModelDelta.REVEAL | IModelDelta.SELECT);
			updateModel(getTopLevelDelta(addDelta));
		} catch (CoreException e) {
			PluginLogger.logError("Error while trying to add and select model element", e);
		}
	}

	private ModelDelta createNewAddDelta(DebugElement added) throws CoreException {
		ModelDelta delta = unchangedDeltaToParent(added);
		delta.setFlags(delta.getFlags() | IModelDelta.CONTENT | IModelDelta.EXPAND);
		return delta.addNode(added, IModelDelta.ADDED);
	}

	public void removeDebugElement(DebugElement removed) {
		try {
			updateModel(getTopLevelDelta(createRemoveDelta(removed)));
		} catch (CoreException e) {
			PluginLogger.logError("Error while trying to remove model element", e);
		}
	}

	private ModelDelta createRemoveDelta(DebugElement removed) throws CoreException {
		ModelDelta delta = unchangedDeltaToParent(removed);
		delta.setFlags(delta.getFlags() | IModelDelta.CONTENT);
		return delta.addNode(removed, IModelDelta.REMOVED);
	}

	/**
	 * Update the label and icon of the debug element.
	 */
	public void updateElement(DebugElement toUpdate) {
		try {
			updateModel(getTopLevelDelta(createNewUpdateDelta(toUpdate)));
		} catch (CoreException e) {
			PluginLogger.logError("Error while trying to add model element", e);
		}
	}

	private ModelDelta createNewUpdateDelta(DebugElement toUpdate) throws CoreException {
		ModelDelta delta = unchangedDeltaToParent(toUpdate);
		delta.setFlags(delta.getFlags() | IModelDelta.CONTENT);
		return delta.addNode(toUpdate, IModelDelta.STATE);
	}

	private ModelDelta getTopLevelDelta(ModelDelta delta) {
		ModelDelta newDelta;
		while (null != (newDelta = (ModelDelta) delta.getParentDelta())) {
			delta = newDelta;
		}
		return delta;
	}

	/**
	 * Creates the part of the delta to the parent of the element.
	 */
	private ModelDelta unchangedDeltaToParent(DebugElement modelElement) throws CoreException {
		ModelDelta launchDelta = deltaToDebugTarget(modelElement.getXUmlRtDebugTarget());
		if (modelElement.getParent() != null) {
			return unchangedDeltaOfElem(launchDelta, modelElement.getParent());
		} else {
			return launchDelta;
		}
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
				delta.setChildCount(children.length);
				return delta.addNode(modelElement, indexOf, IModelDelta.NO_CHANGE);
			}
		}
		return rootDelta;
	}

	/**
	 * Creates the part of the delta from the launch manager to the debug
	 * target.
	 */
	private ModelDelta deltaToDebugTarget(XUMLRTDebugTarget debugTarget) {
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ModelDelta delta = new ModelDelta(launchManager, -1, IModelDelta.NO_CHANGE, launchManager.getLaunches().length);

		ILaunch launch = debugTarget.getLaunch();
		int launchIndex = Arrays.asList(launchManager.getLaunches()).indexOf(launch);
		int debugTargetIndex = Arrays.asList(launch.getDebugTargets()).indexOf(debugTarget);

		ModelDelta launchDelta = delta.addNode(launch, launchIndex, IModelDelta.NO_CHANGE,
				launchManager.getDebugTargets().length);
		return launchDelta.addNode(debugTarget, debugTargetIndex, IModelDelta.NO_CHANGE,
				debugTarget.getComponents().length);
	}

	private void updateModel(IModelDelta delta) {
		accessViewer(v -> ((TreeModelContentProvider) v.getContentProvider()).modelChanged(delta, this));
	}

	/**
	 * Performs the given action on the debug tree view. Can be performed from
	 * both UI and non-UI thread. Returns without performing the action if the
	 * debug view is not open.
	 */
	private void accessViewer(Consumer<TreeModelViewer> action) {
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
