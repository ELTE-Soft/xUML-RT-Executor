package hu.eltesoft.modelexecution.ide.launch;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProjectSetup;
import hu.eltesoft.modelexecution.ide.ui.LaunchConfigTracingLoggingTab;
import hu.eltesoft.modelexecution.ide.util.CmArgBuilder;
import hu.eltesoft.modelexecution.runtime.TestRuntime;

import java.util.function.Consumer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.papyrus.moka.launch.MokaLaunchDelegate;

public class ModelExecutionLaunchConfig {

	private static final String EMPTY_STR = "";

	public static final String ATTR_EXECUTED_FEED_URI = "executed_feed_uri"; //$NON-NLS-1$

	public static final String ATTR_EXECUTED_CLASS_URI = "executed_class_uri"; //$NON-NLS-1$

	public static final String ATTR_UML_RESOURCE = "uml_resource"; //$NON-NLS-1$

	public static final String ATTR_PROJECT_NAME = "project_name"; //$NON-NLS-1$

	public static final String ATTR_EXEC_CLASS_NAME = "exec_class_name"; //$NON-NLS-1$

	public static final String ATTR_FEED_FUN_NAME = "feed_fun_name"; //$NON-NLS-1$

	public static ILaunchConfiguration addMokaConfigs(
			ILaunchConfiguration configuration) throws CoreException {
		return addConfigs(configuration, c -> addMokaConfigs(c));
	}

	public static ILaunchConfiguration addJavaConfigs(
			ILaunchConfiguration configuration) throws CoreException {
		return addConfigs(configuration, c -> addJavaConfigs(c));
	}

	private static ILaunchConfiguration addConfigs(
			ILaunchConfiguration configuration,
			Consumer<ILaunchConfigurationWorkingCopy> extendConfig)
			throws CoreException {
		ILaunchConfigurationWorkingCopy workingCopy = configuration
				.getWorkingCopy();
		extendConfig.accept(workingCopy);
		workingCopy.doSave();
		return configuration;
	}

	public static void addMokaConfigs(
			ILaunchConfigurationWorkingCopy configuration) {
		try {
			configuration.setAttribute(MokaLaunchDelegate.URI_ATTRIBUTE_NAME,
					configuration.getAttribute(ATTR_UML_RESOURCE, ""));
			configuration.setAttribute(
					MokaLaunchDelegate.FRAGMENT_ATTRIBUTE_NAME,
					configuration.getAttribute(ATTR_EXECUTED_CLASS_URI, ""));
		} catch (CoreException e) {
			IdePlugin.logError("Error while adding Moka configs", e);
		}
	}

	public static void addJavaConfigs(
			ILaunchConfigurationWorkingCopy configuration) {
		setJavaDefaultArgs(configuration);
		try {
			configuration.setAttribute(
					IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME,
					configuration.getAttribute(ATTR_PROJECT_NAME, ""));
			setupLaunchArgs(configuration);
		} catch (CoreException e) {
			IdePlugin.logError("Error while adding Java configs", e);
		}
	}

	private static void setJavaDefaultArgs(
			ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME,
				TestRuntime.class.getCanonicalName());
		configuration.setAttribute(
				IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS,
				"-Djava.util.logging.config.file=logging.properties");
		configuration.setAttribute(
				IJavaLaunchConfigurationConstants.ATTR_JRE_CONTAINER_PATH,
				ExecutableModelProjectSetup.JRE_CONTAINER_PATH.toString());
		configuration.setAttribute(
				IJavaLaunchConfigurationConstants.ATTR_CLASSPATH_PROVIDER,
				RuntimeClasspathProvider.PROVIDER_ID);
		configuration.setAttribute(
				IJavaLaunchConfigurationConstants.ATTR_STOP_IN_MAIN, true);
	}

	private static void setupLaunchArgs(
			ILaunchConfigurationWorkingCopy configuration) {
		try {
			CmArgBuilder argsBuilder = new CmArgBuilder();

			argsBuilder.append(configuration.getAttribute(ATTR_EXEC_CLASS_NAME,
					""));
			argsBuilder.append(configuration.getAttribute(ATTR_FEED_FUN_NAME,
					""));

			boolean logging = configuration.getAttribute(
					LaunchConfigTracingLoggingTab.LOGGING_PROPERTY, false);
			if (logging) {
				argsBuilder.append(TestRuntime.OPTION_LOG);
			}
			boolean tracing = configuration.getAttribute(
					LaunchConfigTracingLoggingTab.TRACING_PROPERTY, false);
			if (tracing) {
				String traceFolder = configuration.getAttribute(
						LaunchConfigTracingLoggingTab.TRACE_FOLDER_PROPERTY,
						EMPTY_STR); //$NON-NLS-1$
				argsBuilder.append(TestRuntime.OPTION_WRITE_TRACE);
				argsBuilder.append(traceFolder);
			}
			boolean traceReplay = configuration.getAttribute(
					LaunchConfigTracingLoggingTab.REPLAY_TRACE_PROPERTY, false);
			if (traceReplay) {
				String replayTraceFolder = configuration
						.getAttribute(
								LaunchConfigTracingLoggingTab.REPLAY_TRACE_FOLDER_PROPERTY,
								EMPTY_STR); //$NON-NLS-1$
				argsBuilder.append(TestRuntime.OPTION_READ_TRACE);
				argsBuilder.append(replayTraceFolder);
			}

			configuration.setAttribute(
					IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS,
					argsBuilder.toString());
		} catch (CoreException e) {
			IdePlugin.logError("Cannot setup launch args", e); //$NON-NLS-1$
		}
	}

}
