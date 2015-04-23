package hu.eltesoft.modelexecution.ide.launch;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.ui.Dialogs;
import hu.eltesoft.modelexecution.runtime.TerminationResult;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchesListener2;
import org.eclipse.debug.core.model.IProcess;

/**
 * Listens for the termination of a launch and checks the exit code. If the exit
 * code indicates something unusual it informs the user.
 */
final class ExitCodeChecker implements ILaunchesListener2 {
	private ILaunch launch;

	public ExitCodeChecker(ILaunch launch) {
		super();
		this.launch = launch;
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
		for (int i = 0; i < launches.length; i++) {
			if (launches[i].equals(launch)) {
				checkLaunchExit(launch);
			}
		}
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
		} else if (exitValue != TerminationResult.SUCCESSFUL_TERMINATION
				.getExitCode()) {
			Dialogs.openRuntimeInternalErrorDialog();
		}
	}
}