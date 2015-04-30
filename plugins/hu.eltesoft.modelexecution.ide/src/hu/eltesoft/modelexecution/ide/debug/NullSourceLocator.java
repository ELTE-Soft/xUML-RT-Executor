package hu.eltesoft.modelexecution.ide.debug;

import org.eclipse.debug.core.model.ISourceLocator;
import org.eclipse.debug.core.model.IStackFrame;

public class NullSourceLocator implements ISourceLocator {

	@Override
	public Object getSourceElement(IStackFrame stackFrame) {
		// intentionally left blank as it disables any source lookup
		return null;
	}
}
