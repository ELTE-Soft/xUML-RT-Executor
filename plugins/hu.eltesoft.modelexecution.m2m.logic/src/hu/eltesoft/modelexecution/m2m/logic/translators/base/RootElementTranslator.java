package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import hu.eltesoft.modelexecution.m2m.logic.UnsupportedUMLFeatureException;
import hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Direction;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.base.PrimitiveTypes;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type;
import hu.eltesoft.modelexecution.m2t.java.Template;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class RootElementTranslator<UML extends NamedElement, Trans extends Named, Match extends IPatternMatch>
		extends ModelMapper<UML, Trans, Match> {

	protected static final BaseFactory BASE_FACTORY = BaseFactory.eINSTANCE;
	protected static final BasePackage BASE_PACKAGE = BasePackage.eINSTANCE;

	public RootElementTranslator(IncQueryEngine engine)
			throws IncQueryException {
		super(engine);
	}

	protected abstract Template createTemplate(Trans trans);

	public List<Template> getAllTemplates() {
		List<Template> templates = new ArrayList<>();
		getAllModels().forEach(model -> templates.add(createTemplate(model)));
		return templates;
	}

	public Template getTemplate(UML source) {
		Trans model = getModel(source);
		return createTemplate(model);
	}

	protected RootNode<UML, Trans, Match> fromRoot(BaseMatcher<Match> matcher,
			Function<Match, Trans> transform) {
		if (matcher.getSpecification().getParameters().size() == 0) {
			throw new RuntimeException(
					"Cannot create a root node from a matcher without parameters.");
		}
		return new RootNode<UML, Trans, Match>(this, matcher, transform);
	}

	/**
	 * Creates a type of the translation model from a type of the UML2 model.
	 */
	protected Type convert(org.eclipse.uml2.uml.Type type) {
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

	protected Integer toInt(ValueSpecification value) {
		int ret;
		try {
			ret = value.integerValue();
		} catch (UnsupportedOperationException e) {
			ret = value.unlimitedValue();
		}
		return ret;
	}

	protected Direction convert(ParameterDirectionKind direction) {
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
