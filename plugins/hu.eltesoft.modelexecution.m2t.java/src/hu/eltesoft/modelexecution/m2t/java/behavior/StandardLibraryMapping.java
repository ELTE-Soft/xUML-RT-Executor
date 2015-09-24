package hu.eltesoft.modelexecution.m2t.java.behavior;

import java.util.HashMap;
import java.util.Map;

import hu.eltesoft.modelexecution.runtime.library.CollectionOperations;
import hu.eltesoft.modelexecution.runtime.library.PrimitiveOperations;
import hu.eltesoft.modelexecution.runtime.library.StdOutOperations;

public class StandardLibraryMapping {

	private static final String PACKAGE_STD = "std::";
	private static final String PACKAGE_COLLECTIONS = PACKAGE_STD + "collections::";

	private static final String DATA_OUT = PACKAGE_STD + "out::";
	private static final String DATA_BOOLEAN = PACKAGE_STD + "boolean::";
	private static final String DATA_INT = PACKAGE_STD + "int::";
	private static final String DATA_REAL = PACKAGE_STD + "real::";

	private static final String DATA_COLLECTION = PACKAGE_COLLECTIONS + "Collection::";
	private static final String DATA_SEQUENCE = PACKAGE_COLLECTIONS + "Sequence::";
	private static final String DATA_SET = PACKAGE_COLLECTIONS + "Set::";
	// private static final String DATA_BAG = PACKAGE_COLLECTIONS + "Bag::";

	private static final Map<String, String> MAPPING = new HashMap<>();

	static {
		MAPPING.put(DATA_OUT + "println", StdOutOperations.PRINTLN);

		MAPPING.put(DATA_BOOLEAN + "toString", PrimitiveOperations.TO_STRING);
		MAPPING.put(DATA_INT + "toString", PrimitiveOperations.TO_STRING);
		MAPPING.put(DATA_REAL + "toString", PrimitiveOperations.TO_STRING);

		MAPPING.put(DATA_COLLECTION + "one", CollectionOperations.ONE);
		MAPPING.put(DATA_COLLECTION + "isEmpty", CollectionOperations.IS_EMPTY);
		MAPPING.put(DATA_COLLECTION + "size", CollectionOperations.SIZE);

		MAPPING.put(DATA_SEQUENCE + "get", CollectionOperations.GET);
		MAPPING.put(DATA_SEQUENCE + "add", CollectionOperations.ADD);
		MAPPING.put(DATA_SEQUENCE + "addAt", CollectionOperations.ADD_AT);

		MAPPING.put(DATA_SET + "add", CollectionOperations.ADD);
		MAPPING.put(DATA_SET + "addAll", CollectionOperations.ADD_ALL);
	}

	public static boolean isStandardFeature(String featureQualifiedName) {
		return MAPPING.containsKey(featureQualifiedName);
	}

	public static String getImplementationName(String featureQualifiedName) {
		return MAPPING.get(featureQualifiedName);
	}
}
