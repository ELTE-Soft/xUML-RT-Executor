package hu.eltesoft.modelexecution.ide.launch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchesListener2;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.ui.Dialogs;
import hu.eltesoft.modelexecution.runtime.TerminationResult;

/**
 * Listens for the termination of a launch and checks the exit code. If the exit
 * code indicates something unusual it informs the user.
 */
final class ExitCodeChecker implements ILaunchesListener2 {
	private Set<ILaunch> runningLaunches = new HashSet<>();

	/**
	 * Returns true, if the launch can be started or false, if it can't because
	 * another debugging is already running.
	 */
	public boolean launchStarting(ILaunch launch) {
		if (hasRunningDebug() && !showDebugAlreadyRunningWarning()) {
			return false;
		}
		runningLaunches.add(launch);
		return true;
	}

	private boolean hasRunningDebug() {
		ILaunch[] launches = DebugPlugin.getDefault().getLaunchManager().getLaunches();
		for (ILaunch launch : launches) {
			if (launch.isTerminated()) {
				continue;
			}
			for (IDebugTarget debugTarget : launch.getDebugTargets()) {
				if (debugTarget instanceof MokaDebugTarget) {
					if (!debugTarget.isTerminated()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void launchesRemoved(ILaunch[] launches) {
	}

	@Override
	public void launchesChanged(ILaunch[] launches) {
	}

	@Override
	public void launchesAdded(ILaunch[] launches) {
	}

	@Override
	public void launchesTerminated(ILaunch[] launches) {
		HashSet<ILaunch> res = new HashSet<>(runningLaunches);
		res.retainAll(Arrays.asList(launches));
		if (!res.isEmpty()) {
			checkLaunchExit(res.iterator().next());
		}
		runningLaunches.removeAll(res);
	}

	private boolean showDebugAlreadyRunningWarning() {
		return Dialogs.openDebugAlreadyRunningWarning();
	}

	private void checkLaunchExit(ILaunch launch) {
		for (IProcess process : launch.getProcesses()) {
			if (process.isTerminated()) {
				try {
					checkExitCode(process);
				} catch (DebugException e) {
					IdePlugin.logError("Error while accessing exit code.", e);
				}
			}
		}
	}

	private void checkExitCode(IProcess process) throws DebugException {
		int exitValue = process.getExitValue();
		if (exitValue == TerminationResult.INVALID_TRACEFILE.getExitCode()) {
			Dialogs.openTraceFileInvalidErrorDialog();
		} else if (exitValue == TerminationResult.INVALID_EXTERNAL_ENTITY.getExitCode()) {
			Dialogs.openExternalEntityInvalidErrorDialog();
		} else if (exitValue == TerminationResult.INTERNAL_ERROR.getExitCode()) {
			Dialogs.openInternalErrorDialog();
		}
		refreshFolders(process.getAttribute(ExecutableModelLaunchDelegate.PROC_ATTR_TO_REFRESH));
	}

	private void refreshFolders(String attribute) {
		if (attribute == null) {
			return;
		}
		String[] pathes = attribute.split(";");
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		try {
			for (String path : pathes) {
				root.findMember(path).refreshLocal(IResource.DEPTH_ONE, null);
			}
		} catch (CoreException e) {
			IdePlugin.logError("Error while refreshing changed folders", e);
		}
	}
}