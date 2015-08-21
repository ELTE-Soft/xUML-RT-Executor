package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.uml2.uml.NamedElement;

public class XUmlRtSMStackFrame extends XUmlRtStackFrame implements IPresentation {

	public XUmlRtSMStackFrame(MokaDebugTarget target, XUmlRtStateMachineInstance smInstance, NamedElement modelElement) {
		super(target, smInstance);
		setModelElement(modelElement);
	}

}
