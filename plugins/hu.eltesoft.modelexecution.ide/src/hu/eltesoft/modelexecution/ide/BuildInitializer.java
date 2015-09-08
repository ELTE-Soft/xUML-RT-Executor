package hu.eltesoft.modelexecution.ide;

import org.eclipse.ui.IStartup;

/**
 * An early startup activity that initializes the builder chain.
 */
public class BuildInitializer implements IStartup {

	@Override
	public void earlyStartup() {
		ProjectCloseListener.setUp();
	}

}
