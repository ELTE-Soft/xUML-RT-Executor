package hu.eltesoft.modelexecution.m2m.logic.translators;

import hu.eltesoft.modelexecution.m2m.logic.UnsupportedUMLFeatureException;
import hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Direction;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type;

import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Convenient translators for parts of the model concerning types.
 */
public class TypeSubtranslator {

	protected static final BaseFactory BASE_FACTORY = BaseFactory.eINSTANCE;

	/**
	 * Creates a type of the translation model from a type of the UML2 model.
	 */
	public Type convert(org.eclipse.uml2.uml.Type type) {
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
			case "PrimitiveTypes::Real":
				primType.setType(PrimitiveTypes.REAL);
				break;
			default:
				throw new UnsupportedUMLFeatureException(
						"Invalid primitive type: " + type.getQualifiedName());
			}
			return primType;
		} else {
			Type classType = BASE_FACTORY.createType();
			classType.setReference(new NamedReference(type));
			return classType;
		}
	}

	public Integer toInt(ValueSpecification value) {
		int ret;
		try {
			ret = value.integerValue();
		} catch (UnsupportedOperationException e) {
			ret = value.unlimitedValue();
		}
		return ret;
	}

	public Direction convert(ParameterDirectionKind direction) {
		switch (direction) {
		case INOUT_LITERAL:
			return Direction.INOUT;
		case IN_LITERAL:
			return Direction.IN;
		case OUT_LITERAL:
			return Direction.OUT;
		default:
			throw new UnsupportedUMLFeatureException("Unsupported direction: "
					+ direction);
		}
	}

}
