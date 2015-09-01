package hu.eltesoft.modelexecution.ide.debug.model;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;

import hu.eltesoft.modelexecution.ide.IdePlugin;

public abstract class DelegatingDebugTarget extends DebugElement implements IDebugTarget {

	protected MokaDebugTarget mokaDebugTarget;
	
	public DelegatingDebugTarget(DelegatingDebugTarget debugTarget, MokaDebugTarget mokaDebugTarget) {
		super(debugTarget);
		this.mokaDebugTarget = mokaDebugTarget;
	}
	
	@Override
	public boolean canTerminate() {
		return mokaDebugTarget.canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return mokaDebugTarget.isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		mokaDebugTarget.terminate();
	}

	@Override
	public boolean canResume() {
		return mokaDebugTarget.canResume();
	}

	@Override
	public void resume() throws DebugException {
		mokaDebugTarget.resume();
	}

	@Override
	public boolean canSuspend() {
		return mokaDebugTarget.canSuspend();
	}

	@Override
	public boolean isSuspended() {
		return mokaDebugTarget.isSuspended();
	}

	@Override
	public void suspend() throws DebugException {
		mokaDebugTarget.suspend();
	}

	@Override
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return mokaDebugTarget.supportsBreakpoint(breakpoint);
	}

	@Override
	public boolean canDisconnect() {
		return mokaDebugTarget.canDisconnect();
	}

	@Override
	public void disconnect() throws DebugException {
		mokaDebugTarget.disconnect();
	}

	@Override
	public boolean supportsStorageRetrieval() {
		return mokaDebugTarget.supportsStorageRetrieval();
	}

	@Override
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return mokaDebugTarget.getMemoryBlock(startAddress, length);
	}

	@Override
	public boolean isDisconnected() {
		return mokaDebugTarget.isDisconnected();
	}

	@Override
	public IProcess getProcess() {
		return mokaDebugTarget.getProcess();
	}

	public void stepOver(StateMachineStackFrame stateMachineStackFrame) {
		try {
			mokaDebugTarget.resume(stateMachineStackFrame, DebugEvent.STEP_OVER);
		} catch (DebugException e) {
			IdePlugin.logError("While trying to step over", e); //$NON-NLS-1$
		}
	}

}