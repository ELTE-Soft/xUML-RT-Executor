package hu.eltesoft.modelexecution.ide.debug.ui;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugEditorPresentation;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.launch.EditorUtils;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.NamedElement;

import hu.eltesoft.modelexecution.ide.debug.model.StateMachineStackFrame;

/**
 * Allows to switch between state machine instances and each time the
 * corresponding stack frame is highlighted in the state machine.
 */
public class XUmlRtDebugModelPresentation implements IDebugModelPresentation, IDebugEditorPresentation {
	
	private StackHighlighter highlighter = new StackHighlighter();
	
	@Override
	public void addListener(ILabelProviderListener listener) {
		// not supported
	}

	@Override
	public void dispose() {
		// intentionally left blank
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// not supported
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
		// not supported
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
		// intentionally left blank
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
