package hu.eltesoft.modelexecution.m2t.java

import com.google.common.collect.HashMultiset
import hu.eltesoft.modelexecution.m2m.metamodel.base.FullType
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type
import java.math.BigInteger
import java.util.ArrayList
import java.util.HashSet

import static hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes.*

/** This class converts translational-model-level types to Java types. */
class TypeConverter {

	dispatch def String javaType(FullType type) {
		val baseType = javaType(type.baseType)
		if (type.isOrdered) {
			ArrayList.canonicalName + "<" + baseType + ">"
		} else if (type.isUnique) {
			HashSet.canonicalName + "<" + baseType + ">"
		} else {
			HashMultiset.canonicalName + "<" + baseType + ">"
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
			case BOOLEAN: Boolean.canonicalName
			case INTEGER: BigInteger.canonicalName
			case STRING: String.canonicalName
			case REAL: Double.canonicalName
		}
	}

	def createEmpty(FullType toCreate) {
		val expectedNum = if (toCreate.upperBound == 1) "1" else ""
		if (toCreate.isOrdered) {
			"new " + ArrayList.canonicalName + "<>(" + expectedNum + ")"
		} else if (toCreate.isUnique) {
			"new " + HashSet.canonicalName + "<>(" + expectedNum + ")"
		} else {
			HashMultiset.canonicalName + ".create(" + expectedNum + ")"
		}
	}

	def scalarType(FullType type) {
		return javaType(type.baseType)
	}

}
