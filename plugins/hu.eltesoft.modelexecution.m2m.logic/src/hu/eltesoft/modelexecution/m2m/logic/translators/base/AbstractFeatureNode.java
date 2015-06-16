package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import hu.eltesoft.modelexecution.m2m.logic.GenerationException;
import hu.eltesoft.modelexecution.m2m.logic.listeners.ListenerContext;
import hu.eltesoft.modelexecution.m2m.logic.listeners.MatchUpdateListener;
import hu.eltesoft.modelexecution.m2m.logic.registry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.CompositeReversibleTask;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;

public abstract class AbstractFeatureNode<Trans, Match extends IPatternMatch>
		extends AbstractNode<Trans, Match> {

	private final EStructuralFeature feature;

	private final List<Consumer<AbstractFeatureNode<?, ?>>> childInvocations = new ArrayList<>();

	public AbstractFeatureNode(List<String> typeNames,
			EStructuralFeature feature, BaseMatcher<Match> matcher,
			Function<Match, Trans> transform) {
		super(typeNames, matcher, transform);
		this.feature = feature;
	}

	@SuppressWarnings("unchecked")
	public void integrate(EObject parentObject, List<EObject> stack) {
		Match filterMatch = matcher.newEmptyMatch();
		for (int i = 0; i < stack.size(); ++i) {
			filterMatch.set(i, stack.get(i));
		}
		checkCorrectFeatureIsSet(parentObject);

		boolean hasNoValue = true;
		if (feature.isMany()) {
			Collection<Trans> list = (EList<Trans>) parentObject.eGet(feature);

			if (feature.isOrdered()) {
				processOrderedMultiFeature(filterMatch, stack, list);
			} else {
				processUnorderedMultiFeature(filterMatch, stack, list);
			}

			hasNoValue = list.isEmpty();
		} else {
			matcher.forOneArbitraryMatch(filterMatch,
					m -> parentObject.eSet(feature, transform(m, stack)));

			hasNoValue = null == parentObject.eGet(feature);
		}

		// If the metamodel feature had a default value, it had been set when
		// the parent object was created.
		if (feature.isRequired() && hasNoValue) {
			throw new GenerationException("Required feature not found: "
					+ feature.getName() + " in "
					+ feature.getEContainingClass().getName());
		}

		childNodes.forEach(node -> {
			childInvocations.forEach(invocation -> invocation.accept(node));
		});
		childInvocations.clear();
	}

	// If the parent object's class is not the same as the feature's
	// containing class, the translation was built incorrectly. We cannot
	// find this kind of error earlier conveniently, because it is specified
	// with a template parameter.
	private void checkCorrectFeatureIsSet(EObject parentObject) {
		if (parentObject.eClass() != feature.getEContainingClass()) {
			throw new RuntimeException("Feature '" + feature.getName()
					+ "' has the container class of '"
					+ feature.getEContainingClass().getName()
					+ "' but received a '" + parentObject.eClass().getName()
					+ "' to integrate into.");
		}
	}

	protected abstract void processOrderedMultiFeature(Match filterMatch,
			List<EObject> stack, Collection<Trans> list);

	protected void processUnorderedMultiFeature(Match filterMatch,
			List<EObject> stack, Collection<Trans> list) {
		matcher.forEachMatch(filterMatch, m -> list.add(transform(m, stack)));
	}

	Trans transform(Match match, List<EObject> stack) {
		Trans meta = transform.apply(match);
		childInvocations.add(node -> {
			LinkedList<EObject> newStack = new LinkedList<>(stack);
			newStack.add((EObject) match.get(stack.size()));
			node.integrate((EObject) meta, newStack);
		});
		return meta;
	}

	public ReversibleTask addListeners(RootElementTranslator<?, ?, ?> builder,
			ListenerContext context) {
		return new AddListenerTask(builder, context);
	}

	private final class AddListenerTask extends CompositeReversibleTask {

		private final ListenerContext context;
		private final IMatchUpdateListener<Match> listener;

		public AddListenerTask(RootElementTranslator<?, ?, ?> builder,
				ListenerContext context) {
			this.context = context;
			AdvancedIncQueryEngine engine = context.getEngine();
			ChangeRegistry changes = context.getChanges();

			listener = new MatchUpdateListener<>(builder, changes);
			engine.addMatchUpdateListener(matcher, listener, false);
			childNodes
					.forEach(node -> add(node.addListeners(builder, context)));
		}

		@Override
		public boolean revert() {
			AdvancedIncQueryEngine engine = context.getEngine();
			engine.removeMatchUpdateListener(matcher, listener);
			return super.revert();
		}
	};
}
