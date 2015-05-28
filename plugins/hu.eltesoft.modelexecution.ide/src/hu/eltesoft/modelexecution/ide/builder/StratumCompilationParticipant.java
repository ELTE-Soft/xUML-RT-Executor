package hu.eltesoft.modelexecution.ide.builder;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelNature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.compiler.CompilationParticipant;

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
			outputFolder.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			IdePlugin.logError("Unable to refresh output folder.", e);
		}
	}

	/**
	 * @return true only when the given project has xUML-RT nature
	 */
	@Override
	public boolean isActive(IJavaProject javaProject) {
		IProject project = javaProject.getProject();
		try {
			// check whether this project has the xUML-RT nature
			return null != project.getNature(ExecutableModelNature.NATURE_ID);
		} catch (CoreException e) {
			// do not enable the participant in case of any error
			IdePlugin.logError("Unable to check nature on project.", e);
			return false;
		}
	}
}
