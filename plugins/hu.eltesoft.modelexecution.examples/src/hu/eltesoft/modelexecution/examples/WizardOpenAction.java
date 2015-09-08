package hu.eltesoft.modelexecution.examples;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.wizards.IWizardDescriptor;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;

public abstract class WizardOpenAction extends Action {

	/**
	 * If the wizard is opened successfully, it closes the welcome page if it
	 * was open.
	 */
	protected void openWizard(String wizardName) {
		IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(wizardName);
		try {
			if (descriptor != null) {
				IWizard wizard = descriptor.createWizard();

				WizardDialog wd = new WizardDialog(Display.getDefault().getActiveShell(), wizard);
				wd.setTitle(wizard.getWindowTitle());
				int success = wd.open();
				if (success == IStatus.OK) {
					closeWelcome();
				}
			}
		} catch (CoreException e) {
			PluginLogger.logError("Could not start the project creation wizard", e); //$NON-NLS-1$
		}
	}

	private void closeWelcome() {
		IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
		IIntroPart part = introManager.getIntro();
		if (part != null) {
			introManager.closeIntro(part);
		}
	}

}