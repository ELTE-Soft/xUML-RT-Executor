package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Multiplicity;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class AbstractGenerator<S extends EObject> implements
		Generator<S> {

	protected static final BaseFactory BASE_FACTORY = BaseFactory.eINSTANCE;
	
	/**
	 * A mapping between EObject instances and their EObject id. It is a subset
	 * inverse of ResourceImpl#intrinsicIDToEObjectMap, with extended lifetime.
	 */
	private final Map<EObject, String> instanceToRootName = new HashMap<>();

	@Override
	public void saveRootName(S root) {

		instanceToRootName.put(root, NamedReference.getIdentifier(root));
	}

	@Override
	public void consumeRootName(S root, Consumer<String> task) {
		String rootName = instanceToRootName.get(root);
		if (null != rootName) {
			task.accept(rootName);
			instanceToRootName.remove(root);
		}
	}

	protected void check(boolean success) throws GenerationException {
		if (!success) {
			throw new GenerationException();
		}
	}

	/**
	 * Creates a type of the translation model from a type of the UML2 model.
	 */
	protected Type convertType(org.eclipse.uml2.uml.Type type) {
		if (type instanceof PrimitiveType) {
			hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType primType = BASE_FACTORY
					.createPrimitiveType();
			primType.setReference(new NamedReference(type));
			switch (type.getQualifiedName()) {
			case "PrimitiveTypes::String":
				primType.setType(PrimitiveTypes.STRING);
				break;
			case "PrimitiveTypes::Integer":
				primType.setType(PrimitiveTypes.INTEGER);
				break;
			case "PrimitiveTypes::Boolean":
				primType.setType(PrimitiveTypes.BOOLEAN);
				break;
			default:
				throw new UnsupportedUMLFeatureException(
						"Invalid primitive type: " + type.getQualifiedName());
			}
			return primType;
		} else if (type instanceof Class) {
			Type classType = BASE_FACTORY.createType();
			classType.setReference(new NamedReference(type));
			return classType;
		} else {
			throw new UnsupportedUMLFeatureException("Invalid type: "
					+ type.getQualifiedName());
		}
	}

	/**
	 * Converts multiplicity given by lower and upper bounds to metamodel
	 * multiplicity.
	 */
	protected Multiplicity convertMultiplicity(ValueSpecification lowerValue,
			ValueSpecification upperValue) {
		if ((lowerValue == null || integerValue(lowerValue) == 1)
				&& (upperValue == null || integerValue(upperValue) == 1)) {
			return Multiplicity.ONE;
		} else {
			return Multiplicity.MULTI;
		}
	}
	
	protected Integer integerValue(ValueSpecification value) {
		int ret;
		try {
			ret = value.integerValue();
		} catch (UnsupportedOperationException e) {
			ret = value.unlimitedValue();
		}
		return ret;
	}

}
