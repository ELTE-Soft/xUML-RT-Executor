package hu.eltesoft.modelexecution.ide.ui;

import hu.eltesoft.modelexecution.ide.Messages;

import java.text.MessageFormat;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

/**
 * A helper class that declares functions that show GUI elements for the user.
 * These functions can be called from non-gui threads.
 */
public class Dialogs {

	public static final class ShowAnotherLaunchConfirmDialog implements
			Runnable {
		private boolean result;

		@Override
		public void run() {
			result = new MessageDialog(null,
					Messages.Dialogs_another_debug_launch_caption, null,
					Messages.Dialogs_another_debug_launch_text,
					MessageDialog.QUESTION, new String[] { "Abort",
							"Force launch" }, 0).open() == 1;
		}

		public boolean getResult() {
			return result;
		}

	}

	private static final class ShowEEPrefChangeConfirmDialog implements
			Runnable {
		private boolean result;

		@Override
		public void run() {
			result = MessageDialog.openConfirm(null,
					Messages.Dialogs_executionEnginePreferenceChange_caption,
					Messages.Dialogs_executionEnginePreferenceChange_text);
		}

		public boolean getResult() {
			return result;
		}
	}

	public static boolean openExecutionEnginePreferenceChangeConfirmDialog() {
		ShowEEPrefChangeConfirmDialog showDialog = new ShowEEPrefChangeConfirmDialog();
		Display.getDefault().syncExec(showDialog);
		return showDialog.getResult();
	}

	public static void openDiMissingNotificationDialog(String diResource,
			String umlResource) {
		Display.getDefault().syncExec(
				() -> MessageDialog.openError(null,
						Messages.Dialogs_missing_di_notification_caption,
						MessageFormat.format(
								Messages.Dialogs_missing_di_notification_text,
								diResource, umlResource)));
	}

	public static void openTraceFileInvalidErrorDialog() {
		Display.getDefault().syncExec(
				() -> MessageDialog.openError(null,
						Messages.Dialogs_invalid_trace_file_caption,
						Messages.Dialogs_invalid_trace_file_text));
	}

	public static void openRuntimeInternalErrorDialog() {
		Display.getDefault().syncExec(
				() -> MessageDialog.openError(null,
						Messages.Dialogs_internal_error_caption,
						Messages.Dialogs_internal_error_text));
	}

	public static boolean openDebugAlreadyRunningWarning() {
		ShowAnotherLaunchConfirmDialog showDialog = new ShowAnotherLaunchConfirmDialog();
		Display.getDefault().syncExec(showDialog);
		return showDialog.getResult();
	}

}
