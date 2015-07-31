package hu.eltesoft.modelexecution.ide.ui;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.widgets.Composite;

public class LaunchConfigFolderSelector extends FolderSelector {

	private String attribute;

	public LaunchConfigFolderSelector(Composite comp, ConfigBase base, String labelCaption, String buttonText,
			String dialogTitle, String attribute) {
		super(comp, base, labelCaption, buttonText, dialogTitle);
		this.attribute = attribute;
	}

	public void apply(ILaunchConfigurationWorkingCopy configuration) {
		if (selectedResource != null) {
			configuration.setAttribute(attribute, selectedResource.getFullPath().toString());
		}
	}

	public void initializeFrom(ILaunchConfiguration configuration) throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		selectedResource = workspace.getRoot().findMember(configuration.getAttribute(attribute, "")); //$NON-NLS-1$
		refreshField();
	}

}
