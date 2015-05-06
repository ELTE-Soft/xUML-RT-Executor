package hu.eltesoft.modelexecution.ide.launch;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.debug.XUmlRtExecutionEngine;
import hu.eltesoft.modelexecution.ide.ui.Dialogs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jdt.launching.JavaLaunchDelegate;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.moka.Activator;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.launch.MokaLaunchDelegate;
import org.eclipse.swt.widgets.Display;

/**
 * Starts JRE and Moka delegates to execute the given model. Checks if xUML-RT
 * execution engine is selected and the needed resources exist.
 */
public class ExecutableModelLaunchDelegate implements
		ILaunchConfigurationDelegate {

	private static final String MOKA_EXECUTION_ENGINE_CLASS_NAME_ATTR = "class"; //$NON-NLS-1$
	private static final String MODEL_FILE_EXTENSION = "uml";
	private static final String DIAGRAM_FILE_EXTENSION = "di";

	private MokaLaunchDelegate mokaDelegate = new MokaLaunchDelegate();
	private JavaLaunchDelegate javaDelegate = new JavaLaunchDelegate();
	private BackgroundJavaLauncher backgroundJavaLauncher = new BackgroundJavaLauncher();
	private ExitCodeChecker exitChecker = new ExitCodeChecker();
	private boolean isListening;

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		listenForLaunchTermination();
		if (!launchPassesChecks(configuration, mode)
				|| !exitChecker.launchStarting(launch)) {
			return;
		}
		if (mode.equals(ILaunchManager.DEBUG_MODE)) {
			backgroundJavaLauncher.launch(
					ModelExecutionLaunchConfig.addJavaConfigs(configuration),
					mode, launch, monitor);
			Display.getDefault().asyncExec(
					() -> launchMokaDelegate(configuration, mode, launch,
							monitor));
		} else {
			javaDelegate.launch(
					ModelExecutionLaunchConfig.addJavaConfigs(configuration),
					mode, launch, monitor);
		}
	}

	private void launchMokaDelegate(ILaunchConfiguration configuration,
			String mode, ILaunch launch, IProgressMonitor monitor) {
		try {
			mokaDelegate.launch(
					ModelExecutionLaunchConfig.addMokaConfigs(configuration),
					mode, launch, monitor);
		} catch (Exception e) {
			IdePlugin.logError("Unable to launch moka delegate", e); //$NON-NLS-1$
		}
	}

	/**
	 * Listens for termination of the runtime and informs the user if it was not
	 * successful.
	 */
	private void listenForLaunchTermination() {
		if (!isListening) {
			DebugPlugin.getDefault().getLaunchManager()
					.addLaunchListener(exitChecker);
			isListening = true;
		}
	}

	/**
	 * Returns true if the execution can be started, displays errors and returns
	 * false otherwise.
	 */
	protected boolean launchPassesChecks(ILaunchConfiguration configuration,
			String mode) throws CoreException {
		if (mode.equals(ILaunchManager.DEBUG_MODE)
				&& !executionEngineIsXUMLRT()) {
			if (!askUserToSetExecutionEngine()) {
				return false;
			}
		}
		String umlResource = configuration.getAttribute(
				ModelExecutionLaunchConfig.ATTR_UML_RESOURCE, ""); //$NON-NLS-1$
		String diResource = umlResource
				.replaceAll(
						"\\." + MODEL_FILE_EXTENSION + "$", "." + DIAGRAM_FILE_EXTENSION); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		if (mode.equals(ILaunchManager.DEBUG_MODE)
				&& !diResourceIsPresent(configuration, diResource, umlResource)) {
			notifyUserThatDiIsMissing(diResource, umlResource);
			return false;
		}
		return true;
	}

	private boolean diResourceIsPresent(ILaunchConfiguration configuration,
			String diResource, String umlResource) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		IFile modelElementIFile = (IFile) workspaceRoot.findMember(diResource);
		return modelElementIFile != null;
	}

	private boolean askUserToSetExecutionEngine() {
		if (Dialogs.openExecutionEnginePreferenceChangeConfirmDialog()) {
			setSelectedExecutionEngine(getXUMLRTExecutionEngine());
			return true;
		}
		return false;
	}

	private void notifyUserThatDiIsMissing(String diResource, String umlResource) {
		Dialogs.openDiMissingNotificationDialog(diResource, umlResource);
	}

	private boolean executionEngineIsXUMLRT() {
		IConfigurationElement selectedExecutionEngine = getSelectedExecutionEngine();
		return (selectedExecutionEngine != null && selectedExecutionEngine
				.getAttribute(MOKA_EXECUTION_ENGINE_CLASS_NAME_ATTR).equals(
						XUmlRtExecutionEngine.class.getCanonicalName()));
	}

	private IConfigurationElement[] getPossibleExecutionEngines() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(
				MokaConstants.MOKA_ENGINE_EXTENSION_POINT_ID);
	}

	private IConfigurationElement getSelectedExecutionEngine() {
		String selectedEENameSpace = Activator.getDefault()
				.getPreferenceStore()
				.getString(MokaConstants.MOKA_DEFAULT_EXECUTION_ENGINE_PREF);
		IConfigurationElement[] possibleEEs = getPossibleExecutionEngines();
		for (IConfigurationElement possibleEE : possibleEEs) {
			if (possibleEE.getNamespaceIdentifier().equals(selectedEENameSpace)) {
				return possibleEE;
			}
		}
		// no execution engine is selected
		return null;
	}

	private IConfigurationElement getXUMLRTExecutionEngine() {
		IConfigurationElement[] possibleEEs = getPossibleExecutionEngines();
		for (IConfigurationElement possibleEE : possibleEEs) {
			if (possibleEE.getAttribute(MOKA_EXECUTION_ENGINE_CLASS_NAME_ATTR)
					.equals(XUmlRtExecutionEngine.class.getCanonicalName())) {
				return possibleEE;
			}
		}
		throw new RuntimeException(
				"xUML-RT Execution Engine is not among possible Execution Engines."); //$NON-NLS-1$
	}

	private void setSelectedExecutionEngine(IConfigurationElement selected) {
		IPreferenceStore preferenceStore = Activator.getDefault()
				.getPreferenceStore();
		preferenceStore.setValue(
				MokaConstants.MOKA_DEFAULT_EXECUTION_ENGINE_PREF,
				selected.getNamespaceIdentifier());
	}
}
