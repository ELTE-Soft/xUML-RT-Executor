package hu.eltesoft.modelexecution.ide.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.compiler.CompilationParticipant;

import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelNature;

/**
 * Refreshes the output folder of Java builder after it finished. This ensures
 * that StratumBuilder will be notified about the new class files.
 */
public class StratumCompilationParticipant extends CompilationParticipant {

	@Override
	public void buildFinished(IJavaProject javaProject) {
		try {
			IPath outputPath = javaProject.getOutputLocation();
			IProject project = javaProject.getProject();
			IWorkspaceRoot root = project.getWorkspace().getRoot();
			IResource outputFolder = root.findMember(outputPath);
			if (outputFolder != null) {
				outputFolder.refreshLocal(IResource.DEPTH_INFINITE, null);
			}
		} catch (CoreException e) {
			PluginLogger.logError("Unable to refresh output folder.", e); //$NON-NLS-1$
		}
	}

	/**
	 * @return true only when the given project has xUML-RT nature
	 */
	@Override
	public boolean isActive(IJavaProject javaProject) {
		IProject project = javaProject.getProject();
		try {
			if (!project.isOpen()) {
				// do not build closed projects
				// the nature getter below will fail in that case anyway
				return false;
			}
			// check whether this project has the xUML-RT nature
			return null != project.getNature(ExecutableModelNature.NATURE_ID);
		} catch (CoreException e) {
			// do not enable the participant in case of any error
			PluginLogger.logError("Unable to check nature on project.", e); //$NON-NLS-1$
			return false;
		}
	}
}
