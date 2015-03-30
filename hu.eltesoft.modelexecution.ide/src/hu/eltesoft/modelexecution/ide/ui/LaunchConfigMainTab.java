package hu.eltesoft.modelexecution.ide.ui;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.util.CmArgBuilder;
import hu.eltesoft.modelexecution.runtime.TestRuntime;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.papyrus.moka.launch.MokaLaunchDelegate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Allows the user to configure the model that is loaded, the main class and the
 * feed function that starts the execution.
 */
public class LaunchConfigMainTab extends AbstractLaunchConfigurationTab
		implements ILaunchConfigurationTab {

	public static final String TAB_ID = "hu.eltesoft.modelexecution.ide.tabs.executableModel.mainTab"; //$NON-NLS-1$
	private static final String EMPTY_STR = ""; //$NON-NLS-1$
	private static final String ATTR_EXECUTED_FEED_URI = "executed_feed_uri"; //$NON-NLS-1$
	private static final String ATTR_EXECUTED_CLASS_URI = "executed_class_uri"; //$NON-NLS-1$
	private static final String ATTR_UML_RESOURCE = "uml_resource"; //$NON-NLS-1$
	private static final String ATTR_PROJECT_NAME = "project_name"; //$NON-NLS-1$
	private IFile selectedModelResource;
	private Text selectedModelField;
	private Text selectedClassField;

	private Class selectedClass;
	private Operation selectedFeedFunction;
	private ResourceSet resourceSet = new ResourceSetImpl();

	private Resource resource;
	private ClsMatcher classMatcher;
	private MethodMatcher methodMatcher;
	private Text selectedFeedFunctionField;

	@Override
	public String getId() {
		return TAB_ID;
	}

	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);

		comp.setLayout(new GridLayout(1, false));

		setControl(comp);
		createModelSelector(comp);
		createClassSelector(comp);
		createFeedFunctionSelector(comp);

		comp.pack();
	}

	private void createModelSelector(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		group.setText(Messages.LaunchConfigurationMainTab_select_model_group_caption);
		group.setLayout(new GridLayout(2, false));

		group.setToolTipText(Messages.LaunchConfigurationMainTab_select_model_tooltip);
		selectedModelField = new Text(group, SWT.BORDER);
		selectedModelField.setEditable(false);
		selectedModelField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		selectedModelField.pack();

		Button browseButton = new Button(group, SWT.NONE);
		browseButton.setFont(group.getFont());
		browseButton
				.setText(Messages.LaunchConfigurationMainTab_select_model_button_text);
		browseButton.addSelectionListener(new ModelSelector());
		browseButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));

		browseButton.pack();

		group.pack();
	}

	private final class ModelSelector extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent event) {

			TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());
			dialog.setTitle(Messages.LaunchConfigurationMainTab_select_model_dialog_title);
			dialog.setContentProvider(new WorkspaceContentProvider());
			dialog.setLabelProvider(WorkbenchLabelProvider
					.getDecoratingWorkbenchLabelProvider());
			if (selectedModelResource != null && selectedModelResource.exists()) {
				dialog.setInitialSelections(new IFile[] { selectedModelResource });
			}

			dialog.open();
			Object[] selection = dialog.getResult();
			if (selectionIsOk(dialog, selection)) {
				selectedModelResource = (IFile) selection[0];
				selectedModelField.setText(selectedModelResource.getFullPath()
						.toString());
				registerUMLPackageAndExtension();
				URI uri = URI.createFileURI(selectedModelResource.getLocation()
						.toString());
				resource = resourceSet.getResource(uri, true);
				
				initMatchers();
				updateDialog();
			}
		}

		private boolean selectionIsOk(TreeSelectorDialog dialog,
				Object[] selection) {
			return selection != null
					&& dialog.getReturnCode() == TreeSelectorDialog.OK
					&& selection.length > 0 && (selection[0] instanceof IFile);
		}

		private void registerUMLPackageAndExtension() {
			resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI,
					UMLPackage.eINSTANCE);
			resourceSet
					.getResourceFactoryRegistry()
					.getExtensionToFactoryMap()
					.put(UMLResource.FILE_EXTENSION,
							UMLResource.Factory.INSTANCE);
		}
	}

	private void updateDialog() {
		setDirty(true);
		updateLaunchConfigurationDialog();
	}

	private void createClassSelector(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(Messages.LaunchConfigurationMainTab_select_class_group_caption);
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		group.setToolTipText(Messages.LaunchConfigurationMainTab_select_class_tooltip);
		selectedClassField = new Text(group, SWT.BORDER);
		selectedClassField.setEditable(false);
		selectedClassField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		Button browseClass = new Button(group, SWT.NONE);
		browseClass
				.setText(Messages.LaunchConfigurationMainTab_select_class_button_text);

		browseClass.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));

		browseClass.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				if (selectedClassField == null
						|| selectedClassField.isDisposed()) {
					return;
				}

				List<Class> classes = new LinkedList<>();

				classMatcher.getAllMatches().forEach(
						m -> classes.add(m.getCls()));

				ListSelectionDialog dialog = new ListSelectionDialog(
						getShell(),
						classes.toArray(new Object[classes.size()]),
						new ArrayContentProvider(), new EMFLabelProvider(),
						null);
				dialog.setTitle(Messages.LaunchConfigurationMainTab_select_class_dialog_title);

				dialog.open();
				Object[] selection = dialog.getResult();
				if (selection != null
						&& dialog.getReturnCode() == TreeSelectorDialog.OK
						&& selection.length > 0
						&& (selection[0] instanceof Class)) {
					selectedClass = (Class) selection[0];
					selectedClassField.setText(selectedClass.getName());
					updateDialog();
				}
			}
		});

		group.pack();
	}

	private void createFeedFunctionSelector(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(Messages.LaunchConfigurationMainTab_select_feed_group_caption);
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		group.setToolTipText(Messages.LaunchConfigurationMainTab_select_feed_tooltip);
		selectedFeedFunctionField = new Text(group, SWT.BORDER);
		selectedFeedFunctionField.setEditable(false);
		selectedFeedFunctionField.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, true, false));

		Button browseEObjectButton = new Button(group, SWT.NONE);
		browseEObjectButton
				.setText(Messages.LaunchConfigurationMainTab_select_feed_button_text);

		browseEObjectButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false));

		browseEObjectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				if (selectedFeedFunctionField == null
						|| selectedFeedFunctionField.isDisposed()) {
					return;
				}

				List<Operation> functions = new LinkedList<>();

				methodMatcher.getAllMatches(selectedClass, null, null).forEach(
						m -> functions.add(m.getOperation()));

				ListSelectionDialog dialog = new ListSelectionDialog(
						getShell(), functions.toArray(new Object[functions
								.size()]), new ArrayContentProvider(),
						new EMFLabelProvider(), null);
				dialog.setTitle(Messages.LaunchConfigurationMainTab_select_feed_dialog_title);

				dialog.open();
				Object[] selection = dialog.getResult();
				if (selection != null
						&& dialog.getReturnCode() == TreeSelectorDialog.OK
						&& selection.length > 0
						&& (selection[0] instanceof Operation)) {
					selectedFeedFunction = (Operation) selection[0];
					selectedFeedFunctionField.setText(selectedFeedFunction
							.getName());
					updateDialog();
				}
			}
		});

		group.pack();
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME,
				TestRuntime.class.getCanonicalName());
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		String uri;
		try {
			uri = configuration.getAttribute(ATTR_UML_RESOURCE, EMPTY_STR);
			if (!uri.equals(EMPTY_STR)) {
				resource = resourceSet.getResource(URI.createURI(uri), true);
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IResource member = workspace.getRoot().findMember(uri);
				if (member instanceof IFile) {
					selectedModelResource = (IFile) member;
					selectedModelField.setText(member.getFullPath().toString());
				}
				initMatchers();
				selectedClass = (Class) resource.getEObject(configuration
						.getAttribute(ATTR_EXECUTED_CLASS_URI, EMPTY_STR));
				selectedClassField.setText(selectedClass.getName());
				selectedFeedFunction = (Operation) resource
						.getEObject(configuration.getAttribute(
								ATTR_EXECUTED_FEED_URI, EMPTY_STR));
				selectedFeedFunctionField.setText(selectedFeedFunction
						.getName());

			}
		} catch (Exception e) {
			IdePlugin.logError("Cannot initialize from configuration", e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		if (selectedModelResource == null || selectedClass == null
				|| selectedFeedFunction == null) {
			return;
		}
		String projectName = selectedModelResource.getProject().getName();

		configuration.setAttribute(ATTR_PROJECT_NAME, projectName);
		configuration.setAttribute(ATTR_UML_RESOURCE, selectedModelResource
				.getFullPath().toString());
		configuration.setAttribute(ATTR_EXECUTED_CLASS_URI,
				resource.getURIFragment(selectedClass));
		configuration.setAttribute(ATTR_EXECUTED_FEED_URI,
				resource.getURIFragment(selectedFeedFunction));

		// fill Moka details
		URI uri = URI.createPlatformResourceURI(selectedModelResource
				.getFullPath().toString(), true);
		configuration.setAttribute(MokaLaunchDelegate.URI_ATTRIBUTE_NAME,
				uri.toString());
		configuration.setAttribute(MokaLaunchDelegate.FRAGMENT_ATTRIBUTE_NAME,
				resource.getURIFragment(selectedFeedFunction));

		// fill Java details
		configuration.setAttribute(
				IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME,
				projectName);
		setupLaunchArgs(configuration);
	}

	private void setupLaunchArgs(ILaunchConfigurationWorkingCopy configuration) {
		try {
			CmArgBuilder argsBuilder = new CmArgBuilder();

			argsBuilder.append(selectedClass.getName());
			argsBuilder.append(selectedFeedFunction.getName());

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
			IdePlugin.logError("Cannot setup launch args", e);
		}
	}

	@Override
	public String getName() {
		return Messages.LaunchConfigurationMainTab_launch_config_main_tab_caption;
	}

	private void initMatchers() {
		try {
			IncQueryEngine engine = IncQueryEngine.on(resource);
			classMatcher = ClsMatcher.on(engine);
			methodMatcher = MethodMatcher.on(engine);
		} catch (IncQueryException e) {
			IdePlugin.logError("Problem while creating IncQuery engine", e);
		}
	}

}
