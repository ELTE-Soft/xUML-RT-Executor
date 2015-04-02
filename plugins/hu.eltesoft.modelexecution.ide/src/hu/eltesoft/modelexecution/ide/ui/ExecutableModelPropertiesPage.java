package hu.eltesoft.modelexecution.ide.ui;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProperties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osgi.service.prefs.BackingStoreException;

/**
 * The appearance of the property page where properties of an executable model
 * project can be configured.
 */
public class ExecutableModelPropertiesPage extends PropertyPage implements
		IWorkbenchPropertyPage {

	private static final String EMPTY_PATH = "";

	private static final GridData gridDataFillBoth = new GridData(SWT.FILL,
			SWT.FILL, true, false);

	private Text generatedSourcesFolderField;

	@Override
	protected Control createContents(Composite parent) {
		IEclipsePreferences preferences = getPreferences();

		Composite properties = new Composite(parent, SWT.NONE);
		properties.setLayout(new GridLayout(1, false));

		Group generatedSourcesFolderGroup = new Group(properties, SWT.NONE);
		generatedSourcesFolderGroup
				.setText(Messages.ExecutableModelPropertiesPage_project_properties_folder_for_generated_sources_label);
		generatedSourcesFolderGroup.setLayoutData(gridDataFillBoth);
		generatedSourcesFolderGroup.setLayout(new GridLayout(1, false));

		generatedSourcesFolderField = new Text(generatedSourcesFolderGroup,
				SWT.BORDER);
		generatedSourcesFolderField.setLayoutData(gridDataFillBoth);
		generatedSourcesFolderField.setText(ExecutableModelProperties
				.getSourceGenPath(preferences));
		generatedSourcesFolderField.pack();

		generatedSourcesFolderGroup.pack();
		return properties;
	}

	private IEclipsePreferences getPreferences() {
		return ExecutableModelProperties.getProperties(getProject());
	}

	private IProject getProject() {
		IAdaptable owner = getElement();
		if (owner instanceof IJavaProject) {
			IJavaProject javaProject = (IJavaProject) owner;
			return javaProject.getProject();
		} else if (owner instanceof IProject) {
			return (IProject) owner;
		} else {
			IdePlugin
					.logError("ExecutableModelPropertiesPage owner is not a project");
			return null;
		}
	}

	@Override
	public boolean isValid() {
		boolean sourceGenPathNotEmpty = !generatedSourcesFolderField.getText()
				.equals(EMPTY_PATH);
		boolean sourceGenPathNotSingleSeparator = !generatedSourcesFolderField
				.getText().equals(String.valueOf(Path.SEPARATOR));
		return sourceGenPathNotEmpty && sourceGenPathNotSingleSeparator
				&& super.isValid();
	}

	@Override
	public boolean performOk() {
		if (!isValid()) {
			return false;
		}
		ExecutableModelProperties.setSourceGenPath(getProject(),
				generatedSourcesFolderField.getText());
		try {
			getPreferences().flush();
		} catch (BackingStoreException e) {
			return false;
		}
		return super.performOk();
	}

}
