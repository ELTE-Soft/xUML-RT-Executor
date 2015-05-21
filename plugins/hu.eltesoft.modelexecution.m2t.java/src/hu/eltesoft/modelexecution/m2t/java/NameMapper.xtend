package hu.eltesoft.modelexecution.m2t.java

import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named
import hu.eltesoft.modelexecution.m2m.metamodel.base.TranslationObject
import java.util.HashMap
import java.util.HashSet
import java.util.Map
import java.util.Set
import java.util.Stack
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject

/**
 * Replaces names to valid Java identifiers in the given translation meta-model.
 * The model instance is automatically traversed and every object which is
 * {@link Named Named} will be
 * modified to have a valid Java identifier in its name attribute. This process
 * generates a mapping between original and new names during the transformation.
 * 
 * This current version applies only an identity transformation for Q1 release!
 */
class NameMapper {

	private static val BASE = BasePackage.eINSTANCE
	private static val NAMED = BASE.named
	private static val NAME = BASE.named_Name

	private val Map<String, String> nameMapping = new HashMap
	private val Stack<Object> itemsToMap = new Stack
	private val Set<Object> visited = new HashSet

	def Map<String, String> mapNames(EObject object) {
		nameMapping.clear
		visited.clear

		itemsToMap.push(object)
		while (!itemsToMap.isEmpty) {
			val item = itemsToMap.pop
			if (!visited.contains(item)) {
				visited.add(item)
				mapName(item)
			}
		}

		return nameMapping
	}

	private def dispatch void mapName(EList<?> objects) {
		objects.forEach[itemsToMap.push(it)]
	}

	private def dispatch void mapName(TranslationObject object) {
		val c = object.eClass
		val ancestors = c.getEAllSuperTypes()
		val isNamed = ancestors.contains(NAMED)

		for (feature : c.getEAllStructuralFeatures()) {
			val value = object.eGet(feature);

			if (isNamed && feature.equals(NAME)) {
				val name = value as String;

				// TODO: generate a new valid Java identifier here in later versions
				val newName = name
				nameMapping.put(newName, name);
				object.eSet(feature, newName);
			} else if (null != value) {
				switch value {
					EList<?>: mapName(value)
					TranslationObject: itemsToMap.push(value)
				}
			}
		}
	}

	private def dispatch void mapName(Object object) {
		// intentionally left blank
	}
}
