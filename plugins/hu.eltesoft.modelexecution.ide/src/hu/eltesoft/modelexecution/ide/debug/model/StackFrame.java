package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;

public abstract class StackFrame extends DebugElement implements IStackFrame, IPresentation {

	private final StateMachineInstance instance;
	
	protected List<ModelVariable> variables = null;

	protected ResourceSet resourceSet;
	
	public StackFrame(StateMachineInstance instance, ResourceSet resourceSet) {
		super(instance.getXUmlRtDebugTarget());
		this.instance = instance;
		this.resourceSet = resourceSet;
	}

	// default implementation: every stack frame behaves like the thread
	
	@Override
	public boolean isStepping() {
		return instance.isStepping();
	}

	@Override
	public boolean canResume() {
		return instance.canResume();
	}

	@Override
	public boolean canSuspend() {
		return instance.canSuspend();
	}

	@Override
	public boolean isSuspended() {
		return instance.isSuspended();
	}

	@Override
	public void resume() throws DebugException {
		instance.resume();
	}

	@Override
	public void suspend() throws DebugException {
		instance.suspend();
	}

	@Override
	public boolean canTerminate() {
		return instance.canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return instance.isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		instance.terminate();
	}

	@Override
	public IThread getThread() {
		return instance;
	}
	
	public StateMachineInstance getStateMachineInstance() {
		return instance;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		loadVariables();
		return variables.toArray(new IVariable[variables.size()]);
	}
	
	protected abstract void loadVariables() throws DebugException;

	public ModelVariable[] getModelVariables() {
		return variables.toArray(new ModelVariable[variables.size()]);
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return !variables.isEmpty();
	}

	@Override
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return new IRegisterGroup[0];
	}

	@Override
	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	public void addVariable(ModelVariable createVariable) {
		variables.add(createVariable);
	}


}
