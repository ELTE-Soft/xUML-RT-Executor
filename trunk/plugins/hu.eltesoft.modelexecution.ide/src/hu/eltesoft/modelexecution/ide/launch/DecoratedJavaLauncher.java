package hu.eltesoft.modelexecution.ide.launch;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.jdt.internal.launching.StandardVMDebugger;
import org.eclipse.jdt.internal.launching.StandardVMRunner;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.JavaLaunchDelegate;
import org.eclipse.jdt.launching.VMRunnerConfiguration;

import com.sun.jdi.VirtualMachine;

/**
 * This Java launcher enables to transform the contents of the launch, to enable
 * custom behavior in Eclipse for the launched system. It is useful when a Java
 * application is launched in the background but the user will interact with it
 * in a different way.
 * 
 * The transformation can be given by functions or suppliers. If suppliers are
 * used, the original artifacts are not created, the supplied values are used
 * instead.
 */
@SuppressWarnings("restriction")
// VirtualMachine and StandardVMDebugger are not in API. StandardVMDebugger is
// subclassed to create a debugger that is not registered as a debug target.
public class DecoratedJavaLauncher extends JavaLaunchDelegate implements
		ILaunchConfigurationDelegate {

	private BiFunction<IProcess, ILaunchConfiguration, IProcess> processDecorator;
	private BiFunction<IProcess, VirtualMachine, IProcess> debugOnlyProcessDecorator;
	private Function<IDebugTarget, IDebugTarget> debugTargetDecorator;
	private Supplier<IDebugTarget> debugTargetProvider;

	public DecoratedJavaLauncher(
			BiFunction<IProcess, ILaunchConfiguration, IProcess> processDecorator,
			BiFunction<IProcess, VirtualMachine, IProcess> debugOnlyProcessDecorator,
			Supplier<IDebugTarget> debugTargetProvider) {
		this.processDecorator = processDecorator;
		this.debugOnlyProcessDecorator = debugOnlyProcessDecorator;
		this.debugTargetProvider = debugTargetProvider;
	}

	public DecoratedJavaLauncher(
			BiFunction<IProcess, ILaunchConfiguration, IProcess> processDecorator,
			BiFunction<IProcess, VirtualMachine, IProcess> debugOnlyProcessDecorator,
			Function<IDebugTarget, IDebugTarget> debugTargetDecorator) {
		this.processDecorator = processDecorator;
		this.debugOnlyProcessDecorator = debugOnlyProcessDecorator;
		this.debugTargetDecorator = debugTargetDecorator;
	}

	/**
	 * Creates a decorated runner for a non-debug launch.
	 */
	public class DecoratingJavaVMRunner extends StandardVMRunner {

		public DecoratingJavaVMRunner(IVMInstall vmInstance) {
			super(vmInstance);
		}

		@Override
		protected IProcess newProcess(ILaunch launch, Process p, String label,
				Map<String, String> attributes) throws CoreException {
			IProcess process = super.newProcess(launch, p, label, attributes);
			launch.removeProcess(process);
			IProcess decoratedProcess = processDecorator.apply(process,
					launch.getLaunchConfiguration());
			launch.addProcess(decoratedProcess);
			return decoratedProcess;
		}
	}

	/**
	 * Creates a decorated runner for a debug launch.
	 */
	public class DecoratingJavaVMDebugger extends StandardVMDebugger {

		public DecoratingJavaVMDebugger(IVMInstall vmInstance) {
			super(vmInstance);
		}

		@Override
		protected IDebugTarget createDebugTarget(VMRunnerConfiguration config,
				ILaunch launch, int port, IProcess process, VirtualMachine vm) {
			launch.removeProcess(process);
			launch.addProcess(debugOnlyProcessDecorator.apply(
					processDecorator.apply(process,
							launch.getLaunchConfiguration()), vm));
			IDebugTarget target = null;
			if (debugTargetProvider == null) {
				IDebugTarget debugTarget = super.createDebugTarget(config,
						launch, port, process, vm);
				launch.removeDebugTarget(debugTarget);
				target = debugTargetDecorator.apply(debugTarget);
			} else {
				target = debugTargetProvider.get();
			}
			launch.addDebugTarget(target);
			return target;
		}
	}

	// supplies the decorating VM runner
	@Override
	public IVMRunner getVMRunner(ILaunchConfiguration configuration, String mode)
			throws CoreException {
		IVMInstall vmInstall = getVMInstall(configuration);
		if (mode.equals(ILaunchManager.DEBUG_MODE)) {
			return new DecoratingJavaVMDebugger(vmInstall);
		} else {
			return new DecoratingJavaVMRunner(vmInstall);
		}
	}

}