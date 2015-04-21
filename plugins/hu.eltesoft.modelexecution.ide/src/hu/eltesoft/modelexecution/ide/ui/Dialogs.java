package hu.eltesoft.modelexecution.ide.ui;

import java.text.MessageFormat;

import hu.eltesoft.modelexecution.ide.Messages;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class Dialogs {

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

}
