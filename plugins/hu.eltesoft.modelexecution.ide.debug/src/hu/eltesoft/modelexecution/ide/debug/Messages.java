package hu.eltesoft.modelexecution.ide.debug;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "hu.eltesoft.modelexecution.ide.messages"; //$NON-NLS-1$
	public static String DebugTarget_default_component_label;
	public static String VirtualMachineConnection_variable_currentState_label;
	public static String VirtualMachineConnection_variable_signal_label;
	public static String VirtualMachineConnection_variable_this_label;
	public static String XUMLRTDebugTarget_debug_target_name;
	public static String XUmlRtExecutionEngine_debug_model_label;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
