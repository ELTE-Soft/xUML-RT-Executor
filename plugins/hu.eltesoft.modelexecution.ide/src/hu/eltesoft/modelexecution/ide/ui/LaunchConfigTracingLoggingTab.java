package hu.eltesoft.modelexecution.ide.ui;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.launch.ModelExecutionLaunchConfig;

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
import org.eclipse.swt.widgets.Label;

/**
 * Allows the user to setup logging, tracing and trace replay for the execution
 * of the model.
 */
public class LaunchConfigTracingLoggingTab extends
		AbstractLaunchConfigurationTab {

	public static final String TAB_ID = "hu.eltesoft.modelexecution.ide.tabs.executableModel.tracingLoggingTab"; //$NON-NLS-1$

	private Button loggingEnabled;
	private Button tracingEnabled;
	private Button replayTrace;

	private LaunchConfigFolderSelector traceFolderSelector;
	private LaunchConfigFolderSelector replayFolderSelector;

	private Button defaultTracing;

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
		Label traceNoteLabel = new Label(comp, SWT.NONE);
		traceNoteLabel.setText(Messages.LaunchConfigTracingLoggingTab_trace_note_label);
		createTracingControl(comp);
		createReplayControl(comp);

		comp.pack();
		updateLaunchConfigurationDialog();
		refresh();
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

	private FolderSelectorUpdateListener tabUpdater() {
		return new FolderSelectorUpdateListener() {
			@Override
			public void folderSelectorUpdated(IResource folder) {
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		};
	}
	
	private SelectionListener selectionTabUpdater() {
		return new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				refresh();
				setDirty(true);
				updateLaunchConfigurationDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				refresh();
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		};
	}
	
	private void refresh() {
		defaultTracing.setEnabled(tracingEnabled.getSelection());
		traceFolderSelector.setEnabled(tracingEnabled.getSelection() && !defaultTracing.getSelection());
		replayFolderSelector.setEnabled(replayTrace.getSelection());
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

		defaultTracing = new Button(group, SWT.CHECK);
		defaultTracing.setText("Default trace directory");
		defaultTracing.setSelection(true);
		defaultTracing.addSelectionListener(selectionTabUpdater());
		
		traceFolderSelector = new LaunchConfigFolderSelector(
				group,
				FolderSelector.ConfigBase.WORKSPACE_BASED,
				Messages.LaunchConfigurationTracingLoggingTab_folder_for_tracefiles_label,
				Messages.LaunchConfigurationTracingLoggingTab_folder_for_tracefiles_button_text,
				Messages.LaunchConfigurationTracingLoggingTab_folder_for_tracefiles_dialog_title,
				ModelExecutionLaunchConfig.ATTR_TRACE_FOLDER);
		traceFolderSelector.setEnabled(false);
		traceFolderSelector.addUpdateListener(tabUpdater());

		group.pack();
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

		replayFolderSelector = new LaunchConfigFolderSelector(
				group,
				FolderSelector.ConfigBase.WORKSPACE_BASED,
				Messages.LaunchConfigurationTracingLoggingTab_trace_replay_folder_for_tracefiles,
				Messages.LaunchConfigurationTracingLoggingTab_trace_replay_button_label,
				Messages.LaunchConfigurationTracingLoggingTab_trace_replay_folder_dialog_title,
				ModelExecutionLaunchConfig.ATTR_REPLAY_TRACE_FOLDER);
		replayFolderSelector.addUpdateListener(tabUpdater());

		group.pack();
	}
	
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ModelExecutionLaunchConfig.ATTR_LOGGING,
				ModelExecutionLaunchConfig.ATTR_LOGGING_DEFAULT);
		configuration.setAttribute(ModelExecutionLaunchConfig.ATTR_TRACING,
				ModelExecutionLaunchConfig.ATTR_TRACING_DEFAULT);
		configuration.setAttribute(
				ModelExecutionLaunchConfig.ATTR_REPLAY_TRACE,
				ModelExecutionLaunchConfig.ATTR_REPLAY_TRACE_DEFAULT);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			loggingEnabled.setSelection(configuration.getAttribute(
					ModelExecutionLaunchConfig.ATTR_LOGGING,
					ModelExecutionLaunchConfig.ATTR_LOGGING_DEFAULT));
			tracingEnabled.setSelection(configuration.getAttribute(
					ModelExecutionLaunchConfig.ATTR_TRACING,
					ModelExecutionLaunchConfig.ATTR_TRACING_DEFAULT));
			replayTrace.setSelection(configuration.getAttribute(
					ModelExecutionLaunchConfig.ATTR_REPLAY_TRACE,
					ModelExecutionLaunchConfig.ATTR_REPLAY_TRACE_DEFAULT));
			traceFolderSelector.initializeFrom(configuration);
			replayFolderSelector.initializeFrom(configuration);
		} catch (CoreException e) {
			IdePlugin.logError("Exception while initializing dialog", e); //$NON-NLS-1$
			MessageDialog
					.openError(
							null,
							Messages.LaunchConfigurationTracingLoggingTab_tracing_config_data_error_title,
							Messages.LaunchConfigurationTracingLoggingTab_tracing_config_data_error_description);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ModelExecutionLaunchConfig.ATTR_LOGGING,
				loggingEnabled.getSelection());
		configuration.setAttribute(ModelExecutionLaunchConfig.ATTR_TRACING,
				tracingEnabled.getSelection());
		configuration.setAttribute(ModelExecutionLaunchConfig.ATTR_DEFAULT_TRACING,
				defaultTracing.getSelection());
		configuration.setAttribute(
				ModelExecutionLaunchConfig.ATTR_REPLAY_TRACE,
				replayTrace.getSelection());
		traceFolderSelector.apply(configuration);
		replayFolderSelector.apply(configuration);
	}

	@Override
	public String getName() {
		return Messages.LaunchConfigurationTracingLoggingTab_tracing_and_logging_tab_name;
	}

}
