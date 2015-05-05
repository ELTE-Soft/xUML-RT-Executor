package hu.eltesoft.modelexecution.ide.debug;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.launch.ModelExecutionLaunchConfig;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

public class LaunchConfigReader {

	private static final String ERRMSG_MISSING_PROJECT = "Unable to retrieve project";
	private static final String ERRMSG_READING_LAUNCH_CONFIG = "Unable to read launch configuration";

	private final ILaunchConfiguration configuration;

	public LaunchConfigReader(ILaunch launch) {
		configuration = launch.getLaunchConfiguration();
	}

	public IProject getProject() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		try {
			return root.getProject(configuration.getAttribute(
					ModelExecutionLaunchConfig.ATTR_PROJECT_NAME, ""));
		} catch (CoreException e) {
			IdePlugin.logError(ERRMSG_MISSING_PROJECT, e);
			return null;
		}
	}

	public boolean isAnimating() {
		try {
			return configuration.getAttribute(
					ModelExecutionLaunchConfig.ATTR_ANIMATE, false);
		} catch (CoreException e) {
			IdePlugin.logError(ERRMSG_READING_LAUNCH_CONFIG, e);
			return false;
		}
	}

	public int getAnimationTimerMultiplier() {
		try {
			return configuration.getAttribute(
					ModelExecutionLaunchConfig.ATTR_TIMER_SLOWDOWN,
					ModelExecutionLaunchConfig.ATTR_TIMER_SLOWDOWN_DEFAULT);
		} catch (CoreException e) {
			IdePlugin.logError(ERRMSG_READING_LAUNCH_CONFIG, e);
			return ModelExecutionLaunchConfig.ATTR_TIMER_SLOWDOWN_DEFAULT;
		}
	}
}
