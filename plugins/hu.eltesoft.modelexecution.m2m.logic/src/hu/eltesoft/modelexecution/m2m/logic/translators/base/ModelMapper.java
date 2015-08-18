package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.NamedElement;

import hu.eltesoft.modelexecution.m2m.logic.GenerationException;
import hu.eltesoft.modelexecution.m2m.logic.listeners.ListenerContext;
import hu.eltesoft.modelexecution.m2m.logic.listeners.RootMatchUpdateListener;
import hu.eltesoft.modelexecution.m2m.logic.registry.RootNameStorage;
import hu.eltesoft.modelexecution.m2m.logic.tasks.CompositeReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.ResourceTranslator;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;

/**
 * A class for mapping UML elements into the translational model. These are
 * created by the translation tree.
 */
public abstract class ModelMapper<UML extends NamedElement, Trans extends Named, Match extends IPatternMatch> {

	private final RootNode<UML, Trans, Match> root;

	public ModelMapper(IncQueryEngine engine) throws IncQueryException {
		root = buildMapper(engine);
	}

	protected abstract RootNode<UML, Trans, Match> createMapper(IncQueryEngine engine);

	protected abstract void initMapper(RootNode<?, ?, ?> rootNode, IncQueryEngine engine);

	protected RootNode<UML, Trans, Match> buildMapper(IncQueryEngine engine) throws IncQueryException {
		RootNode<UML, Trans, Match> mapper = createMapper(engine);
		initMapper(mapper, engine);
		return mapper;
	}

	/**
	 * Enables filtering of source models. Override in subclasses to prevent
	 * building specific instances of the source model.
	 */
	public boolean shouldMap(UML source) {
		Resource eResource = source.eResource();
		if (eResource == null) {
			return true;
		}
		URI uri = eResource.getURI();
		if (uri == null) {
			return true;
		}
		return !ResourceTranslator.PATHMAP_SCHEME.equals(uri.scheme());
	}

	/**
	 * @return The root name of the element that is generated by the translator.
	 */
	public String getRootName(UML source) {
		return NamedReference.getIdentifier(source);
	}

	/**
	 * @return A task to remove the registered match update listeners
	 */
	public ReversibleTask addListeners(ListenerContext context) {
		return new AddListenerTask(context);
	}

	private final class AddListenerTask extends CompositeReversibleTask {

		private final ListenerContext context;
		private final IMatchUpdateListener<Match> listener;

		public AddListenerTask(ListenerContext context) {
			this.context = context;
			AdvancedIncQueryEngine engine = context.getEngine();
			RootNameStorage rootNames = context.getRootNames();

			root.matcher.forEachMatch(m -> {
				UML root = getRoot(m);
				String rootName = getRootName(root);
				rootNames.saveRootName(root, rootName);
			});
			listener = new RootMatchUpdateListener<>(root.translator, rootNames);
			engine.addMatchUpdateListener(root.matcher, listener, false);
			root.childNodes.forEach(node -> add(node.addListeners(root.translator, context)));
		}

		@Override
		public boolean revert() {
			AdvancedIncQueryEngine engine = context.getEngine();
			engine.removeMatchUpdateListener(root.matcher, listener);
			return super.revert();
		}
	}

	/**
	 * @param source
	 *            The model element that will be transformed.
	 * @return The result of transforming the given model element.
	 */
	protected Trans getModel(UML source) throws GenerationException {
		Match filterMatch = root.matcher.newEmptyMatch();
		filterMatch.set(0, source);
		Match match = root.matcher.getOneArbitraryMatch(filterMatch);
		if (match == null) {
			throw new GenerationException("Required match not found for: " + source.eClass().getName());
		}

		Trans meta = root.transform.apply(match);

		root.childNodes.forEach(node -> node.integrate((EObject) meta, Arrays.asList(source)));
		return meta;
	}

	/**
	 * @return All model elements that can be transformed by this mapper.
	 */
	protected Collection<UML> getSourceModels() throws GenerationException {
		List<UML> models = new ArrayList<>();
		root.matcher.forEachMatch(m -> {
			UML source = getRoot(m);
			if (shouldMap(source)) {
				models.add(source);
			}
		});
		return models;
	}

	@SuppressWarnings("unchecked")
	private UML getRoot(Match m) {
		return (UML) m.get(0);
	}
}
