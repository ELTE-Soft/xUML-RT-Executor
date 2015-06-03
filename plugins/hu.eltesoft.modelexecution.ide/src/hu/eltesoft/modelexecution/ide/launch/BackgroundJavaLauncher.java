package hu.eltesoft.modelexecution.ide.launch;

import hu.eltesoft.modelexecution.ide.util.ProcessDecorator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.RuntimeProcess;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugTarget;
import org.eclipse.jdt.internal.launching.StandardVMDebugger;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.JavaLaunchDelegate;
import org.eclipse.jdt.launching.VMRunnerConfiguration;

import com.sun.jdi.VirtualMachine;

/**
 * Launches a java debugger in a background mode. It is not registered in launch
 * as a debug target, only as a process. This process (
 * {@linkplain BackgroundJavaProcess}) gives access to the virtual machine
 * object that can communicate with the debugging vm.
 */
@SuppressWarnings("restriction")
// VirtualMachine and StandardVMDebugger are not in API. StandardVMDebugger is
// subclassed to create a debugger that is not registered as a debug target.
public class BackgroundJavaLauncher extends JavaLaunchDelegate implements
		ILaunchConfigurationDelegate {

	/**
	 * A process representing the debugging virtual machine running in the
	 * background. Not a debug target but lets others access the virtual machine
	 * object of the debugger.
	 */
	public static class BackgroundJavaProcess extends ProcessDecorator implements
			IProcess, IProcessWithVM {
		
		private VirtualMachine vm;

		public BackgroundJavaProcess(IProcess process, VirtualMachine vm) {
			super(process);
			this.vm = vm;
		}

		@Override
		public VirtualMachine getVM() {
			return vm;
		}

	}

	/**
	 * A debugger runner that creates a {@linkplain BackgroundJavaProcess}
	 * instead of a simple {@linkplain RuntimeProcess} and a
	 * {@linkplain JDIDebugTarget}.
	 */
	public static class BackgroundJavaVMRunner extends StandardVMDebugger {

		public BackgroundJavaVMRunner(IVMInstall vmInstance) {
			super(vmInstance);
		}

		@Override
		protected IDebugTarget createDebugTarget(VMRunnerConfiguration config,
				ILaunch launch, int port, IProcess process, VirtualMachine vm) {
			launch.removeProcess(process);
			launch.addProcess(new GracefulTerminationProcessDecorator(
					new BackgroundJavaProcess(process, vm)));
			// This is not a problem, because the returned value is not used.
			// The architecture depends on registering debug targets and
			// processes into the launch.
			return null;
		}
	}

	@Override
	public IVMRunner getVMRunner(ILaunchConfiguration configuration, String mode)
			throws CoreException {
		IVMInstall vmInstall = getVMInstall(configuration);
		return new BackgroundJavaVMRunner(vmInstall);
	}

}
