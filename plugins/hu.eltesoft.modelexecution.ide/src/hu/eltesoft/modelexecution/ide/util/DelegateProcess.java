package hu.eltesoft.modelexecution.ide.util;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

/**
 * An Eclipse process that acts as a proxy to the other process received as a
 * constructor argument.
 */
public class DelegateProcess implements IProcess {

	private IProcess process;

	public DelegateProcess(IProcess process) {
		this.process = process;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
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