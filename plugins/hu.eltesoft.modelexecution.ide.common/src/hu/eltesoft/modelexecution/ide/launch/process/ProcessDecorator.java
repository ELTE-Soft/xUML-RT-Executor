package hu.eltesoft.modelexecution.ide.launch.process;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

import com.sun.jdi.VirtualMachine;

import hu.eltesoft.modelexecution.ide.runtime.RuntimeControllerClient;

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

	public boolean canTerminate() {
		return process.canTerminate();
	}

	public boolean isTerminated() {
		return process.isTerminated();
	}

	public void terminate() throws DebugException {
		process.terminate();
	}

	public String getLabel() {
		return process.getLabel();
	}

	public ILaunch getLaunch() {
		return process.getLaunch();
	}

	public IStreamsProxy getStreamsProxy() {
		return process.getStreamsProxy();
	}

	public void setAttribute(String key, String value) {
		process.setAttribute(key, value);
	}

	public String getAttribute(String key) {
		return process.getAttribute(key);
	}

	public int getExitValue() throws DebugException {
		return process.getExitValue();
	}

}