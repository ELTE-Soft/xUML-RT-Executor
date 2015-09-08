package hu.eltesoft.modelexecution.ide.common;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IStartup;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class PluginLogger implements BundleActivator, IStartup {

	private static final String PLUGIN_ID = "hu.eltesoft.modelexecution.logger";
	
	private static ILog log = null;

	public static void log(IStatus status) {
		if (log != null) {
			log.log(status);
		}
	}

	public static void logError(String msg, Throwable e) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, msg, e));
	}

	public static void logError(String msg) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, msg));
	}

	public static void logInfo(String msg) {
		log(new Status(IStatus.INFO, PLUGIN_ID, msg));
	}
	
	public void earlyStartup() {
		PluginLogger.log = Platform.getLog(Platform.getBundle(PLUGIN_ID));
	}

	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
