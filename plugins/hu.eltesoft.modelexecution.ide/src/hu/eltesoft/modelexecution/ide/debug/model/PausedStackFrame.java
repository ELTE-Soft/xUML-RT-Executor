package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;

/**
 * A state machine stack frame that is created for state machine instances that
 * are not stopped directly but only paused according to the sequential nature
 * of the execution.
 */
public class PausedStackFrame extends StateMachineStackFrame implements IPresentation {

	public PausedStackFrame(StateMachineInstance smInstance) throws DebugException {
		super((MokaDebugTarget) smInstance.getDebugTarget(), smInstance);
		setThread(thread);
	}

}
