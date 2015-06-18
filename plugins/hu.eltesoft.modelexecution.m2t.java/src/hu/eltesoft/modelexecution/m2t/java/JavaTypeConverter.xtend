package hu.eltesoft.modelexecution.m2t.java

import com.google.common.collect.HashMultiset
import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes
import hu.eltesoft.modelexecution.m2m.metamodel.base.ReferencedType
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type
import java.math.BigInteger
import java.util.ArrayList
import java.util.HashSet

import static hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes.*
import hu.eltesoft.modelexecution.m2m.metamodel.base.ScalarType

/** This class converts translational-model-level types to Java types. */
class JavaTypeConverter {

	/**
	 * Java version of a complete type with multiplicity
	 */
	def javaType(Type type) {
		collectionName(type) + "<" + scalarType(type.baseType) + ">"
	}

	/**
	 * Java version of type and multiplicity given separately
	 */
	def javaType(ScalarType type, Multiplicity mult) {
		collectionName(mult) + "<" + scalarType(type) + ">"
	}

	/**
	 * Java version of a scalar type
	 */
	def javaType(ScalarType type) {
		scalarType(type)
	}

	dispatch def scalarType(PrimitiveType type) {
		javaPrimitiveType(type.type);
	}

	dispatch def scalarType(ReferencedType type) {
		type.reference.identifier
	}

	def String collectionName(Multiplicity type) {
		if (type.upperBound == 1 || type.isOrdered) {
			ArrayList.canonicalName
		} else if (type.isUnique) {
			HashSet.canonicalName
		} else {
			HashMultiset.canonicalName
		}
	}

	def javaPrimitiveType(PrimitiveTypes primType) {
		switch (primType) {
			case BOOLEAN: Boolean.canonicalName
			case INTEGER: BigInteger.canonicalName
			case STRING: String.canonicalName
			case REAL: Double.canonicalName
		}
	}

	def createEmpty(Multiplicity type) {
		val expectedNum = expectedNum(type)
		val collectionName = collectionName(type)
		if (collectionName == HashMultiset.canonicalName) {
			collectionName + ".create(" + expectedNum + ")"
		} else {
			"new " + collectionName + "<>(" + expectedNum + ")"
		}
	}

	def expectedNum(Multiplicity type) {
		switch (0) {
			case type.upperBound == 1: "1"
			case type.upperBound == type.lowerBound: type.upperBound
			default: ""
		}
	}

}
