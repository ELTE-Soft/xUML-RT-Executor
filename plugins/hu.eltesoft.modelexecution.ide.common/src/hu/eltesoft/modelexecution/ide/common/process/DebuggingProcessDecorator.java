package hu.eltesoft.modelexecution.ide.common.process;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.swt.widgets.Display;

import com.sun.jdi.VirtualMachine;

/**
 * A process representing the debugging virtual machine running in the
 * background. Not a debug target, but lets others access the virtual machine
 * object of the debugger.
 */
@SuppressWarnings("restriction")
// VirtualMachine is not in API
public class DebuggingProcessDecorator extends ProcessDecorator implements IProcess, IProcessWithVM {

	private VirtualMachine vm;

	public DebuggingProcessDecorator(IProcess process, VirtualMachine vm) {
		super(process);
		this.vm = vm;
	}

	@Override
	public void terminate() throws DebugException {
		super.terminate();

		// Let the console update the termination status
		// see ticket #187
		// This object will be the launched process associated with the launch,
		// so this code have to be here, otherwise the ProcessConsole listening
		// to this event will not process it
		Display.getDefault().asyncExec(() -> {
			DebugEvent event = new DebugEvent(this, DebugEvent.TERMINATE);
			DebugEvent[] eventSet = new DebugEvent[] { event };
			DebugPlugin.getDefault().fireDebugEventSet(eventSet);
		});
	}

	@Override
	public VirtualMachine getVM() {
		return vm;
	}

}