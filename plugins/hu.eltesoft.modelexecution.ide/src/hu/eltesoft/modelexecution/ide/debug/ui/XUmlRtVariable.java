package hu.eltesoft.modelexecution.ide.debug.ui;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaVariable;

public class XUmlRtVariable extends MokaVariable {

	private XUmlRtValue value2;
	private String name2;

	public XUmlRtVariable(MokaDebugTarget debugTarget, String name, XUmlRtValue value) {
		super(debugTarget);
		name2 = name;
		value2 = value;
	}
	
	@Override
	public IValue getValue() throws DebugException {
		return value2;
	}

	@Override
	public String getName() throws DebugException {
		return name2;
	}
	
}
