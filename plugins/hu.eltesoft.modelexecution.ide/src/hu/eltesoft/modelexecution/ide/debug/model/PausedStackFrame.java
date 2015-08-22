package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;

public class PausedStackFrame extends XUmlRtStackFrame implements IPresentation {

	public PausedStackFrame(XUmlRtStateMachineInstance smInstance) throws DebugException {
		super((MokaDebugTarget) smInstance.getDebugTarget(), smInstance);
		setThread(thread);
	}
	
}
