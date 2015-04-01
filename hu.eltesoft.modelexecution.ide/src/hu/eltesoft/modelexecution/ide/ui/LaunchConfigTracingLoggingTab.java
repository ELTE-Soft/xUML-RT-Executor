package hu.eltesoft.modelexecution.ide.ui;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.Messages;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * Allows the user to setup logging, tracing and trace replay for the execution
 * of the model.
 */
public class LaunchConfigTracingLoggingTab extends
		AbstractLaunchConfigurationTab {

	public static final String TAB_ID = "hu.eltesoft.modelexecution.ide.tabs.executableModel.tracingLoggingTab"; //$NON-NLS-1$
	public static final boolean REPLAY_TRACE_PROPERTY_DEFAULT = false;
	public static final boolean TRACING_PROPERTY_DEFAULT = false;
	public static final boolean LOGGING_PROPERTY_DEFAULT = true;
	public static final String REPLAY_TRACE_PROPERTY = "replayTrace"; //$NON-NLS-1$
	public static final String TRACING_PROPERTY = "tracing"; //$NON-NLS-1$
	public static final String LOGGING_PROPERTY = "logging"; //$NON-NLS-1$
	public static final String TRACE_FOLDER_PROPERTY = "traceFolderProperty"; //$NON-NLS-1$
	public static final String REPLAY_TRACE_FOLDER_PROPERTY = "replayTraceFolderProperty"; //$NON-NLS-1$

	private Button loggingEnabled;
	private Button tracingEnabled;
	private Button replayTrace;

	private FolderSelector traceFolderSelector;
	private FolderSelector replayFolderSelector;

	@Override
	public String getId() {
		return TAB_ID;
	}

	@Override
	public void createControl(Composite parent) {

		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(1, false));
		setControl(comp);

		createLoggingControl(comp);
		createTracingControl(comp);
		createReplayControl(comp);

		comp.pack();
		updateLaunchConfigurationDialog();
	}

	private void createLoggingControl(Composite comp) {
		Group loggingGroup = new Group(comp, SWT.NONE);
		loggingGroup
				.setText(Messages.LaunchConfigurationTracingLoggingTab_logging_group_caption);
		loggingGroup
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		loggingGroup.setLayout(new RowLayout());

		loggingEnabled = new Button(loggingGroup, SWT.CHECK);
		loggingEnabled
				.setText(Messages.LaunchConfigurationTracingLoggingTab_enable_logging_label);
		loggingEnabled.addSelectionListener(selectionTabUpdater());
		loggingGroup.pack();
	}

	private SelectionListener selectionTabUpdater() {
		return new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		};
	}

	private void createTracingControl(Composite comp) {
		Group group = new Group(comp, SWT.NONE);
		group.setText(Messages.LaunchConfigurationTracingLoggingTab_tracing_group_caption);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		group.setLayout(new GridLayout(1, true));

		tracingEnabled = new Button(group, SWT.CHECK);
		tracingEnabled
				.setText(Messages.LaunchConfigurationTracingLoggingTab_enable_tracing_label);
		tracingEnabled.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		tracingEnabled.addSelectionListener(selectionTabUpdater());
		
		traceFolderSelector = new FolderSelector(
				group,
				Messages.LaunchConfigurationTracingLoggingTab_folder_for_tracefiles_label,
				Messages.LaunchConfigurationTracingLoggingTab_folder_for_tracefiles_button_text,
				Messages.LaunchConfigurationTracingLoggingTab_folder_for_tracefiles_dialog_title,
				TRACE_FOLDER_PROPERTY);
		traceFolderSelector.addUpdateListener(tabUpdater());
		
		
		group.pack();
	}

	private FolderSelectorUpdateListener tabUpdater() {
		return new FolderSelectorUpdateListener() {
			@Override
			public void folderSelectorUpdated(IResource folder) {
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		};
	}

	private void createReplayControl(Composite comp) {
		Group group = new Group(comp, SWT.NONE);
		group.setText(Messages.LaunchConfigurationTracingLoggingTab_trace_replay_group_caption);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		group.setLayout(new GridLayout(1, false));

		replayTrace = new Button(group, SWT.CHECK);
		replayTrace
				.setText(Messages.LaunchConfigurationTracingLoggingTab_trace_replay_label);
		replayTrace.addSelectionListener(selectionTabUpdater());

		replayFolderSelector = new FolderSelector(
				group,
				Messages.LaunchConfigurationTracingLoggingTab_trace_replay_folder_for_tracefiles,
				Messages.LaunchConfigurationTracingLoggingTab_trace_replay_button_label,
				Messages.LaunchConfigurationTracingLoggingTab_trace_replay_folder_dialog_title,
				REPLAY_TRACE_FOLDER_PROPERTY);
		replayFolderSelector.addUpdateListener(tabUpdater());

		group.pack();
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(LOGGING_PROPERTY, LOGGING_PROPERTY_DEFAULT);
		configuration.setAttribute(TRACING_PROPERTY, TRACING_PROPERTY_DEFAULT);
		configuration.setAttribute(REPLAY_TRACE_PROPERTY,
				REPLAY_TRACE_PROPERTY_DEFAULT);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			loggingEnabled.setSelection(configuration.getAttribute(
					LOGGING_PROPERTY, false));
			tracingEnabled.setSelection(configuration.getAttribute(
					TRACING_PROPERTY, false));
			replayTrace.setSelection(configuration.getAttribute(
					REPLAY_TRACE_PROPERTY, false));
			traceFolderSelector.initializeFrom(configuration);
			replayFolderSelector.initializeFrom(configuration);
		} catch (CoreException e) {
			IdePlugin.logError("Exception while initializing dialog", e);
			MessageDialog
					.openError(
							null,
							Messages.LaunchConfigurationTracingLoggingTab_tracing_config_data_error_title,
							Messages.LaunchConfigurationTracingLoggingTab_tracing_config_data_error_description);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(LOGGING_PROPERTY,
				loggingEnabled.getSelection());
		configuration.setAttribute(TRACING_PROPERTY,
				tracingEnabled.getSelection());
		configuration.setAttribute(REPLAY_TRACE_PROPERTY,
				replayTrace.getSelection());
		traceFolderSelector.apply(configuration);
		replayFolderSelector.apply(configuration);
	}

	@Override
	public String getName() {
		return Messages.LaunchConfigurationTracingLoggingTab_tracing_and_logging_tab_name;
	}

}
