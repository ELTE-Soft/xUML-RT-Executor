package hu.eltesoft.modelexecution.m2t.java

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference
import java.util.HashMap
import java.util.HashSet
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject

/**
 * Replaces names to valid Java identifiers in the given translation meta-model.
 * The model instance is automatically traversed and every object which is
 * {@link Named Named} will be
 * modified to have a valid Java identifier in its name attribute. This process
 * generates a mapping between original and new names during the transformation.
 */
class NameMapper {

	private static val BASE = BasePackage.eINSTANCE
	private static val NAMED = BASE.named
	private static val REFERENCE = BASE.named_Reference

	private val Map<String, String> nameMapping = new HashMap;
	private val Set<EObject> visited = new HashSet;
	private var long nextId;

	def Map<String, String> mapNames(EObject object) {
		nextId = 0
		nameMapping.clear
		visited.clear
		mapNamesRecursively(object)
		return nameMapping
	}

	private def dispatch void mapNamesRecursively(EList<?> object) {
		for (item : object) {
			mapNamesRecursively(item);
		}
	}

	private def dispatch void mapNamesRecursively(EObject object) {
		if (visited.contains(object)) {
			return
		}
		visited.add(object)

		val c = object.eClass
		val ancestors = c.getEAllSuperTypes()
		val isNamed = ancestors.contains(NAMED)

		for (feature : c.getEAllStructuralFeatures()) {
			val value = object.eGet(feature);

			if (isNamed && feature.equals(REFERENCE)) {
				val reference = value as NamedReference;
				nameMapping.put(reference.newIdentifier, reference.originalName);
			} else if (null != value) {
				mapNamesRecursively(value);
			}
		}
	}

	private def dispatch void mapNamesRecursively(Object object) {
		// Intentionally left blank.
	}
}
