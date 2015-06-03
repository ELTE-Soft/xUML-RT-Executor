package hu.eltesoft.modelexecution.ide.launch.process;

import hu.eltesoft.modelexecution.ide.util.ProcessDecorator;

import org.eclipse.debug.core.model.IProcess;

import com.sun.jdi.VirtualMachine;

/**
 * A process representing the debugging virtual machine running in the
 * background. Not a debug target, but lets others access the virtual machine
 * object of the debugger.
 */
@SuppressWarnings("restriction")
// VirtualMachine is not in API
public class DebuggingProcessDecorator extends ProcessDecorator implements
		IProcess, IProcessWithVM {

	private VirtualMachine vm;

	public DebuggingProcessDecorator(IProcess process, VirtualMachine vm) {
		super(process);
		this.vm = vm;
	}

	@Override
	public VirtualMachine getVM() {
		return vm;
	}

}