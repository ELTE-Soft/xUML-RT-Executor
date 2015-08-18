package hu.eltesoft.modelexecution.ide;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;

import hu.eltesoft.modelexecution.ide.builder.TranslatorRegistry;

/**
 * Listens to project close events in the workspace. Removes registered EMF
 * resources, domains and translators for the given project from the registry.
 */
public class ProjectCloseListener implements IResourceChangeListener {

	/**
	 * Attach an instance of this class to watch all projects in the workspace.
	 */
	public static void setUp() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResourceChangeListener listener = new ProjectCloseListener();
		workspace.addResourceChangeListener(listener, IResourceChangeEvent.PRE_CLOSE | IResourceChangeEvent.PRE_DELETE);
	}

	protected ProjectCloseListener() {
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		if (!(event.getResource() instanceof IProject)) {
			// watch only for projects
			return;
		}

		IProject project = (IProject) event.getResource();
		TranslatorRegistry.INSTANCE.resourceRemoved(project);
	}
}
