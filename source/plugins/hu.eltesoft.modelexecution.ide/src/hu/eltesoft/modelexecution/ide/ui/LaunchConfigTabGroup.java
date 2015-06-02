package hu.eltesoft.modelexecution.ide.ui;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

/**
 * Tab group is populated according to the extension points described in
 * plugin.xml.
 */
public class LaunchConfigTabGroup extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		// all tabs are configured in the plugin.xml
		setTabs(new ILaunchConfigurationTab[] {});
	}

}
