package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IThread;

public abstract class SuspendableThread extends DebugElement implements IThread {

	protected List<StackFrame> stackFrames = new LinkedList<>();

	public SuspendableThread(ClassInstances parent) {
		super(parent.getXUmlRtDebugTarget());
	}

	// delegates up

	@Override
	public boolean canResume() {
		return getXUmlRtDebugTarget().canResume();
	}

	@Override
	public boolean canSuspend() {
		return getXUmlRtDebugTarget().canSuspend();
	}

	@Override
	public boolean isSuspended() {
		return getXUmlRtDebugTarget().isSuspended();
	}

	@Override
	public void resume() throws DebugException {
		getXUmlRtDebugTarget().resume();
	}

	@Override
	public void suspend() throws DebugException {
		getXUmlRtDebugTarget().suspend();
	}

	@Override
	public boolean canTerminate() {
		return getDebugTarget().canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		getXUmlRtDebugTarget().terminate();
	}

	// delegates down

	@Override
	public boolean canStepInto() {
		return this.isSuspended() && !stackFrames.isEmpty() && stackFrames.get(0).canStepInto();
	}

	@Override
	public boolean canStepOver() {
		return this.isSuspended() && !stackFrames.isEmpty() && stackFrames.get(0).canStepOver();
	}

	@Override
	public boolean canStepReturn() {
		return this.isSuspended() && !stackFrames.isEmpty() && stackFrames.get(0).canStepReturn();
	}

	@Override
	public boolean isStepping() {
		return isSuspended();
	}

	@Override
	public void stepInto() throws DebugException {
		stackFrames.get(0).stepInto();
	}

	@Override
	public void stepOver() throws DebugException {
		stackFrames.get(0).stepOver();
	}

	@Override
	public void stepReturn() throws DebugException {
		stackFrames.get(0).stepReturn();
	}

}