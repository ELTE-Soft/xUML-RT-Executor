package hu.eltesoft.modelexecution.ide;

import hu.eltesoft.modelexecution.ide.builder.EMFResourceRegistry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

public class ProjectCloseListener implements IResourceChangeListener {

	public static void setUp() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResourceChangeListener listener = new ProjectCloseListener();
		workspace.addResourceChangeListener(listener,
				IResourceChangeEvent.PRE_CLOSE);
	}

	ProjectCloseListener() {
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		if (!(event.getResource() instanceof IProject)) {
			// assume that only projects can be closed
			return;
		}

		IProject project = (IProject) event.getResource();
		try {
			project.accept(new IResourceVisitor() {

				@Override
				public boolean visit(IResource resource) throws CoreException {
					EMFResourceRegistry.INSTANCE.forgetResource(resource);
					return true;
				}
			});
		} catch (CoreException e) {
			IdePlugin.logError("Error while cleaning up project resources", e); //$NON-NLS-1$
		}
	}
}
