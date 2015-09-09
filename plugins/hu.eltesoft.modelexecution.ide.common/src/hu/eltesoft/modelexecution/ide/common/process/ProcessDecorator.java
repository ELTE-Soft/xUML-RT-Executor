package hu.eltesoft.modelexecution.ide.common.process;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

import com.sun.jdi.VirtualMachine;

import hu.eltesoft.modelexecution.ide.common.runtime.RuntimeControllerClient;

/**
 * An Eclipse process that acts as a proxy to the other process received as a
 * constructor argument.
 */
@SuppressWarnings("restriction")
public class ProcessDecorator implements IProcess, IProcessWithVM, IProcessWithController {

	protected IProcess process;

	public ProcessDecorator(IProcess process) {
		this.process = process;
	}

	@Override
	public VirtualMachine getVM() {
		if (process instanceof IProcessWithVM) {
			return ((IProcessWithVM) process).getVM();
		} else {
			return null;
		}
	}

	@Override
	public RuntimeControllerClient getController() {
		if (process instanceof IProcessWithController) {
			return ((IProcessWithController) process).getController();
		} else {
			return null;
		}
	}

	public IProcess getDecoratedProcess() {
		return process;
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		return process.getAdapter(adapter);
	}

	@Override
	public boolean canTerminate() {
		return process.canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return process.isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		process.terminate();
	}

	@Override
	public String getLabel() {
		return process.getLabel();
	}

	@Override
	public ILaunch getLaunch() {
		return process.getLaunch();
	}

	@Override
	public IStreamsProxy getStreamsProxy() {
		return process.getStreamsProxy();
	}

	@Override
	public void setAttribute(String key, String value) {
		process.setAttribute(key, value);
	}

	@Override
	public String getAttribute(String key) {
		return process.getAttribute(key);
	}

	@Override
	public int getExitValue() throws DebugException {
		return process.getExitValue();
	}

}