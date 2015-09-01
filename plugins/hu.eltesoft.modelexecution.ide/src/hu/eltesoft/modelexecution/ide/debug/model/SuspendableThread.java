package hu.eltesoft.modelexecution.ide.debug.model;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IThread;

public abstract class SuspendableThread extends DebugElement implements IThread {

	protected boolean isSuspended;
	protected List<StackFrame> stackFrames = new LinkedList<>();

	public SuspendableThread(DelegatingDebugTarget debugTarget) {
		super(debugTarget);
	}

	@Override
	public boolean canResume() {
		return isSuspended();
	}

	@Override
	public boolean canSuspend() {
		return !isSuspended();
	}

	@Override
	public boolean isSuspended() {
		return isSuspended;
	}

	@Override
	public void resume() throws DebugException {
		getXUmlRtDebugTarget().resume();
	}

	@Override
	public void suspend() throws DebugException {
		getXUmlRtDebugTarget().resume();
	}

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

}