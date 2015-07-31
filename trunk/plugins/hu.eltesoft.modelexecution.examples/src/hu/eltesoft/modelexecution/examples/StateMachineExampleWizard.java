package hu.eltesoft.modelexecution.examples;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import hu.eltesoft.modelexecution.ide.project.ExecutableModelProjectSetup;

/**
 * Creates a new xUML-RT project with a few models added initially.
 */
public class StateMachineExampleWizard extends ExampleModelWizard {

	public static final String WIZARD_ID = "hu.eltesoft.modelexecution.examples.helloworld"; //$NON-NLS-1$
	public static final String PROJECT_NAME = Messages.StateMachineExampleWizard_projectName;

	public StateMachineExampleWizard() {
		setWindowTitle(Messages.StateMachineExampleWizard_title);
	}

	@Override
	public boolean performFinish() {
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(PROJECT_NAME);
			if (project.exists()) {
				return true;
			}
			ExecutableModelProjectSetup.createProject(PROJECT_NAME, null);
			copyModel(project, "Machine"); //$NON-NLS-1$
			copyLaunchConfig(project, "Machine"); //$NON-NLS-1$
			copyModel(project, "Phone"); //$NON-NLS-1$
			copyLaunchConfig(project, "Phone"); //$NON-NLS-1$
			copyModel(project, "Loop"); //$NON-NLS-1$
			copyLaunchConfig(project, "Loop"); //$NON-NLS-1$
			copyModel(project, "HelloWorld"); //$NON-NLS-1$
			copyLaunchConfig(project, "HelloWorld"); //$NON-NLS-1$
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void addPages() {
		ExampleWizardPage page = new ExampleWizardPage(""); //$NON-NLS-1$
		page.setTitle(Messages.StateMachineExampleWizard_page_title);
		addPage(page);
	}

	private static final class ExampleWizardPage extends WizardPage {
		private ExampleWizardPage(String pageName) {
			super(pageName);
		}

		@Override
		public void createControl(Composite parent) {
			Composite control = new Composite(parent, SWT.NONE);
			control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			setControl(control);
			FormLayout layout = new FormLayout();
			layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
			layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			layout.spacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
			control.setLayout(layout);

			Label label = new Label(control, SWT.WRAP);
			label.setText(Messages.StateMachineExampleWizard_description);
			FormData layoutData = new FormData();
			layoutData.width = 400;
			label.setLayoutData(layoutData);
		}
	}

}
