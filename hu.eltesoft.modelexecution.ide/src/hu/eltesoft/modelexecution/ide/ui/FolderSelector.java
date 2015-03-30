package hu.eltesoft.modelexecution.ide.ui;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchLabelProvider;

final class FolderSelector extends SelectionAdapter {

	private String dialogTitle;
	private String attribute;
	private IResource selectedResource;
	private Text field;
	private Composite parent;
	private List<FolderSelectorUpdateListener> listeners = new LinkedList<>();

	public FolderSelector(Composite comp, String labelCaption,
			String buttonText, String dialogTitle, String attribute) {
		this.parent = comp;
		this.dialogTitle = dialogTitle;
		this.attribute = attribute;
		createWidget(comp, labelCaption, buttonText);
	}

	private void createWidget(Composite comp, String labelCaption,
			String buttonText) {

		Composite group = new Composite(comp, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		group.setLayout(new GridLayout(3, false));

		Label traceFolderLabel = new Label(group, SWT.NONE);
		traceFolderLabel.setText(labelCaption);
		traceFolderLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false));
		traceFolderLabel.pack();

		field = new Text(group, SWT.BORDER);
		field.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		Button browseUML = new Button(group, SWT.NONE);
		browseUML.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		browseUML.setText(buttonText);
		browseUML.addSelectionListener(this);

		group.pack();
	}

	@Override
	public void widgetSelected(SelectionEvent event) {

		TreeSelectorDialog dialog = new TreeSelectorDialog(parent.getShell());
		dialog.setTitle(dialogTitle);
		dialog.setContentProvider(new WorkspaceContentProvider());
		dialog.setLabelProvider(WorkbenchLabelProvider
				.getDecoratingWorkbenchLabelProvider());
		if (selectedResource != null && selectedResource.exists()) {
			dialog.setInitialSelections(new IResource[] { selectedResource });
		}

		dialog.open();
		Object[] selection = dialog.getResult();
		if (selectionValid(dialog, selection)) {
			selectedResource = (IResource) selection[0];
			refreshField();
			notifyListeners(selectedResource);
		}
	}

	public void addUpdateListener(FolderSelectorUpdateListener listener) {
		listeners.add(listener);
	}
	
	public void removeUpdateListener(FolderSelectorUpdateListener listener) {
		listeners.remove(listener);
	}
	
	protected void notifyListeners(IResource folder) {
		for (FolderSelectorUpdateListener listener : listeners) {
			listener.folderSelectorUpdated(folder);
		}
	}

	private boolean selectionValid(TreeSelectorDialog dialog, Object[] selection) {
		return selection != null
				&& dialog.getReturnCode() == TreeSelectorDialog.OK
				&& selection.length > 0 && (selection[0] instanceof IResource);
	}

	private void refreshField() {
		if (selectedResource != null) {
			field.setText(selectedResource.getFullPath().toString());
		}
	}

	public void apply(ILaunchConfigurationWorkingCopy configuration) {
		if (selectedResource != null) {
			configuration.setAttribute(attribute, selectedResource
					.getFullPath().toString());
		}
	}

	public void initializeFrom(ILaunchConfiguration configuration)
			throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		selectedResource = workspace.getRoot().findMember(
				configuration.getAttribute(attribute, ""));
		refreshField();
	}
}