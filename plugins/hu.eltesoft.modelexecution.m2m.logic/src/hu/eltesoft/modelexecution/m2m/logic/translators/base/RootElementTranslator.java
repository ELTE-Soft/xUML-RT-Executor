package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ValueSpecification;

import hu.eltesoft.modelexecution.m2m.logic.translators.helpers.TypeConverter;
import hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Direction;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ScalarType;
import hu.eltesoft.modelexecution.m2t.java.Template;

/**
 * An abstract base class for translators that map a root element.
 */
public abstract class RootElementTranslator<UML extends NamedElement, Trans extends Named, Match extends IPatternMatch>
		extends ModelMapper<UML, Trans, Match> {

	protected static final BaseFactory BASE_FACTORY = BaseFactory.eINSTANCE;
	protected static final BasePackage BASE_PACKAGE = BasePackage.eINSTANCE;
	protected TypeConverter typeTranslator = new TypeConverter();
	private BaseMatcher<Match> matcher;

	public RootElementTranslator(IncQueryEngine engine) throws IncQueryException {
		super(engine);
	}

	protected abstract Template createTemplate(Trans trans);

	/**
	 * @return All templates to generate code for model elements that can be
	 *         feed into this translator. The call of this method implies batch
	 *         translation rather than incremental.
	 */
	public Map<String, Template> getAllTemplates() {
		Map<String, Template> templates = new HashMap<>();
		getSourceModels().forEach(source -> {
			String rootName = getRootName(source);
			Template template = getTemplate(source);
			templates.put(rootName, template);
		});
		return templates;
	}

	/**
	 * @param source
	 *            The model element that should be translated.
	 * @return The template to generate code for the given model element.
	 */
	public Template getTemplate(UML source) {
		Trans model = getModel(source);
		return createTemplate(model);
	}

	/**
	 * @return The root of a new translation tree.
	 */
	protected RootNode<UML, Trans, Match> fromRoot(BaseMatcher<Match> matcher, Function<Match, Trans> transform) {
		this.matcher = matcher;
		if (matcher.getSpecification().getParameters().size() == 0) {
			throw new RuntimeException("Cannot create a root node from a matcher without parameters.");
		}
		return new RootNode<UML, Trans, Match>(this, matcher, transform);
	}

	/**
	 * Checks if the translator can handle a subpattern match update if the root
	 * object is the one given in the parameter. It returns true, when the given
	 * parameter is an instance of the type parameter {@link UML}.
	 */
	public boolean canHandle(UML root) {
		String rootTypeName = matcher.getSpecification().getParameters().get(0).getTypeName();
		Class<?> rootType;
		try {
			rootType = getClass().getClassLoader().loadClass(rootTypeName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("While checking if the translator can handle a subpattern match", e);
		}
		return rootType.isInstance(root);
	}

	// delegates for methods of converters (sub-translators)

	public ScalarType convert(org.eclipse.uml2.uml.Type type) {
		return typeTranslator.convert(type);
	}

	public Direction convert(ParameterDirectionKind direction) {
		return typeTranslator.convert(direction);
	}

	public Integer toInt(ValueSpecification value) {
		return typeTranslator.toInt(value);
	}

}
