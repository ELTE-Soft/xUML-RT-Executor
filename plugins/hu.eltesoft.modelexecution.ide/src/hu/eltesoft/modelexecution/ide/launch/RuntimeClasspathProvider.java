package hu.eltesoft.modelexecution.ide.launch;

import hu.eltesoft.modelexecution.ide.project.ExecutableModelNature;
import hu.eltesoft.modelexecution.ide.project.ExecutableModelProperties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.internal.launching.RuntimeClasspathEntry;
import org.eclipse.jdt.launching.IRuntimeClasspathEntry;
import org.eclipse.jdt.launching.IRuntimeClasspathProvider;
import org.eclipse.jdt.launching.StandardClasspathProvider;

/**
 * This provider behaves like the standard provider except that it loads the
 * instrumented class files from projects that are xUML-RT Executor projects.
 */
@SuppressWarnings("restriction")
public class RuntimeClasspathProvider extends StandardClasspathProvider
		implements IRuntimeClasspathProvider {

	public final static String PROVIDER_ID = "hu.eltesoft.modelexecution.ide.project.runtimeClasspathProvider"; //$NON-NLS-1$

	@Override
	public IRuntimeClasspathEntry[] resolveClasspath(
			IRuntimeClasspathEntry[] entries, ILaunchConfiguration configuration)
			throws CoreException {
		IRuntimeClasspathEntry[] resolved = super.resolveClasspath(entries,
				configuration);
		for (int i = 0; i < resolved.length; i++) {
			if (resolved[i].getType() == IRuntimeClasspathEntry.PROJECT) {
				// the project is the resource of the classpath entry
				if (((IProject) resolved[i].getResource())
						.hasNature(ExecutableModelNature.NATURE_ID)) {
					resolved[i] = new RuntimeClasspathEntry(
							resolved[i].getClasspathEntry()) {
						@Override
						public String getLocation() {
							String folder = ExecutableModelProperties
									.getInstrumentedClassFilesPath(getResource()
											.getProject());
							return ((IProject) getResource()).getLocation()
									.append(folder).toOSString();
						}
					};
				}
			}
		}
		return resolved;
	}
}
