package hu.eltesoft.modelexecution.m2t.java

import com.google.common.collect.HashMultiset
import com.google.common.collect.ImmutableSet
import com.incquerylabs.uml.ralf.reducedAlfLanguage.CollectionType
import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes
import hu.eltesoft.modelexecution.m2m.metamodel.base.ReferencedType
import hu.eltesoft.modelexecution.m2m.metamodel.base.ScalarType
import java.math.BigInteger
import java.util.ArrayList
import java.util.HashSet
import java.util.Set
import org.eclipse.uml2.uml.Type
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations

/** This class converts translational-model-level types to Java types. */
class JavaTypeConverter {

	private static final String STD_COLLECTIONS_SEQUENCE = "std::collections::Sequence";
	private static final String STD_COLLECTIONS_SET = "std::collections::Set";
	private static final String STD_COLLECTIONS_BAG = "std::collections::Bag";

	private static final Set<String> STD_COLLECTIONS = ImmutableSet.builder().add(STD_COLLECTIONS_SEQUENCE).add(
		STD_COLLECTIONS_SET).add(STD_COLLECTIONS_BAG).build();

	/**
	 * Java version of a complete type with multiplicity
	 */
	def javaType(hu.eltesoft.modelexecution.m2m.metamodel.base.Type type) {
		collectionName(type) + "<" + scalarType(type.baseType) + ">"
	}

	/**
	 * Java version of type and multiplicity given separately
	 */
	def javaType(ScalarType type, Multiplicity mult) {
		collectionName(mult) + "<" + scalarType(type) + ">"
	}

	/**
	 * Java version of a collection type
	 */
	def javaType(CollectionType collection, ScalarType baseType) {
		collectionName(collection) + "<" + scalarType(baseType) + ">"
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

	def boolean isCollection(Type type) {
		STD_COLLECTIONS.contains(type.qualifiedName)
	}

	def String collectionName(Type type) {
		switch type.qualifiedName {
			case STD_COLLECTIONS_SEQUENCE: ArrayList.canonicalName
			case STD_COLLECTIONS_SET: HashSet.canonicalName
			case STD_COLLECTIONS_BAG: HashMultiset.canonicalName
		}
	}

	def String collectionName(CollectionType type) {
		switch type {
			case SEQUENCE: ArrayList.canonicalName
			case SET: HashSet.canonicalName
			case BAG: HashMultiset.canonicalName
		}
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

	def createEmpty(Type type) {
		createEmptyCollection(collectionName(type))
	}

	def createEmpty(CollectionType type) {
		createEmptyCollection(collectionName(type))
	}

	def createEmpty(ScalarType type, Multiplicity mult) {
		// FIXME: when the lower bound is greater than zero,
		// the collection should be initialized with the required amount of items
		if (mult.upperBound > 1 || 0 == mult.upperBound) {
			// create an empty collection
			createEmptyCollection(collectionName(mult), expectedNum(mult))
		} else {
			// create default value initializer
			createDefaultValue(type)
		}
	}

	def createEmpty(hu.eltesoft.modelexecution.m2m.metamodel.base.Type type) {
		createEmpty(type.baseType, type)
	}

	def dispatch createDefaultValue(PrimitiveType type) {
		switch type.type {
			case BOOLEAN: PrimitiveOperations.BOOLEAN_LITERAL + "(false)"
			case INTEGER: PrimitiveOperations.INTEGER_LITERAL + '''("0", 10)'''
			case REAL: PrimitiveOperations.REAL_LITERAL + "(0.0)"
			case STRING: PrimitiveOperations.STRING_LITERAL + '''("")'''
		}
	}

	def dispatch createDefaultValue(ReferencedType type) {
		return PrimitiveOperations.NULL_VALUE + "()"
	}

	def createEmptyCollection(String collectionName) {
		if (collectionName == HashMultiset.canonicalName) {
			collectionName + ".create()"
		} else {
			"new " + collectionName + "<>()"
		}
	}

	def createEmptyCollection(String collectionName, String expectedNum) {
		if (collectionName == HashMultiset.canonicalName) {
			collectionName + ".create(" + expectedNum + ")"
		} else {
			"new " + collectionName + "<>(" + expectedNum + ")"
		}
	}

	def expectedNum(Multiplicity type) {
		switch (0) {
			case type.upperBound == 1: "1"
			case type.upperBound == type.lowerBound: type.upperBound.toString
			default: ""
		}
	}
}
