package hu.eltesoft.modelexecution.ide.launch;

import org.eclipse.debug.core.model.IProcess;

import com.sun.jdi.VirtualMachine;

@SuppressWarnings("restriction")
public interface IProcessWithVM extends IProcess {

	VirtualMachine getVM();
	
}
