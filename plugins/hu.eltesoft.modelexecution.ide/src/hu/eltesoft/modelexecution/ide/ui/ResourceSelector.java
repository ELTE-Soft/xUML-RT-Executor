package hu.eltesoft.modelexecution.ide.ui;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.ILabelProvider;
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

class ResourceSelector extends SelectionAdapter {

	private String dialogTitle;
	protected IResource selectedResource;
	private Text field;
	private Composite parent;
	private List<ResourceSelectorUpdateListener> listeners = new LinkedList<>();
	private ConfigBase base;
	private Button browseButton;
	private Map<String, String> resourceFilters = new HashMap<>();

	/**
	 * A widget for selecting a folder in the workspace
	 */
	public ResourceSelector(Composite comp, ConfigBase base, String labelCaption,
			String buttonText, String dialogTitle) {
		this.parent = comp;
		this.base = base;
		this.dialogTitle = dialogTitle;
		createWidget(comp, labelCaption, buttonText);
	}

	public void addResourceFilter(String filter, String label) {
		resourceFilters.put(filter, label);
	}
	
	/**
	 * Defines the base of the folder path.
	 */
	public enum ConfigBase {
		WORKSPACE_BASED(res -> res.getFullPath()), PROJECT_BASED(res -> res
				.getProjectRelativePath());
		private ConfigBase(Function<IResource, IPath> conv) {
			this.conv = conv;
		}

		private final Function<IResource, IPath> conv;

		public IPath getPath(IResource res) {
			return conv.apply(res);
		}
	}

	protected void createWidget(Composite comp, String labelCaption,
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
		field.setEnabled(false);
		field.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		browseButton = new Button(group, SWT.NONE);
		browseButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		browseButton.setText(buttonText);
		browseButton.addSelectionListener(this);

		group.pack();
	}

	@Override
	public void widgetSelected(SelectionEvent event) {

		TreeSelectorDialog dialog = new TreeSelectorDialog(parent.getShell());
		dialog.setTitle(dialogTitle);
		dialog.setContentProvider(contentProvider());
		dialog.setLabelProvider(getLabelProvider());
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

	protected WorkspaceContentProvider contentProvider() {
		WorkspaceContentProvider contentProvider = new WorkspaceContentProvider();
		contentProvider.setExtensionFilters(resourceFilters);
		return contentProvider;
	}

	protected ILabelProvider getLabelProvider() {
		return WorkbenchLabelProvider
				.getDecoratingWorkbenchLabelProvider();
	}

	public void addUpdateListener(ResourceSelectorUpdateListener listener) {
		listeners.add(listener);
	}

	public void removeUpdateListener(ResourceSelectorUpdateListener listener) {
		listeners.remove(listener);
	}

	protected void notifyListeners(IResource folder) {
		for (ResourceSelectorUpdateListener listener : listeners) {
			listener.resourceSelectorUpdated(folder);
		}
	}

	private boolean selectionValid(TreeSelectorDialog dialog, Object[] selection) {
		return selection != null
				&& dialog.getReturnCode() == TreeSelectorDialog.OK
				&& selection.length > 0 && (selection[0] instanceof IResource);
	}

	public boolean selectionValid() {
		return selectedResource != null && selectedResource.exists();
	}

	protected void refreshField() {
		if (selectedResource != null) {
			field.setText(base.getPath(selectedResource).toString());
		}
	}

	public IPath getSelectedResourcePath() {
		return base.getPath(selectedResource);
	}

	public void setSelectedResource(IResource resource) {
		if (resource != null && resource.exists()) {
			selectedResource = resource;
			field.setText(base.getPath(selectedResource).toString());
		}
	}
	
	public void setEnabled(boolean enabled) {
		browseButton.setEnabled(enabled);
	}
}