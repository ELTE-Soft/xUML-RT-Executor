package hu.eltesoft.modelexecution.ide.buildpath;

import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPage;
import org.eclipse.jdt.ui.wizards.NewElementWizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import hu.eltesoft.modelexecution.ide.Messages;

/**
 * Shows an informational page about the executor runtime library.
 */
public class RuntimeLibraryContainerWizardPage extends NewElementWizardPage implements IClasspathContainerPage {

	private IClasspathEntry containerEntry;

	@SuppressWarnings("restriction")
	public RuntimeLibraryContainerWizardPage() {
		super("RuntimeLibraryContainer"); //$NON-NLS-1$
		setTitle(Messages.RuntimeLibraryContainerWizardPage_Title);
		setImageDescriptor(org.eclipse.jdt.internal.ui.JavaPluginImages.DESC_WIZBAN_ADD_LIBRARY);
		setDescription(Messages.RuntimeLibraryContainerWizardPage_Description);
		this.containerEntry = JavaCore.newContainerEntry(RuntimeLibraryContainerInitializer.LIBRARY_PATH);
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());
		Label label = new Label(composite, SWT.NONE);
		String aboutText = NLS.bind(Messages.RuntimeLibraryContainerWizardPage_AboutContainer, containedBundles());
		label.setText(aboutText);
		setControl(composite);
	}

	private String containedBundles() {
		StringBuilder builder = new StringBuilder();
		for (String bundleId : RuntimeLibraryContainer.BUNDLE_IDS_TO_INCLUDE) {
			builder.append("\t").append(bundleId).append("\n"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return builder.toString();
	}

	public boolean finish() {
		return true;
	}

	public IClasspathEntry getSelection() {
		return containerEntry;

	}

	public void setSelection(IClasspathEntry containerEntry) {
		// intentionally left blank
	}
}
