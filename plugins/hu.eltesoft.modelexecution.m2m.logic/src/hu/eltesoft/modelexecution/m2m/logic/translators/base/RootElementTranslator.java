package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import hu.eltesoft.modelexecution.m2m.logic.translators.TypeSubtranslator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Direction;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type;
import hu.eltesoft.modelexecution.m2t.java.Template;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * An abstract base class for translators that map a root element.
 */
public abstract class RootElementTranslator<UML extends NamedElement, Trans extends Named, Match extends IPatternMatch>
		extends ModelMapper<UML, Trans, Match> {

	protected static final BaseFactory BASE_FACTORY = BaseFactory.eINSTANCE;
	protected static final BasePackage BASE_PACKAGE = BasePackage.eINSTANCE;
	protected TypeSubtranslator typeTranslator = new TypeSubtranslator();

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

	// delegates for conversions by subtranslators

	public Type convert(org.eclipse.uml2.uml.Type type) {
		return typeTranslator.convert(type);
	}

	public Direction convert(ParameterDirectionKind direction) {
		return typeTranslator.convert(direction);
	}

	public Integer toInt(ValueSpecification value) {
		return typeTranslator.toInt(value);
	}

}
