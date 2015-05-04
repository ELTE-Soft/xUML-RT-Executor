package hu.eltesoft.modelexecution.ide.launch;

import hu.eltesoft.modelexecution.ide.util.DelegateProcess;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.jdt.internal.launching.StandardVMDebugger;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.JavaLaunchDelegate;
import org.eclipse.jdt.launching.VMRunnerConfiguration;

import com.sun.jdi.VirtualMachine;

@SuppressWarnings("restriction")
public class BackgroundJavaLauncher extends JavaLaunchDelegate implements
		ILaunchConfigurationDelegate {

	public class BackgroundJavaProcess extends DelegateProcess implements
			IProcess {
		private VirtualMachine vm;
		
		public BackgroundJavaProcess(IProcess process, VirtualMachine vm) {
			super(process);
			this.vm = vm;
		}

		public VirtualMachine getVM() {
			return vm;
		}
		
	}

	VirtualMachine vm;
	
	public class BackgroundJavaVMRunner extends StandardVMDebugger {

		public BackgroundJavaVMRunner(IVMInstall vmInstance) {
			super(vmInstance);
		}

		@Override
		protected IDebugTarget createDebugTarget(VMRunnerConfiguration config,
				ILaunch launch, int port, IProcess process, VirtualMachine vm) {
			BackgroundJavaLauncher.this.vm = vm;
			launch.removeProcess(process);
			launch.addProcess(new BackgroundJavaProcess(process, vm));
			return null;
		}
	}

	@Override
	public IVMRunner getVMRunner(ILaunchConfiguration configuration, String mode)
			throws CoreException {
		IVMInstall vmInstall = getVMInstall(configuration);
		return new BackgroundJavaVMRunner(vmInstall);
	}

	public VirtualMachine getVM() {
		return vm;
	}

}
