package hu.eltesoft.modelexecution.ide;

import hu.eltesoft.modelexecution.ide.builder.EMFResourceRegistry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;

public class ProjectCloseListener implements IResourceChangeListener {

	public static void setUp() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResourceChangeListener listener = new ProjectCloseListener();
		workspace.addResourceChangeListener(listener,
				IResourceChangeEvent.PRE_CLOSE
						| IResourceChangeEvent.PRE_DELETE);
	}

	ProjectCloseListener() {
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		if (!(event.getResource() instanceof IProject)) {
			// watch only for projects
			return;
		}

		IProject project = (IProject) event.getResource();
		EMFResourceRegistry.INSTANCE.forgetResources(project);
	}
}
