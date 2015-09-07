package hu.eltesoft.modelexecution.m2t.java

/**
 * Holds stratum names as constants for various languages. Unfortunately, it
 * could not be represented in an enumeration type, as the SourceMappedTemplate
 * annotation can only use a String for stratum names.
 * 
 * This class must be implemented in Xtend in order to be loaded at annotation
 * processing time.
 */
class Languages {

	public static val RALF = "rALF";
	public static val XUML_RT = "xUML-rt";
}
