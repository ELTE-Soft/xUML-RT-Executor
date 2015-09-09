package hu.eltesoft.modelexecution.ide.buildpath;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.osgi.framework.Bundle;

import hu.eltesoft.modelexecution.ide.Messages;
import hu.eltesoft.modelexecution.ide.common.PluginLogger;
import hu.eltesoft.modelexecution.runtime.RuntimePlugin;

/**
 * Contains the model execution runtime library and its dependencies.
 */
public class RuntimeLibraryContainer implements IClasspathContainer {

	public static final String[] BUNDLE_IDS_TO_INCLUDE = { "com.google.guava", "org.json", RuntimePlugin.PLUGIN_ID }; //$NON-NLS-1$

	private final IPath containerPath;
	private IClasspathEntry[] classPathEnries;

	public RuntimeLibraryContainer(IPath containerPath) {
		this.containerPath = containerPath;
	}

	@Override
	public IClasspathEntry[] getClasspathEntries() {
		if (classPathEnries == null) {
			List<IClasspathEntry> cpEntries = new ArrayList<IClasspathEntry>();
			for (String bundleId : BUNDLE_IDS_TO_INCLUDE) {
				addEntry(cpEntries, bundleId);
			}
			classPathEnries = cpEntries.toArray(new IClasspathEntry[] {});
		}
		return classPathEnries;
	}

	private void addEntry(final List<IClasspathEntry> cpEntries, final String bundleId) {
		Bundle bundle = Platform.getBundle(bundleId);
		if (bundle != null) {
			IPath bundlePath = bundlePath(bundle);
			cpEntries.add(JavaCore.newLibraryEntry(bundlePath, null, null, new IAccessRule[] {}, null, false));
		}
	}

	private IPath bundlePath(Bundle bundle) {
		IPath path = binFolderPath(bundle);
		if (path == null) {
			// common jar file case, no bin folder
			try {
				path = new Path(FileLocator.getBundleFile(bundle).getAbsolutePath());
			} catch (IOException e) {
				PluginLogger.logError("Can't resolve path '" + bundle.getSymbolicName() + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return path;
	}

	private IPath binFolderPath(Bundle bundle) {
		URL binFolderURL = FileLocator.find(bundle, new Path("bin"), null);
		if (binFolderURL != null) {
			try {
				URL binFolderFileURL = FileLocator.toFileURL(binFolderURL);
				return new Path(binFolderFileURL.getPath()).makeAbsolute();
			} catch (IOException e) {
				PluginLogger.logError("Can't resolve path '" + bundle.getSymbolicName() + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return null;
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
		return containerPath;
	}
}
