package hu.eltesoft.modelexecution.ide.launch;

import hu.eltesoft.modelexecution.ide.IdePlugin;
import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.runtime.RuntimePlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.osgi.framework.Bundle;

/**
 * Setups a container that automatically adds the runtime and required projects
 * to the java class path when the model is executed.
 */
public class ClasspathRuntimeLibrary extends ClasspathContainerInitializer {

	public static final String CONTAINER_ID = "hu.eltesoft.modelexecution.ide.runtimeClasspathInitializer"; //$NON-NLS-1$

	private static final String[] THIRDPARTY_PLUGIN_IDS = { "com.google.guava", "org.json" }; //$NON-NLS-1$

	@Override
	public void initialize(IPath containerPath, IJavaProject project)
			throws CoreException {
		BundleLibraryContainer container = new BundleLibraryContainer(
				containerPath, bundlesAndPathes());
		JavaCore.setClasspathContainer(containerPath,
				new IJavaProject[] { project },
				new IClasspathContainer[] { container }, null);
	}

	private Map<Bundle, IPath> bundlesAndPathes() {
		Map<Bundle, IPath> ret = new HashMap<Bundle, IPath>();
		ret.put(Platform.getBundle(RuntimePlugin.PLUGIN_ID), new Path("bin")); //$NON-NLS-1$
		for (String pluginId : THIRDPARTY_PLUGIN_IDS) {
			ret.put(Platform.getBundle(pluginId), new Path("")); //$NON-NLS-1$
		}
		return ret;
	}

	/**
	 * The container automatically adds the runtime and required projects to the
	 * java class path when the model is executed.
	 */
	private class BundleLibraryContainer implements IClasspathContainer {

		private IPath path;
		private Map<Bundle, IPath> bundleRelativePathes;

		public BundleLibraryContainer(IPath path,
				Map<Bundle, IPath> bundleRelativePathes) {
			this.path = path;
			this.bundleRelativePathes = bundleRelativePathes;
		}

		@Override
		public IClasspathEntry[] getClasspathEntries() {
			try {
				List<IClasspathEntry> entries = new LinkedList<>();
				for (Entry<Bundle, IPath> bundlePath : bundleRelativePathes
						.entrySet()) {
					File bundleFile = FileLocator.getBundleFile(bundlePath
							.getKey());
					IPath bundleClasspath = new Path(
							bundleFile.getAbsolutePath());
					if (!bundleFile.isFile()) {
						bundleClasspath = bundleClasspath.append(bundlePath
								.getValue().toString());
					}
					IClasspathEntry entry = JavaCore.newLibraryEntry(
							bundleClasspath, null, null, new IAccessRule[0],
							new IClasspathAttribute[0], false);
					entries.add(entry);
				}
				return entries.toArray(new IClasspathEntry[entries.size()]);

			} catch (IOException e) {
				IdePlugin.logError("Cannot calculate classpath dynamically", e); //$NON-NLS-1$
				return new IClasspathEntry[0];
			}
		}

		@Override
		public String getDescription() {
			return Messages.ClasspathRuntimeLibrary_model_execution_classpath_library;
		}

		@Override
		public int getKind() {
			return IClasspathContainer.K_APPLICATION;
		}

		@Override
		public IPath getPath() {
			return path;
		}

	}

}
