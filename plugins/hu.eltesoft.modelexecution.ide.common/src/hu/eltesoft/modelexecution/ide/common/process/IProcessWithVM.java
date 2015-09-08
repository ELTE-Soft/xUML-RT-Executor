package hu.eltesoft.modelexecution.ide.common.process;

import org.eclipse.debug.core.model.IProcess;

import com.sun.jdi.VirtualMachine;

/**
 * A process with the attached VM.
 */
@SuppressWarnings("restriction")
public interface IProcessWithVM extends IProcess {

	VirtualMachine getVM();

}
