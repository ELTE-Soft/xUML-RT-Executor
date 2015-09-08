package hu.eltesoft.modelexecution.ide.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
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
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.launching.JavaLaunchDelegate;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.moka.Activator;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.launch.MokaLaunchDelegate;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import hu.eltesoft.modelexecution.ide.common.ProjectProperties;
import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.common.launch.ModelExecutionLaunchConfig;
import hu.eltesoft.modelexecution.ide.common.launch.TraceFileMissingException;
import hu.eltesoft.modelexecution.ide.debug.XUmlRtExecutionEngine;
import hu.eltesoft.modelexecution.ide.launch.process.DebuggingProcessDecorator;
import hu.eltesoft.modelexecution.ide.launch.process.RunProcessDecorator;
import hu.eltesoft.modelexecution.ide.ui.Dialogs;

/**
 * Starts JRE and Moka delegates to execute the given model. Checks if xUML-RT
 * execution engine is selected and the needed resources exist.
 */
public class ExecutableModelLaunchDelegate extends LaunchConfigurationDelegate {

	public static final String PROC_ATTR_TO_REFRESH = "hu.eltesoft.modelexecution.processAttributes.toRefresh"; //$NON-NLS-1$
	private static final String MOKA_EXECUTION_ENGINE_CLASS_NAME_ATTR = "class"; //$NON-NLS-1$
	private static final String MODEL_FILE_EXTENSION = "uml";
	private static final String DIAGRAM_FILE_EXTENSION = "di";

	private MokaLaunchDelegate mokaDelegate = new MokaLaunchDelegate();
	private JavaLaunchDelegate javaDelegate = new DecoratedJavaLauncher(RunProcessDecorator::new,
			DebuggingProcessDecorator::new, () -> null);
	private ExitCodeChecker exitChecker = new ExitCodeChecker();
	private boolean isListening;

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		if (!super.preLaunchCheck(configuration, mode, monitor)) {
			return false;
		}
		if (!mentionedResourcesExist(configuration)) {
			Dialogs.openMentionedResourceDoesNotExistsDialog();
			return false;
		}
		if (mode.equals(ILaunchManager.DEBUG_MODE) && !executionEngineIsXUMLRT()) {
			if (!askUserToSetExecutionEngine()) {
				return false;
			}
		}
		String umlResource = configuration.getAttribute(ModelExecutionLaunchConfig.ATTR_UML_RESOURCE, ""); //$NON-NLS-1$
		String diResource = umlResource.replaceAll("\\." + MODEL_FILE_EXTENSION + "$", "." + DIAGRAM_FILE_EXTENSION); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		if (mode.equals(ILaunchManager.DEBUG_MODE) && !diResourceIsPresent(configuration, diResource, umlResource)) {
			notifyUserThatDiIsMissing(diResource, umlResource);
			return false;
		}
		return true;
	}

	private boolean mentionedResourcesExist(ILaunchConfiguration configuration) throws CoreException {
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			String umlResourceURI = configuration.getAttribute(ModelExecutionLaunchConfig.ATTR_UML_RESOURCE, "");
			String classURIFragment = configuration.getAttribute(ModelExecutionLaunchConfig.ATTR_EXECUTED_CLASS_URI,
					"");
			String functionURIFragment = configuration.getAttribute(ModelExecutionLaunchConfig.ATTR_EXECUTED_FEED_URI,
					"");
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot workspaceRoot = workspace.getRoot();
			URI umlURI = URI.createURI(workspaceRoot.findMember(umlResourceURI).getLocationURI().toString());
			EObject executedClass = resourceSet.getEObject(umlURI.appendFragment(classURIFragment), true);
			EObject executedFunction = resourceSet.getEObject(umlURI.appendFragment(functionURIFragment), true);
			return executedClass != null && executedFunction != null;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean diResourceIsPresent(ILaunchConfiguration configuration, String diResource, String umlResource) {
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
		return (selectedExecutionEngine != null
				&& selectedExecutionEngine.getAttribute(MOKA_EXECUTION_ENGINE_CLASS_NAME_ATTR)
						.equals(XUmlRtExecutionEngine.class.getCanonicalName()));
	}

	private IConfigurationElement[] getPossibleExecutionEngines() {
		return Platform.getExtensionRegistry()
				.getConfigurationElementsFor(MokaConstants.MOKA_ENGINE_EXTENSION_POINT_ID);
	}

	private IConfigurationElement getSelectedExecutionEngine() {
		String selectedEENameSpace = Activator.getDefault().getPreferenceStore()
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
		throw new RuntimeException("xUML-RT Execution Engine is not among possible Execution Engines."); //$NON-NLS-1$
	}

	private void setSelectedExecutionEngine(IConfigurationElement selected) {
		IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		preferenceStore.setValue(MokaConstants.MOKA_DEFAULT_EXECUTION_ENGINE_PREF, selected.getNamespaceIdentifier());
	}

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		listenForLaunchTermination();

		if (!exitChecker.launchStarting(launch)) {
			return;
		}
		try {
			ILaunchConfiguration mokaConfigs = ModelExecutionLaunchConfig.addMokaConfigs(configuration);
			ILaunchConfiguration javaConfigs = ModelExecutionLaunchConfig.addJavaConfigs(configuration, mode);
			launchProcesses(mode, launch, monitor, mokaConfigs, javaConfigs);

		} catch (TraceFileMissingException e) {
			Dialogs.openTraceFileMissingErrorDialog();
		}
	}

	private void launchProcesses(String mode, ILaunch launch, IProgressMonitor monitor,
			ILaunchConfiguration mokaConfigs, ILaunchConfiguration javaConfigs) throws CoreException {
		javaDelegate.launch(javaConfigs, mode, launch, monitor);
		if (mode.equals(ILaunchManager.DEBUG_MODE)) {
			Display.getDefault().asyncExec(() -> {
				changePerspective();
				launchMokaDelegate(mokaConfigs, mode, launch, monitor);
			});
		}
		setFoldersToRefresh(launch, javaConfigs);
	}

	private void changePerspective() {
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		try {
			workbenchWindow.getWorkbench().showPerspective("org.eclipse.debug.ui.DebugPerspective", workbenchWindow);
		} catch (Exception e) {
			PluginLogger.logError("Error while changing perspective", e);
		}
	}

	protected void setFoldersToRefresh(ILaunch launch, ILaunchConfiguration javaConfigs) throws CoreException {
		for (IProcess process : launch.getProcesses()) {
			IProject project = getProject(javaConfigs);
			String path = ProjectProperties.getTraceFilesPath(project);
			process.setAttribute(PROC_ATTR_TO_REFRESH,
					project.getFullPath() + ";" + project.findMember(path).getFullPath());
		}
	}

	private IProject getProject(ILaunchConfiguration launchConfig) throws CoreException {
		String projectName = launchConfig.getAttribute(ModelExecutionLaunchConfig.ATTR_PROJECT_NAME, "");
		return (IProject) ResourcesPlugin.getWorkspace().getRoot().findMember(projectName);
	}

	private void launchMokaDelegate(ILaunchConfiguration configuration, String mode, ILaunch launch,
			IProgressMonitor monitor) {
		try {
			mokaDelegate.launch(configuration, mode, launch, monitor);
		} catch (Exception e) {
			PluginLogger.logError("Unable to launch moka delegate", e); //$NON-NLS-1$
		}
	}

	/**
	 * Listens for termination of the runtime and informs the user if it was not
	 * successful.
	 */
	private void listenForLaunchTermination() {
		if (!isListening) {
			DebugPlugin.getDefault().getLaunchManager().addLaunchListener(exitChecker);
			isListening = true;
		}
	}
}
