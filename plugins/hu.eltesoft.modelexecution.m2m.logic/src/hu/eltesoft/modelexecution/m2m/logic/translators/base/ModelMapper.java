package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import hu.eltesoft.modelexecution.m2m.logic.GenerationException;
import hu.eltesoft.modelexecution.m2m.logic.listeners.ListenerContext;
import hu.eltesoft.modelexecution.m2m.logic.listeners.RootMatchUpdateListener;
import hu.eltesoft.modelexecution.m2m.logic.registry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.registry.RootNameStorage;
import hu.eltesoft.modelexecution.m2m.logic.tasks.CompositeReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Named;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.NamedElement;

/**
 * A class for mapping UML elements into the translational model. These are
 * created by the translation tree.
 */
public abstract class ModelMapper<UML extends NamedElement, Trans extends Named, Match extends IPatternMatch> {

	private final RootNode<UML, Trans, Match> root;

	public ModelMapper(IncQueryEngine engine) throws IncQueryException {
		root = buildMapper(engine);
	}

	protected abstract RootNode<UML, Trans, Match> buildMapper(
			IncQueryEngine engine) throws IncQueryException;

	/**
	 * @return a task to remove the registered match update listeners
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
			ChangeRegistry changes = context.getChanges();
			RootNameStorage rootNames = context.getRootNames();

			root.matcher.forEachMatch(m -> rootNames.saveRootName(getRoot(m)));
			listener = new RootMatchUpdateListener<>(root.builder, changes,
					rootNames);
			engine.addMatchUpdateListener(root.matcher, listener, false);
			root.childNodes.forEach(node -> add(node.addListeners(root.builder,
					context)));
		}

		@Override
		public boolean revert() {
			AdvancedIncQueryEngine engine = context.getEngine();
			engine.removeMatchUpdateListener(root.matcher, listener);
			return super.revert();
		}
	}

	protected Trans getModel(UML source) throws GenerationException {
		Match filterMatch = root.matcher.newEmptyMatch();
		filterMatch.set(0, source);
		Match match = root.matcher.getOneArbitraryMatch(filterMatch);
		if (match == null) {
			throw new GenerationException("Required match not found for: "
					+ source.eClass().getName());
		}

		Trans meta = root.transform.apply(match);

		root.childNodes.forEach(node -> node.integrate((EObject) meta,
				Arrays.asList(source)));
		return meta;
	}

	protected Collection<Trans> getAllModels() throws GenerationException {
		List<Trans> models = new ArrayList<>();
		root.matcher.forEachMatch(m -> models.add(getModel(getRoot(m))));
		return models;
	}

	@SuppressWarnings("unchecked")
	private UML getRoot(Match m) {
		return (UML) m.get(0);
	}
}
