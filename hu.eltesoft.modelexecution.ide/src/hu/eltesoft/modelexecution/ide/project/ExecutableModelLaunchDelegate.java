package hu.eltesoft.modelexecution.ide.project;

import hu.eltesoft.modelexecution.ide.IdePlugin;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jdt.launching.JavaLaunchDelegate;
import org.eclipse.papyrus.moka.launch.MokaLaunchDelegate;

public class ExecutableModelLaunchDelegate implements
		ILaunchConfigurationDelegate {

	MokaLaunchDelegate mokaDelegate = new MokaLaunchDelegate();
	JavaLaunchDelegate javaDelegate = new JavaLaunchDelegate();

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		if (mode.equals(ILaunchManager.DEBUG_MODE)) {
			try {
				mokaDelegate.launch(configuration, mode, launch, monitor);
			} catch (Exception e) {
				IdePlugin.logError("Unable to launch moka delegate", e);
			}
		}
		javaDelegate.launch(configuration, mode, launch, monitor);
	}

}
