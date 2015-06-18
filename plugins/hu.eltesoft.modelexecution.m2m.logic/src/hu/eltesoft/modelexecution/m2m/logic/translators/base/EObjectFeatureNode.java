package hu.eltesoft.modelexecution.m2m.logic.translators.base;

import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;

/**
 * A node of the translation tree that corresponds to a feature that's element
 * is a data type of the translational model rather than a primitive type or
 * wrapped native java type.
 */
public class EObjectFeatureNode<Trans extends EObject, Match extends IPatternMatch>
		extends AbstractFeatureNode<Trans, Match> {

	public EObjectFeatureNode(List<String> types, EStructuralFeature feature,
			BaseMatcher<Match> matcher, Function<Match, Trans> transform) {
		super(types, feature, matcher, transform);
	}

	@Override
	protected void processOrderedMultiFeature(Match filterMatch,
			List<EObject> stack, Collection<Trans> list) {
		TreeMap<Integer, Trans> ordered = new TreeMap<>();

		matcher.forEachMatch(filterMatch, m -> {
			EObject original = (EObject) m.get(stack.size());
			int index = indexOf(original);
			Trans translated = transform(m, stack);
			ordered.put(index, translated);
		});

		while (!ordered.isEmpty()) {
			list.add(ordered.pollFirstEntry().getValue());
		}
	}

	private int indexOf(EObject elem) {
		EStructuralFeature containingFeature = elem.eContainingFeature();
		Object featureContent = elem.eContainer().eGet(containingFeature);
		if (featureContent instanceof List<?>) {
			return ((List<?>) featureContent).indexOf(elem);
		} else {
			return 0;
		}
	}
}
