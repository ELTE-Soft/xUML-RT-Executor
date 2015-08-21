package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;

public class XUmlRtStEmptyStackFrame extends XUmlRtStackFrame implements IPresentation {

	public XUmlRtStEmptyStackFrame(XUmlRtStateMachineInstance smInstance) throws DebugException {
		super((MokaDebugTarget) smInstance.getDebugTarget(), smInstance);
		setThread(thread);
	}
	
}
