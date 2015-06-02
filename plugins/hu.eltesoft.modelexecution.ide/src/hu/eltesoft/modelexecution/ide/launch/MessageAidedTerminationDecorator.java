package hu.eltesoft.modelexecution.ide.launch;

import java.io.IOException;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

public class MessageAidedTerminationDecorator implements IProcess {

	private IProcess process;

	private boolean sigkill = false;
	
	public IProcess getDecoratedProcess() {
		return process;
	}

	@Override
	public void terminate() throws DebugException {
		if (!sigkill) {
			IStreamsProxy streamsProxy = process.getStreamsProxy();
			if (streamsProxy == null) {
				process.terminate();
			} else {
				try {
					streamsProxy.write("TERMINATE");
				} catch (IOException e) {
					process.terminate();
				}
			}
			this.sigkill = true;
		} else {
			process.terminate();
		}
	}

	public MessageAidedTerminationDecorator(IProcess process) {
		this.process = process;
	}

	public boolean canTerminate() {
		return process.canTerminate();
	}

	public boolean isTerminated() {
		return process.isTerminated();
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		return process.getAdapter(adapter);
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