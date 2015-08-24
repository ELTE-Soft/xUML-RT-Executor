package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ParameterDirectionKind;

import hu.eltesoft.modelexecution.m2m.logic.SourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.registry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.registry.RootNameStorage;
import hu.eltesoft.modelexecution.m2m.logic.tasks.CompositeReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.helpers.TypeConverter;
import hu.eltesoft.modelexecution.m2m.metamodel.base.BaseFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.base.BasePackage;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Direction;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ScalarType;
import hu.eltesoft.modelexecution.m2t.java.Template;

/**
 * An abstract base class for translators that map a root element. These
 * translators track changes in the model elements they translate, and their
 * root names.
 */
public abstract class RootElementTranslator<UML extends NamedElement, Trans extends Named, Match extends IPatternMatch>
		extends ModelMapper<UML, Trans, Match> {

	protected static final BaseFactory BASE_FACTORY = BaseFactory.eINSTANCE;
	protected static final BasePackage BASE_PACKAGE = BasePackage.eINSTANCE;
	protected static final TypeConverter TYPE_CONVERTER = new TypeConverter();
	private BaseMatcher<Match> matcher;
	private final ChangeRegistry changes = new ChangeRegistry();
	private final RootNameStorage rootNames = new RootNameStorage();

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

	@Override
	public ReversibleTask addListeners() {
		return new AddListenerTask();
	}

	private final class AddListenerTask extends CompositeReversibleTask {

		private final IMatchUpdateListener<Match> listener;

		public AddListenerTask() {
			root.matcher.forEachMatch(m -> {
				UML root = getRoot(m);
				String rootName = getRootName(root);
				rootNames.saveRootName(root, rootName);
			});
			listener = new RootMatchUpdateListener();
			engine.addMatchUpdateListener(root.matcher, listener, false);
			root.childNodes.forEach(node -> add(node.addListeners(root.translator)));
		}

		@Override
		public boolean revert() {
			engine.removeMatchUpdateListener(root.matcher, listener);
			return super.revert();
		}
	}

	/**
	 * A match update listener which is intended to be used with root m2m model
	 * elements. Every object disappearance will indicate a delete operation in
	 * the change registry.
	 */
	public class RootMatchUpdateListener extends MatchUpdateListener<Match> {

		@Override
		public void notifyAppearance(Match match) {
			UML root = extractRoot(match);
			if (shouldMap(root)) {
				String rootName = getRootName(root);
				rootNames.saveRootName(root, rootName);
				registerUpdate(root);
			}
		}

		@Override
		public void notifyDisappearance(Match match) {
			UML root = extractRoot(match);
			if (shouldMap(root)) {
				rootNames.consumeRootName(root, changes::registerDelete);
			}
		}
	}

	/**
	 * @return the match update listener that updates the generated code of the
	 *         root element when something changes in it.
	 */
	public <SubMatch extends IPatternMatch> IMatchUpdateListener<SubMatch> getMatchUpdateListener() {
		return new MatchUpdateListener<SubMatch>();
	}

	/**
	 * Update listener applied by generators to keep the change registry in sync
	 * using query notification listeners. As it indicates a modification even
	 * in case of object removals, this class is intended to use with
	 * non-m2m-root model elements.
	 */
	private class MatchUpdateListener<SubMatch extends IPatternMatch> implements IMatchUpdateListener<SubMatch> {

		@Override
		public void notifyAppearance(SubMatch match) {
			registerChangeIfAppliable(match);
		}

		@Override
		public void notifyDisappearance(SubMatch match) {
			registerChangeIfAppliable(match);
		}

		private void registerChangeIfAppliable(SubMatch match) {
			UML root = extractRoot(match);
			// To generalize patterns, we allow subpattern updates to appear for
			// multiple translators. For example when an attribute is created
			// for an AssociationClass, both the Class and AssociationClass
			// translators register it, but only the later can handle the
			// change.
			if (canHandle(root)) {
				registerUpdate(extractRoot(match));
			}
		}

		@SuppressWarnings("unchecked")
		protected UML extractRoot(SubMatch match) {
			return (UML) match.get(0);
		}
	}

	/**
	 * Removes data about the incremental changes in the elements it translates.
	 * Should be called before a full rebuild is performed.
	 */
	public void clear() {
		changes.clear();
	}

	/**
	 * Performs the incremental changes in the elements it translates.
	 * 
	 * @return the list of tasks needed to update the generated code.
	 */
	public List<SourceCodeTask> incrementalTranslation() {
		return changes.performTranslation();
	}

	private void registerUpdate(UML root) {
		changes.registerUpdate(root, this);
	}

	/**
	 * Converts a UML type to a type in the metamodel.
	 */
	protected ScalarType convert(org.eclipse.uml2.uml.Type type) {
		return TYPE_CONVERTER.convert(type);
	}

	/**
	 * Converts a UML parameter direction to a direction in the metamodel.
	 */
	protected Direction convert(ParameterDirectionKind direction) {
		return TYPE_CONVERTER.convert(direction);
	}

}
