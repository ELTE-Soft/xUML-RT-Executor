package hu.eltesoft.modelexecution.ide.launch;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProjectSetup;
import hu.eltesoft.modelexecution.ide.util.CmArgBuilder;
import hu.eltesoft.modelexecution.runtime.TestRuntime;

import java.util.function.Consumer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.papyrus.moka.launch.MokaLaunchDelegate;

public class ModelExecutionLaunchConfig {

	private static final String JAVA_LOGGING_OPTION = "-Djava.util.logging.config.file=logging.properties"; //$NON-NLS-1$

	private static final String EMPTY_STR = ""; //$NON-NLS-1$

	private static final String ATTR_PREFIX = "hu.eltesoft.modelexecution.attr."; //$NON-NLS-1$

	/**
	 * URI fragment of the executed feed function. Must be a non-static
	 * operation of the class that is identified by the
	 * {@linkplain #ATTR_EXECUTED_CLASS_URI} attribute.
	 */
	public static final String ATTR_EXECUTED_FEED_URI = ATTR_PREFIX
			+ "executed_feed_uri"; //$NON-NLS-1$

	/**
	 * URI fragment of the executed class. Contains the operation marked by
	 * {@linkplain #ATTR_EXECUTED_FEED_URI} attribute.
	 */
	public static final String ATTR_EXECUTED_CLASS_URI = ATTR_PREFIX
			+ "executed_class_uri"; //$NON-NLS-1$

	/**
	 * The workspace-relative path to the uml file that contains the model that
	 * is executed.
	 */
	public static final String ATTR_UML_RESOURCE = ATTR_PREFIX + "uml_resource"; //$NON-NLS-1$

	/**
	 * The name of the project this launch configuration is linked to.
	 */
	public static final String ATTR_PROJECT_NAME = ATTR_PREFIX + "project_name"; //$NON-NLS-1$

	/**
	 * The name of the executed class. Must be the fully qualified name of the
	 * UML class that is identified by {@linkplain #ATTR_EXECUTED_CLASS_URI}.
	 */
	public static final String ATTR_EXEC_CLASS_NAME = ATTR_PREFIX
			+ "exec_class_name"; //$NON-NLS-1$

	/**
	 * The name of the executed feed function. Must be the name of the UML
	 * function that is identified by {@linkplain #ATTR_EXECUTED_FEED_URI}.
	 */
	public static final String ATTR_FEED_FUN_NAME = ATTR_PREFIX
			+ "feed_fun_name"; //$NON-NLS-1$

	/**
	 * Marks if the animation is enabled in Moka debugging.
	 */
	public static final String ATTR_ANIMATE = ATTR_PREFIX + "animate"; //$NON-NLS-1$

	/**
	 * Controls if animation is enabled by default.
	 */
	public static final boolean ATTR_ANIMATE_DEFAULT = true;

	/**
	 * The slowdown factor for the animation.
	 */
	public static final String ATTR_TIMER_SLOWDOWN = ATTR_PREFIX
			+ "timer_slowdown"; //$NON-NLS-1$

	/**
	 * Defines a reasonable default for the slowdown factor.
	 */
	public static final int ATTR_TIMER_SLOWDOWN_DEFAULT = 5;

	/**
	 * Marks if events are read from trace for the launch configuration.
	 */
	public static final String ATTR_REPLAY_TRACE = ATTR_PREFIX + "replay_trace"; //$NON-NLS-1$

	/**
	 * Controls if {@linkplain #ATTR_REPLAY_TRACE} is enabled by default.
	 */
	public static final boolean ATTR_REPLAY_TRACE_DEFAULT = false;

	/**
	 * Marks if events are serialized into trace files for the launch
	 * configuration.
	 */
	public static final String ATTR_TRACING = ATTR_PREFIX + "tracing"; //$NON-NLS-1$

	/**
	 * Controls if {@linkplain #ATTR_TRACING} is enabled by default.
	 */
	public static final boolean ATTR_TRACING_DEFAULT = false;

	/**
	 * Marks if events are logged during model execution.
	 */
	public static final String ATTR_LOGGING = ATTR_PREFIX + "logging"; //$NON-NLS-1$

	/**
	 * Controls if {@linkplain #ATTR_LOGGING} is enabled by default.
	 */
	public static final boolean ATTR_LOGGING_DEFAULT = true;

	/**
	 * Selects the folder where events are serialized into files during tracing
	 * ( enabled by {@linkplain #ATTR_TRACING} ).
	 */
	public static final String ATTR_TRACE_FOLDER = ATTR_PREFIX + "trace_folder"; //$NON-NLS-1$

	/**
	 * Selects the folder from where events are deserialized for trace replay (
	 * enabled by {@linkplain #ATTR_REPLAY_TRACE} ).
	 */
	public static final String ATTR_REPLAY_TRACE_FOLDER = ATTR_PREFIX
			+ "replay_trace_folder"; //$NON-NLS-1$

	/**
	 * Adds launch configuration attributes needed by Moka.
	 */
	public static ILaunchConfiguration addMokaConfigs(
			ILaunchConfiguration configuration) throws CoreException {
		return addConfigs(configuration, c -> addMokaConfigs(c));
	}

	/**
	 * Adds launch configuration attributes needed for JRE execution.
	 */
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

	/**
	 * Adds launch configuration attributes needed by Moka to a configuration
	 * working copy.
	 */
	public static void addMokaConfigs(
			ILaunchConfigurationWorkingCopy configuration) {
		try {
			URI uri = URI.createPlatformResourceURI(
					configuration.getAttribute(ATTR_UML_RESOURCE, ""), false); //$NON-NLS-1$
			configuration.setAttribute(MokaLaunchDelegate.URI_ATTRIBUTE_NAME,
					uri.toString());
			configuration.setAttribute(
					MokaLaunchDelegate.FRAGMENT_ATTRIBUTE_NAME,
					configuration.getAttribute(ATTR_EXECUTED_CLASS_URI, "")); //$NON-NLS-1$
		} catch (CoreException e) {
			IdePlugin.logError("Error while adding Moka configs", e); //$NON-NLS-1$
		}
	}

	/**
	 * Adds launch configuration attributes needed for JRE execution to a
	 * configuration working copy.
	 */
	public static void addJavaConfigs(
			ILaunchConfigurationWorkingCopy configuration) {
		setJavaDefaultArgs(configuration);
		try {
			configuration.setAttribute(
					IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME,
					configuration.getAttribute(ATTR_PROJECT_NAME, "")); //$NON-NLS-1$
			setupLaunchArgs(configuration);
		} catch (CoreException e) {
			IdePlugin.logError("Error while adding Java configs", e); //$NON-NLS-1$
		}
	}

	private static void setJavaDefaultArgs(
			ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME,
				TestRuntime.class.getCanonicalName());
		configuration.setAttribute(
				IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS,
				JAVA_LOGGING_OPTION);
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
					"")); //$NON-NLS-1$
			argsBuilder.append(configuration.getAttribute(ATTR_FEED_FUN_NAME,
					"")); //$NON-NLS-1$

			boolean logging = configuration.getAttribute(
					ModelExecutionLaunchConfig.ATTR_LOGGING, false);
			if (logging) {
				argsBuilder.append(TestRuntime.OPTION_LOG);
			}
			boolean tracing = configuration.getAttribute(
					ModelExecutionLaunchConfig.ATTR_TRACING, false);
			if (tracing) {
				String traceFolder = configuration
						.getAttribute(
								ModelExecutionLaunchConfig.ATTR_TRACE_FOLDER,
								EMPTY_STR); //$NON-NLS-1$
				argsBuilder.append(TestRuntime.OPTION_WRITE_TRACE);
				argsBuilder.append(traceFolder);
			}
			boolean traceReplay = configuration.getAttribute(
					ModelExecutionLaunchConfig.ATTR_REPLAY_TRACE, false);
			if (traceReplay) {
				String replayTraceFolder = configuration.getAttribute(
						ModelExecutionLaunchConfig.ATTR_REPLAY_TRACE_FOLDER,
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
