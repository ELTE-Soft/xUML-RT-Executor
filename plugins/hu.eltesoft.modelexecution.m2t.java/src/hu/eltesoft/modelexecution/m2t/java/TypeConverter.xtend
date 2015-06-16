package hu.eltesoft.modelexecution.m2t.java

import com.google.common.collect.Multiset
import hu.eltesoft.modelexecution.m2m.metamodel.base.FullType
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type
import hu.eltesoft.modelexecution.runtime.values.MutableBool
import hu.eltesoft.modelexecution.runtime.values.MutableInt
import hu.eltesoft.modelexecution.runtime.values.MutableReal
import hu.eltesoft.modelexecution.runtime.values.MutableString
import java.util.ArrayList
import java.util.HashSet

import static hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes.*

/** This class converts translational-model-level types to Java types. */
class TypeConverter {

	dispatch def String javaType(FullType type) {
		val baseType = javaType(type.baseType)
		if (type.lowerBound != 1 || type.upperBound != 1) {
			if (type.isOrdered) {
				ArrayList.canonicalName + "<" + baseType + ">"
			} else if (type.isUnique) {
				HashSet.canonicalName + "<" + baseType + ">"
			} else {
				Multiset.canonicalName + "<" + baseType + ">"
			}
		} else {
			baseType
		}
	}

	dispatch def javaType(PrimitiveType type) {
		javaPrimitiveType(type.type);
	}

	dispatch def javaType(Type type) {
		type.reference.identifier
	}

	def javaPrimitiveType(PrimitiveTypes primType) {
		switch (primType) {
			case BOOLEAN: MutableBool.canonicalName
			case INTEGER: MutableInt.canonicalName
			case STRING: MutableString.canonicalName
			case REAL: MutableReal.canonicalName
		}
	}

}
