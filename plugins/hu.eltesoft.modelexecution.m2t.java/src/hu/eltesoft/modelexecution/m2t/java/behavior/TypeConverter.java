package hu.eltesoft.modelexecution.m2t.java.behavior;

import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;

import hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Direction;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ReferencedType;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ScalarType;
import hu.eltesoft.modelexecution.m2t.java.CompilationFailedException;

// FIXME: this class is copied from m2m.logic!
/**
 * Convenient translators for parts of the model concerning types.
 */
public class TypeConverter {

	private static final String UML_PRIMITIVE_TYPES_REAL = "PrimitiveTypes::Real";
	private static final String UML_PRIMITIVE_TYPES_BOOLEAN = "PrimitiveTypes::Boolean";
	private static final String UML_PRIMITIVE_TYPES_INTEGER = "PrimitiveTypes::Integer";
	private static final String UML_PRIMITIVE_TYPES_STRING = "PrimitiveTypes::String";

	protected static final BaseFactory BASE_FACTORY = BaseFactory.eINSTANCE;

	/**
	 * Creates a type of the translation model from a type of the UML2 model.
	 */
	public ScalarType convert(org.eclipse.uml2.uml.Type type) {
		if (type instanceof PrimitiveType) {
			hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveType primType = BASE_FACTORY.createPrimitiveType();
			switch (type.getQualifiedName()) {
			case UML_PRIMITIVE_TYPES_STRING:
				primType.setType(PrimitiveTypes.STRING);
				break;
			case UML_PRIMITIVE_TYPES_INTEGER:
				primType.setType(PrimitiveTypes.INTEGER);
				break;
			case UML_PRIMITIVE_TYPES_BOOLEAN:
				primType.setType(PrimitiveTypes.BOOLEAN);
				break;
			case UML_PRIMITIVE_TYPES_REAL:
				primType.setType(PrimitiveTypes.REAL);
				break;
			default:
				throw new CompilationFailedException("Invalid primitive type: " + type.getQualifiedName());
			}
			return primType;
		} else {
			ReferencedType classType = BASE_FACTORY.createReferencedType();
			classType.setReference(new NamedReference(type));
			return classType;
		}
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
			throw new CompilationFailedException("Unsupported direction: " + direction);
		}
	}

}
