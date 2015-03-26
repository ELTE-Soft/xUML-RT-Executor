package hu.eltesoft.modelexecution.ide;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class IdePlugin extends AbstractUIPlugin implements IStartup {

	public static final String PLUGIN_ID = "hu.eltesoft.modelexecution.ide"; //$NON-NLS-1$

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
	
	@Override
	public void earlyStartup() {
		IdePlugin.log = Platform.getLog(getBundle());
		logInfo("IdePlugin logger started");
	}

}
