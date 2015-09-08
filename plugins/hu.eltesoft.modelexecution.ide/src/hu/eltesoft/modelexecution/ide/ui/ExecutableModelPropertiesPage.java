package hu.eltesoft.modelexecution.ide.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.osgi.service.prefs.BackingStoreException;

import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.common.util.ClasspathUtils;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProperties;
import hu.eltesoft.modelexecution.logger.PluginLogger;

/**
 * The appearance of the property page where properties of an executable model
 * project can be configured.
 * 
 * Property pages are validated by {@linkplain #updateApplyButton()} that calls
 * {@linkplain #isValid()}.
 */
public class ExecutableModelPropertiesPage extends PropertyPage implements IWorkbenchPropertyPage {

	private static final GridData gridDataFillBoth = new GridData(SWT.FILL, SWT.FILL, true, false);

	private ResourceSelector generatedFilesFolderSelector;
	private ResourceSelector instrumentedClassFilesFolderSelector;
	private ResourceSelector debugFilesFolderSelector;

	private ResourceSelector generatedTracesFolderSelector;

	@Override
	protected Control createContents(Composite parent) {
		IEclipsePreferences preferences = getPreferences();

		Composite properties = new Composite(parent, SWT.NONE);
		properties.setLayout(new GridLayout(1, false));

		generatedSourceFolderControl(preferences, properties);

		Label binLibTxt = new Label(properties, SWT.NONE);
		binLibTxt.setText(Messages.ExecutableModelPropertiesPage_java_class_files_label);

		debugFilesFolderControl(preferences, properties);
		instrumentedClassFilesFolderControl(preferences, properties);
		generatedTracesFolderControl(preferences, properties);

		return properties;
	}

	private void generatedSourceFolderControl(IEclipsePreferences preferences, Composite properties) {
		Group generatedSourcesFolderGroup = new Group(properties, SWT.NONE);
		generatedSourcesFolderGroup
				.setText(Messages.ExecutableModelPropertiesPage_project_properties_folder_for_generated_sources_label);
		generatedSourcesFolderGroup.setLayoutData(gridDataFillBoth);
		generatedSourcesFolderGroup.setLayout(new GridLayout(1, false));

		generatedFilesFolderSelector = new ResourceSelector(generatedSourcesFolderGroup,
				ResourceSelector.ConfigBase.PROJECT_BASED, Messages.ExecutableModelPropertiesPage_gen_sources_label,
				Messages.ExecutableModelPropertiesPage_gen_sources_button,
				Messages.ExecutableModelPropertiesPage_gen_sources_dialog_caption);
		String sourceGenPath = ExecutableModelProperties.getSourceGenPath(getProject());
		generatedFilesFolderSelector.setSelectedResource(getProject().findMember(sourceGenPath));
		generatedFilesFolderSelector.addUpdateListener(sel -> updateApplyButton());

		generatedSourcesFolderGroup.pack();
	}

	private void generatedTracesFolderControl(IEclipsePreferences preferences, Composite properties) {
		Group generatedTracesFolderGroup = new Group(properties, SWT.NONE);
		generatedTracesFolderGroup.setText("Folder for generated trace files");
		generatedTracesFolderGroup.setLayoutData(gridDataFillBoth);
		generatedTracesFolderGroup.setLayout(new GridLayout(1, false));

		generatedTracesFolderSelector = new ResourceSelector(generatedTracesFolderGroup,
				ResourceSelector.ConfigBase.PROJECT_BASED, "Folder for generated trace files", "Select",
				"Select folder for generated trace files");
		String tracesPath = ExecutableModelProperties.getTraceFilesPath(getProject());
		generatedTracesFolderSelector.setSelectedResource(getProject().findMember(tracesPath));
		generatedTracesFolderSelector.addUpdateListener(sel -> updateApplyButton());

		generatedTracesFolderGroup.pack();
	}

	private void debugFilesFolderControl(IEclipsePreferences preferences, Composite properties) {
		Group debugFilesFolderGroup = new Group(properties, SWT.NONE);
		debugFilesFolderGroup.setText(Messages.ExecutableModelPropertiesPage_debug_folder_group_caption);
		debugFilesFolderGroup.setLayoutData(gridDataFillBoth);
		debugFilesFolderGroup.setLayout(new GridLayout(1, false));

		debugFilesFolderSelector = new ResourceSelector(debugFilesFolderGroup,
				ResourceSelector.ConfigBase.PROJECT_BASED, Messages.ExecutableModelPropertiesPage_debug_files_label,
				Messages.ExecutableModelPropertiesPage_debug_files_button,
				Messages.ExecutableModelPropertiesPage_debug_files_dialog_caption);
		String sourceGenPath = ExecutableModelProperties.getDebugFilesPath(getProject());
		debugFilesFolderSelector.setSelectedResource(getProject().findMember(sourceGenPath));
		debugFilesFolderSelector.addUpdateListener(sel -> updateApplyButton());

		debugFilesFolderGroup.pack();
	}

	private void instrumentedClassFilesFolderControl(IEclipsePreferences preferences, Composite properties) {
		Group instrumentedClassFolderGroup = new Group(properties, SWT.NONE);
		instrumentedClassFolderGroup.setText(Messages.ExecutableModelPropertiesPage_instrumented_group_label);
		instrumentedClassFolderGroup.setLayoutData(gridDataFillBoth);
		instrumentedClassFolderGroup.setLayout(new GridLayout(1, false));

		instrumentedClassFilesFolderSelector = new ResourceSelector(instrumentedClassFolderGroup,
				ResourceSelector.ConfigBase.PROJECT_BASED,
				Messages.ExecutableModelPropertiesPage_instrumented_folder_label,
				Messages.ExecutableModelPropertiesPage_instrumented_folder_button,
				Messages.ExecutableModelPropertiesPage_instrumented_folder_dialog_caption);
		String sourceGenPath = ExecutableModelProperties.getInstrumentedClassFilesPath(getProject());
		instrumentedClassFilesFolderSelector.setSelectedResource(getProject().findMember(sourceGenPath));
		instrumentedClassFilesFolderSelector.addUpdateListener(sel -> updateApplyButton());

		instrumentedClassFolderGroup.pack();
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
			PluginLogger.logError("ExecutableModelPropertiesPage owner is not a project"); //$NON-NLS-1$
			return null;
		}
	}

	@Override
	public boolean isValid() {
		return generatedFilesFolderSelector.selectionValid() && debugFilesFolderSelector.selectionValid()
				&& instrumentedClassFilesFolderSelector.selectionValid()
				&& generatedTracesFolderSelector.selectionValid() && super.isValid();
	}

	@Override
	public boolean performOk() {
		String oldSrcGenPath = ExecutableModelProperties.getSourceGenPath(getProject());
		String newSrcGenPath = generatedFilesFolderSelector.getSelectedResourcePath().toString();
		ExecutableModelProperties.setSourceGenPath(getProject(), newSrcGenPath);
		ExecutableModelProperties.setDebugFilesPath(getProject(),
				debugFilesFolderSelector.getSelectedResourcePath().toString());
		ExecutableModelProperties.setInstrumentedClassFilesPath(getProject(),
				instrumentedClassFilesFolderSelector.getSelectedResourcePath().toString());
		ExecutableModelProperties.setTraceFilesPath(getProject(),
				generatedTracesFolderSelector.getSelectedResourcePath().toString());

		if (!newSrcGenPath.equals(oldSrcGenPath)) {
			try {
				ClasspathUtils.removeClasspathEntry(JavaCore.create(getProject()),
						getProject().findMember(oldSrcGenPath).getFullPath());
				ClasspathUtils.addClasspathEntry(JavaCore.create(getProject()),
						JavaCore.newSourceEntry(getProject().findMember(newSrcGenPath).getFullPath()));
			} catch (JavaModelException e) {
				PluginLogger.logError("Error while removing old source dir classpath entry.", //$NON-NLS-1$
						e);
			}
		}
		Job job = new Job(Messages.ExecutableModelPropertiesPage_clean_job_name) {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					getProject().build(IncrementalProjectBuilder.FULL_BUILD, monitor);
				} catch (CoreException e) {
					PluginLogger.logError("Error while building project after a directory had been changed.", //$NON-NLS-1$
							e);
					return Status.CANCEL_STATUS;
				}
				return Status.OK_STATUS;
			}

		};
		job.setUser(true);
		job.schedule();

		try {
			getPreferences().flush();
		} catch (BackingStoreException e) {
			return false;
		}
		return super.performOk();
	}

}
