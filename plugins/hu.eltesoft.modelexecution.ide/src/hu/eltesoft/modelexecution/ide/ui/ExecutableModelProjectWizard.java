package hu.eltesoft.modelexecution.ide.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProjectSetup;

/**
 * A wizard to create a new executable model project.
 */
public class ExecutableModelProjectWizard extends Wizard implements INewWizard {

	private WizardNewProjectCreationPage pageOne;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	@Override
	public boolean performFinish() {
		try {

			ExecutableModelProjectSetup.createProject(pageOne.getProjectName(), pageOne.getLocationURI());
		} catch (CoreException e) {
			PluginLogger.logError("Problem while creating project", e);
			Dialogs.openInternalErrorDialog();
		}
		return true;
	}

	@Override
	public void addPages() {
		super.addPages();

		pageOne = new WizardNewProjectCreationPage(Messages.ExecutableModelProjectWizard_create_new_project_name);
		pageOne.setTitle(Messages.ExecutableModelProjectWizard_create_new_project_title);
		pageOne.setDescription(Messages.ExecutableModelProjectWizard_create_new_project_description);

		addPage(pageOne);
	}

}
