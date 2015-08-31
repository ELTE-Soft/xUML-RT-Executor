package hu.eltesoft.modelexecution.ide.debug.ui;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.debug.ui.IDebugEditorPresentation;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.launch.EditorUtils;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.NamedElement;

import hu.eltesoft.modelexecution.ide.debug.model.StateMachineStackFrame;

/**
 * Allows to switch between state machine instances and each time the
 * corresponding stack frame is highlighted in the state machine.
 */
public class XUmlRtDebugModelPresentation implements IDebugModelPresentation, IDebugEditorPresentation {

	private static final String DEBUG_VIEW_ID = "org.eclipse.debug.ui.DebugView";
	
	private StackHighlighter highlighter = new StackHighlighter();
	
	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public IEditorInput getEditorInput(Object element) {
		return EditorUtils.getFileEditorInput((EObject) element);
	}

	@Override
	public String getEditorId(IEditorInput input, Object element) {
		return MokaConstants.PAPYRUS_EDITOR_ID;
	}

	@Override
	public void setAttribute(String attribute, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof IPresentation) {
			return ((IPresentation) element).getImage();
		} else {
			return null;
		}
	}

	@Override
	public String getText(Object element) {
		if (element instanceof IPresentation) {
			return ((IPresentation) element).getLabel();
		} else {
			return null;
		}
	}

	@Override
	public void computeDetail(IValue value, IValueDetailListener listener) {
		
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
	
	public static void refreshDebugElements() {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null) {
			// we must perform this operation on a UI thread
			Display.getDefault().syncExec(() -> refreshDebugElementsUIThread());
		} else {
			refreshDebugElementsUIThread();
		}
	}
	
	private static void refreshDebugElementsUIThread() {
		AbstractDebugView debugView = (AbstractDebugView) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().findView(DEBUG_VIEW_ID);
		if (debugView == null) {
			// debug view is not open
			return;
		}
		StructuredViewer viewer = (StructuredViewer) debugView.getViewer();
		viewer.refresh(false);
	}

	@Override
	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		if (frame instanceof StateMachineStackFrame) {
			NamedElement element = ((StateMachineStackFrame) frame).getModelElement();
			highlighter.setHighlighted(element);
		}
		return false;
	}

	@Override
	public void removeAnnotations(IEditorPart editorPart, IThread thread) {
		highlighter.removeHighlight();
	}

}
