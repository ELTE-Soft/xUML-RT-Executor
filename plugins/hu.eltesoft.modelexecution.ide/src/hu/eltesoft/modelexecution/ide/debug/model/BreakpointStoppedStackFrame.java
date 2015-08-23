package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.uml2.uml.NamedElement;

/**
 * State machine stack frame that is created for the instance that is stopped at
 * a breakpoint (or suspended).
 */
public class BreakpointStoppedStackFrame extends StateMachineStackFrame implements IPresentation {

	public BreakpointStoppedStackFrame(MokaDebugTarget target, XUmlRtStateMachineInstance smInstance,
			NamedElement modelElement) {
		super(target, smInstance);
		setModelElement(modelElement);
	}

}
