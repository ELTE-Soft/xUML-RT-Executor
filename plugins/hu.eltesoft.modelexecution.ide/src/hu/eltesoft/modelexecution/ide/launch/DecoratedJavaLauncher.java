package hu.eltesoft.modelexecution.ide.launch;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.RuntimeProcess;
import org.eclipse.jdt.internal.debug.core.model.JDIDebugTarget;
import org.eclipse.jdt.internal.launching.StandardVMRunner;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.JavaLaunchDelegate;

@SuppressWarnings("restriction")
// VirtualMachine and StandardVMDebugger are not in API. StandardVMDebugger is
// subclassed to create a debugger that is not registered as a debug target.
public class DecoratedJavaLauncher extends JavaLaunchDelegate implements
		ILaunchConfigurationDelegate {

	/**
	 * A debugger runner that creates a {@linkplain WrappedJavaProcess} instead
	 * of a simple {@linkplain RuntimeProcess} and a {@linkplain JDIDebugTarget}
	 */
	public static class WrappedJavaVMRunner extends StandardVMRunner {

		public WrappedJavaVMRunner(IVMInstall vmInstance) {
			super(vmInstance);
		}

		@Override
		protected IProcess newProcess(ILaunch launch, Process p, String label,
				Map<String, String> attributes) throws CoreException {
			IProcess process = super.newProcess(launch, p, label, attributes);
			launch.removeProcess(process);
			IProcess wrappedProcess = new GracefulTerminationProcessDecorator(
					process);
			launch.addProcess(wrappedProcess);
			return wrappedProcess;
		}
	}

	@Override
	public IVMRunner getVMRunner(ILaunchConfiguration configuration, String mode)
			throws CoreException {
		IVMInstall vmInstall = getVMInstall(configuration);
		return new WrappedJavaVMRunner(vmInstall);
	}

}