package hu.eltesoft.modelexecution.examples;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "hu.eltesoft.modelexecution.examples.messages"; //$NON-NLS-1$
	public static String StateMachineExampleWizard_description;
	public static String StateMachineExampleWizard_page_title;
	public static String StateMachineExampleWizard_projectName;
	public static String StateMachineExampleWizard_title;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
