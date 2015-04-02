package hu.eltesoft.modelexecution.m2t.java

import hu.eltesoft.modelexecution.m2t.smap.emf.LocationRegistry
import java.io.Serializable
import java.util.Map

/**
 * Contains information for debugging support. It includes a location registry
 * of EMF references and a name mapping between original model element names
 * and generated Java identifiers.
 */
@Data
class DebugSymbols implements Serializable {
	val LocationRegistry locationRegistry
	val Map<String, String> nameMapping
}
