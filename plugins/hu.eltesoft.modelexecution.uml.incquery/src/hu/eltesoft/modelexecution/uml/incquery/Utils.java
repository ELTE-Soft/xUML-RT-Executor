package hu.eltesoft.modelexecution.uml.incquery;

import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Redeclares java methods as pure (without side effects) to be used in IncQuery
 * without getting a warning.
 */
public class Utils {

	@Pure
	public static String toLowerCase(String str) {
		return str.toLowerCase();
	}
	
	@Pure
	public static boolean isExternalEntity(org.eclipse.uml2.uml.Class cls) {
		return false;
	}

}
