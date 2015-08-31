package hu.eltesoft.modelexecution.ide.debug;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IPersistableSourceLocator;
import org.eclipse.debug.core.model.IStackFrame;

import hu.eltesoft.modelexecution.ide.debug.model.StateMachineStackFrame;

public class PersistableSourceLocator implements IPersistableSourceLocator {

	@Override
	public Object getSourceElement(IStackFrame stackFrame) {
		if (stackFrame instanceof StateMachineStackFrame) {
			return ((StateMachineStackFrame) stackFrame).getModelElement();
		}
		return null;
	}

	@Override
	public String getMemento() throws CoreException {
		return null;
	}

	@Override
	public void initializeFromMemento(String memento) throws CoreException {
	}

	@Override
	public void initializeDefaults(ILaunchConfiguration configuration) throws CoreException {
	}

}
