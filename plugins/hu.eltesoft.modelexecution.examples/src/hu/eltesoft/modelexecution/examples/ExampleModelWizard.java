package hu.eltesoft.modelexecution.examples;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.osgi.framework.Bundle;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;

public abstract class ExampleModelWizard extends Wizard implements INewWizard {

	private static final String PLUGIN_ID = "hu.eltesoft.modelexecution.examples"; //$NON-NLS-1$
	private static final String RESOURCE_DIR = "resources"; //$NON-NLS-1$

	private static final String DIAGRAM_EXTENSION = ".di"; //$NON-NLS-1$
	private static final String NOTATION_EXTENSION = ".notation"; //$NON-NLS-1$
	private static final String MODEL_EXTENSION = ".uml"; //$NON-NLS-1$
	private static final String LAUNCH_EXTENSION = ".launch"; //$NON-NLS-1$

	public ExampleModelWizard() {
		super();
	}

	protected void copyModel(IProject project, String modelName) {
		copyResourceToProject(project, modelName + DIAGRAM_EXTENSION);
		copyResourceToProject(project, modelName + NOTATION_EXTENSION);
		copyResourceToProject(project, modelName + MODEL_EXTENSION);
	}

	protected void copyLaunchConfig(IProject project, String modelName) {
		copyResourceToProject(project, modelName + LAUNCH_EXTENSION);
	}

	private void copyResourceToProject(IProject project, String fileName) {
		IFile file = project.getFile(fileName);
		Bundle bundle = Platform.getBundle(PLUGIN_ID);
		URL fileURL = bundle.getEntry(RESOURCE_DIR + "/" + fileName); //$NON-NLS-1$
		try {
			file.create(fileURL.openStream(), true, null);
		} catch (CoreException | IOException e) {
			PluginLogger.logError("Error while copying models to example project", e); //$NON-NLS-1$
		}
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// no initialization needed
	}

}